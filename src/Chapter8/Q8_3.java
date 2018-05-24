package Chapter8;

import java.util.ArrayList;
import java.util.Arrays;


public class Q8_3 {
	public static ArrayList<ArrayList<Integer>> findAllSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubSets;
		if(set.size() == index) {
			//Reached last element
			allSubSets = new ArrayList<ArrayList<Integer>>();
			allSubSets.add(new ArrayList<Integer>()); //Add empty set
		}else {
			allSubSets = findAllSubsets(set, index+1);
			int element = set.get(index);
			ArrayList<ArrayList<Integer>> newSubSets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> l: allSubSets) {
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.addAll(l);
				temp.add(element);
				newSubSets.add(temp);
			}
			allSubSets.addAll(newSubSets);
		}
		return allSubSets;
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> res = findAllSubsets(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4)), 0);
		for(ArrayList<Integer> s : res) {
			System.out.println(s);
		}
	}
}
