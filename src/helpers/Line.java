package helpers;

import helpers.GraphPoint;

public class Line {
	private static final double epsilon = .0001;
	public double slope;
	public double intercept;
	public boolean infiniteSlope;
	
	public Line(GraphPoint p, GraphPoint q) {
		if(Math.abs(p.x - q.x) > epsilon) {
			slope = (p.y - q.y)/(p.x - q.x);
			intercept = p.y - (slope *p.x); // y = mx + c
			
		}else {
			//Xs are same and hence the line has infinite slope and store x-intercept instead of y
			infiniteSlope = true;
			intercept = p.x;
		}
	}
}
