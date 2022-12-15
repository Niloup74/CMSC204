import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Town implements Comparable<Town>{

	/*
	 * Parameters
	 */
	private ArrayList<Town> adjTown;
	private ArrayList<Road> rdList;
	private String name;
	private Town prevTown;
	private int distance;
	private List<Town> shortestPath = new LinkedList<>();
	private Map<Town, Road> adjacentTowns = new HashMap<>();
	
	/*
	 * Constructors
	 */
	
	public Town(String name) {
		this.name=name;
		ArrayList<Road> rdList;
		adjTown = new ArrayList<Town>();
	}
	
	public Town(Town t) {
		this(t.getName());
		ArrayList<Road> rdList;
		setAdjTown(t.getAdjTown());
	}
	
	/*
	 * Setters and getters
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAdjTown(ArrayList<Town> t) {
		for(int i =0;i<t.size();i++) {
			adjTown.add(t.get(i));
		}
	}
	public ArrayList<Town> getAdjTown(){
		return adjTown;
		
	}
	/*
	 * methods
	 */
	
	public void addAdjTown(Town t) {
		adjTown.add(t);
	}
	
	public int hashCode() {
		return name.hashCode();
	}
	
	public String toString() {
		String result="";
		for(int i=0;i<adjTown.size();i++) {
			result += adjTown.get(i).getName()+" ";
		}
		return "Name of Town: " + name + "\t Adjacent Towns: " + result + "\n";
	}
		
		
	
	@Override
	public int compareTo(Town o) {
		return this.name.compareToIgnoreCase(o.name);
	}
	public boolean equals(Town o) {
		return (this.getName().equalsIgnoreCase(o.getName()));
	}
	

}
