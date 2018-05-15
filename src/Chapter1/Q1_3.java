package Chapter1;
/**
 * 
 * @author amitrajan
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 *  NOTE: One or two additional variables are fine. An extra copy of the array is not.
 *
 */

public class Q1_3 {
	public static String removeDuplicates(String word) {
		//Assumption: String has characters a-z
		//Concept used is same as Question 1
		int check = 0;
		char[] res = word.toCharArray();
		for(int i=0;i<res.length;i++) {
			int bitAtIndex = res[i];
			if((check & (1 << bitAtIndex)) > 0) {
				//Duplicate character found: Remove it
				res[i] = '\0';
			}
			check = check | (1 << bitAtIndex);
		}
		return String.valueOf(res);
	}

	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle", "abcdee"};
		for (String word : words) {
			System.out.println(word + ": " + removeDuplicates(word));
		}
	}
}
