import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class Player	{
	private int id;
	private Deck deck;
	private Card[] hand;
	private int standingPlayer;
	public final String ranks[] = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
	public final String suits[]={"Hearts","Diamonds","Spades","Clubs"};
	
	
	public Player(int _id, Deck _deck)	{
		id = _id;
		deck = _deck;
		hand = deck.dealHand();
		standingPlayer = -1;
	}
	

	public int getStandingPlayer() {
		return standingPlayer;
	}


	public void setStandingPlayer(int standingPlayer) {
		this.standingPlayer = standingPlayer;
	}


	public Card[] getHand() {
		return hand;
	}


	public void setHand(Card[] hand) {
		this.hand = hand;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isPlayerValid()	{
		if(isPlayerIDValid() == true)	{
			return true;
		}
		else 
			return false;
	}

	public boolean isPlayerIDValid() {
		if(id >= 1 && id <= 4)
			return true;
		else	
			return false;
	}
	
	public boolean checkInput(String[] array)	{
		String[] split = array;
		for(String string: split)	{
			String check = string.toString();
			if(Arrays.asList(ranks).contains(check) || Arrays.asList(suits).contains(check))	{
				continue;
			}
			else
				return false;
		}
		return true;
	}
	
	public void setManualHand()	{
		String[] split;
		do	{		
			System.out.println("Please Enter the rank and suit of the 5 cards in the hand. Use the following form. Capitalization matters. Example:");
			System.out.println("Two Hearts Three Spades King Diamonds ...etc...");
			System.out.println("------------------------------------------------------------");
			Scanner userInput = new Scanner(System.in);
			String fullInput = userInput.nextLine();
			split = StringUtils.split(fullInput);
		}while(checkInput(split) == false);

		int x = 0;
		int y = 1;
		for (Card card : hand) {
			String rank = split[x];
			String suit = split[y];
			card.rank = rankToInt(rank);
			card.suit = suitToInt(suit);
			x = x + 2;
			y = y + 2;
		}
	}
	
	public int rankToInt(String rank)	{
		if(rank.equals("Two")){
			return 0;
		}
		if(rank.equals("Three")){
			return 1;
		}
		if(rank.equals("Four")){
			return 2;
		}
		if(rank.equals("Five")){
			return 3;
		}
		if(rank.equals("Six")){
			return 4;
		}
		if(rank.equals("Seven")){
			return 5;
		}
		if(rank.equals("Eight")){
			return 6;
		}
		if(rank.equals("Nine")){
			return 7;
		}
		if(rank.equals("Ten")){
			return 8;
		}
		if(rank.equals("Jack")){
			return 9;
		}
		if(rank.equals("Queen")){
			return 10;
		}
		if(rank.equals("King")){
			return 11;
		}
		if(rank.equals("Ace")){
			return 12;
		}
		else
			return -1;	
	}
	
	public int suitToInt(String suit)	{
		if(suit.equals("Hearts")){
			return 0;
		}
		if(suit.equals("Diamonds")){
			return 1;
		}
		if(suit.equals("Spades")){
			return 2;
		}
		if(suit.equals("Clubs")){
			return 3;
		}
		else
			return -1;
	}


	
}
