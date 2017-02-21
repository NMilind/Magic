package projects;

import java.util.ArrayList;

public class Card implements ICard, Comparable {

    private final String name;
    private Cost cost;
    private ArrayList<Type> types;
    private final String title;
    private int power;
    private int toughness;
    
    public Card() {
        
        this.name = "";
        this.cost = new Cost();
        this.types = new ArrayList<>();
        this.title = "";
        this.power = Integer.MIN_VALUE;
        this.toughness = Integer.MIN_VALUE;
    }
    
    public Card(String name, Cost cost, ArrayList<Type> types, String title, int power, int toughness) {
        
        this.name = name;
        this.cost = cost;
        this.types = types;
        this.title = title;
        this.power = power;
        this.toughness = toughness;
    }
    
    @Override
    public String getName() {
    
        return this.name;
    }

    @Override
    public Cost getCost() {
    
        return this.cost;
    }

    @Override
    public ArrayList<Type> getTypes() {
        
        return this.types;
    }

    @Override
    public String getTitle() {
        
        return this.title;
    }

    @Override
    public int getPower() {
        
        return this.power;
    }

    @Override
    public int getToughness() {
        
        return this.toughness;
    }
    
    @Override
    public String toString() {
        
        return this.name + "|" + 
                this.cost.getConvertedManaCost() + "|" + 
                this.title + "|" + 
                this.power + "|" + 
                this.toughness;
    }

    @Override
    public int compareTo(Object obj) {
        
        if (obj instanceof Card == false) {
            return Integer.MAX_VALUE;
        }
        
        return this.getName().compareTo(((Card)obj).getName());
    }
}
