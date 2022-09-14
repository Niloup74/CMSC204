import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords1;
	ArrayList<String> passwords2;

	@Before
	public void setUp() throws Exception {
		String[] p = {"899678VV#", "gretge2MMM#", "3Helr#", "pablos55", "september66", "sder4W", 
				"Fgolesfrrr3#", "aased4T", "Assignment1", "HHHhello3"};
		passwords1 = new ArrayList<String>();
		passwords1.addAll(Arrays.asList(p));
		
	}

	@After
	public void tearDown() throws Exception {
		passwords1 = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("heLlo"));
			assertTrue("Did not throw ex", false);
		}
		catch(LengthException e){
			assertTrue("Successfully threw a lengthExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides lengthException",false);
		}
		
		
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword("Hello#3423w"));
			assertTrue("Did not throw ex", true);}
		catch(Exception e)
		{
			assertTrue("Threw some other exception",false);
		}
		

	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("lkjhgfd"));
			 
			assertTrue("Did not throw NoUpperAlphaException",false);
		}
		catch(NoUpperAlphaException e) {
			assertTrue("Successfully threw a NoUpperAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",false);
		}
		
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("lLjhgfd"));
			 
			assertTrue("Did not throw NoUpperAlphaException",true);
		}
		catch(NoUpperAlphaException e) {
			assertTrue("threw a NoUpperAlphaExcepetion",false);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoUpperAlphaException",true);
		}
		
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("HELLO435"));
 
			assertTrue("Did not throw NoLowerAlphaException",false);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",false);
		}
		try{
			assertTrue(PasswordCheckerUtility.isValidPassword("HELLo435"));
 
			assertTrue("Did not throw NoLowerAlphaException",true);
		}
		catch(NoLowerAlphaException e)
		{
			assertTrue("threw a NoLowerAlphaExcepetion",false);
		}
		catch(Exception e)
		{
			assertTrue("Threw some other exception besides NoLowerAlphaException",true);
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try{
			 
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("5623#Ss");
			assertTrue("Did not throw WeakPassword Exception",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("Successfully threw a NoLowerAlphaExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
		try{
			 
			boolean weakPwd = PasswordCheckerUtility.isWeakPassword("5623#SsKlEr");
			assertTrue("Did not throw WeakPassword Exception",true);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("threw a NoLowerAlphaExcepetion",false);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some incorrect exception",false);
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("123#Jlllkgt"));
		 	assertTrue("Did not throw an InvalidSequenceException",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("Successfully threw an InvalidSequenceExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("123#Jlljkgt"));
		 	assertTrue("Did not throw an InvalidSequenceException",true);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("threw an InvalidSequenceExcepetion",false);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("rthd#Jkllkgtk"));
		 	assertTrue("Did not throw a NoDigitException",false);
		}
		catch(NoDigitException e)
		{
			assertTrue("Successfully threw a NoDigitExcepetion",true);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides a NoDigitException",false);
		}
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("123#Jlljkgt"));
		 	assertTrue("Did not throw a NoDigitException",true);
		}
		catch(NoDigitException e)
		{
			assertTrue("threw a NoDigitExcepetion",false);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides an InvalidSequenceException",false);
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("r3thd#Jkllkgtk"));
		 	assertTrue("Did not throw any exception",true);
		}
		catch(NoDigitException e)
		{
			assertTrue(" threw a NoDigitExcepetion",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("threw an InvalidSequenceExcepetion",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("threw a NoLowerAlphaExcepetion",false);
		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides a NoDigitException",false);
		}
		try{
			assertEquals(true,PasswordCheckerUtility.isValidPassword("r3thdJkllkgtk"));
		 	assertTrue("Did not throw any exception",false);
		}
		catch(NoDigitException e)
		{
			assertTrue(" threw a NoDigitExcepetion",false);
		}
		catch(InvalidSequenceException e)
		{
			assertTrue("threw an InvalidSequenceExcepetion",false);
		}
		catch(WeakPasswordException e)
		{
			assertTrue("threw a NoLowerAlphaExcepetion",false);
		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
			assertTrue("Threw some other exception besides a NoDigitException",true);
		}

	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> invalidPass;
		invalidPass = PasswordCheckerUtility.getInvalidPasswords​(passwords1);
		ArrayList<String> trueInvalid;
		String[] s = {"899678VV#", "gretge2MMM#", "3Helr#", "pablos55", "september66", "sder4W", 
				"Fgolesfrrr3#","aased4T", "Assignment1", "HHHhello3"};
		trueInvalid = new ArrayList<String>();
		trueInvalid.addAll(Arrays.asList(s));
		boolean status = true;
		for(int i=0; i < trueInvalid.size(); i++) {
			if(!trueInvalid.get(i).equals(invalidPass.get(i))){
				status = false;
			}
		}
		if(trueInvalid.size() != invalidPass.size())
		status = false;
		assertTrue(status);
	}
	
}
