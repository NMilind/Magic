package projects;

import java.util.ArrayList;

public class Hand {
    
    private ArrayList<Card> cards;
    
    public Hand() {
        
        this.cards = new ArrayList<>();
    }
    
    public Hand(ArrayList<Card> cards) {
        
        cards.sort((c1, c2) -> c1.compareTo(c2));
        this.cards = cards;
    }
    
    public ArrayList<Card> getCards() {
        
        return this.cards;
    }
    
    public boolean isWinning() {
        
        
    }
    
    @Override
    public String toString() {
        
        String output = "";
        for (Card card : this.cards) {
            
            output += card.toString() + "\n";
        }
        return output;
    }
}
