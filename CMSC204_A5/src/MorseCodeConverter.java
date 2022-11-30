import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	/*
	 * parameters
	 */
	private static MorseCodeTree codetree = new MorseCodeTree();
	
	
	/*
	 * methods
	 */
	public static String printTree() {
		String result = "";
		ArrayList<String>list=new ArrayList<String>();
		list=codetree.toArrayList();
		for(int i=0;i<list.size();i++) {
			result+=list.get(i);
		}
		return result;
	}
	
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		Scanner scanner = new Scanner(codeFile);
		String result ="";
		while(scanner.hasNext()) {
			result+=convertToEnglish(scanner.nextLine());
		}
		return result;
	}
	
	public static String convertToEnglish(String code) {
      String[] codeW;
      String[] codeL;
      String result="";
      codeW=code.split("/");
      for(int i =0;i<codeW.length;i++) {
    	  codeW[i]=codeW[i].trim();
    	  codeL=codeW[i].split(" ");
    	  for(int k=0;k<codeL.length; k++) {
    		  result+=codetree.fetch(codeL[k]);
    	  }
    	  result+=" ";
      }
      result=result.trim();
      return result;
	}

}
