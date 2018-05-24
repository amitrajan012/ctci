package Chapter8;
/**
 * 
 * Imagine a robot sitting on the upper left hand corner of an NxN grid. 
 * The robot can only move in two directions: right and down. How many possible paths are there for the robot?
 * Follow Up: Imagine certain squares are “off limits”, such that the robot can not step on them. Design an algorithm to get all possible paths for the robot.
 *
 */
public class Q8_2 {
	public static int findNumberOfPaths(int N, int M) {
		if(N>1 & M>1) {
			//Can move in both directions
			return findNumberOfPaths(N-1, M) + findNumberOfPaths(N, M-1);
		}else {
			//Only one possible path exists: right or down
			return 1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(findNumberOfPaths(7, 6));
	}
}
