import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * 
 * @author Niloufar Zafari
 *
 */

public class PasswordCheckerUtility {


	
/**
 * 
 * @param password
 * @param passwordConfirm
 */
public static void comparePasswords(String password , String passwordConfirm) {
	if(password.equals(passwordConfirm)) {
		System.out.println("Passwords match");}
		else {
			
			System.out.println("Passwords do not match");
			throw new UnmatchedException();
		}
	
}

/**
 * 
 * @param password
 * @param passwordConfirm
 * @return true if password and passwordconfirm are same
 */
public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
	return password.equals(passwordConfirm);
}





/**
 * 
 * @param passwords
 * @return the arraylist of invalid passwords in passowrds.
 */
public static ArrayList<String>  getInvalidPasswords​(ArrayList<String> passwords){
	ArrayList<String> invalidList = new ArrayList<String>();
	for(String p: passwords) {
		try {
			isValidPassword(p);
		}
		catch(Exception exception){
			invalidList.add(p + " -> " +exception.getMessage());
		}
		
	}
	return invalidList;
}



/**
 * 
 * @param password
 * @return true if password contains between 6-9 chars
 */
public static boolean hasBetweenSixAndNineChars(String password) {
boolean status = false;
if(password.length() >= 6 && password.length() <= 9)
	status= true;
return status;
}

/**
 * 
 * @param password
 * @return true if passowrd contains digits
 * @throws NoDigitException
 */
public static boolean 	hasDigit​(String password) throws NoDigitException{
	boolean status = false;
	for (int i = 0; i < password.length(); i++) {
		if(Character.isDigit(password.charAt(i)))
			status = true;
	}
	if(status == true) {
		return status;
	}
	throw new NoDigitException();
}


/**
 * 
 * @param password
 * @return true if password has lower case 
 * @throws NoLowerAlphaException
 */
public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException{
	boolean status = false;
	for(int i = 0; i < password.length(); i++) {
		if(Character.isLowerCase(password.charAt(i))) {
			status = true;
		}
	}
	if(status == false)
	{throw new NoLowerAlphaException();}
	return status;
	
}

/**
 * 
 * @param password
 * @return false if there is no special char
 * @throws NoSpecialCharacterException
 */

public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException{
	Pattern pat = Pattern.compile("[^A-Za-z0-9]");
	Matcher mat = pat.matcher(password);
	if(!mat.find()) {
		throw new NoSpecialCharacterException();
	}
	return true;
}

/**
 * 
 * @param password
 * @return false if does not contain upper
 * @throws NoUpperAlphaException
 */

public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException{
	boolean status = false;
	for(int i =0; i<password.length();i++) {
		if(Character.isUpperCase(password.charAt(i))) {
			status = true;
		}
	}
	if(status == false) {
		throw new NoUpperAlphaException();
	}
	return status;
	
}


/**
 * *
 * @param password
 * @return false if length is less than 6
 * @throws LengthException
 */
public static boolean isValidLength(String password) throws  LengthException{
	if(password.length()< 6) {
	throw new LengthException();}
	return true;
}



/**
 * 
 * @param password
 * @return true if passowrd is valid
 * @throws InvalidSequenceException
 * @throws NoDigitException
 * @throws NoLowerAlphaException
 * @throws NoSpecialCharacterException
 * @throws NoUpperAlphaException
 * @throws LengthException
 */
public static boolean isValidPassword(String password) throws InvalidSequenceException, NoDigitException, NoLowerAlphaException, NoSpecialCharacterException, NoUpperAlphaException, LengthException {
	boolean status = false;
	isValidLength(password);
	hasUpperAlpha(password);
	noSameCharInSequence(password);
	if(isValidLength(password)&& hasDigit​(password) && hasLowerAlpha(password) && hasSpecialChar(password) && hasUpperAlpha(password)
		 && noSameCharInSequence(password)) {
		status = true;
	}
	return status;
}

/**
 * 
 * @param password
 * @return return true if passowrd is weak and less than 10 chars
 * @throws NoDigitException
 * @throws NoLowerAlphaException
 * @throws NoSpecialCharacterException
 * @throws NoUpperAlphaException
 * @throws LengthException
 */
public static boolean isWeakPassword(String password) throws NoDigitException, NoLowerAlphaException, NoSpecialCharacterException, NoUpperAlphaException, LengthException {
	if (password.length()<10){
		throw new WeakPasswordException();
	}
	return false;
}


/**
 * 
 * @param password
 * @return return false if same char is in sequence more than 2 times.
 * @throws InvalidSequenceException
 */
public static boolean noSameCharInSequence(String password) throws InvalidSequenceException{
	boolean status = true;
	if(password.length() <= 3 && password.charAt(0) != password.charAt(1))
		return true;
	if(password.length() <= 3 && password.charAt(0) == password.charAt(1) && password.charAt(2)== password.charAt(0))
		throw new InvalidSequenceException();
	if(password.length() >3 && (password.charAt(0) == password.charAt(1)) && password.charAt(0)== password.charAt(2)) {
	
		throw new InvalidSequenceException();
	
	}
	if(password.length() > 3 && password.charAt(0)!= password.charAt(1)) {
		noSameCharInSequence(password.substring(1));
	}
	return status;
}

}
