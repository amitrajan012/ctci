package Chapter19;
/*
 * Write a method which finds the maximum of two numbers. You should not use if-else or any other comparison operator.
 */
public class Q19_4 {
	public static int findMax(int a, int b) {
		//a-b is positive(Sign bit 0) if a is max and negative(Sign bit 1) if b is max
		//Hence we can return a - (Sign Bit) * (a-b)
		int temp = a-b;
		return a - ((temp >> 31) & 1)*temp;
	}
	
	public static void main(String[] args) {
		int a = 23, b = 65;
		System.out.println("Max of " + a + " and " + b + " is: " + findMax(a, b));
	}
}
