package card;

import java.util.ArrayList;
import java.util.List;

public abstract class Game {
	
	private static int numberOfDecks;
	private static int numberOfPlayers;
	private static int numberOfCardsInHand;
	private List<Integer> scores;
	private List<ArrayList<Card>> hand;

	public abstract void calculate();
	
}
