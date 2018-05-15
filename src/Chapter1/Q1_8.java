package Chapter1;
/**
 * 
 * @author amitrajan
 * Assume you have a method isSubstring which checks if one word is a substring of another. 
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring (i.e., “waterbottle” is a rotation of “erbottlewat”).
 *
 */

public class Q1_8 {
	public static boolean checkSubstring(String s1, String s2) {
		StringBuilder sb = new StringBuilder(s1);
		sb.append(s1);
		return sb.toString().contains(s2);
		
	}
	
	public static void main(String[] args) {
		System.out.println(checkSubstring("erbottlewat", "waterbottle"));
	}

}
