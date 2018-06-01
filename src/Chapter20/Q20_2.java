package Chapter20;
/*
 * Write a method to shuffle a deck of cards. It must be a perfect shuffle - in other words, each 52! permutations of the deck has to be equally likely.
 * Assume that you are given a random number generator which is perfect.
 */
public class Q20_2 {
	public static void shuffle(int[] cards) {
		for(int i=0;i<cards.length;i++) {
			int index = (int)((Math.random()) * (cards.length-i)) + i;
			int temp = cards[i];
			cards[i] = cards[index];
			cards[index] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] cards = new int[] {23, 14, 12, 45, 6};
		shuffle(cards);
		for(int i: cards) {
			System.out.print(i + " ");
		}
	}
}
