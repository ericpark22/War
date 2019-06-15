/*
This program simulates the game war and determines the winner of the game. It uses the Card class to compare each card in the deck using the compareTo method.
If there is a tie, it also calculates that and keeps on going until one of the players have no cards left.

 */
import java.util.ArrayList;
import java.util.Collections;

public class War
{
    private ArrayList<Card> p1;
    private ArrayList<Card> p2;

    /**
     * Creates a deck of cards and splits it between Player 1 and Player 2
     */
    public War()
    {
        ArrayList<Card> deck = new ArrayList<>();
        String[] rank = new String[] {"2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k", "a"};

        for(int i = 0; i < 13; i++) // creates cards with Diamond suit
        {
            String suitAndRank = "d";
            suitAndRank = suitAndRank + rank[i];
            Card current = new Card(suitAndRank);
            deck.add(current);
        }

        for(int i = 0; i < 13; i++) // creates cards with Heart suit
        {
            String suitAndRank = "h";
            suitAndRank = suitAndRank + rank[i];
            Card current = new Card(suitAndRank);
            deck.add(current);
        }

        for(int i = 0; i < 13; i++) // creates cards with Spades suit
        {
            String suitAndRank = "s";
            suitAndRank = suitAndRank + rank[i];
            Card current = new Card(suitAndRank);
            deck.add(current);
        }

        for(int i = 0; i < 13; i++) // creats cards with Clubs suit
        {
            String suitAndRank = "c";
            suitAndRank = suitAndRank + rank[i];
            Card current = new Card(suitAndRank);
            deck.add(current);
        }

        Collections.shuffle(deck); // shuffles the newly made card deck

        p1 = new ArrayList<>(); // player 1 deck
        p2 = new ArrayList<>(); // player 2 deck

        while(deck.size() > 0) // equally divides the cards
        {
            p1.add(deck.remove(0));
            p2.add(deck.remove(0));

        }
    }

    /**
     * Initializes Player 1's deck and Player 2's deck
     * @param p1
     * @param p2
     */
    public War(ArrayList<Card> p1, ArrayList<Card> p2)
    {
        this.p1 = new ArrayList<Card>(p1);
        this.p2 = new ArrayList<Card>(p2);
    }

    /**
     * Starts the battle between players
     * @return Player who won
     */
    public String battle()
    {
        ArrayList<Card> removePile = new ArrayList<>();
        ArrayList<Card> tiePileP1 = new ArrayList<>();
        ArrayList<Card> tiePileP2 = new ArrayList<>();
        ArrayList<Card> tieCombined = new ArrayList<>();
        int position = 0; // current position of card in Arraylist
        Card currentP1 = p1.get(position);
        Card currentP2 = p2.get(position);

        while(p1.size() > 0 && p2.size() > 0) // if there are more than 0 cards
        {
            currentP1 = p1.get(position); // current card of p1
            currentP2 = p2.get(position); // current card of p2

            System.out.println(currentP1.getShortHand().toUpperCase() + " vs " + currentP2.getShortHand().toUpperCase());


            if (currentP1.compareTo(currentP2) != 0)
            {
                if (currentP1.compareTo(currentP2) == 1) // if P2 card is higher
                {
                    removePile.add(p1.remove(position)); // removes both cards that were compared
                    removePile.add(p2.remove(position));
                    Collections.shuffle(removePile); // shuffles them

                    p2.addAll(removePile); // adds them to winning player's pile
                    removePile.clear(); // clears the shuffling pile

                }

                else if (currentP2.compareTo(currentP1) == 1) // if P2 card is lower
                {
                    removePile.add(p1.remove(position));
                    removePile.add(p2.remove(position));
                    Collections.shuffle(removePile);

                    p1.addAll(removePile);
                    removePile.clear();

                }
            }

            while (currentP1.compareTo(currentP2) == 0) // if there is a tie
            {
                System.out.println(">>WAR!<<");

                if(p1.size() >= 5)
                {
                    for(int i = 0; i < 4; i++)
                    {
                        tiePileP1.add(p1.remove(position)); // removes first 4 cards
                    }
                }

                else if(p1.size() < 5 && p1.size() != 1) // if there is less than 5 cards
                {
                    int removeCardsP1 = p1.size() - 1;

                    for(int i = 0; i < removeCardsP1; i++)
                    {
                        tiePileP1.add(p1.remove(position)); // removes cards until there is 1
                    }
                }

                if(p2.size() >= 5)
                {
                    for(int i = 0; i < 4; i++)
                    {
                        tiePileP2.add(p2.remove(position)); // removes first 4 cards
                    }
                }

                else if(p2.size() < 5 && p2.size() != 1) // if there is less than 5 cards
                {
                    int removeCardsP2 = p2.size() - 1;

                    for(int i = 0; i < removeCardsP2; i++)
                    {
                        tiePileP2.add(p2.remove(position));
                    }
                }

                // combines the piles together
                tieCombined.addAll(tiePileP1);
                tiePileP1.clear();
                tieCombined.addAll(tiePileP2);
                tiePileP2.clear();

                //shuffles
                Collections.shuffle(tieCombined);

                currentP1 = p1.get(position);
                currentP2 = p2.get(position);

                System.out.println(currentP1.getShortHand().toUpperCase() + " vs " + currentP2.getShortHand().toUpperCase());

                if(currentP1.compareTo(currentP2) == 1) // if player 2 wins
                {
                    p2.addAll(tieCombined);
                    tieCombined.clear();
                }

                if(currentP2.compareTo(currentP1) == 1) // if player 1 wins
                {
                    p1.addAll(tieCombined);
                    tieCombined.clear();
                }

            }
        }

        if(p1.size() == 0) // player 2 wins
        {
            return "Player 2";
        }

        else // player 1 wins
        {
            return "Player 1";
        }
    }


    /**
     * Determines if the game is over
     * @return true if game is done, false if it is not
     */
    public boolean gameOver()
    {
        if(p1.size() == 0 || p2.size() == 0)
            return true;
        return false;
    }

    /**
     * Takes in a Card ArrayList and turns it into a String ArrayList
     * @param cardList
     * @return String ArrayList
     */
    public ArrayList<String> cardToArrayList(ArrayList<Card> cardList)
    {
        ArrayList<String> transfer = new ArrayList<>();

        for(int i = 0; i < cardList.size(); i++)
        {
            Card cardGet = cardList.get(i); // obtains each Card
            String stringCard = cardGet.getShortHand(); // gets string of each Card


            transfer.add(stringCard.toUpperCase()); // enters it into the String ArrayList
        }

        return transfer;
    }

    public String toString()
    {

        ArrayList<String> p1ToString = cardToArrayList(p1);// converts to String ArrayList
        ArrayList<String> p2ToString = cardToArrayList(p2);// converts to String ArrayList

        String returnString = "";

        if(p1.size() < 9)
        {
            returnString = returnString + "Player 1 " + "(" + p1.size() + "):   " + p1ToString + "\n" +
                    "Player 2 " + "(" + p2.size() + "):   " + p2ToString;
        }

        else if(p2.size() < 9)
        {
            returnString = returnString + "Player 1 " + "(" + p1.size() + "):   " + p1ToString + "\n" +
                    "Player 2 " + "(" + p2.size() + "):    " + p2ToString;
        }

        else
        {
            returnString = returnString + "Player 1 " + "(" + p1.size() + "):    " + p1ToString + "\n" +
                "Player 2 " + "(" + p2.size() + "):    " + p2ToString;
        }

        return returnString;
    }
}