import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class Graph_Student_Test {
	private Town[] town;
	
	private GraphInterface<Town,Road> graph;

	@Before
	public void setUp() throws Exception{
		 graph = new Graph();
		 town =new Town[6];
		for(int i=1;i<6;i++) {
			town[i]=new Town("Town_ "+ i);
			graph.addVertex(town[i]);
		}
		
		graph.addEdge(town[1], town[2], 3, "road1");
		graph.addEdge(town[1], town[3], 3, "road2");
		graph.addEdge(town[1], town[4], 3, "road3");
		graph.addEdge(town[1], town[5], 3, "road4");
		graph.addEdge(town[2], town[6], 3, "road5");
		
	}
	
	@After
	public void tearDown() throws Exception{
	graph = null;
	}
	@Test
	public void testAddVertex() {
		Town town1 = new Town("Towntest");
		assertEquals(false,graph.containsVertex(town1));
		graph.addVertex(town1);
		assertEquals(true,graph.containsVertex(town1));
	}
	@Test
	public void testContainsVertex() {
		assertEquals(true, graph.containsVertex(new Town("Town_2")));
		assertEquals(false, graph.containsVertex(new Town("Town_12")));
}}
