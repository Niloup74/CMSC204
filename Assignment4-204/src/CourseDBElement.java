/*
 * @author Niloufar Zafari
 * CMSC204 Assignment4
 */
public class CourseDBElement implements Comparable{
	
	//Attributes
	private String id;
	private int crn;
	private int credits;
	private String roomNumber;
	private String instructorName;

	
	
	
	//constructors 
	
	public CourseDBElement() {
		this(null,0,0,null,null);
	}
	public CourseDBElement(String id, int crn, int credits, String roomNumber, String instructorName) {
		this.id=id;
		this.crn=crn;
		this.credits=credits;
		this.roomNumber=roomNumber;
		this.instructorName=instructorName;
	}
	
	
	//setters and getters

	public String getID() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCRN() {
		return crn;
	}
	public void setCRN(int crn) {
		this.crn = crn;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getRoomNum() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	
	
	@Override
	public int compareTo(Object element) {
		CourseDBElement DB = (CourseDBElement) element;
		if(DB.crn==crn) {
			return 0;
		}
		else if(DB.crn<crn) {
			return -1;
		}
		else {return 1;}
	}
	public String toString() {
		return "\nCourse:" + id + " CRN:" + crn +" Credits:"+ credits+ " Instructor:"+instructorName+" Room:"+roomNumber; 
	}

}
