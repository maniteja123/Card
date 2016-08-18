package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class Main {

	private static int MIN_LIMIT = 1;
	private static int MAX_LIMIT = 14;
	
	public static void main(String[] args) {
		ArrayList<Card> cards = new ArrayList<>();
		int noOfCards = 7;
		boolean isJoker = false;
 		for(int value=MIN_LIMIT; value<=MAX_LIMIT; value++) {
			for(Suit suit : Suit.values()) {
				Card card = new Card(value, suit, isJoker);
				cards.add(card);
			}
		}
		Collections.shuffle(cards);
		Random rnd = new Random();
		ArrayList<Card> rummyCards = new ArrayList<>();
		ArrayList<Card> newCards = new ArrayList<>();
		for(int value=0; value<noOfCards; value++) {
			rummyCards.add(cards.remove(rnd.nextInt(cards.size())));
		}
		System.out.println(rummyCards);
		newCards = Card.getSortedCardsByValue(rummyCards);
		System.out.println(newCards);
		newCards = Card.getSortedCardsBySuit(rummyCards);
		System.out.println(newCards);
		Rummy rummy = new Rummy(1, 1, rummyCards, 2);
		rummy.evaluate();
	}
}
