/**
 * 
 */
package za.co.shortestpath.Processor;

import java.io.File;
import java.io.IOException;
import java.util.List;

import za.co.shortestpath.beans.Graph;
import za.co.shortestpath.beans.Node;
import za.co.shotestpath.GraphOperations.GraphOperationsImpl;

/**
 * @author C808146
 *
 */
public class ProcessSSP {
	

	//static Graph graph;
	//static GraphOperationsImpl graphOperations;
	//static File testFile;
	
	/**
	 * 
	 */
	public ProcessSSP() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		File file = new File("TestFile.txt");
		System.out.println("testFile is [" + file.getAbsolutePath() + "]");
		
		Graph graph = new Graph();
		
		GraphOperationsImpl graphOperations = new GraphOperationsImpl(graph);

		 
		System.out.println("\r\n======================================");
		System.out.println("\r\n+++++++++++++++++++++++++++++++++++++++");
		System.out.println("Before applying shortest path aglorithm");
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		
		
		System.out.println("\r\n+++++++++++++++++++++++++++++++++++++++");
		System.out.println("After applying shortest path aglorithm");
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		graphOperations.printOutput();
		
		graphOperations.parseFile(file);
		System.out.println();
		System.out.println("Source is " + graph.getSource());
		
		System.out.println();
		System.out.println("Source is " + graph.getTarget());		

		graph = graphOperations.calculateShortestPath(graph.getSource(), graph.getTarget());
		 //GraphOperationsImpl graphmarkings = new GraphOperationsImpl(outGgraph);
		 
		 List<Node> shortestPathNodes= graph.getTarget().getShortestPath();
		 graphOperations.markShortesPathNodes(shortestPathNodes);
		 graphOperations.markVisitedNodes(shortestPathNodes);
		 graphOperations.printOutput();
		
		
	}

}
