# COMP4004A-A1
Filip Todoric
100883264

To run the project please clone the repository and import into Eclipse.

The game will then run in the console, follow on screen instruction for any other necessary game play information. 

The poker game runs through a bunch of tests, to run the tests open the TestSuite: TestCases.java and click run.

You may need to go input information into the console for some of the test to finish. 

The tests for checking min/max number of players return the 'opposite' boolean then what is expected at first glance but this implementation is done on purpose because it is used in a do...while loop.

Testing for the minimal requirments such as: Test for Minimum and maximum number of players (2 to 4), Test to ensure there are 5 cards dealt to each player, Test for invalid cards e.g. fourteenClubs, threeShovels, thDiamonds etc., Test for valid player ids, Ensure the order of entry is correct - e.g. player id and then the cards ... etc ...

are all located in the TestCases.java file. 

Below is the requirments and the corresoponding test methods: 

Determine how many players are playing in each round (2-4)
  - testIfPlayerIsValid
  - testForValidPlayerID
  - testForValidPlayerID2
  - testForMaxPlayers
  - testForMinPlayers

Input playerId/cards
  - testIsCardValid
  - testStringToIntRank
  - testStringToIntSuit
  - testForMaxPlayers
  - testManuallySetHand
  - testForPlayerId
  - testNumberOfCardsDealt
  - testFor5Cards
  - testForInvalidCards
  - testForValidCards

Output these cards ranked and sorted
  - testHighCard
  - testTwoPair
  - testThreeOfAKind
  - testStraight
  - testFlush
  - testFullHouse
  - testFourOfAKind
  - testStraightFlush
  - testRoyalFlush
  - testEval
  
