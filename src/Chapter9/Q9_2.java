package Chapter9;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class Q9_2  implements Comparator<String>{
	public String sortChars(String s) {
		char[] C = s.toCharArray();
		Arrays.sort(C);
		return new String(C);
	}
	@Override
	public int compare(String s1, String s2) {
		return sortChars(s1).compareTo(sortChars(s2));
	}
	
	public static void main(String[] args) {
		String[] in = {"abcde", "def", "edcba"};
		Arrays.sort(in, new Q9_2());
		for(String s: in) {
			System.out.println(s);
		}
	}
}
