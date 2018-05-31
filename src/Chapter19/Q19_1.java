package Chapter19;
/*
 * Write a function to swap a number in place without temporary variables.
 */
public class Q19_1 {
	public static void main(String[] args) {
		int a = 13, b = 23;
		a = a+b;
		b = a-b;
		a = a-b;
		System.out.println("First Number: " +a);
		System.out.println("Second Number: " +b);
	}
}
