package Chapter9;
/*
 * Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
 * Example: find “ball” in [“at”, “”, “”, “”, “ball”, “”, “”, “car”, “”, “”, “dad”, “”, “”] will return 4
 * Example: find “ballcar” in [“at”, “”, “”, “”, “”, “ball”, “car”, “”, “”, “dad”, “”, “”] will return -1
 */

public class Q9_5 {
	public static int findIndex(String[] S, String x) {
		for(int i=0;i<S.length;i++) {
			if(S[i] == "") {
				continue;
			}else if(S[i].compareTo(x) == 0) {
				return i;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(findIndex(new String[] {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}, "ball"));
		System.out.println(findIndex(new String[] {"at", "", "", "", "ball", "car", "", "", "dad", "", ""}, "ballcar"));
	}
}
