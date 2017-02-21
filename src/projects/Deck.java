package projects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;
    
    public Deck() {
        
        this.cards = new ArrayList<>();
    }
    
    public Card getCard(int index) {
        
        return this.cards.get(index);
    }
    
    public int getSize() {
        
        return this.cards.size();
    }
    
    public void shuffle() {
        
        Collections.shuffle(this.cards, new Random(new Date().hashCode()));
    }
    
    public Hand dealHand(int num) {
        
        ArrayList<Card> hand = new ArrayList<>(this.cards.subList(0, num));
        return new Hand(hand);
    }
    
    @Override
    public String toString() {
        
        String output = "";
        for (Card card : this.cards) {
            
            output += card.toString() + "\n";
        }
        return output;
    }
    
    public static Deck FromCSV(String filepath) throws IOException {
        
        Deck newDeck = new Deck();
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filepath)))) {
            
            for (String line; (line = br.readLine()) != null; ) { 
                
                String[] data = line.split(",");
                
                String name = data[0];
                int red = Integer.valueOf(data[1]);
                int green = Integer.valueOf(data[2]);
                int blue = Integer.valueOf(data[3]);
                int white = Integer.valueOf(data[4]);
                int black = Integer.valueOf(data[5]);
                int colorless = Integer.valueOf(data[6]);
                
                String[] types = data[7].split(";");
                Type[] types_cast = new Type[types.length];
                for (int i = 0; i < types.length; i++) {
                    types_cast[i] = Type.valueOf(types[i]);
                }
                
                String title = data[8];
                int power = Integer.valueOf(data[9]);
                int toughness = Integer.valueOf(data[10]);
                
                int redgen = Integer.valueOf(data[11]);
                int bluegen = Integer.valueOf(data[12]);
                int greengen = Integer.valueOf(data[13]);
                int whitegen = Integer.valueOf(data[14]);
                int blackgen = Integer.valueOf(data[15]);
                int colorlessgen = Integer.valueOf(data[16]);
                
                Card card = new Card(
                        name,
                        new Cost(red, green, blue, white, black, colorless),
                        new ArrayList<>(Arrays.asList(types_cast)),
                        title,
                        power,
                        toughness,
                        new Cost(redgen, bluegen, greengen, whitegen, blackgen, colorlessgen)
                );
                
                newDeck.cards.add(card);
            }
        }
        return newDeck;
    }
}
