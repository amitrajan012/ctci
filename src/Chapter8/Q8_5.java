package Chapter8;
/**
 * 
 * Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n-pairs of parentheses.
 *
 */
public class Q8_5 {
	public static void printParentheses(int left, int right, char[] str, int count) {
		//On each recursion, a particular index is present at which either a left or right paren can be inserted
		//Left paren can be inserted as long as all the left parens are not used
		//Right paren can be inserted if there is no syntax error, Syntax error occurs if number of right paren exceeds left paren
		if(left == 0 && right == 0) {
			//String is found and hence print
			System.out.println(str);
		}else {
			if(left > 0) {
				//Try inserting left paren
				str[count] = '(';
				printParentheses(left-1, right, str, count+1);
			}
			if(right > 0 && right > left) {
				//Try right paren
				str[count] = ')';
				printParentheses(left, right-1, str, count+1);
			}
		}
	}
	
	public static void main(String[] args) {
		int count = 3;
		char[] str = new char[2*count];
		printParentheses(count, count, str, 0);
	}
}
