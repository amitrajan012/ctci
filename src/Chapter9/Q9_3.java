package Chapter9;
/*
 * Given a sorted array of n integers that has been rotated an unknown number of times, give an O(log n) algorithm that finds an element in the array.
 * You may assume that the array was originally sorted in increasing order.
 * EXAMPLE:
 *	Input: find 5 in array (15 16 19 20 25 1 3 4 5 7 10 14)
 *	Output: 8 (the index of 5 in the array)
 */

public class Q9_3 {
	public static int findIndex(int[] a, int x) {
		if(a == null) {
			return -1;
		}
		return findIndex(a, x, 0, a.length-1);
	}
	public static int findIndex(int[] a, int x, int low, int high) {
		//Base case
        if (low > high) {
        		return -1;
        }
        int mid = low + (high - low) / 2;
        if (a[mid] == x) {
        		return mid;
        }
        
        // Left half is sorted
        if (a[low] < a[mid]) {
            if (x >= a[low] && x < a[mid]) {
                return findIndex(a, x, low, mid - 1);
            } else {
                return findIndex(a, x, mid + 1, high);
            }
        // Right half is sorted
        } else if (a[low] > a[mid]) {
            if (x > a[mid] && x <= a[high]) {
                return findIndex(a, x, mid + 1, high);
            } else {
                return findIndex(a, x, low, mid - 1);
            }
        } else {
            // left half must be all repeats
            if (a[mid] != a[high]) {
                return findIndex(a, x, mid + 1, high);
            // no special pattern is found, so brute force
            } else {
                int result = findIndex(a, x, low, mid - 1);
                if (result == -1)
                    result = findIndex(a, x, mid + 1,high);
                return result;
            }
        }
    }

	public static void main(String[] args) {
		System.out.println(findIndex(new int[] {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}, 5));
		System.out.println(findIndex(new int[] {2,2,2,2,3,4,1}, 1));
		System.out.println(findIndex(new int[] {1,1,1,1,1,1,1,0,1,1,1,1}, 0));
		System.out.println(findIndex(new int[] {1,1,1,2,1,1,1,1,1,1,1,1}, 2));
	}
}
