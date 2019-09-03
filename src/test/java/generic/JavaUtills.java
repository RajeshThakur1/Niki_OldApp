package generic;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaUtills {
	
	public static String extractFloat(String text) {
		String s = text;
		String findText=null;
	    Pattern p = Pattern.compile("\\d*\\.\\d+");
	    Matcher m = p.matcher(s);
	    while(m.find()){
	    	findText=m.group();
	        System.out.println(m.group());
	    }
	    return findText;
	}
	
	
	public  String generateRandomChars(String candidateChars, int length) {
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < length; i++) {
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars
	                .length())));
	    }

	    return sb.toString();
	}

	

}
