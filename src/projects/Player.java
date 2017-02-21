
package projects;

import java.io.IOException;


public class Player {

    private Deck deck;
    private Hand hand;
    
    public Player() throws IOException {
        
        this.deck = Deck.FromCSV("C:\\Users\\s769.098211\\Documents\\Magic\\src\\projects\\cards.csv");
        this.deck.shuffle();
        this.hand = this.deck.dealHand(7);
    }
    public boolean isWinning() {
        
        int totalblack = 0;
        int total = 0;
        boolean BS = false; //Balustrade Spy or Uundercity Informer is in hand
        boolean DR = true; //Dread Return and Uunderworld Cerberus are not in hand 
        int narcomoeba = 0; //Number of Narcomoebas
        for (Card c: this.hand.getCards()){
            totalblack += c.getManagen().getManaCost(Mana.BLACK);
            total += c.getManagen().getConvertedManaCost();
            if(c.getName().equals("Balustrade Spy") || c.getName().equals("Undercity Informer")){
                BS = true;
            }
            if(c.getName().equals("Dread Return") || c.getName().equals("Underworld Cerberus")){
                DR = false;
            }
            if(c.getName().equals("Narcomoeba")){
                narcomoeba += 1;
            }
            if(c.getName().equals("Dark Ritual")){
                totalblack -= 1;
            }
            if(c.getName().equals("Cabal Ritual")){
                totalblack -= 1;
                total -= 1;
            }
            
        }
        if (totalblack >=1){
            total -= 1;
        }
        System.out.print("Black Mana =");
        System.out.println(totalblack);
        System.out.print("Total Colorless Mana Except 1 Black =");
        System.out.println(total);
        return totalblack >= 1 && total >= 3 && BS && DR && narcomoeba <= 1;
        
        
    }
    public Hand getHand(){
        return this.hand;
    }
    public Deck getDeck(){
        return this.deck;
    }
    
}
