package helpers;

import java.util.ArrayList;

public class SuffixTree {
	SuffixTreeNode root = new SuffixTreeNode();
	public SuffixTree(String S) {
		for(int i=0;i<S.length();i++) {
			String suffix = S.substring(i);
			root.insertString(suffix, i); //Begin index of string
		}
	}
	
	public ArrayList<Integer> getIndexes(String S) {
		return root.getIndexes(S);
	}
}
