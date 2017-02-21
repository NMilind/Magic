package projects;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {

    public static void main(String[] args) {

        /*Deck deck = new Deck();
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
        }*/
        Player player = null;
        try {
            player = new Player();
        } catch (IOException ex) {
            System.err.println(ex);
        }
        System.out.println(player.getHand());
        System.out.println(player.isWinning());
    }
}
