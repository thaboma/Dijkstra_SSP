package za.co.shortestpath.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

	/**
	 * Set of all nodes in the graph
	 */
	private List<Node> nodes;
	/**
	 * Map of line number to the set of notes on that particular line
	 */
	private Map<Integer, List<Node>> nodesMap;

	private Node source;

	private Node target;
	
	public Graph(Graph graph) { 
		super();
		//this.
		this.nodes = graph.getNodes();
		this.nodesMap = graph.getNodesMap();
		
	}

	public Graph() {
		super();
		this.nodes = new ArrayList<>();
		this.nodesMap = new HashMap<>();
	}
	/*
	 * public Graph(List<Node> nodes) { super(); this.nodes = nodes; }
	 */

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public Map<Integer, List<Node>> getNodesMap() {
		return nodesMap;
	}

	public void setNodesMap(Map<Integer, List<Node>> nodesMap) {
		this.nodesMap = nodesMap;
	}

	public Node getSource() {
		return source;
	}

	public void setSource(Node source) {
		this.source = source;
	}

	public Node getTarget() {
		return target;
	}

	public void setTarget(Node target) {
		this.target = target;
	}

	public void addNode(Node nodeA) {
		nodes.add(nodeA);
	}

	public void addAdjacentNodes(Node nodeA, List<Node> adjacentNodes) {
		nodeA.setAdjacentNodes(adjacentNodes);
	}

	public Node getNode(Integer x, Integer y) {

		if (x < 0 || y < 0) {
			return null;
		}

		List<Node> nodes = nodesMap.get(y);
		for (int i = 0; i < nodes.size(); i++) {
		//	for (int i = 0; i < nodes.size()-1; i = i + 2) {
			Node node = nodes.get(i);
			//if (node.getY_coordinate() == x) {
				
				if (node.getX_coordinate() == x) {
			
			   // if (x == i) {

				if (!(node.getSymbol().equals("W"))) {
					return node;
				}
			}
		}

		return null;
	}
	
	public Graph setNode(Node node) {

		List<Node> nodes = nodesMap.get(node.getY_coordinate());		 

		for (int i = 0; i < nodes.size(); i=i+2) {
				
				if (node.getX_coordinate() == i) {

					//if (node.getSymbol().equals("S")) {
						if (!"SWE*".contains(node.getSymbol())) {
					nodesMap.get(node.getY_coordinate()).set(i, node);
					nodes = nodesMap.get(node.getY_coordinate());
					
					nodesMap.put(node.getY_coordinate(), nodes);
					this.setNodesMap(nodesMap);
					break;
					}
			}
		}
   return this;
	}

}