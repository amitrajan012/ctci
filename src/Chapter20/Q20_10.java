package Chapter20;
/*
 * Given two words of equal length that are in a dictionary, write a method to transform one word into another word by changing only one letter at a time.
 * The new word you get in each step must be in the dictionary.
 * EXAMPLE: Input: DAMP, LIKE
 * Output: DAMP -> LAMP -> LIMP -> LIME -> LIKE
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Q20_10 {
	//We can consider a graph in which words that are one edit away from each word are the adjacent node for it.
	//We can implement BFS(using Queue) and can reach eventually to the desired word
	//The path needs to be backtracked as well. This can be implemented using a TreeMap (ordering preserved)
	//In the map, if B[v] = w, w is obtained by editing v
	//When we reach the end, this backtrack map can be used to reverse the path
	
	public static LinkedList<String> transform(String startWord, String stopWord, Set<String> dictionary) {
		startWord = startWord.toUpperCase();
		stopWord = stopWord.toUpperCase();
		
		Queue<String> queue = new LinkedList<String>();
		Set<String> visitedSet = new HashSet<String>();
		Map<String, String> backtrackMap = new TreeMap<String, String>(); //TreeMap is used as order of word is required while backtracking
		
		queue.add(startWord);
		visitedSet.add(startWord);
		
		//Implement BFS
		while(!queue.isEmpty()) {
			String w = queue.poll();
			//For each one edit word
			for(String v: getOneEditWords(w)) {
				if(v.equals(stopWord)) {
					//Stop and backtrack as the word is found
					LinkedList<String> res = new LinkedList<String>();
					res.add(v);//Add stop word/last word
					while(w != null) {
						res.add(0, w);
						w = backtrackMap.get(w);
					}
					return res;
				}
				if(dictionary.contains(v)) {
					if(!visitedSet.contains(v)) {
						queue.add(v);
						visitedSet.add(v);
						backtrackMap.put(v, w);
					}
				}
			}
		}
		return null;
	}

	private static Set<String> getOneEditWords(String w) {
		Set<String> words = new TreeSet<String>();
		for(int i=0;i<w.length();i++) {
			char[] wordArray = w.toCharArray();
			//Change the letter to something else
			for(char c = 'A'; c <= 'Z'; c++) {
				if(c != wordArray[i]) {
					wordArray[i] = c;
					words.add(new String(wordArray));
				}
			}
		}
		return words;
	}
	
	public static void main(String[] args) {
		String[] dict = {"DAMP", "CAMP", "RAMP", "LAMP", "LAMB", "LIMP", "LINT", "LIME", "LAME", "LIKE"}; 
		Set<String> dictionary = new HashSet<String>(Arrays.asList(dict));
		
		LinkedList<String> res = transform("damp", "like", dictionary);
		for(String s: res) {
			System.out.print(s + " -> ");
		}
	}
	
}
