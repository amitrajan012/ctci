package Chapter10;
/*
 * Given two squares on a two dimensional plane, find a line that would cut these two squares in half.
 * Key Concept: Any line that goes through the center of a rectangle must cut it in half
 */
public class Q10_5 {
	
	public class Square {
		public double left;
		public double right;
		public double top;
		public double bottom;
		
		public Square(double l, double r, double t, double b) {
			left = l; right = r; top = t; bottom = b;
		}
		
		public void findLine(Square s) {
			double middle_this_x = (this.left+this.right)/2.0;
			double middle_this_y = (this.top+this.bottom)/2.0;
			
			double middle_s_x = (s.left+s.right)/2.0;
			double middle_s_y = (s.top+s.bottom)/2.0;
			
			if(middle_this_x == middle_s_x && middle_this_y == middle_s_y) {
				//Middle points are same
				System.out.println("The intersecting line is: (" + this.left + "," + this.top + "), (" + this.right + "," + this.bottom + ")");
			}else {
				System.out.println("The intersecting line is: (" + middle_this_x + "," + middle_this_y + "), (" + middle_s_x + "," + middle_s_y + ")");
			}
		}
	}
}
