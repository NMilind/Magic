package projects;

import java.io.IOException;

public class Program {

    public static void main(String[] args) {

        Deck deck = new Deck();
        try {
            deck = Deck.FromCSV("/home/nikhil/Desktop/Java-Code/Magic/src/projects/cards.csv");
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
        
        deck.shuffle();
        Hand hand = deck.dealHand(12);
        System.out.println(hand);
        
        try {
            HTMLWriter.GenerateHand(hand);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
