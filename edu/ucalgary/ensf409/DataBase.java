package edu.ucalgary.ensf409;
/**
@author Ahmad Janjua
@version 1.0
@since 1.0
*/

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


/*
 * Class that interacts with the database and returns information to other classes
 */
public class DataBase {
    //Fields to connect to the database
    private final String DBURL = "jdbc:mysql://localhost:3306/food_inventory";
    private final String USERNAME = "student";
    private final String PASSWORD = "ensf";    
    private Connection dbConnect;
    private ResultSet results;

    // Default constructor that initializes the connection
    public DataBase()
    {
        try {
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    // Method that closes the connection
    public void close() {
        try {
            results.close();    
            dbConnect.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Methods for Client enum
    /**
     * @param id Require the ID number of the Client Requested
     * @return An array of 5 integers.
     * int[0]: Grain Percent out of 100.
     * int[1]: Fruits and Veggies Percent out of 100.
     * int[2]: Protein Percent out of 100.
     * int[3]: Other Percent out of 100.
     * int[4]: Total Calories required.
     * */
    public int[] selectNeeds(int id) {
        int[] clientNeeds = new int[5];
        String query = "SELECT * FROM DAILY_CLIENT_NEEDS WHERE ClientID =" + id;

        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery(query);

            if(results.next()) {
                clientNeeds[0] = results.getInt("WholeGrains");
                clientNeeds[1] = results.getInt("FruitVeggies");
                clientNeeds[2] = results.getInt("Protein");
                clientNeeds[3] = results.getInt("Other");
                clientNeeds[4] = results.getInt("Calories");
            }

            stmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clientNeeds;
    }

    // Methods for FoodMap
    /**
     * Creates a new hashmap that filled with Food objects from the
     * available_food database.
     */
    public HashMap<Integer, Food> getAllFood() {
        var foodMap = new HashMap<Integer, Food>();

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
                var food = new Food(itemID, name, grainContent, fvContent, proContent, other, calories);
                foodMap.put(itemID,food);
            }
            stmt.close();
            return foodMap;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new HashMap<Integer, Food>();
        }
    }
    /*
     * Method that removes selected food from database.
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
    
}
