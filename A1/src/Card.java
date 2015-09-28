public class Card	{
	/*
	 * Card is essentially just a place holder so it looks more OO
	 * All it stores is an int which represents a rank and suit.
	 */
	public int suit;
	public int rank;
	
	public boolean isCardValid()	{
		if(suit >= 0 && suit <= 3 && rank >= 0 && rank <= 12)	{
			return true;
		}
		else	{
			return false;
		}
	}
	
	
}
