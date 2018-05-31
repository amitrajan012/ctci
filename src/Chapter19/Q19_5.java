package Chapter19;

import java.util.HashSet;
import java.util.Set;

/*
 * The Game of Master Mind is played as follows:
 * The computer has four slots containing balls that are red (R), yellow (Y), green (G) or blue (B). 
 * For example, the computer might have RGGB. the user, are trying to guess the solution. You might, for example, guess YRGB.
 * When you guess the correct color for the correct slot, you get a “hit”. If you guess a color that exists but is in the wrong slot, you get a “pseudo-hit”.
 * For example, the guess YRGB has 2 hits and one pseudo hit.
 * Write a method that, given a guess and a solution, returns the number of hits and pseudo hits.
 */
public class Q19_5 {
	public static int[] getHits(String solution, String guess) {
		int[] res = new int[2];
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<solution.length();i++) {
			if(solution.charAt(i) == guess.charAt(i)) {
				//Hit
				res[0] += 1;
			}else {
				//Check for pseudo-hit
				if(set.contains(guess.charAt(i))) {
					res[1] += 1;	
				}
				//Add current character to the set to check further pseudo-hit
				set.add(solution.charAt(i));
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String solution = "RGGB";
		String guess = "YRGB";
		int[] res = getHits(solution, guess);
		System.out.println("Solution: " + solution);
		System.out.println("Guess: " + guess);
		System.out.println("Hits: " + res[0]);
		System.out.println("Pseudo-Hits: " + res[1]);
	}
}
