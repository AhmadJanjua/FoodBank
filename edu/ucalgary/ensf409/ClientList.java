package edu.ucalgary.ensf409;
/**
@author Ahmad Janjua, Zohaib
@version 1.3
@since 1.0
*/
import java.util.*;
import java.sql.*;

/*
ClientList Class takes in a collection of clients and gets their requirement from the database
from the database it then gets gathers info related to their daily needs.
 */

public class ClientList {

    private final String DBURL = "jdbc:mysql://localhost:3306/food_inventory";
    private final String USERNAME = "student";
    private final String PASSWORD = "ensf";    
    private Connection dbConnect;
    private ResultSet results;
    private int numMale, numFemale, under, over;

    private ArrayList<Client> clients = new ArrayList<>();
    private double totalCalories= 0;
    private double totalGrainCalories = 0;
    private double totalFVCalories = 0;
    private double totalProteinCalories = 0;
    private double totalOtherCalories = 0;
    private boolean isMobilityStruggled = false;
    private int address;
    

    public ClientList(int numMale, int numFemale, int under, int over, boolean isMobilityStruggled) {
        this.numMale = numMale;
        this.numFemale = numFemale;
        this.over = over;
        this.under = under;
        
        this.isMobilityStruggled = isMobilityStruggled;
        try {
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String query = "SELECT * from daily_client_needs";

        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery(query);
            while (results.next()) {
                String client = results.getString("Client");
                int wholeGrains = results.getInt("WholeGrains");
                int fruitVeggies = results.getInt("FruitVeggies");
                int protein = results.getInt("Protein");
                int other = results.getInt("Other");
                int calories = results.getInt("Calories");
                switch (client) {
                    case "Adult Male":
                        for(int i=0; i<numMale;i++){
                            Client temp = new Client(client, wholeGrains, fruitVeggies, protein, other, calories);
                            clients.add(temp);
                        }
                        break;
                    case "Adult Female":
                        for(int i=0; i<numFemale;i++){
                            Client temp = new Client(client, wholeGrains, fruitVeggies, protein, other, calories);
                            clients.add(temp);
                        }
                        break;
                    case "Child over 8":
                        for(int i=0; i<over;i++){
                            Client temp = new Client(client, wholeGrains, fruitVeggies, protein, other, calories);
                            clients.add(temp);
                        }
                        break;
                    case "Child under 8":
                        for(int i=0; i<under;i++){
                            Client temp = new Client(client, wholeGrains, fruitVeggies, protein, other, calories);
                            clients.add(temp);
                        }
                        break;
                }
            }
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        this.setNutrientNeeds();
    }
    
    public ArrayList<Client> getClients() {
        return clients;
    }
    public void setNutrientNeeds() {
        this.totalCalories = 0; 
        this.totalGrainCalories = 0;
        this.totalFVCalories = 0;
        this.totalProteinCalories = 0;
        this.totalOtherCalories = 0;
        for(int i=0; i<clients.size(); i++){
            Client tmp = clients.get(i);
            this.totalCalories += tmp.getCalories(); 
            this.totalGrainCalories += (0.01)*tmp.getGrainPercent()*tmp.getCalories();
            this.totalFVCalories += (0.01)*tmp.getFVPercent()*tmp.getCalories();
            this.totalProteinCalories += (0.01)*tmp.getProteinPercent()*tmp.getCalories();
            this.totalOtherCalories += (0.01)*tmp.getOtherPercent()*tmp.getCalories();
        }
    }
    public double getTotalGrainCalories() {
        return totalGrainCalories;
    }
    //Returns a String of clients
    public String getClientString() {
        String clientString = "";
        if(numMale != 0){
            clientString += numMale + " Adult Male, ";
        }
        if(numFemale != 0){
            clientString += numFemale + " Adult Female, ";
        }
        if(under != 0){
            clientString += under + " Child under 8, ";
        }
        if(over != 0){
            clientString += over + " Child over 8, ";
        }
        return clientString.substring(0, clientString.length()-2);

    }



    public void setTotalGrainCalories(int totalGrainCalories) {
        this.totalGrainCalories = totalGrainCalories;
    }
    public double getTotalFVCalories() {
        return totalFVCalories;
    }
    public void setTotalFVCalories(int totalFVCalories) {
        this.totalFVCalories = totalFVCalories;
    }
    public double getTotalProteinCalories() {
        return totalProteinCalories;
    }
    public void setTotalProteinCalories(int totalProteinCalories) {
        this.totalProteinCalories = totalProteinCalories;
    }
    public double getTotalOtherCalories() {
        return totalOtherCalories;
    }
    public void setTotalOtherCalories(int totalOtherCalories) {
        this.totalOtherCalories = totalOtherCalories;
    }
    public double getTotalCalories() {
        return totalCalories;
    }
    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }
    public boolean isMobilityStruggled() {
        return isMobilityStruggled;
    }
    public void setMobilityStruggled(boolean isMobilityStruggled) {
        this.isMobilityStruggled = isMobilityStruggled;
    }
    public int getAddress() {
        return address;
    }
    public void setAddress(int address) {
        this.address = address;
    }
    public void removeClient(String client) {
        for(int i= 0; i<clients.size(); i++){
            if(clients.get(i).getClientType().equals(client)){
                clients.remove(i);
                return;
            }
        }
        this.setNutrientNeeds();
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
