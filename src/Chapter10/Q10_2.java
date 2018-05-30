package Chapter10;
/*
 * There are three ants on different vertices of a triangle. 
 * What is the probability of collision (between any two or all of them) if they start walking on the sides of the triangle?
 * Similarly find the probability of collision with ‘n’ ants on an ‘n’ vertex polygon.
 */
public class Q10_2 {
	public static void main(String[] args) {
		//Assumption: Speed of all the ants is same
		//Any of the ants will not collide if they are moving in the same direction (all the three clockwise or counterclockwise)
		//An ant can move in 2 ways and hence all the 3 ants can move in 2^3 = 8 ways
		//They will not collide for 2 out of these 8 ways
		//Hence probability of collision = 6/8 = 3/4
		
		//For n ants, They will not collide for 2 ways (all moving clockwise or counterclockwise) out of 2^n ways
		//Hence probability = (2^n-2)/2^n
	}
}
