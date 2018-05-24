package Chapter8;
/**
 * 
 * Write a method to compute all permutations of a string.
 *
 */

import java.util.ArrayList;

public class Q8_4 {
	public static ArrayList<String> findPermutations(String s, int index) {
		ArrayList<String> permutations = new ArrayList<String>();
		if(s.length() == index) {
			permutations.add(new String(""));
		}else {
			ArrayList<String> temp = new ArrayList<String>();
			permutations = findPermutations(s, index+1);
			Character c = s.charAt(index);
			for(String l: permutations) {
				temp.add(new StringBuilder(l).append(c).toString());
			}
			permutations.addAll(temp);
		}
		return permutations;
	}
	
	public static void main(String[] args) {
		ArrayList<String> res = findPermutations("abc", 0);
		for(String s: res) {
			System.out.println(s);
		}
	}
}
