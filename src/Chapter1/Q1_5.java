package Chapter1;
/**
 * 
 * @author amitrajan
 * Write a method to replace all spaces in a string with ‘%20’.
 *
 */
public class Q1_5 {
	public static String replaceSpace(String s) {
		StringBuilder sb = new StringBuilder();
		for(char c: s.toCharArray()) {
			if(c == ' ') {
				sb.append("%20");
			}else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(replaceSpace("a m n "));
	}
}
