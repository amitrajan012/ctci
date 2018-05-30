package Chapter10;
/*
 * You have a basketball hoop and someone says that you can play 1 of 2 games.
 * Game #1: You get one shot to make the hoop.
 * Game #2: You get three shots and you have to make 2 of 3 shots.
 * If p is the probability of making a particular shot, for which values of p should you pick one game or the other?
 */
public class Q10_1 {
	public static void main(String[] args) {
		//Let the probability of making a particular shot be p
		//P(Game 1) = p
		//P(Game 2) = p^3 + 3C2[(i-p)p^2]
		//For Game 2 to win P(Game 2) > P(Game 1)
		//Solving the equation we get : 1/2 < p < 1
		//Hence Game 1 should be picked when p < 1/2
	}
}
