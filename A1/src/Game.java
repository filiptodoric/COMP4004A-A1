import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang3.StringUtils;

public class Game {
	public final String ranks[] = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
	public final String suits[]={"Hearts","Diamonds","Spades","Clubs"};
	
	public Deck deck = new Deck();
	public Evaluate eval = new Evaluate();
	public static void main(String[] args) {
		Game game = new Game();
		game.PlayRound();
	}
	
	@SuppressWarnings("resource")
	public void PlayRound()	{
		int numPlayers;
		boolean manualHands;
		do	{		
			System.out.println("Welcome to Poker. The round is starting!");
			System.out.print("Please enter how many players are taking part in this round: ");
			Scanner userInput = new Scanner(System.in);
			String stringNumPlayers = userInput.next();
			numPlayers = Integer.parseInt(stringNumPlayers);
		}while(checkIfNumberOfPlayerValid(numPlayers));
		System.out.print("Do you want to manually deal cards, press 'Y' for yes and any key for no.");
		Scanner userInput = new Scanner(System.in);
		String yesOrNo = userInput.next();
		if(yesOrNo.equals("Y"))	{
			manualHands = true;
		}
		else	{
			manualHands = false;
		}
		
		Player[] players = new Player[numPlayers];
		if(manualHands == true)	{
			for(int i = 0; i < numPlayers; i++)	{
				
				System.out.print("Please enter the player ID of the player that you want to edit (must be between 1 and " + numPlayers + "): ");
				String playerIdString = userInput.next();
				int playerId = Integer.parseInt(playerIdString);
				players[i] = new Player(playerId, deck);
				
				System.out.println("You are not setting the cards for the Player with an ID of: " + playerId);
				players[i].setManualHand();
				
			}
		}
		else	{
			for(int i = 0; i < numPlayers; i++)	{
				players[i] = new Player(i+1, deck);
			}
		}
		System.out.println("");
		System.out.println("");
		finalResult(players);
	}
	
	public boolean checkIfNumberOfPlayerValid(int numPlayers)	{
		if(numPlayers <= 1 || numPlayers >= 5)	{
			return true;
		}
		else
			return false;
	}
	
	public void printCards(Card[] hand)	{
		for(Card card: hand){
			System.out.println((ranks[card.rank]) + (suits[card.suit]));
		}
	}
	
	public void printHandResult(int standing)	{
		if(standing == 1){
			System.out.println("Royal Flush");
		}
		if(standing == 2){
			System.out.println("Straight Flush");
		}
		if(standing == 3){
			System.out.println("Four of a Kind");
		}
		if(standing == 4){
			System.out.println("Full House");
		}
		if(standing == 5){
			System.out.println("Flush");
		}
		if(standing == 6){
			System.out.println("Straight");
		}
		if(standing == 7){
			System.out.println("Three of a Kind");
		}
		if(standing == 8){
			System.out.println("Two Pair");
		}
		if(standing == 9){
			System.out.println("Pair");
		}
		if(standing == 10){
			System.out.println("High Card");
		}
	}
	
	public void finalResult(Player[] players)	{
		Evaluate eval = new Evaluate();
		int standing[] = new int[players.length];
		Map<Integer, Integer> map = new TreeMap<Integer,Integer>();
		
		for (int i = 0; i < players.length; i++)	{
			map.put(eval.checkHand(players[i].getHand()), players[i].getId());
		}
		
		Set keys = map.keySet();
		Iterator itr = keys.iterator();
		int temp = 1;
		while(itr.hasNext())	{
			Integer key = (Integer) itr.next();
			Integer playerID = (Integer) map.get(key);
			int x = playerID.intValue();
			System.out.println("Ranking " + temp );
			temp++;
			display(players[x - 1]);
	}
		
//		for(Map.Entry<Integer, Integer> entry: map.entrySet())	{
//			Integer key = entry.getKey();
//			Integer playerID = entry.getValue();
//			int x = playerID.intValue();
//			System.out.println("Ranking " + temp );
//			temp++;
//			display(players[x - 1]);
//		}

	}
	
	public void display(Player player)	{
		System.out.println("------------------------------------------------------------");
		System.out.println("This is player " + player.getId());
		int result = eval.checkHand(player.getHand());
		printCards(player.getHand());
		System.out.print("You had a ");
		printHandResult(result);
		System.out.println("------------------------------------------------------------");
	}

	
}
