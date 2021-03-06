package projects;

import java.util.ArrayList;
import java.util.Objects;

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
        
        int totalblack = 0;
        int total = 0;
        boolean BS = false; //Balustrade Spy or Uundercity Informer is in hand
        boolean DR = true; //Dread Return and Uunderworld Cerberus are not in hand 
        int narcomoeba = 0; //Number of Narcomoebas
        for (Card c: this.cards){
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
    @Override
    public int hashCode(){
        int code = 0;
        code = this.cards.stream().map((card) -> card.hashCode()).reduce(code, Integer::sum);
        return (int)(code / this.cards.size());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hand other = (Hand) obj;
        if (!Objects.equals(this.cards, other.cards)) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        
        String output = "";
        output = this.cards.stream().map((card) -> card.toString() + "\n").reduce(output, String::concat);
        return output;
    }
}
