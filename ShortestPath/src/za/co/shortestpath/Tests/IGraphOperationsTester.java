/**
 * 
 */
package za.co.shortestpath.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import za.co.shortestpath.beans.Graph;
import za.co.shortestpath.beans.Node;
import za.co.shotestpath.GraphOperations.GraphOperationsImpl;

/**
 * @author C808146
 *
 */
@SuppressWarnings("deprecation")
class IGraphOperationsTester {

	static Graph graph;
	static GraphOperationsImpl graphOperations;
	static File testFile;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		graph = new Graph();
		graphOperations = new GraphOperationsImpl(graph);

		testFile = new File("TestFile.txt");
		System.out.println("testFile is [" + testFile.getAbsolutePath() + "]");

	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link za.co.shortestpath.api.IGraphOperations#parseFile(java.io.File)}.
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("deprecation")
	@Test
	final void testParseFile() throws IOException {
		// fail("Not yet implemented"); // TODO

		graphOperations.parseFile(testFile);
		Assert.assertTrue("test message", true);
	}

	/**
	 * Test method for
	 * {@link za.co.shortestpath.api.IGraphOperations#setSoure(za.co.shortestpath.beans.Node)}.
	 */
	@Test
	final void testSetSoure() {
		System.out.println();
		System.out.println("Source is " + graph.getSource());
	}

	/**
	 * Test method for
	 * {@link za.co.shortestpath.api.IGraphOperations#setTarget(za.co.shortestpath.beans.Node)}.
	 */
	@Test
	final void testSetTarget() {
		System.out.println();
		System.out.println("Target is " + graph.getTarget());
	}

	/**
	 * Test method for
	 * {@link za.co.shortestpath.api.IGraphOperations#printOutput()}.
	 */
	@Test
	final void testPrintOutput() {
		// fail("Not yet implemented"); // TODO
	}

	@Test
	final void testAdjacencyMatrices() {
		System.out.println();

		for (Node node : graph.getNodes()) {
		//Node node  = graph.getNode(4, 0);

			if (graphOperations.getAdjacentNodes(node).size() > 0) {
				System.out.println();
				System.out.println("For Node  [" + node + "]");

				for (Node adjNode : graphOperations.getAdjacentNodes(node)) {

					System.out.print(" =====>AdjNode " + adjNode);

				}
				System.out.println();
			}
			
		}

	}

}
