
public class Evaluate {
	public final String ranks[] = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King","Ace"};
	public final String suits[]={"Hearts","Diamonds","Spades","Clubs"};
	private int standing;

	// evaluates the hand
	public int checkHand(Card[] hand)	{
		if (this.evalRoyalFlush(hand) == true)	{
			return standing = 1;
		}
		else if (this.evalStraightFlush(hand) == true)	{
			return standing = 2;
		}
		else if (this.evalFourOfAKind(hand) == true)	{
			return standing = 3;
		}
		else if (this.evalFullHouse(hand) == true)	{
			return standing = 4;
		}
		else if (this.evalFlush(hand) == true)	{
			return standing = 5;
		}
		else if (this.evalStraight(hand) == true)	{
			return standing = 6;
		}
		else if (this.evalThreeOfAKind(hand) == true)	{
			return standing = 7;
		}
		else if (this.evalTwoPair(hand) == true)	{
			return standing = 8;
		}
		else if (this.evalPair(hand) == true)	{
			return standing = 9;
		}
		else	{
			Card highCard = this.highCard(hand);
			System.out.println("------------------------------------------------------------");
			//System.out.println((ranks[highCard.rank]) + (suits[highCard.suit]));
			return standing = 10;
		}
	}

	public boolean evalRoyalFlush(Card[] hand)	{
		if (hand[0].rank == 12 && hand[1].rank == 8 && hand[2].rank == 9 && hand[3].rank == 10 && hand[4].rank == 11)	{
			return true;
		}
		else	{
			return false;
		}
	}

	public boolean evalStraightFlush(Card[] hand)	{
		for (int x = 1; x < 5; x++)	{
			if (hand[0].suit != hand[x].suit)	{
				return false;
			}
		}
		for (int x = 1; x < 5; x++)	{
			if (hand[x - 1].rank != (hand[x].rank - 1))	{
				return false;
			}
		}
		return true;

	}

	public boolean evalFourOfAKind(Card[] hand)	{
		if (hand[0].rank != hand[3].rank && hand[1].rank != hand[4].rank)	{
			return false;
		}
		else	{
			return false;
		}
	}

	public boolean evalFullHouse(Card[] hand)	{
		int num = 0;
		for (int x = 1; x < 5; x++)	{
			if (hand[x - 1].rank == hand[x].rank)	{
				num++;
			}
		}
		if (num == 3)	{
			return true;
		}
		else	{
			return false;
		}
	}

	public boolean evalFlush(Card[] hand)	{
		for (int x = 1; x < 5; x++)	{
			if (hand[0].suit != hand[x].suit)	{
				return false;
			}
		}
		return true;
	}

	public boolean evalStraight(Card[] hand)	{
		for (int x = 1; x < 5; x++)	{
			if (hand[x - 1].rank != (hand[x].rank - 1))	{
				return false;
			}
		}
		return true;
	}

	public boolean evalThreeOfAKind(Card[] hand)	{
		if (hand[0].rank == hand[2].rank || hand[2].rank == hand[4].rank)	{
			return true;
		}
		return false;
	}

	public boolean evalTwoPair(Card[] hand)	{
		int check = 0;
		for (int x = 1; x < 5; x++)	{
			if (hand[x - 1].rank == hand[x].rank)	{
				check++;
			}
		}
		if (check == 2)	{
			return true;
		}
		else	{
			return false;
		}
	}

	public boolean evalPair(Card[] hand)	{
		int num = 0;
		for (int x = 1; x < 5; x++)	{
			if (hand[x - 1].rank == hand[x].rank)	{
				num++;
			}
		}
		if (num == 1)	{
			return true;
		}
		else	{
			return false;
		}
	}

	public Card highCard(Card[] hand)	{
		Card highCard = new Card();
		for (int x = 0; x < 5; x++)	{
			if (hand[x].rank > highCard.rank)	{
				highCard = hand[x];
			}
		}
		return highCard;
	}

}
