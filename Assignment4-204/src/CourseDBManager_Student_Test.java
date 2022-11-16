import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class CourseDBManager_Student_Test {

	private CourseDBManager data = new CourseDBManager();

	@Before
	public void setUp() throws Exception {
		data = new CourseDBManager();
	}

	@After
	public void tearDown() throws Exception {
		data = null;
	}

	@Test
	void testAddToDB() {
		try {
			data.add("Yoga101", 123456, 3, "SC500", "teacher1");
		} catch (Exception e) {
			fail("Should have not thrown an exception");
		}
	}

	@Test
	public void testShowAll() {
		data.add("yoga101", 123456, 3, "SC500", "Teacher1");
		data.add("yoga201", 11111, 4, "SC550", "teacher2");
		data.add("yoga301", 22222, 2, "SC600", "teacher3");
		ArrayList<String> datapoints = data.showAll();
		assertEquals(datapoints.get(0), "\nCourse:yoga101 CRN:123456 Credits:3 Instructor:Teacher1 Room:SC500");
		assertEquals(datapoints.get(1), "\nCourse:yoga201 CRN:11111 Credits:4 Instructor:Teacher2 Room:SC550");
	}
}
