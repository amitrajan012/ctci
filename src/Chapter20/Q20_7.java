package Chapter20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/*
 * Write a program to find the longest word made of other words in a String Array.
 */

public class Q20_7 {
	public static String findLongestWord(String[] A){
		Arrays.sort(A, new LengthComparator());
		Set<String> set = new HashSet<String>();
		for(String s: A) {
			set.add(s);
		}
		
		for(int i=0;i<A.length;i++) {
			String s = A[i];
			for(int len=1;len<A[i].length()-1;len++) {
				String s1 = s.substring(0, len);
				String s2 = s.substring(len, A[i].length());
				if(set.contains(s1) && set.contains(s2)) {
					return s;
				}
			}
		}
		return "";
	}
	
	public static void main(String[] args) {
		String[] A = {"test", "tester", "testertest", "testing", "testingtester"};
		System.out.println(findLongestWord(A));
	}
}

class LengthComparator implements Comparator<String>{
	//Implemented to reverse sort by length
	@Override
	public int compare(String s0, String s1) {
		if(s0.length() < s1.length()) return 1;
		if(s0.length() > s1.length()) return -1;
		return 0;
	}

}


