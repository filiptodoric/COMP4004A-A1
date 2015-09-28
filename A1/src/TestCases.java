import static org.junit.Assert.*;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

public class TestCases {

	@Test
	public void test() {
		// Not yet implemented 
	}

	@Test
	public void testIfPlayerIsValid() throws Exception	{
		Deck deck = new Deck();
		Player player = new Player(1, deck);
		assertTrue(player.isPlayerValid());
	}
	
	@Test
	public void testForValidPlayerID() throws Exception {
		Deck deck = new Deck();
		Player player = new Player(1, deck);
		assertTrue(player.isPlayerIDValid());
	}

	@Test
	public void testForValidPlayerID2() throws Exception {
		Deck deck = new Deck();
		Player player = new Player(5, deck);
		assertFalse(player.isPlayerIDValid());
	}
	
	@Test
	public void testIsCardValid() throws Exception {
		Card card = new Card();
		card.rank = 7;
		card.suit = 2;
		assertTrue(card.isCardValid());
	}
	
	@Test
	public void testIsCardNotValid() throws Exception	{
		Card card = new Card();
		card.rank = 20;
		card.suit = 1;
		assertFalse(card.isCardValid());
	}

	@Test
	public void testStringToIntRank() throws Exception	{
		Deck deck = new Deck();
		Player player = new Player(2, deck);
		int test = player.rankToInt("Five");
		assertEquals(3, test);
	}

	@Test
	public void testStringToIntSuit() throws Exception	{
		Deck deck = new Deck();
		Player player = new Player(2, deck);
		int test = player.suitToInt("Hearts");
		assertEquals(0, test);
	}

//	@Test
//	public void testManuallySetHand() throws Exception	{
//		Deck deck = new Deck();
//		Player myPlayer = new Player(1, deck);
//		myPlayer.setManualHand();
//		String input = "Two Hearts Three Spades King Diamonds Two Hearts Three Spades";
//		assertEquals(1,1);
//	}
	
	@Test
	public void testNumberOfCardsDealt() throws Exception	{
		Deck deck = new Deck();
		Player myPlayer = new Player(1, deck);
		int x = myPlayer.getHand().length;
		assertEquals(5,x);
	}
	
