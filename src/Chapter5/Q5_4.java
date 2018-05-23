package Chapter5;
/**
 * 
 * Write a function to determine the number of bits required to convert integer A to integer B.
 *
 */
public class Q5_4 {
	public static int bitRequired(int N, int M) {
		return Q5_3.count(N ^ M);
	}
	
	public static void main(String[] args) {
		System.out.println("Required bits to flipped are: " + bitRequired(31, 14));
	}
}
