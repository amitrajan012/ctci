package Chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * A circus is designing a tower routine consisting of people standing atop one another’s shoulders. 
 * For practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or her. 
 * Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people in such a tower.
 */
public class Q9_7 {
	//Sort all items by height first and then weight
	//Find the longest sequence which contains increasing heights and increasing weights
	private static ArrayList<Person> findHighestTower(List<Person> persons, Person bottom) {
		int max = 0;
		ArrayList<Person> maxTower = null;
		for(Person p: persons) {
			if(p.canStandAbove(bottom)) {
				ArrayList<Person> tower = findHighestTower(persons, p);
				int num = tower.size();
				if(num > max) {
					max = num;
					maxTower = tower;
				}
			}
		}
		if (maxTower == null) maxTower = new ArrayList<Person>();
        if (bottom != null) maxTower.add(bottom);
        
		return maxTower;
	}
	
	private static class Person implements Comparable<Object> {
		int height, weight;
		
		
		public Person(int h, int w) {
			height = h;
			weight = w;
		}
		
		private boolean canStandAbove(Person p) {
			return p == null || (height < p.height && weight < p.weight);
		}
		
		public String toString() {
            return "(" + height + ", " + weight + ")";
        }
		
		@Override
		public int compareTo(Object arg0) {
			Person p = (Person) arg0;
			return height != p.height ? ((Integer)height).compareTo(p.height) : ((Integer)weight).compareTo(p.weight);
		}
	}
	
	public static void main(String[] args) {
		Person[] persons = {
	            new Person(56,94),
	            new Person(60,95),
	            new Person(65,100),
	            new Person(68,93),
	            new Person(70,150),
	            new Person(75,200),
	            new Person(75,100),
	            new Person(76,190),
	            new Person(76,220),
	        };
		List<Person> list = Arrays.asList(persons);
        Collections.shuffle(list);
        ArrayList<Person> res = findHighestTower(list, null);
        for(Person p: res) {
        		System.out.println(p.toString());
        }
	}

}
