package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

public class FoodList {

    public static void main(String[] args) {
        FoodList fl = new FoodList();
        Iterator<Food> it = fl.getFoodList().iterator();
        while(it.hasNext()) {
            System.out.println(it.next().getNAME());
          }
        fl.close();
    }


    private final String DBURL = "jdbc:mysql://localhost:3306/food_inventory";
    private final String USERNAME = "student";
    private final String PASSWORD = "ensf";    
    private Connection dbConnect;
    private ResultSet results;


    private ArrayList<Food> currentFood = new ArrayList<>();

    public FoodList(){
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
                currentFood.add(food);
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    public void addFood(Food food){
        
    }

    public void removeFood(int foodID){}

    public ArrayList<Food> getFoodList() {
        return currentFood;
    }

    public void setFoodList(ArrayList<Food> foodList) throws IllegalArgumentException {
        this.currentFood = foodList;
    }

    public void close() {
        try {
            results.close();    
            dbConnect.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
