package Chapter20;

import java.util.ArrayList;

import helpers.SuffixTree;

/*
 * Given a string S and an array of smaller strings T, design a method to search S for each small string in T.
 */
public class Q20_8 {
	public static void main(String[] args) {
		String S = "mississippi";
		String[] list = {"is", "sip", "hi", "sis"};
		SuffixTree tree = new SuffixTree(S);
		for(String s: list) {
			ArrayList<Integer> indexes = tree.getIndexes(s);
			if(indexes != null) {
				System.out.println("Indexes of " + s + " : " + indexes.toString());
			}
		}
	}
}
