package Chapter19;
/*
 * You are given an array of integers (both positive and negative). Find the continuous sequence with the largest sum. Return the sum.
 */
public class Q19_7 {
	public static int getMaxSum(int[] a) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for(int i: a) {
			sum += i;
			if(maxSum < sum) {
				maxSum = sum;
			}
			if(sum < 0) {
				sum = 0;
			}
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		System.out.println(getMaxSum(new int[] {2, -8, 3, -2, 4, -10}));
	}
}
