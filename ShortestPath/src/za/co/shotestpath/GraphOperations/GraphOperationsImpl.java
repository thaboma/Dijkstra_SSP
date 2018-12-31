package za.co.shotestpath.GraphOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import za.co.shortestpath.api.IGraphOperations;
import za.co.shortestpath.beans.Graph;
import za.co.shortestpath.beans.Node;

public class GraphOperationsImpl implements IGraphOperations {

	Graph graph;

//	Graph outGraph;

	public GraphOperationsImpl(Graph graph) {
		super();
		this.graph = graph;
		// this.outGraph = graph.;
	}

	@Override
	public Graph calculateShortestPath(Node source, Node target) {
		source.setDistance(0);

		Set<Node> settledNodes = new HashSet<>();
		Set<Node> unsettledNodes = new HashSet<>();

		unsettledNodes.add(source);

		outer: while (unsettledNodes.size() != 0) {
			Node currentNode = getLowestDistanceNode(unsettledNodes);
			unsettledNodes.remove(currentNode);
			
//			if (!"SWE*".contains(currentNode.getSymbol())) {
//			//if (currentNode.getSymbol().equals(".")) {	
//				currentNode.setSymbol("\"");
//		       graph= graph.setNode(currentNode);
//		  }	

			// Look at adding adjacent nodes here rather
			for (Iterator<Node> iterator = currentNode.getAdjacentNodes().iterator(); iterator.hasNext();) {
				Node adjacentNode = iterator.next();
				if (!settledNodes.contains(adjacentNode)) {
					calculateMinimumDistance(adjacentNode, currentNode);
					unsettledNodes.add(adjacentNode);
					
					if (adjacentNode.getSymbol().equals("E")) {
						break outer;
					}
				}
			}
			settledNodes.add(currentNode);
		}

		return graph;
	}

	@Override
	public Node getLowestDistanceNode(Set<Node> unsettledNodes) {
		Node lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (Node node : unsettledNodes) {
			
			//if (!"SWE*".contains(node.getSymbol())) {
//			if (node.getSymbol().equals(".")) {	
//			   node.setSymbol("\"");
//		       graph= graph.setNode(node);
//		  }	
			int nodeDistance = node.getDistance();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}

	@Override
	public Node calculateMinimumDistance(Node evaluationNode, Node sourceNode) {	
		

		
				
		Integer sourceDistance = sourceNode.getDistance();
		if (sourceDistance + 1 < evaluationNode.getDistance()) {
			evaluationNode.setDistance(sourceDistance + 1);
			LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());

			shortestPath.add(sourceNode);
			evaluationNode.setShortestPath(shortestPath);
			

		}

		return evaluationNode;
	}

	/**
	 * Work out an adjacency list for a given node
	 */
	@Override
	public List<Node> getAdjacentNodes(Node sourceNode) {

		List<Node> adjacentNodes = new ArrayList<>();
		Map<Integer, List<Node>> nodesMap = graph.getNodesMap();

		Integer lineNo = sourceNode.getY_coordinate();

		Node adjNodeS = null;
		Node adjNodeN = null;

		if (nodesMap.get(lineNo - 1) != null) {
			adjNodeN = graph.getNode(sourceNode.getX_coordinate(), (sourceNode.getY_coordinate() - 1));
		}

		if (nodesMap.get(lineNo + 1) != null) {
			adjNodeS = graph.getNode(sourceNode.getX_coordinate(), (sourceNode.getY_coordinate() + 1));
		}

		Node adjNodeW = graph.getNode((sourceNode.getX_coordinate() - 2), sourceNode.getY_coordinate());

		Node adjNodeE = graph.getNode((sourceNode.getX_coordinate() + 2), sourceNode.getY_coordinate());

		if (adjNodeE != null) {
			adjacentNodes.add(adjNodeE);
		}
		if (adjNodeW != null) {
			adjacentNodes.add(adjNodeW);
		}
		if (adjNodeN != null) {
			adjacentNodes.add(adjNodeN);
		}
		if (adjNodeS != null) {
			adjacentNodes.add(adjNodeS);
		}
		return adjacentNodes;
	}

	@Override
	public void setSoure(Node sourceNode) {
		graph.setSource(sourceNode);
	}

	@Override
	public void setTarget(Node targetNode) {
		graph.setTarget(targetNode);
	}

	@Override
	public void parseFile(File inputFile) throws IOException {

		BufferedReader buf = new BufferedReader(new FileReader(inputFile));

		Integer lineNo = 0;
		String line = null;

		while ((line = buf.readLine()) != null) {
			parseline(lineNo, line);
			lineNo++;
		}
		buf.close();

		for (Node node : graph.getNodes()) {

			if (node.getSymbol().equals("S")) {
				graph.setSource(node);
			}

			if (node.getSymbol().equals("E")) {
				graph.setTarget(node);
			}

			// Add adjacent nodes to each of the nodes
			List<Node> adjacentNodes = getAdjacentNodes(node);
			graph.addAdjacentNodes(node, adjacentNodes);
		}

	}

	public void parseline(Integer lineNo, String line) {
		// System.out.println("lineNo "+lineNo+" is .. ["+line+"]");
		System.out.println(line);
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < line.length(); i = i + 2) {

			String symbol = "" + line.charAt(i);
			Node node = new Node(i, lineNo, symbol);
			nodes.add(node);
		}
		graph.getNodes().addAll(nodes);
		graph.getNodesMap().put(lineNo, nodes);

	}

	@Override
	public void printOutput() {

		for (Integer lineNo : graph.getNodesMap().keySet()) {
			parseLine(lineNo);
		}

	}

	public void parseLine(Integer lineNo) {

		for (Iterator<Node> iterator = graph.getNodesMap().get(lineNo).iterator(); iterator.hasNext();) {
			Node node = iterator.next();
			System.out.print(node.getSymbol() + " ");
		}

		System.out.println();
	}

	@Override
	public void markVisitedNodes(List<Node> shortestpath) {

		for (Node node : shortestpath) {

			for (Iterator<Node> iterator = node.getAdjacentNodes().iterator(); iterator.hasNext();) {
				Node adjacentNode = iterator.next();

				if (!"SWE*".contains(adjacentNode.getSymbol())) {
					adjacentNode.setSymbol("\"");
					graph = graph.setNode(adjacentNode);
				}

			}
		}
	}

	@Override
	public void markShortesPathNodes(List<Node> shortestpath) {

		for (Node node : shortestpath) {

			if (!"SE".contains(node.getSymbol())) {
				node.setSymbol("*");
				graph = graph.setNode(node);
			}
		}
	}
}
