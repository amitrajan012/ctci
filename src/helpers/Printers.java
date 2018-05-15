package helpers;
/**
 * 
 * Courtsey: https://github.com/wzhishen/cracking-the-coding-interview/tree/master/src/helpers
 *
 */

public class Printers {
	public static void print(Object o) {
        System.out.print(o);
    }
	
	public static void println() {
        print(lineSeparator());
    }
	
	public static void printArray(int[][] a) {
        for (int[] row : a) {
            for (int col : row) {
                print(col + " ");
            }
            println();
        }
    }
	
	private static String lineSeparator() {
        return System.lineSeparator();
    }
}
