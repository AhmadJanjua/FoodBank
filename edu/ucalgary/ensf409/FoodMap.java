package edu.ucalgary.ensf409;
/**
@author Ahmad Janjua
@version 1.5
@since 1.0
*/

import java.util.*;

/*
FoodMap gets a Hashmap of all the food inside the database.
It also is used to update the database when food is removed.
*/
public class FoodMap {

    //Field for the FoodList class
    private HashMap<Integer,Food> currentFood;
    private DataBase food_data;

    /**
     * @param arrayList Requires an ArrayList of Integers that represent the ItemID
     * and removes those items from the database
     * @throws InsufficientStockException if an ItemID is passed which in not present in the database the
     * method throws an InsufficientStockException.
     */
    public void removeFromDatabase(ArrayList<Integer> arrayList) throws InsufficientStockException {
        food_data.removeFromDatabase(arrayList);
    }

    /**
     * Closes the connection to the database.
     */
    public void close() {
        food_data.close();
    }
    /**
     * Default constructor that initializes an empty HashMap
     */
    public FoodMap(){
        currentFood = new HashMap<>();
        food_data = new DataBase();
        currentFood = food_data.getAllFood();
    }
    /**
     * Over loaded constructor
     * @param food Requires a food object that it adds to the hashmap.
     */
    public FoodMap(Food food){
        currentFood = new HashMap<>();
        currentFood.put(food.getITEM_ID(), food);
    }
    /**
     * Adds food to the Food hashmap
     * @param food Requires a valid Food object
     */
    public void addFood(Food food){
        currentFood.put(food.getITEM_ID(), food);
    }
    /**
     * Removes Food object matching the ItemID passed in from the
     * hashmap. NOT CONNECTED TO DATABASE.
     * @param foodID An int corresponding to the item to be removed from the hashmap.
     */
    public void removeFood(int foodID){
        currentFood.remove(foodID);
    }
    /**
     * @return A hashmap full of Food object and ItemID as the main key's.
     */
    public HashMap<Integer,Food> getFoodList() {
        return currentFood;
    }
    /**
     * @return Get the total calories in the FoodList.
     */
    public double getTotalCalories(){
        double calories = 0;
        Iterator<Food> it = currentFood.values().iterator();
        while(it.hasNext()){
            calories += it.next().getCALORIES();
        }
        return calories;
    }
    /**
     * @param foodMap A replacement hashmap.
     */
    public void setFoodList(HashMap<Integer,Food> fMap) {
        this.currentFood = fMap;
    }

    public HashMap<Integer, Food> getFoodMap() {
        return currentFood;
    }
}
