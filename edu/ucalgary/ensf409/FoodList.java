package edu.ucalgary.ensf409;

import java.sql.*;
import java.util.*;

public class FoodList {

    public static void main(String[] args) {
        FoodList hashM = new FoodList();
        hashM.fillFromDatabase();
        System.out.println("hashmap is: "+ hashM.getFoodList());
        // Iterator<Food> it = hashM.entrySet().iterator();
        // while(it.hasNext()) {
        //     System.out.println(it.next().getNAME());
        //   }
        // fl.close();
    }


    private final String DBURL = "jdbc:mysql://localhost:3306/food_inventory";
    private final String USERNAME = "student";
    private final String PASSWORD = "ensf";    
    private Connection dbConnect;
    private ResultSet results;

    private HashMap<Integer,Food> currentFood;
    public FoodList(){
        currentFood = new HashMap<>();
    }
    public FoodList(Food food){
        currentFood = new HashMap<>();
        currentFood.put(food.getITEM_ID(), food);
    }
    
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
    
    public void addFood(Food food){
        currentFood.put(food.getITEM_ID(), food);
    }
    
    public void removeFood(String foodID){
        for(int i= 0; i<currentFood.size(); i++){
            if(currentFood.get(i).getNAME().equals(foodID)){
                currentFood.remove(i);
                return;
            }
        }
    }
    
    public HashMap<Integer,Food> getFoodList() {
        return currentFood;
    }
    public void removeFromDatabase(ArrayList<Integer> arrayList) throws InsufficientStockException{
        for(int id : arrayList){
            try {
                String query1 = "DELETE FROM available_Food WHERE itemID = ?";
                String query2 = "SELECT * FROM available_Food WHERE itemID = ?";
                PreparedStatement myStmt1 = dbConnect.prepareStatement(query1);
                PreparedStatement myStmt2 = dbConnect.prepareStatement(query2);
                myStmt2.setInt(1, id);
                //myStmt2.executeUpdate();
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

    public int getTotalCalories(){
        int calories = 0;
        for(int i=0; i<currentFood.size(); i++){
            calories += currentFood.get(i).getCALORIES();
        }
        return calories;
    }

    public void setFoodList(HashMap<Integer,Food> foodList) throws IllegalArgumentException {
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
