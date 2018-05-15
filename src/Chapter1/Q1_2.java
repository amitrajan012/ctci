package Chapter1;
/**
 * 
 * @author amitrajan
 * Write code to reverse a C-Style String. (C-String means that “abcd” is represented as five characters, including the null character.)
 *
 */

public class Q1_2 {
	public static String reverseString(String s) {
		char[] res = s.toCharArray();
		int start = 0, end = s.length()-1;
		while(start < end) {
			char temp = res[start];
			res[start] = res[end];
			res[end] = temp;
			start++;
			end--;
		}
		return String.valueOf(res);
	}
	
	public static void main(String[] args) {
		String s = "This is a demo!!!";
		System.out.println(reverseString(s));
	}
}
