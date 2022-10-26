import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class BasicDoubleLinkedListTeststudent {
	BasicDoubleLinkedList<String> testString;
	StringComparator comparator;
	
	BasicDoubleLinkedList<Double> testDouble;
	DoubleComparator comparatorD;
	
	BasicDoubleLinkedList<Plant> testplant;
	PlantComparator comparatorP;
	
	public Plant a = new Plant("Prickly", "cactus", 40);
	public Plant b = new Plant("rubber", "ficus", 75 );
	public Plant c = new Plant("angle", "begonia", 75);
	public Plant d = new Plant("jewel", "orchid", 75);
	
	public ArrayList<Plant> fill = new ArrayList<Plant>();
	
	
	@Before
	public void setUp() throws Exception{
		testString = new BasicDoubleLinkedList<String>();
		testString.addToEnd("planet");
		testString.addToEnd("green");
		
		
		testDouble = new BasicDoubleLinkedList<Double>();
		testDouble.addToEnd(18.6);
		testDouble.addToEnd(32.1);
		
		comparator = new StringComparator();
		
		
		testplant = new BasicDoubleLinkedList<Plant>();
		testplant.addToEnd(a);
		testplant.addToEnd(b);
		comparatorP = new PlantComparator();
	}
	@After
	public void tearDown() throws Exception{
		
		comparator = null;
		testString = null;
		testDouble = null;
		testplant=null;
		comparatorP=null;
	}

	@Test
	public void testAddToEnd() {
		assertEquals("green", testString.getLast());
		testString.addToEnd("flowers");
		assertEquals("flowers", testString.getLast());
		
		assertEquals(32.1, testDouble.getLast());
		
		assertEquals(b, testplant.getLast());
		testplant.addToEnd(c);
		assertEquals(c, testplant.getLast());
	}

	@Test
	public void testAddToFront() {
		assertEquals("planet", testString.getFirst());
		testString.addToFront("flowers");
		assertEquals("flowers", testString.getFirst());
		
		
		assertEquals(a, testplant.getFirst());
		testplant.addToFront(c);
		assertEquals(c, testplant.getFirst());
		
	}

	@Test
	public void testGetFirst() {
		assertEquals("planet", testString.getFirst());
		testString.addToFront("front");
		assertEquals("front", testString.getFirst());
		assertEquals(18.6, testDouble.getFirst());
		
		assertEquals(a, testplant.getFirst());
		testplant.addToFront(c);
		assertEquals(c, testplant.getFirst());
	}

	@Test
	public void testGetLast() {
		assertEquals("green", testString.getLast());
		testString.addToEnd("adding to end");
		assertEquals("adding to end", testString.getLast());
		
		assertEquals(32.1, testDouble.getLast());
		
		assertEquals(b, testplant.getLast());
	}

	@Test
	public void testGetSize() {
		assertEquals(2, testString.getSize());
		assertEquals(2, testDouble.getSize());
		assertEquals(2, testplant.getSize());
	}

	@Test
	public void testRemove() {
		assertEquals(a, testplant.getFirst());
		assertEquals(b,testplant.getLast());
		testplant.addToFront(c);
		assertEquals(c, testplant.getFirst());
		testplant.remove(c, comparatorP);
		assertEquals(a , testplant.getFirst());
		
	}

	@Test
	public void testRetrieveFirstElement() {
		assertEquals("planet", testString.retrieveFirstElement());
		testString.addToFront("front");
		assertEquals("front", testString.getFirst());
		assertEquals("front", testString.retrieveFirstElement());
		assertEquals("green", testString.retrieveFirstElement());
	}

	@Test
	public void testRetrieveLastElement() {
		assertEquals("green", testString.retrieveLastElement());
		testString.addToEnd("last");
		assertEquals("last", testString.getLast());
		assertEquals("last", testString.retrieveLastElement());
		assertEquals("planet", testString.retrieveLastElement());
	}

	@Test
	public void testToArrayList() {
		ArrayList<Plant> list;
		testplant.addToFront(a);
		testplant.addToEnd(d);
		list= testplant.toArrayList();
		assertEquals(a,list.get(0));
		assertEquals(a,list.get(1));
		assertEquals(b,list.get(2));

	}

	@Test
	public void testIterator() {
		testString.addToFront("hello");
		testString.addToEnd("bye");
		Iterator<String> iterator = testString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("hello", iterator.next());
		assertEquals("planet", iterator.next());
		
	}
	public class StringComparator implements Comparator<String>{
		public int compare(String a, String b) {
			return a.compareTo(b);
		}
	}
	
	
	public class DoubleComparator implements Comparator<Double>{
		public int compare(Double a, Double b) {
			return a.compareTo(b);
		}
	}
	public class PlantComparator implements Comparator<Plant>{
		public int compare(Plant a, Plant b) {
			return a.toString().compareTo(b.toString());
		}
	}
	
	public class Plant{
		String name;
		String type;
		int humidity;
		public Plant(String name, String type, int humidity) {
			super();
			this.name = name;
			this.type = type;
			this.humidity = humidity;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public int getHumidity() {
			return humidity;
		}
		public void setHumidity(int humidity) {
			this.humidity = humidity;
		}
		@Override
		public String toString() {
			return name + " " + type + " " + humidity + " ";
		}
		
	}

}
