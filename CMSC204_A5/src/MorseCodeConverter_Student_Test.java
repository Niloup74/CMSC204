import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import org.junit.jupiter.api.Test;

class MorseCodeConverter_Student_Test {
	File codef;

	@Test
	void testConvertToEnglishString() {
		String w = MorseCodeConverter.convertToEnglish("-. .. .-.. --- --- / .-- .-. --- - . / - .... .. ...");
		assertEquals("niloo wrote this",w);
	}
	@Test
	public void testConvertoEnglishFile()throws FileNotFoundException{
		File file = new File("src/LoveLooksNot.txt");
		try {
			assertEquals("love looks not with the eyes but with the mind",MorseCodeConverter.convertToEnglish(file));
		}
		catch(FileNotFoundException e) {
			assertTrue("An unwanted exception was caught", false);
		}
	}

}
