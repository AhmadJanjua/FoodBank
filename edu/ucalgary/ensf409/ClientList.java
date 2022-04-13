package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.util.Iterator;
import java.sql.*;

public class ClientList {

    public static void main(String[] args) {
        ClientList cList = new ClientList(1, 2, 3, 4, true);
        cList.removeClient("Adult Male");
        System.out.println(cList.getTotalCalories());
        Iterator<Client> it = cList.getClients().iterator();
        while(it.hasNext()) {
            System.out.println(it.next().getClientType());
        }
    }

    private final String DBURL = "jdbc:mysql://localhost:3306/food_inventory";
    private final String USERNAME = "student";
    private final String PASSWORD = "ensf";    
    private Connection dbConnect;
    private ResultSet results;

    private ArrayList<Client> clients = new ArrayList<>();
    private int totalCalories= 0;
    private int totalGrainCalories = 0;
    private int totalFVCalories = 0;
    private int totalProteinCalories = 0;
    private int totalOtherCalories = 0;
    private boolean isMobilityStruggled = false;
    private int address;
    
    public ClientList(int numMale, int numFemale, int under, int over, boolean isMobilityStruggled) {
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
        for(int i=0; i<clients.size(); i++){
            this.totalCalories = 0; 
            this.totalGrainCalories = 0;
            this.totalFVCalories = 0;
            this.totalProteinCalories = 0;
            this.totalOtherCalories = 0;
            Client tmp = clients.get(i);
            this.totalCalories += tmp.getCalories(); 
            this.totalGrainCalories += Math.ceil((0.01)*tmp.getGrainPercent()*tmp.getCalories());
            this.totalFVCalories += Math.ceil((0.01)*tmp.getFVPercent()*tmp.getCalories());
            this.totalProteinCalories += Math.ceil((0.01)*tmp.getProteinPercent()*tmp.getCalories());
            this.totalOtherCalories += Math.ceil((0.01)*tmp.getOtherPercent()*tmp.getCalories());
        }
    }
    public int getTotalGrainCalories() {
        return totalGrainCalories;
    }
    public void setTotalGrainCalories(int totalGrainCalories) {
        this.totalGrainCalories = totalGrainCalories;
    }
    public int getTotalFVCalories() {
        return totalFVCalories;
    }
    public void setTotalFVCalories(int totalFVCalories) {
        this.totalFVCalories = totalFVCalories;
    }
    public int getTotalProteinCalories() {
        return totalProteinCalories;
    }
    public void setTotalProteinCalories(int totalProteinCalories) {
        this.totalProteinCalories = totalProteinCalories;
    }
    public int getTotalOtherCalories() {
        return totalOtherCalories;
    }
    public void setTotalOtherCalories(int totalOtherCalories) {
        this.totalOtherCalories = totalOtherCalories;
    }
    public int getTotalCalories() {
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
