package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class ClientList {
    private ArrayList<Client> clients;
    private int totalGrainCalories;
    private int totalFVCalories;
    private int totalProteinCalories;
    private int totalOtherCalories;
    private boolean isMobilityStruggled;
    private int address;
    
    
    public ClientList(ArrayList<Client> clients, boolean isMobilityStruggled) {
        this.clients = clients;
    }
    
    public ClientList(Client client, boolean isMobilityStruggled) {
        this.clients = new ArrayList<Client> clients;
    }
    
    public ArrayList<Client> getClients() {
        return clients;
    }
    public void setNutrientNeeds(ArrayList<Client> clients) {
        this.clients = clients;
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
    
    public void removeClient(int clientID) {
        
        for (int i = 0; i < clients.length; i++) {
            int currID = clients.get(i).getclientID;
            
            if (currID = clientID) {
                clients.remove(i);
                return;
            }
    
        }
    }
    
    public void addClient(Client client) {
        clients.add client;
    }
    
    
    
}
