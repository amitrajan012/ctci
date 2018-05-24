package Chapter8;
/*
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent), 
 * write code to calculate the number of ways of representing n cents.
 */
public class Q8_7 {
	public static int makeChange(int n, int denom) {
		int nextDenom = 0;
		switch(denom) {
		case 25:
			nextDenom = 10;
			break;
		case 10:
			nextDenom = 5;
			break;
		case 5:
			nextDenom = 1;
			break;
		case 1:
			return 1;
		}
		int ways = 0;
		for(int i=0; i*denom <= n; i++) {
			ways += makeChange(n-i*denom, nextDenom);
		}
		return ways;
	}
	
	public static void main(String[] args) {
		System.out.println(makeChange(25, 25));
	}
}
