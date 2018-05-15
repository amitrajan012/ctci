package Chapter1;
/**
 * 
 * @author amitrajan
 * Write a method to decide if two strings are anagrams or not.
 *
 */

public class Q1_4 {
	public static boolean checkAnagram(String s1, String s2) {
		//Base case
		if(s1.length() != s2.length()) return false;
		int[] temp = new int[128];
		for(int i=0;i<s1.length();i++) {
			temp[s1.charAt(i)]++;
			temp[s2.charAt(i)]--;
		}
		
		for(int i: temp) {
			if(i != 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkAnagram("m", "n"));
	}
}
