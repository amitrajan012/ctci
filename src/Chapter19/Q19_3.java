package Chapter19;
/*
 * Write an algorithm which computes the number of trailing zeros in n factorial.
 */
public class Q19_3 {
	public static int findTrailingZeroes(int N) {
		int res = 0;
		for(int i=5;N/i>0;i*=5) {
			res += N/i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int N = 25;
		System.out.println("Number of trainling zeroes in " + N + "! is: " +findTrailingZeroes(N));
	}
}
