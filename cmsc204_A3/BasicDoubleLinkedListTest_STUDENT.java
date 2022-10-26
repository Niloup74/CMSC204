import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;






class BasicDoubleLinkedListTest_STUDENT {

	BasicDoubleLinkedList<String> linkedString;
	BasicDoubleLinkedList<Double> linkedDouble;
	BasicDoubleLinkedList<Plant> linkedPlant;
	StringComparator comparator;
	DoubleComparator comparatorD;
	PlantComparator comparatorPlant;
	
	public Plant a=new Plant("deli", "monstera", 85);
	public Plant b=new Plant("Bipen", "philo", 85);
	public Plant c=new Plant("Joy", "Hoya", 85);
	public Plant d=new Plant("pilea", "pep", 85);
	public Plant e=new Plant("rubber", "ficus", 65);
	public Plant f=new Plant("prickly", "cactus", 40);
	public ArrayList<Plant> fill = new ArrayList<Plant>();
	@Before
	public void setUp() throws Exception {
	//	linkedString = new BasicDoubleLinkedList<String>();
	//	linkedString.addToEnd("testing");
	//	linkedString.addToEnd("planet");
	//	comparator = new StringComparator();
		
		linkedDouble = new BasicDoubleLinkedList<Double>();
		linkedDouble.addToEnd(18.75);
		linkedDouble.addToEnd(31.10);
		comparatorD = new DoubleComparator();
		
		linkedPlant= new BasicDoubleLinkedList<Plant>();
		linkedPlant.addToEnd(a);
		linkedPlant.addToEnd(b);
		comparatorPlant = new PlantComparator();
		
	}

	@After
	public void tearDown() throws Exception {
		linkedString = null;
		linkedDouble = null;
		linkedPlant = null;
		comparatorD = null;
		comparator = null;
	}

	@Test
	public void testGetSize() {
	//	assertEquals(2,linkedString.getSize());
		assertEquals(2,linkedDouble.getSize());
		assertEquals(2,linkedPlant.getSize());
	}
	@Test
	public void testAddToEnd() {
	//	assertEquals("planet",linkedString.getLast());
		assertEquals(31.10,linkedDouble.getLast());
		assertEquals(b,linkedPlant.getLast());
	}
	
	
	
	private class StringComparator implements Comparator<String>
	{

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class DoubleComparator implements Comparator<Double>
	{

		@Override
		public int compare(Double arg0, Double arg1) {
			// TODO Auto-generated method stub
			return arg0.compareTo(arg1);
		}
		
	}
	
	private class PlantComparator implements Comparator<Plant>
	{

		@Override
		public int compare(Plant arg0, Plant arg1) {
			// Just put cars in alphabetic order by make
			return arg0.toString().compareTo(arg1.toString());
		}
		
	}
	
	private class Plant{
		String name;
		String type;
		int humidity;
		
		public Plant(String name, String type, int humidity){
			this.name = name;
			this.type = type;
			this.humidity = humidity;
		}
		
		public String getName(){
			return name;
		}
		public String getType(){
			return type;
		}
		public int getHumidity(){
			return humidity;
		}
		
		public String toString() {
			return (getName()+" "+getType()+" "+getHumidity());
		}
	}


}
