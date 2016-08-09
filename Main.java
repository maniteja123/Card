package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {
		Card one = new Card(1, Suit.HEART);
		Card two = new Card(2, Suit.HEART);
		Card three = new Card(3, Suit.HEART);
		List<Card> cards = new ArrayList<>();
		cards.add(three);
		cards.add(two);
		cards.add(one);
		for(Card card : cards) {
			System.out.print(card.getValue() +  " ");
		}
		System.out.println();
		Collections.sort(cards);
		for(Card card : cards) {
			System.out.print(card.getValue() +  " ");
		}
		System.out.println();
	}
}
