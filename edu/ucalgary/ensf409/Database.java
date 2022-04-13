package edu.ucalgary.ensf409;

import java.sql.*;

public class Database{

    private final String DBURL;
    private final String USERNAME;
    private final String PASSWORD;    
    
    private Connection dbConnect;
    private ResultSet results;
    
    public Database(String url, String user, String pw){
        // Database URL
        this.DBURL = url;

        //  Database credentials
        this.USERNAME = user;
        this.PASSWORD = pw;
    }


//Must create a connection to the database, no arguments, no return value    
    public void initializeConnection(){
        try {
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    public String selectFoods(){     
        String query = "SELECT ItemID, Name from available_food";
        StringBuilder result = new StringBuilder("");

        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery(query);

            while (results.next()) {
                String itemID = results.getString("ItemID");
                String name = results.getString("Name");
                result.append(itemID + "," + name + "\n");
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 

        return result.toString();
    }
    
    public String selectClients(){     
        String query = "SELECT ClientID, Client from daily_client_needs";
        StringBuilder result = new StringBuilder("");

        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery(query);

            while (results.next()) {
                String clientID = results.getString("ClientID");
                String client = results.getString("Client");
                result.append(clientID + "," + client + "\n");
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 

        return result.toString();
    }   
    
 
    public void deleteFood(String id){
        String query = "DELETE FROM available_food WHERE itemID = " + id;

        try {
            Statement stmt = dbConnect.createStatement();
            stmt.executeUpdate(query);
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } 
    }    

    public void close() {
        try {
            results.close();    
            dbConnect.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {

		// Remember that each time you execute the given .sql file, the database will be reset. 
		// You should reset the database before each test run of your code.

        //Use the following account information: Username = student, Password = ensf
        Database myJDBC = new Database("jdbc:mysql://localhost:3306/food_inventory","student", "ensf");

        myJDBC.initializeConnection();

        //myJDBC.deleteFood("1");
        //myJDBC.deleteFood("3");
        //myJDBC.deleteFood("9");

        //System.out.println(myJDBC.selectFoods());
        System.out.println(myJDBC.selectClients());
        myJDBC.close();
        System.out.println("------------------------------");
        System.out.println("***End of tests.***"); 
    }
}


