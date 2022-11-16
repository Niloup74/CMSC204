import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/*
 * @author Niloufar Zafari
 * CMSC204 Assignment4
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	private int size;
	private int elementsize;

	LinkedList<CourseDBElement>[] hashTable;

//constructor #1	
	public CourseDBStructure(int n) {
		size = n;
		hashTable = new LinkedList[n];
	}

//constructor#2
	public CourseDBStructure(String string, int n) {
		size = n;
		hashTable = new LinkedList[n];
	}

	@Override
	public void add(CourseDBElement element) {
		boolean status = true;
		int index = getHashIndex(element);
		if (hashTable[index] == null) {
			hashTable[index] = new LinkedList<CourseDBElement>();

		}
		for (CourseDBElement listElement : hashTable[index])
			if (listElement.compareTo(element) == 0)
				status = false;

		if (status = true) {
			hashTable[index].add(element);
			elementsize++;
		}

	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		CourseDBElement result = null;

		for (LinkedList<CourseDBElement> list : hashTable) {
			if (list != null) {
				for (CourseDBElement elements : list) {
					if (elements.compareTo(new CourseDBElement("", crn, 0, "", "")) == 0) {
						result = elements;
					}
				}
			}

		}
		if (result == null) {
			throw new IOException();
		}

		return result;
	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> courselist = new ArrayList<String>();
		String result;
		for (int i = 0; i < size; i++) {
			// while (hashTable[i] != null) {
			for (int k = 0; k < hashTable[i].size(); k++) {
				result = hashTable[i].get(k).toString();
				Collections.sort(courselist);

			}
		}
		return courselist;
	}

	@Override
	public int getTableSize() {
		return size;
	}

	public int getHashIndex(CourseDBElement element) {
		int hashIndex = element.hashCode() % hashTable.length; // HashCode
		if (hashIndex < 0) {
			hashIndex += hashTable.length;
		}
		return hashIndex;
	}

}
