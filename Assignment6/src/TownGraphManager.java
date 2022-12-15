import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TownGraphManager implements TownGraphManagerInterface{

	Graph graph = new Graph();
	ArrayList<Road> edges = graph.edges;
	ArrayList<Town> towns = graph.towns;
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town towna = new Town(town1);
		Town townb = new Town(town2);
		graph.addEdge(towna, townb, weight, roadName);
		return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town towna = new Town(town1);
		Town townb = new Town(town2);
		Road result = graph.getEdge(towna, townb);
		return result.getName();
	}

	@Override
	public boolean addTown(String v) {
		Town town = new Town(v);
		boolean status = false;
		if(!graph.containsVertex(town)) {
			graph.addVertex(town);
			status = true;
		}
		return status;
	}

	@Override
	public Town getTown(String name) {
		Town town = new Town(name);
		String result = "";
		if(!graph.containsVertex(town)) {
			town = null;
		if(graph.containsVertex(town)) {
			result = name;
		}}
		return town;
	}

	@Override
	public boolean containsTown(String v) {
		boolean status= false;
		Town town = new Town(v);
		if(graph.containsVertex(town)) {
			status = true;
		}
		return status;
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		boolean status = false;
		for(int i=0;i<edges.size();i++) {
			if(edges.get(i).getsSource().getName().equalsIgnoreCase(town1)&& edges.get(i).getDestination().getName().equals(town2)) {
				status = true;
			
			}
		}
	return status;
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> result = new ArrayList<String>();
		for(int i=0; i< edges.size(); i++) {
			result.add(edges.get(i).getName());
		}
		Collections.sort(result);
		return result;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		boolean status = false;
		
		Town towna = new Town(town1);
		Town townb = new Town(town2);

			for(int i=0; i<towns.size(); i++) {
				if(towns.get(i).getName().equals(town1))
					towna = towns.get(i);
				else if(towns.get(i).getName().equals(town2))
					townb = towns.get(i);
			}
			if(graph.containsEdge(towna, townb)) {
				status = true;
			}
			Road toRemove = graph.getEdge(towna, townb);
			edges.remove(toRemove);
	
			
		
		return status;
	}

	@Override
	public boolean deleteTown(String v) {
		boolean status = true; 
		Town town = new Town(v);
		if(!graph.containsVertex(town)) {
			status=false;
		}
		graph.removeVertex(town);
		
		return status;
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> townl = new ArrayList<String>();
		for(Town t : towns) {
			townl.add(t.getName());
			Collections.sort(townl);
		}
		return townl;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return graph.shortestPath(new Town(town1), new Town(town2));
	}

	public void populateTownGraph(File selectedFile) throws FileNotFoundException {
		Scanner in=new Scanner(selectedFile);
		Town town1,town2;
		String line="";
		String[] splitLine;
		while(in.hasNext()) {
			line=in.nextLine();
			splitLine=line.split("[,;]");
			town2=new Town(splitLine[3]);
			town1=new Town(splitLine[2]);
			graph.addVertex(town1);
			graph.addVertex(town2);
			graph.addEdge(town1, town2, Integer.parseInt(splitLine[1]), splitLine[0]);
	}

}}
