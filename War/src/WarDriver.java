import java.util.ArrayList;

public class WarDriver
{
    public static void main(String[] args)
    {
        War game = new War();

        //War game = warTest1();
        //War game = warTest2();
        //War game = warTest3();
        //War game = warTest4();
        //War game = warTest5();

        System.out.println(game);

        while(!game.gameOver())
        {
            System.out.println("Winner: " + game.battle());
            System.out.println("\n" + game);
        }
    }

    private static War warTest1()
    {
        String[] cards1 = {"5C"};
        String[] cards2 = {"AD"};

        ArrayList<Card> p1 = new ArrayList<Card>();
        ArrayList<Card> p2 = new ArrayList<Card>();

        for(String card : cards1)
            p1.add(new Card(card));

        for(String card : cards2)
            p2.add(new Card(card));

        return new War(p1, p2);
    }

    /*
    private static War warTest2()
    {
        String[] cards1 = {"AC", "5C", "8D", "KS", "QD"};
        String[] cards2 = {"AD", "QC", "7H", "5H", "3D"};

        ArrayList<Card> p1 = new ArrayList<Card>();
        ArrayList<Card> p2 = new ArrayList<Card>();

        for(String card : cards1)
            p1.add(new Card(card));

        for(String card : cards2)
            p2.add(new Card(card));

        return new War(p1, p2);
    }
    /*
    private static War warTest3()
    {
        String[] cards1 = {"10H", "3D", "QD", "6D", "10C", "5S", "QS", "4S", "2S"};
        String[] cards2 = {"10D", "8C", "4D", "5H", "10S", "QC", "KS", "3S", "JC"};

        ArrayList<Card> p1 = new ArrayList<Card>();
        ArrayList<Card> p2 = new ArrayList<Card>();

        for(String card : cards1)
            p1.add(new Card(card));

        for(String card : cards2)
            p2.add(new Card(card));

        return new War(p1, p2);
    }

   private static War warTest4()
    {
        String[] cards1 = {"QH", "6S", "5D", "8H", "KH", "AS", "9D"};
        String[] cards2 = {"QC", "JS", "8D"};

        ArrayList<Card> p1 = new ArrayList<Card>();
        ArrayList<Card> p2 = new ArrayList<Card>();

        for(String card : cards1)
            p1.add(new Card(card));

        for(String card : cards2)
            p2.add(new Card(card));

        return new War(p1, p2);
    }

    /*private static War warTest5()
    {
        String[] cards1 = {"10S", "2D", "3C", "8S"};
        String[] cards2 = {"10C", "9C", "KS", "AC", "8C", "JC"};

        ArrayList<Card> p1 = new ArrayList<Card>();
        ArrayList<Card> p2 = new ArrayList<Card>();

        for(String card : cards1)
            p1.add(new Card(card));

        for(String card : cards2)
            p2.add(new Card(card));

        return new War(p1, p2);
   }*/
}