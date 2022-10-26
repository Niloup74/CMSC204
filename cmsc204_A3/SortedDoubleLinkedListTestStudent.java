


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class SortedDoubleLinkedListTestStudent {
	SortedDoubleLinkedList<String> testString;
	SortedDoubleLinkedList<Double> testDouble;
	SortedDoubleLinkedList<Plant> testplant;
	StringComparator comparator;
	DoubleComparator comparatorD;
	PlantComparator comparatorP;
	
	public Plant a=new Plant("prickly", "cactus", 43);
	public Plant b=new Plant("angle", "begonia", 75);
	public Plant c=new Plant("rubber", "ficus", 75);
	public Plant d=new Plant("Subaru", "Outback", 2005);
	//b a c d

	
	@Before
	public void setUp() throws Exception {
		comparator = new StringComparator();
		testString = new SortedDoubleLinkedList<String>(comparator);
		
		comparatorD = new DoubleComparator();
		testDouble = new SortedDoubleLinkedList<Double>(comparatorD);
		
		comparatorP = new PlantComparator();
		testplant = new SortedDoubleLinkedList<Plant>(comparatorP);
		
	}

	@After
	public void tearDown() throws Exception {
		comparator = null;
		comparatorD = null;
		comparatorP = null;
		testString = null;
		testDouble = null;
		testplant = null;
	}

	@Test
	public void testAddToEnd() {
		try {
			testString.addToEnd("error");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testAddToFront() {
		try {
			testString.addToFront("Hello");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	public void testIteratorSuccessfulNext() {
		testplant.add(a);
		testplant.add(b);
		testplant.add(c);
		testplant.add(d);
		ListIterator<Plant> iterator = testplant.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals(d, iterator.next());
		assertEquals(b, iterator.next());
		assertEquals(a, iterator.next());
		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testIteratorSuccessfulStringPrevious() {
		testString.add("first");
		testString.add("second");
		testString.add("Hello");
		
		ListIterator<String> iterator = testString.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("Hello", iterator.next());
		assertEquals("first", iterator.next());		
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
			return arg0.getType().compareTo(arg1.getType());
		}		
	}
	
	private class Plant{
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
		
		
	}
}
