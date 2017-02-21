package projects;

import java.util.HashMap;

public class Cost {

    private HashMap<Mana, Integer> manas;
    
    public Cost() {
        
        this.manas = new HashMap<>();
    }
    
    public Cost(int red, int green, int blue, int white, int black, int colorless) {
        
        this.manas = new HashMap<>();
        this.manas.put(Mana.RED, red);
        this.manas.put(Mana.GREEN, green);
        this.manas.put(Mana.BLUE, blue);
        this.manas.put(Mana.WHITE, white);
        this.manas.put(Mana.BLACK, black);
        this.manas.put(Mana.COLORLESS, colorless);
    }
    
    public int getManaCost(Mana mana) {
        
        return this.manas.get(mana);
    }
    
    public int getConvertedManaCost() {
        
        int total = 0;
        for (int cost : this.manas.values()) {
            total += cost;
        }
        return total;
    }
}