	@Test
	public void testHighCard() throws Exception	{
		Card[] hand = new Card[5];
		Deck deck = new Deck();
		hand = deck.dealHand();
		hand[0].rank = 12;
		hand[0].suit = 0;
		hand[1].rank = 2;
		hand[1].suit = 0;
		hand[2].rank = 5;
		hand[2].suit = 0;
		hand[3].rank = 6;
		hand[3].suit = 0;
		hand[4].rank = 2;
		hand[4].suit = 0;
		Card card = new Card();
		card.rank = 12;
		card.suit = 0;
		Evaluate eval = new Evaluate();
		eval.highCard(hand);
		assertEquals(card.rank, eval.highCard(hand).rank);	
	}
	@Test
	public void testPair() throws Exception	{
		Card[] hand = new Card[5];
		Deck deck = new Deck();
		hand = deck.dealHand();
		hand[0].rank = 12;
		hand[0].suit = 0;
		hand[1].rank = 12;
		hand[1].suit = 0;
		hand[2].rank = 5;
		hand[2].suit = 0;
		hand[3].rank = 6;
		hand[3].suit = 0;
		hand[4].rank = 2;
		hand[4].suit = 0;
		Evaluate eval = new Evaluate();
		assertTrue(eval.evalPair(hand));
	}
	@Test
	public void testTwoPair() throws Exception	{
		Card[] hand = new Card[5];
		Deck deck = new Deck();
		hand = deck.dealHand();
		hand[0].rank = 12;
		hand[0].suit = 0;
		hand[1].rank = 12;
		hand[1].suit = 0;
		hand[2].rank = 5;
		hand[2].suit = 0;
		hand[3].rank = 5;
		hand[3].suit = 0;
		hand[4].rank = 2;
		hand[4].suit = 0;
		Evaluate eval = new Evaluate();
		assertTrue(eval.evalTwoPair(hand));
	}
	@Test
	public void testThreeOfAKind() throws Exception	{
		Card[] hand = new Card[5];
		Deck deck = new Deck();
		hand = deck.dealHand();
		hand[0].rank = 12;
		hand[0].suit = 0;
		hand[1].rank = 12;
		hand[1].suit = 0;
		hand[2].rank = 5;
		hand[2].suit = 0;
		hand[3].rank = 5;
		hand[3].suit = 0;
		hand[4].rank = 2;
		hand[4].suit = 0;
		Evaluate eval = new Evaluate();
		assertFalse(eval.evalThreeOfAKind(hand));
	}	
	@Test
	public void testStraight() throws Exception	{
		Card[] hand = new Card[5];
		Deck deck = new Deck();
		hand = deck.dealHand();
		hand[0].rank = 4;
		hand[0].suit = 0;
		hand[1].rank = 5;
		hand[1].suit = 0;
		hand[2].rank = 6;
		hand[2].suit = 0;
		hand[3].rank = 7;
		hand[3].suit = 0;
		hand[4].rank = 8;
		hand[4].suit = 0;
		Evaluate eval = new Evaluate();
		assertTrue(eval.evalStraight(hand));
	}	
	@Test
	public void testFlush() throws Exception	{
		Card[] hand = new Card[5];
		Deck deck = new Deck();
		hand = deck.dealHand();
		hand[0].rank = 12;
		hand[0].suit = 0;
		hand[1].rank = 12;
		hand[1].suit = 0;
		hand[2].rank = 5;
		hand[2].suit = 0;
		hand[3].rank = 5;
		hand[3].suit = 0;
		hand[4].rank = 2;
		hand[4].suit = 0;
		Evaluate eval = new Evaluate();
		assertTrue(eval.evalFlush(hand));
	}	
	@Test
	public void testFullHouse() throws Exception	{
		Card[] hand = new Card[5];
		Deck deck = new Deck();
		hand = deck.dealHand();
		hand[0].rank = 12;
		hand[0].suit = 0;
		hand[1].rank = 12;
		hand[1].suit = 1;
		hand[2].rank = 12;
		hand[2].suit = 2;
		hand[3].rank = 5;
		hand[3].suit = 3;
		hand[4].rank = 5;
		hand[4].suit = 3;
		Evaluate eval = new Evaluate();
		assertTrue(eval.evalFullHouse(hand));
	}	
	@Test
	public void testFourOfAKind() throws Exception	{
		Card[] hand = new Card[5];
		Deck deck = new Deck();
		hand = deck.dealHand();
		hand[0].rank = 12;
		hand[0].suit = 0;
		hand[1].rank = 12;
		hand[1].suit = 1;
		hand[2].rank = 12;
		hand[2].suit = 2;
		hand[3].rank = 12;
		hand[3].suit = 3;
		hand[4].rank = 5;
		hand[4].suit = 3;
		Evaluate eval = new Evaluate();
		assertFalse(eval.evalFourOfAKind(hand));
	}	
	@Test
	public void testStraightFlush() throws Exception	{
		Card[] hand = new Card[5];
		Deck deck = new Deck();
		hand = deck.dealHand();
		hand[0].rank = 5;
		hand[0].suit = 0;
		hand[1].rank = 4;
		hand[1].suit = 0;
		hand[2].rank = 3;
		hand[2].suit = 0;
		hand[3].rank = 2;
		hand[3].suit = 0;
		hand[4].rank = 1;
		hand[4].suit = 0;
		Evaluate eval = new Evaluate();
		assertFalse(eval.evalStraightFlush(hand));
	}	
	@Test
	public void testRoyalFlush() throws Exception	{
		Card[] hand = new Card[5];
		Deck deck = new Deck();
		hand = deck.dealHand();
		hand[0].rank = 8;
		hand[0].suit = 0;
		hand[1].rank = 9;
		hand[1].suit = 0;
		hand[2].rank = 10;
		hand[2].suit = 0;
		hand[3].rank = 11;
		hand[3].suit = 0;
		hand[4].rank = 12;
		hand[4].suit = 0;
		Evaluate eval = new Evaluate();
		assertFalse(eval.evalRoyalFlush(hand));
	}	
	@Test
	public void testEval() throws Exception	{
		Card[] hand = new Card[5];
		Deck deck = new Deck();
		hand = deck.dealHand();
		hand[0].rank = 3;
		hand[0].suit = 2;
		hand[1].rank = 3;
		hand[1].suit = 1;
		hand[2].rank = 7;
		hand[2].suit = 3;
		hand[3].rank = 2;
		hand[3].suit = 3;
		hand[4].rank = 3;
		hand[4].suit = 6;
		Evaluate eval = new Evaluate();
		assertEquals(9, eval.checkHand(hand));
	}	
	
	
	@Test
	public void testForMaxPlayers() throws Exception	{
		Game game = new Game();
		boolean chk = game.checkIfNumberOfPlayerValid(5);
		assertTrue(chk);
	}	
	@Test
	public void testForMinPlayers() throws Exception	{
		Game game = new Game();
		boolean chk = game.checkIfNumberOfPlayerValid(0);
		assertTrue(chk);
	}	
	@Test
	public void testFor5Cards() throws Exception	{
		Deck deck = new Deck();	
		Card[] hand = deck.dealHand();
		assertEquals(5, hand.length);
	}
	@Test
	public void testForInvalidCards() throws Exception	{
		Deck deck = new Deck();	
		Player player = new Player(1, deck);
		String[] test = new String[1];
		test[0] = "Hello";
		assertFalse(player.checkInput(test));
	}
	@Test
	public void testForValidCards() throws Exception	{
		Deck deck = new Deck();	
		Player player = new Player(1, deck);
		String[] test = new String[1];
		test[0] = "Spades";
		assertTrue(player.checkInput(test));
	}
	
}
