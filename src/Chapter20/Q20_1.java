package Chapter20;
/*
 * Write a function that adds two numbers. You should not use + or any arithmetic operators.
 */
public class Q20_1 {
	public static int add(int A, int B) {
		int carry = 0;
		int bit = 0;
		int res = 0;
		while(A > 0 || B > 0) {
			int a = A & 1;
			int b = B & 1;
			//Conditional statements can be written for the following operations
			res = res | (((a+b+carry) % 2) << bit);
			carry = (a+b+carry)/2;
			bit++;
			A = A >> 1;
			B = B >> 1;
		}
		if(carry == 1) {
			res = res | (carry << bit);
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println("Sum:" +add(182, 1980));
	}
}