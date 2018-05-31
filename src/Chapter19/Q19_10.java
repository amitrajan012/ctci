package Chapter19;
/*
 * Write a method to generate a random number between 1 and 7, given a method that generates a random number between 1 and 5 
 * (i.e., implement rand7() using rand5()).
 */
public class Q19_10 {
	public static int rand7() {
		while (true) {
			int num = 5 * (rand5() - 1) + (rand5() - 1);
			//Have to check for less than 21 as maximum value of num can be 24 which gives more probability for the occurrence of 1,2 and 3
			if (num < 21) {
				return (num % 7 + 1);
			}
		}
	}

	private static int rand5() {
		return 0;
	}
}
