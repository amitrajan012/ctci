package Chapter10;
/*
 * Design an algorithm to find the kth number such that the only prime factors are 3, 5, and 7.
 */
public class Q10_7 {
	public static int findKthNumber(int k) {
		int num = 1;
		k--;
		while(k>=1 ) {
			num++;
			if(checkNumber(num)) {
				//Next eligible number found
				k--;
			}
		}
		return num;
	}
	
	private static boolean checkNumber(int num) {
		if(num % 2 == 0) {
			return false;
		}else {
			while(num % 3 == 0) {
				num = num/3;
			}
			if(num == 1) {
				return true;
			}
			while(num % 5 == 0) {
				num = num/5;
			}
			if(num == 1) {
				return true;
			}
			while(num % 7 == 0) {
				num = num/7;
			}
			if(num == 1) {
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(findKthNumber(5));
	}
}
