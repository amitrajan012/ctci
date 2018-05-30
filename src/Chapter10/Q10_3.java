package Chapter10;
/*
 * Given two lines on a Cartesian plane, determine whether the two lines would intersect.
 */
public class Q10_3 {
	public static void main(String[] args) {
		//Case 1 (For lines) : Two lines will intersect if their slopes are not equal and hence we can compare the slopes
		
		//Case 2 (For line-segments) :  Let the end point of first line segment is (x1, y1) and (x2, y2) and that of second line segment is (x3, y3) and (x4, y4)
		//Let the intersection point be (m, n)
		//If the line-segments intersect at the point we can compare the slops
		//Math.mod((n-y1)/(m-x1)) = Math.mod((n-y2)/(m-x2)) and Math.mod((n-y3)/(m-x3)) = Math.mod((n-y4)/(m-x4))
		//If we get a solution, the line intersects, otherwise not
	}
}
