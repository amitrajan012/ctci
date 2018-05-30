package Chapter10;

import java.util.HashMap;

import helpers.GraphPoint;
import helpers.Line;

/*
 * Given a two dimensional graph with points on it, find a line which passes the most number of points.
 */
public class Q10_6 {

	public static Line findBestLine(GraphPoint[] points) {
		Line bestLine = null;
		HashMap<Line, Integer> line_count= new HashMap<Line, Integer>();
		
		for(int i=0;i<points.length;i++) {
			for(int j=i+1;j<points.length;j++) {
				Line l = new Line(points[i], points[j]);
				line_count.put(l, line_count.getOrDefault(l, 0));
				if(bestLine == null || line_count.get(l) > line_count.get(bestLine) ) {
					bestLine = l;
				}
			}
		}
		return bestLine;
	}
}
