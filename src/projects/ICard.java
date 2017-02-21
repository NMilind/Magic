package projects;

import java.util.ArrayList;

public interface ICard {

    String getName();
    Cost getCost();
    Cost getManagen();
    ArrayList<Type> getTypes();
    String getTitle();
    int getPower();
    int getToughness();
}
