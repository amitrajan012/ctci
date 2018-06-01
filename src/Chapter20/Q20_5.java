package Chapter20;
/*
 * You have a large text file containing words. Given any two words, find the shortest distance (in terms of number of words) between them in the file. 
 * Can you make the searching operation in O(1) time? What about the space complexity for your solution?
 */
public class Q20_5 {
	public static int findMinDistance(String[] words, String word1, String word2) {
		int min = Integer.MAX_VALUE;
		int word1Pos = Integer.MIN_VALUE/2;
		int word2Pos = Integer.MIN_VALUE/2;
		for(int i=0;i<words.length;i++) {
			String word = words[i];
			if(word.equals(word1)) {
				word1Pos = i;
				int d = Math.abs(word2Pos - word1Pos);
				if(d < min) {
					min = d;
				}
			}else if(word.equals(word2)) {
				word2Pos = i;
				int d = Math.abs(word2Pos - word1Pos);
				if(d < min) {
					min = d;
				}
			}
		}
		return min-1;
	}
	
	public static void main(String[] args) {
		String[] words = {"ram", "term", "asd", "asf", "asd", "as"};
		int d = findMinDistance(words, "asd", "as");
		System.out.println(d);
	}
}
