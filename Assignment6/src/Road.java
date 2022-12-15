
public class Road implements Comparable<Road>{
	/*
	 * Parameters
	 */
	
	private Town townA;
	private Town townB;
	private int distance;
	private String name;
	
	
	/*
	 * Constructors
	 */
	public Road(Town source, Town dest, int degrees, String name) {
		townA = source;
		townB = dest;
		this.distance=degrees;
		this.name=name;
	}
	
	public Road(Town source, Town dest, String name) {
		this(source,dest,1,name);
	}
	
	
	/*
	 * Setters and Getters
	 */

	public Town getsSource() {
		return townA;
	}

	public void setSource(Town town1) {
		this.townA = town1;
	}

	public Town getDestination() {
		return townB;
	}

	public void setDestination(Town town2) {
		this.townB = town2;
	}

	public int getdistance() {
		return distance;
	}

	public void setdistance(int distance) {
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	/*
	 * other Methods
	 */
	
	public boolean contains(Town town) {
		return (town.getName().equalsIgnoreCase(townA.getName())|| (town.getName().equalsIgnoreCase(townB.getName())));
	}
	public boolean equals(Road r) {
		if(!(r instanceof Road)) {
			return false;
		}
		else {
			String rTownA=((Road)r).getsSource().getName();
			String rTownB= ((Road)r).getsSource().getName();
			if((townA.getName().equalsIgnoreCase(rTownA)||townA.getName().equalsIgnoreCase(rTownB))&&(townB.getName().equalsIgnoreCase(rTownA)||townB.getName().equalsIgnoreCase(rTownB))){
				return true;
			}
			else {
				return false;
			}
		}
	}
	public String toString() {
		return " " + this.getName();
	}
	

	@Override
	public int compareTo(Road o) {
		return name.compareToIgnoreCase(o.getName());
	}

}
