/*
This program creates a Card object from a String based on the short hand version of a card. It "expands" (long hand notation) the short hand version to get the rank and suit and also contains a compareTo method
to compare the rank of 2 cards. The program returns the long hand notation of the card.
 */
public class Card implements Comparable<Card>
{
    private String rank;
    private String suit;
    private String shortHand; // 8c, 4h, etc

    /**
     * Constructs a card from a short-hand notation.
     *
     * Assigns "Unknown" to rank or suit if the rank or suit
     * cannot be determined from the shorthand notation, i.e.
     * the notation contains invalid characters.
     *
     * Not case sensitive.
     * @param card
     */
    public Card(String card)
    {
        card = card.toLowerCase(); // makes the String lower case
        shortHand = card;


        char[] shortHandChar = new char[] {'j', 'k', 'q', 'a', '2', '3', '4', '5', '6', '7', '8', '9'}; // short hand array of the rank to compare to long hand array of the rank
        String[] longHandChar = new String[] {"Jack", "King", "Queen", "Ace", "Two", "Three", "Four", "Five", // long hand array of the rank with same indexes as the short hand array
                                                "Six", "Seven", "Eight", "Nine"};

        char[] cardType = new char[] {'d', 'h', 's', 'c'};  // short hand array of the suit to compare to long hand array of the suit
        String[] cardTypeToString = new String[] {"Diamonds", "Hearts", "Spades", "Clubs"}; // long hand array of the suit with same indexes as the short hand array

        int positionChar = 0;
        int positionType = 0;


        if(card.length() == 2) // if the card does not contain 10
        {
            for(int i = 0; i < card.length(); i++) // loops through card
            {
                for(int j = 0; j < shortHandChar.length; j++) // loops through short hand rank
                {
                    if (card.charAt(i) == shortHandChar[j]) // if the two characters match
                        positionChar = j; // saves position
                }

                for(int k = 0; k < cardType.length; k++) // loops through short hand suit
                {
                   if(card.charAt(i) == cardType[k]) // if the two characters match
                       positionType = k; // saves position
                }
            }

            rank = longHandChar[positionChar]; // rank is obtained from the long hand array position
            suit = cardTypeToString[positionType]; // suit is obtained form the long hand array position
        }

        else if(card.length() == 3) // if the card does contain 10
        {
            for(int i = 0 ; i < card.length() - 1; i++)
            {
                if(card.charAt(i) == '1' && card.charAt(i + 1) == '0') // if 10 is found
                    rank = "Ten"; // rank automatically set to "Ten"

                for(int k = 0; k < cardType.length; k++) // same as before loops of suit
                {
                    if(card.charAt(i) == cardType[k])
                        positionType = k;
                }
            }

            if(rank == null)
                rank = "Unknown";

            suit = cardTypeToString[positionType];
        }

        else
        {
            rank = "Unknown";
            suit = "Unknown";
        }
    }


    /**
     * Obtains the rank
     * @return
     */
    public String getRank()
    {
        return rank;
    }

    /**
     * Obtains the suit
     * @return
     */
    public String getSuit()
    {
        return suit;
    }

    /**
     * Obtains the short hand notation
     * @return
     */
    public String getShortHand()
    {
        return shortHand;
    }

    /**
     * Returns a negative number if the rank of this card is less than
     *         the rank of the other card.
     *         a positive number if the rank of this card is greater than
     *         the rank of the other card.
     *         0 if the ranks of this and other are equal.
     *
     * @param other
     * @return
     */
    public int compareTo(Card other)
    {
        String currentRank = rank;
        String otherRank = other.getRank(); // gets rank of other card

        int positionCurrent = 0;
        int positionOther = 0;

        String[] rankOrder = new String[]{"Two", "Three", "Four", "Five", // ranking of ranks from lowest to highest
                "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};

        for (int i = 0; i < rankOrder.length; i++) // loops through the rankOrder
        {
            if (currentRank.equals(rankOrder[i])) // if currentRank matches
                positionCurrent = i; // saves position

            if (otherRank.equals(rankOrder[i])) // if otherRank matches
                positionOther = i; // saves position
        }

        if (positionOther > positionCurrent) // if the other card is higher than the current card
            return 1;

        if (positionOther < positionCurrent) // if the other card is lower than the current card
            return -1;

        if (positionOther == positionCurrent) // if the other card is equal to the current card
            return 0;

        else
            return 0;
    }

    /**
     * Returns the long notation of this Card object.
     *         "Unknown" if the rank or suit is not known.
     */
    public String toString()
    {
        if(rank.equals("Unknown") && suit.equals("Unknown"))
            return "Unknown";

        else
            return rank + " of " + suit;
    }

}
