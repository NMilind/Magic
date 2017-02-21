package projects;

import java.io.IOException;

public class Program {

    public static void main(String[] args) {

        Deck deck = new Deck();
        try {
            deck = Deck.FromCSV("C:\\Users\\s769.098211\\Documents\\Magic\\src\\projects\\cards.csv");
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
        
        deck.shuffle();
        Hand hand = deck.dealHand(7);
        System.out.println(hand);
        System.out.println(hand.isWinning());
        
        try {
            HTMLWriter.GenerateHand(hand);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
