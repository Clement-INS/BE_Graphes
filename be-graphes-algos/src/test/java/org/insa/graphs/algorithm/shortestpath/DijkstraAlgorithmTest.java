package org.insa.graphs.algorithm.shortestpath;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;

import org.insa.graphs.model.io.BinaryGraphReader;
import org.insa.graphs.model.io.GraphReader;
import org.junit.BeforeClass;
import org.junit.Test;
import org.insa.graphs.algorithm.ArcInspectorFactory;
import org.insa.graphs.model.Arc;
import org.insa.graphs.model.Graph;
import org.insa.graphs.model.Node;
import org.insa.graphs.model.Path;


public class DijkstraAlgorithmTest {
	
	private static Graph graph, graph_insa;
	
	private static Path oneNodePath;
	
	private static ShortestPathSolution oneNodeSolution, simplePathSolution, mediumPathSolution, BFmediumSolution;
	
	private static double cost;
	
	@BeforeClass
    public static void initAll() throws Exception{
		
		//get graph of map carré
		String mapName = "/home/vigand/Documents/3A/Graphes/Maps/carre.mapgr";
		GraphReader reader = new BinaryGraphReader(new DataInputStream(new BufferedInputStream(new FileInputStream(mapName))));
		graph = reader.read();
		//get graph of map insa
		mapName = "/home/vigand/Documents/3A/Graphes/Maps/insa.mapgr";
		reader = new BinaryGraphReader(new DataInputStream(new BufferedInputStream(new FileInputStream(mapName))));
		graph_insa = reader.read();
		
		//init OneNodePath
		Node node = graph.getNodes().get(0);
		oneNodePath = new Path(graph, node);
		
		ShortestPathData data = new ShortestPathData(graph, node, node, ArcInspectorFactory.getAllFilters().get(0));
		DijkstraAlgorithm Dijkstra = new DijkstraAlgorithm(data);
		oneNodeSolution = Dijkstra.doRun();
		
		//Init simple path
		cost = 0;
		for (int i = 5; i < 9; i++) {
			for (Arc a : graph.getNodes().get(i).getSuccessors()) {
				if (a.getDestination() == graph.getNodes().get(i+1)) {
					cost += a.getLength();
					break;
				}
			}
		}
		
		data = new ShortestPathData(graph, graph.getNodes().get(5), graph.getNodes().get(9), ArcInspectorFactory.getAllFilters().get(0));
		Dijkstra = new DijkstraAlgorithm(data);
		simplePathSolution = Dijkstra.doRun();
		
		//Init medium path
		data = new ShortestPathData(graph_insa, graph_insa.getNodes().get(805), graph_insa.getNodes().get(70), ArcInspectorFactory.getAllFilters().get(0));
		Dijkstra = new DijkstraAlgorithm(data);
		mediumPathSolution = Dijkstra.doRun();
		
		//faire BELMAN FORD !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	}
	
	@Test
	public void TestOneNodePath() {
		assertEquals(0, oneNodePath.getOrigin().compareTo(oneNodeSolution.getPath().getOrigin()));
		assertTrue(Math.abs(oneNodePath.getLength() - oneNodeSolution.getPath().getLength()) < 0.01);
	}
	
	@Test
	public void TestSimplePath() {
		assertTrue(Math.abs(cost - simplePathSolution.getPath().getLength()) < 0.01);
	}
	
	@Test
	public void TestMediumPath() {
		
	}
}