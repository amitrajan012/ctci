package Chapter4;
/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two nodes.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import helpers.GraphNode;

public class Q4_2 {
	public static boolean DFSIter(GraphNode n1, GraphNode n2) {
		//Base case
		if(n1 == null || n2 == null) return true;
		//Implemented using Stack
		Stack<GraphNode> stack = new Stack<GraphNode>();
		stack.push(n1);
		while(!stack.isEmpty()) {
			GraphNode n = stack.pop();
			if(!n.isVisited) {
				n.isVisited = true;
				if(n == n2) {
					return true;
				}
				stack.addAll(n.adjacent);
			}
		}
		return false;
	}
	
	public static boolean DFSRec(GraphNode n1, GraphNode n2) {
		if(n1 == null || n2 == null) return false;
		n1.isVisited = true;
		if(n1 == n2) return true;
		for(GraphNode c: n1.adjacent) {
			if(!c.isVisited) {
				if(DFSRec(c, n2)) return true;
			}
		}
		return false;
	}
	
	public static boolean BFS(GraphNode n1, GraphNode n2) {
		if(n1 == null || n2 == null) return false;
		//BFS is implemented using Queue
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(n1);
		while(!queue.isEmpty()) {
			GraphNode n = queue.remove();
			if(!n.isVisited) {
				n.isVisited = true;
				if(n == n2) return true;
				queue.addAll(n.adjacent);
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        n1.adjacent.add(n2);n1.adjacent.add(n3);
        n2.adjacent.add(n3);n2.adjacent.add(n4);
        n3.adjacent.add(n4);
        
        System.out.println(BFS(n2, n4)); 
	}
}
