package Chapter8;

import java.util.Random;

/**
 * Implement the “paint fill” function that one might see on many image editing programs. 
 * That is, given a screen (represented by a 2 dimensional array of Colors), a point, and a new color, 
 * fill in the surrounding area until you hit a border of that color.’
 *
 */
public class Q8_6 {
	public static boolean paintFill(Color[][] screen, int x, int y, Color old, Color newColor) {
		if(x < 0 || x >= screen.length || y < 0 || y >= screen[0].length) {
			return false;
		}
		if(screen[x][y] == old) {
			//Fill with color and expand
			screen[x][y] = newColor;
			paintFill(screen, x-1, y, old, newColor);
			paintFill(screen, x+1, y, old, newColor);
			paintFill(screen, x, y-1, old, newColor);
			paintFill(screen, x, y+1, old, newColor);
		}
		return true;
	}
	
	enum Color {
		B, W, R, Y, G;
		
		public static Color getRandomColor() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
	}
	
	public static void main(String[] args) {
		Color[][] screen = new Color[5][5];
		for(int i=0;i<screen.length;i++) {
			for(int j=0;j<screen[0].length;j++) {
				screen[i][j] = Color.getRandomColor();
			}
		}
		
		for(int i=0;i<screen.length;i++) {
			for(int j=0;j<screen[0].length;j++) {
				System.out.print(screen[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		System.out.print("\n");
		paintFill(screen, 2, 3, screen[2][3], Color.B);
		
		for(int i=0;i<screen.length;i++) {
			for(int j=0;j<screen[0].length;j++) {
				System.out.print(screen[i][j]);
				System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
}


