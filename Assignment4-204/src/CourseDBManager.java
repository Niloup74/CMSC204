import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
/*
 * @author Niloufar Zafari
 * CMSC204 Assignment4
 */

public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure structure;

	public CourseDBManager() {
		structure = new CourseDBStructure(10);
	}

	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement ele = new CourseDBElement(id, crn, credits, roomNum, instructor);
		structure.add(ele);

	}

	@Override
	public CourseDBElement get(int crn) {
		try {
			return structure.get(crn);
		} catch (IOException e) {
			e.getMessage();
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		if (!input.exists()) {
			throw new FileNotFoundException();
		}

		ArrayList<String> inputfile = new ArrayList<>();

		Scanner scanner = new Scanner(input);
		while (scanner.hasNextLine()) {
			String result = scanner.nextLine();
			if (result != " ") {
				inputfile.add(result);
			}
		}
		scanner.close();
		for (String inputs : inputfile) {
			String[] inputArray = inputs.split(" ");
			String courseId = inputArray[0];
			int crnNum = Integer.parseInt(inputArray[1]);
			int credits = Integer.parseInt(inputArray[2]);
			String room = inputArray[3];
			String instructor = String.join(" ", Arrays.copyOfRange(inputArray, 4, inputArray.length));
			add(courseId, crnNum, credits, room, instructor);
		}

	}

	@Override
	public ArrayList<String> showAll() {
		ArrayList<CourseDBElement> list = new ArrayList<>();
		ArrayList<String> list2;
		for (int i = 0; i < structure.getTableSize(); i++) {
			if (structure.hashTable[i] != null) {
				list.addAll(structure.hashTable[i]);
			}
		}
		list2 = (ArrayList<String>) list.stream().map(s -> s.toString()).collect(Collectors.toList());
		return list2;
	}

}
