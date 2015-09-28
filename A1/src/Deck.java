import java.util.ArrayList;
import java.util.Random;

public class Deck {

	public Card[] deck = new Card[52]; 
	public Card cardToGetRanksAndSuits = new Card();

	public Deck()	{
		// add cards to the deck
		int cardNum = 0;
		for(int suit = 0; suit <= 3; suit++)	{
			for(int rank = 0; rank <= 12; rank++)	{
				deck[cardNum] = new Card();
				deck[cardNum].rank = rank;
				deck[cardNum].suit = suit;
				cardNum++;
			}
		}
	}

	public Card[] dealHand()	{
		Card[] hand = new Card[5];
		for (int x = 0; x < 5; x++)	{
			Random rand = new Random();
			int randCard = rand.nextInt(51);
			hand[x] = deck[randCard];
		}
		return hand;
	}
}
