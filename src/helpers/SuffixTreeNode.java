package helpers;

import java.util.ArrayList;
import java.util.HashMap;

public class SuffixTreeNode {
	HashMap<Character, SuffixTreeNode> children = new HashMap<Character, SuffixTreeNode>();
	char value;
	ArrayList<Integer> indexes = new ArrayList<Integer>();
	
	public SuffixTreeNode() { }
	
	public void insertString(String S, int index) {
		indexes.add(index);
		if(S != null && S.length() > 0) {
			value = S.charAt(0);
			SuffixTreeNode child = null;
			if(children.containsKey(value)) {
				child = children.get(value);
			}else {
				child = new SuffixTreeNode();
				children.put(value, child);
			}
			String remainder = S.substring(1);
			child.insertString(remainder, index);
		}
	}
	
	public ArrayList<Integer> getIndexes(String S) {
		if(S == null || S.length() == 0) {
			return indexes;
		}else {
			char first = S.charAt(0);
			if(children.containsKey(first)) {
				String remainder = S.substring(1);
				return children.get(first).getIndexes(remainder);
			}
		}
		return null;
	}
}