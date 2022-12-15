import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{
	/*
	 * parameters
	 */
	//private ArrayList<Town> towns;

	static ArrayList<Road> edges;
	static ArrayList<Town> towns;
	static ArrayList<LinkedList> vertex;
	private int cost;
	Map<Town, Town> prevNode = new HashMap<>();
	private List<Town> shortestPath = new LinkedList<>();
	private Map<Town, Road> adjacentTowns = new HashMap<>();
	
	/*
	 * constructors
	 */
	
	public Graph() {
		towns = new ArrayList<Town>();
		edges = new ArrayList<Road>();
	}
	
	
	/*
	 * methods
	 */


	@Override
	public Set edgeSet() {
		Set<Road> edge = new HashSet<Road>();
		for(int i=0;i<edges.size();i++) {
			edge.add(edges.get(i));
		}
		return edge;
	}

	
	@Override
	public Set vertexSet() {
		Set<Town> vertexes = new HashSet<Town>();
		for(int i=0;i<towns.size();i++) {
		vertexes.add(towns.get(i));
		}
		return vertexes;
	}



	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {

		Integer result=null;
		if (sourceVertex == null || destinationVertex == null) {
			return null;
		}
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).getsSource().equals(sourceVertex)
					&& edges.get(i).getDestination().equals(destinationVertex)) {
				result = i;
				break;
			}

		}
		return edges.get(result);
		
		
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {

		Road result = null;

		if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		boolean status = false;

		//if (towns.contains(sourceVertex) && towns.contains(destinationVertex)) {
			for (int i = 0; i < edges.size(); i++) {
				if (edges.get(i).getsSource().equals(sourceVertex)
						&& edges.get(i).getDestination().equals(destinationVertex)) {
					status = true;
					break;
				}
			}
			if (!status) {
				edges.add(new Road(sourceVertex, destinationVertex, weight, description));
				result = new Road(sourceVertex, destinationVertex, weight, description);
			}
		
		return result;

	}


	@Override
	public boolean addVertex(Town v) 
	{	boolean status = true;
	int i=0;
		while(status && i< towns.size()) {
			if(towns.get(i).equals(v)) {
				status = false;
			}
			i++;
		}
		if(status == true) {
			towns.add(v);
		}
				return status;
	}


	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
	
		boolean status = false;

		//if (towns.contains(sourceVertex) && towns.contains(destinationVertex)) {
		//status = true;
		
		for (int i = 0; i < edges.size(); i++) {
			if (edges.get(i).getsSource().equals(sourceVertex)
					&& edges.get(i).getDestination().equals(destinationVertex)) {
				status = true;}}
		return status;
				
	}


	@Override
	public boolean containsVertex(Town v) {
	 
		boolean status = false;
	
			for(int i=0;i<towns.size();i++) {
				
				if(towns.get(i).equals(v)) {
					status = true;
					break;
					
				}}
				
									
			
			return status;
	}


	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> result = new HashSet<Road>();
		//if(!edges.contains(vertex)) {
		//	throw new IllegalArgumentException();
		//}
		if(vertex == null) {
			throw new NullPointerException();
		}
		for(int i=0;i<edges.size();i++)
		if(edges.get(i).contains(vertex)) {
			result.add(edges.get(i));			
					
					}
			
		return result;
		}
		
	


	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		boolean status = false;
		int i = 0;
		Road removed = null;
		while (!status & i < edges.size()) {
			if (edges.get(i).getsSource().equals(sourceVertex)
					&& edges.get(i).getDestination().equals(destinationVertex) && edges.get(i).getdistance() == weight
					&& edges.get(i).getName().equalsIgnoreCase(description)) {
				removed = edges.get(i);
				edges.remove(i);
				status = true;
			}
			i++;

		}
		return removed;
	}


	@Override
	public boolean removeVertex(Town v) {
		boolean status = false; 
		if(this.containsVertex(v)) {
			for(int i=0;i<edges.size();i++) {
				if(edges.get(i).getDestination().equals(v)|| edges.get(i).getsSource().equals(v)) {
					edges.remove(i);
					
					for(int k=0;k<towns.size();k++) {
						if(towns.get(k).equals(v)) {
							towns.remove(k);
							
						}
					}
					status=true;
				}
			}
		}
		
		
		return status;
	}


	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		dijkstraShortestPath(sourceVertex);
		ArrayList<String> sp = new ArrayList<String>();
		return sp;
	}




	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		Town[] table = new Town[towns.size()];
		int i = 0;
		for(Town t: towns) {
			table[i] = new Town(t);
			i++;
		}
		
		
	}

}
