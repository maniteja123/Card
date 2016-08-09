package card;

import java.util.ArrayList;
import java.util.List;

public class Rummy extends Game {

	private static int numberOfDecks;
	private static int numberOfPlayers;
	private static int numberOfCardsInHand;
	private List<ArrayList<Card>> hand = new ArrayList<ArrayList<Card>>();
	
	

	public Rummy(int numberOfDecks, int numberOfPlayers, int numberOfCardsInHand){
		this.numberOfDecks=numberOfDecks;
		this.numberOfPlayers=numberOfPlayers;
		this.numberOfCardsInHand=numberOfCardsInHand;
	}
	
	
	
	@Override
	public void calculate() {
		// TODO Auto-generated method stub
		
	}
}
