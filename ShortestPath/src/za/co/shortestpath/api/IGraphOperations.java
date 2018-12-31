package za.co.shortestpath.api;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import za.co.shortestpath.beans.Graph;
import za.co.shortestpath.beans.Node;

public interface IGraphOperations {

	Graph calculateShortestPath(Node source ,Node target );
	Node getLowestDistanceNode(Set<Node> unsettledNodes);
	Node calculateMinimumDistance(Node evaluationNode, Node sourceNode);	
	List<Node> getAdjacentNodes(Node sourceNode);	
	void setSoure(Node sourceNode);
	void setTarget(Node targetNode);
	
	void parseFile(File inputFile) throws IOException;	
	void printOutput();	
	void markVisitedNodes(List<Node> shortestpath);	
	void markShortesPathNodes(List<Node> shortestpath);
}
