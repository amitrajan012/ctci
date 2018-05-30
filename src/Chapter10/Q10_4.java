package Chapter10;
/*
 * Write a method to implement *, - , / operations. You should use only the + operator
 * Assumption: Implementation is for positive integers (Can be easily extended for negative integers)
 */
public class Q10_4 {
	public static int multiply(int m, int n) {
		int res = 0;
		for(int i=1;i<=n;i++) {
			res += m;
		}
		return res;
	}
	
	public static int divide(int m, int n) {
		int res = 0;
		while(m > 0) {
			m -= n;
			res++;
		}
		return res;
	}
	
	public static int subtract(int m, int n) {
		while(n>0) {
			m += -1;
			n--;
		}
		return m;
	}
	
	public static void main(String[] args) {
		System.out.println(subtract(23, 7));
		System.out.println(divide(21, 3));
		System.out.println(multiply(11, 9));
	}
}
