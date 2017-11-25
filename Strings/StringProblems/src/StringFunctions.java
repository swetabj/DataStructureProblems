import java.util.Arrays;


public class StringFunctions {

	/*Implement an algorithm to determine if a string has all unique characters. What if you cannot
	use additional data structures? */
	public Boolean uniqueCharInString(String s) {
		s = stringSorting(s);
		
		for(int i=0;i<s.length()-1;i++) {
			if(s.charAt(i) == s.charAt(i+1)) {
				System.out.println("Given String doesnot have unique characters");
				return false;
			}
		}
		System.out.println("Given String have unique characters");
		return true;
	}
	
	public String stringSorting(String s) {
		char c[] = s.toCharArray();
		Arrays.sort(c);
		return String.valueOf(c);
	}
}
