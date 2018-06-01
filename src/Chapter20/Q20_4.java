package Chapter20;
/*
 * Write a method to count the number of 2s between 0 and n.
 */
public class Q20_4 {
	public static int countTwos(int n) {
		//Base case
		if(n==0) return 0;
		int exp = 1;
		while(10*exp < n) {
			exp *= 10;
		}
		int firstDigit = n / exp;
		int remainingDigit = n % exp;
		
		//Count 2s due to first digit
		int numberOfTwosFirstDigit = 0;
		if(firstDigit > 2) {
			numberOfTwosFirstDigit += exp; //In 583, 100 2s occur due to first digit 
		}else if(firstDigit == 2) {
			numberOfTwosFirstDigit += remainingDigit+1; //In 283, 84 2s occur due to first digit
		}
		
		//Count 2s for remaining digits
		//In 583, we need to count 2s for 0-99 5 times and 2s in remaining 83 
		int numberOfTwosRemaining = firstDigit * countTwos(exp-1) + countTwos(remainingDigit);
		
		return numberOfTwosFirstDigit + numberOfTwosRemaining;
	}
	
	public static void main(String[] args) {
		int n = 583;
		System.out.println("Number of 2s in 0 to " + n + " is: " + countTwos(n));
	}
}
