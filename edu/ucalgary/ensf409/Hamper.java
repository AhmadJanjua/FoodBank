package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Hamper {
    private ClientList nutrientNeeds;
    private FoodList foodsDatabase;
    private ArrayList<String> inHamper;

    public Hamper(ClientList nutrientNeeds, FoodList foods) {
    }
    
    public void addToHamper(Food food){
    }

    public ArrayList<String> getInHamper() {
        return inHamper;
    }
    
    public ClientList getNutrientNeeds() {
        return nutrientNeeds;
    }
    public void setNutrientNeeds(ClientList nutrientNeeds) {
        this.nutrientNeeds = nutrientNeeds;
    }

    public String createOrderFormat() {
        return "";
    }

}
