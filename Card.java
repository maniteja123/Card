package card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Card implements Comparable<Card> {

	private Suit suit;
	private int value;
	private boolean isJoker;

	public Card(int value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}

	public static boolean areInSequence(ArrayList<Card> cards) {
		cards.sort();
		int flag = 0;
		int x = cards.get(0).value;
		
		for (int i=1;i<cards.size();i++)
		{
			if((cards.get(i)-x) !=1)
				flag=1;
			x=cards.get(i).value;
		}
		
		if(flag==1)
			return false;
		
		return true;
	}

	public static boolean isSameSuit(ArrayList<Card> cards) {
		int flag = 0;
		int x = cards.get(0)
				
		for (int i=1;i<cards.size();i++)
		{
			if((cards.get(i)-x) !=1)
				flag=1;
			x=cards.get(i);
		}
		
		return true;
	}

	public static Map<Integer, Integer> getFreqOfCards(ArrayList<Card> cards) {

		return null;
	}

	public static Map<String, Integer> getFreqOfSuits(ArrayList<Card> cards) {
		Map<String,String> 
		
		for (Card c :cards )
		{
			
		}
		return null;	
	}

	@Override
	public int compareTo(Card card) {
		return card.value - this.value;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isJoker() {
		return isJoker;
	}

	public void setJoker(boolean isJoker) {
		this.isJoker = isJoker;
	}

}
