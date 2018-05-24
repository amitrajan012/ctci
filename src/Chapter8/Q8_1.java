package Chapter8;
/**
 * 
 * Write a method to generate the nth Fibonacci number
 *
 */
public class Q8_1 {
	public static int fibonacci(int n) {
		if(n == 0) return 0;
		else if(n == 1) return 1;
		else if(n > 1) return fibonacci(n-1) + fibonacci(n-2);
		else return -1; //Error
	}
	
	public static void main(String[] args) {
		System.out.println(fibonacci(12));
	}
}
