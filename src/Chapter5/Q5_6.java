package Chapter5;
/**
 * 
 * Write a program to swap odd and even bits in an integer with as few instructions as possible.
 *
 */
public class Q5_6 {
	public static int swapOddEven(int N) {
		//Mask all odd bits with 10101010 in binary (which is 0xAA), then shift them right to put them in the even bits.
		int res = 0 | ((N & 0xaaaaaaaa) >> 1);
		//Mask all even bits with 01010101 in binary (which is 0x55), then shift them left to put them in the odd bits.
		res = res | ((N & 0x55555555) << 1);
		 return res;
	}
	
	public static void main(String[] args) {
		System.out.println("Integer after swapped odd and even bits is: " + swapOddEven(23)); //Output: 43
	}
}
