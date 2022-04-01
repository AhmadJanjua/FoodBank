package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class FoodList {
    
    private ArrayList<Food> currentFood;

    public FoodList(Food food){}

    public FoodList(ArrayList<Food> foodList) throws IllegalArgumentException{}

    public void addFood(Food food){}

    public void removeFood(int foodID){}

    public ArrayList<Food> getFoodList() {
        return currentFood;
    }

    public void setFoodList(ArrayList<Food> foodList) throws IllegalArgumentException {
        this.currentFood = foodList;
    }
}
