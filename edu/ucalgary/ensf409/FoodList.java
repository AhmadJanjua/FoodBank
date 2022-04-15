package edu.ucalgary.ensf409;
/**
@author Ahmad Janjua
@version 1.4
@since 1.0
*/
import java.sql.*;
import java.util.*;

/*
FoodList class creates a hashmap of Food.
This class may create a collection from the database
or as manual inputs of Food objects. 
The foodList can be used to connect to the database and also modify it.
It also provides info about the nutrition 
*/
public class FoodList {

    public static void main(String[] args) {
        FoodList hashM = new FoodList();
        hashM.fillFromDatabase();
        System.out.println("hashmap is: "+ hashM.getFoodList());
        hashM.close();
    }

    //Fields to connect to the database
    private final String DBURL = "jdbc:mysql://localhost:3306/food_inventory";
    private final String USERNAME = "student";
    private final String PASSWORD = "ensf";    
    private Connection dbConnect;
    private ResultSet results;
    /**
     * Creates a new hashmap thats filled with Food objects from the
     * available_food database.
     */
    public void fillFromDatabase(){
        currentFood = new HashMap<>();
        try {
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String query = "SELECT * from available_food";
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery(query);
            while (results.next()) {
                int itemID = results.getInt("ItemID");
                String name = results.getString("Name");
                int grainContent = results.getInt("GrainContent");
                int fvContent = results.getInt("FVContent");
                int proContent = results.getInt("ProContent");
                int other = results.getInt("Other");
                int calories = results.getInt("Calories");
                Food food = new Food(itemID, name, grainContent, fvContent, proContent, other, calories);
                currentFood.put(itemID,food);
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    /**
     * @param arrayList Requires an ArrayList of Integers that represent the ItemID
     * and removes those items from the database
     * @throws InsufficientStockException if an ItemID is passed which in not present in the database the
     * method throws an InsufficientStockException.
     */
    public void removeFromDatabase(ArrayList<Integer> arrayList) throws InsufficientStockException{
        for(int id : arrayList){
            try {
                String query1 = "DELETE FROM available_Food WHERE itemID = ?";
                String query2 = "SELECT * FROM available_Food WHERE itemID = ?";
                PreparedStatement myStmt1 = dbConnect.prepareStatement(query1);
                PreparedStatement myStmt2 = dbConnect.prepareStatement(query2);
                myStmt2.setInt(1, id);
                ResultSet rs = myStmt2.executeQuery();
                if(!rs.isBeforeFirst()){
                    throw new InsufficientStockException("Items out of Stock!");
                }
                myStmt1.setInt(1, id);
                myStmt1.executeUpdate();
                myStmt1.close();
                myStmt2.close();
    
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    /**
     * Closes the connection to the database.
     */
    public void close() {
        try {
            results.close();    
            dbConnect.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    //Field for the FoodList class
    private HashMap<Integer,Food> currentFood;

    /**
     * Default constructor that initializes an empty HashMap
     */
    public FoodList(){
        currentFood = new HashMap<>();
    }
    /**
     * Over loaded constructor
     * @param food Requires a food object that it adds to the hashmap.
     */
    public FoodList(Food food){
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
     * 
     * @return A hashmap full of Food object and ItemID as the main key's.
     */
    public HashMap<Integer,Food> getFoodList() {
        return currentFood;
    }
    /**
     * 
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
     * @param foodList A replacement hashmap.
     */
    public void setFoodList(HashMap<Integer,Food> foodList) {
        this.currentFood = foodList;
    }
}
