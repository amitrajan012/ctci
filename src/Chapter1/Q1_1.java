package Chapter1;
/**
 * 
 * @author amitrajan
 * Implement an algorithm to determine if a string has all unique characters. What if you can not use additional data structures?
 *
 */
public class Q1_1 {
	public static boolean isUnique(String s) {
		//Base case
		if(s.length() > 128) return false;
		boolean[] b = new boolean[128];
		for(char c: s.toCharArray()) {
			if(b[c]) {
				return false;
			}else {
				b[c] = true;
			}
		}
		return true;
	}
	
	/**
	 * Without extra space
	 * @param s
	 * @return
	 */
	public static boolean isUnique2(String s) {
		//Valid for strings having alphabet as a-z
		//Maintain an integer value of 32 bits and instead of making the boolean array false, set the bits of this integer
		//Base case
		if(s.length() > 26) return false;
		int check = 0; 
		for(char c: s.toCharArray()) {
			int bitAtIndex = c - 'a';
			//Shift left 1 to set the bit at corresponding position
			if((check & (1 << bitAtIndex)) > 0) {
				return false;
			}
			//Set the bit as character found
			check = check | (1 << bitAtIndex);
		}
		return true;
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle", "abcdee"};
		for (String word : words) {
			System.out.println(word + ": " + isUnique2(word));
		}
	}
}
