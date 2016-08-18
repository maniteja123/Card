package card;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class Rummy {

	private static int numberOfDecks;
	private static int numberOfPlayers;
	private static int numberOfCardsInHand;
	private static int ACE = 13;
	private static int THREE = 3;
	private static int FOUR = 4;
	private static int FIVE = 5;
	private static int MIN_LIMIT = 1;
	private static int MAX_LIMIT = 14;
	private static Integer[] seqLengths = {THREE, FOUR, FIVE};
	private static Integer[] setSizes = {THREE, FOUR};
	
	private ArrayList<Card> cards;
	private int jokerCard;

	public Rummy(int numberOfDecks, int numberOfPlayers, ArrayList<Card> cards, int jokerCard) {
		this.numberOfPlayers = numberOfPlayers;
		this.jokerCard = jokerCard;
		this.numberOfCardsInHand = cards.size();
		this.cards = cards;
	}

	public ArrayList<Card> getCards() {
		return this.cards;
	}
	
	public void evaluate() {
		int numJokers = (int)this.cards.stream().filter(p -> p.getValue() == jokerCard || p.isJoker()).count();
		System.out.println("Jokers " + jokerCard + " "  + numJokers);
		ArrayList<Card> finalCards = getNonJokerCards();
		for(int len : seqLengths) {
			getMinimumNeedSequence(finalCards, numJokers, len);
		}
		for(int len: setSizes) {
//			getMinimumNeedSet(finalCards, numJokers, len);
		}
	}
	

	private ArrayList<Result> getMinimumNeedSet(ArrayList<Card> cards, int numJokers, int len) {
		ArrayList<Card> sortedCards = Card.getSortedCardsByValue(cards);
		ArrayList<Result> minSets = new ArrayList<>();
		System.out.println(len);
		for(int value= MIN_LIMIT; value <=MAX_LIMIT; value++) {
			Result res= getNoOfSets(sortedCards, value, len, numJokers);
			minSets.add(res);
			System.out.print(value + "-" + res.getValue() + " ");
		}
		System.out.println();
		return minSets;
	}
	
	private Result getNoOfSets(ArrayList<Card> sortedCards, int value, int len, int numJokers) {
		int count = 0;
		ArrayList<Card> minSet = new ArrayList<>();
		int c = getRankDistinctCount(sortedCards, value);
		if(c == len || c + numJokers == len) {
			count = 1;
		}
		return new Result(count, minSet);
	}
	
	private int getMinimumNeedSequence(ArrayList<Card> cards, int numJokers, int len) {
		int min = Integer.MAX_VALUE;
		ArrayList<Card> sortedCards = Card.getSortedCardsBySuit(cards);
		System.out.println("seq length : " + len);
		for(Suit suit: Suit.values()) {
			System.out.println(suit);
			System.out.println(getNoOfSequences(sortedCards, suit, len, numJokers));
		}
		return min;
	}
	
	private int getNoOfSequences(ArrayList<Card> sortedCards, Suit suit, int len, int numJokers) {
		ArrayList<Card> suitCards = (ArrayList<Card>) sortedCards.stream().filter(p -> p.getSuit().equals(suit)).collect(Collectors.toList());
		int count = 0, start = 0;
		while(start + len - 1 < suitCards.size()) {
			int gap = getGap(cards, start, len);
			System.out.println(suitCards.subList(start, start+len).toString() + " " + gap);
			if(gap == 0 || gap <=  numJokers) count++;
			start++;
		}
		return count;
	}
	
	private ArrayList<Card> getNonJokerCards() {
		return (ArrayList<Card>) this.cards.stream().filter(p -> p.getValue() != jokerCard && !p.isJoker()).collect(Collectors.toList());
	}

	public int getGap(List<Card> list, int start, int len) {
		int count = 0;
		for(int i = start; i < start + len - 1 ; i++) {
			int diff = list.get(i).getValue() - list.get(i+1).getValue() - 1;
			if(diff == 0) count++;
		}
		return len - 1 - count;
	}
	
	public int getSuitDistinctCount(ArrayList<Card> cards, Suit suit) {
		return (int) cards.stream().filter(p -> p.getSuit().equals(suit)).collect(Collectors.groupingBy(p -> p.getValue())).size();
	}
	
	public int getRankDistinctCount(ArrayList<Card> cards, int value) {
		return (int) cards.stream().filter(p -> p.getValue() == value).collect(Collectors.groupingBy(p -> p.getSuit())).size();
	}
	
}
