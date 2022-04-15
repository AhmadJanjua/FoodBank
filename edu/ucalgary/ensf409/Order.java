package edu.ucalgary.ensf409;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Order {
    
    public static void main(String[] args) throws InsufficientFoodException, InsufficientStockException {
        ClientList cList = new ClientList(1, 0, 0, 1, true);
        FoodList fList = new FoodList();
        fList.fillFromDatabase();
        Hamper hamper = new Hamper(cList, fList);
        System.out.println(hamper.createOrderFormat());
        fList.removeFromDatabase(hamper.getItemList());
        //fList.removeFromDatabase(hamper.getItemList());
    }
    
    
    
    public static void fileCreator(String hampersFile){

        try{
            File output = new File(hampersFile);
            if (output.createNewFile()){
                System.out.println("\nOrder File has been created: " + output.getName());
            }
            else{
                System.out.println("\nNew order File created, old files removed.");
            }
        }

            catch (IOException e){
                System.out.println("An error occured.");
                e.printStackTrace();
            }
    }
}


   

    
    
    
    
    /*private ArrayList<Hamper> hampers;

    public Order() {
        hampers = new ArrayList<Hamper>();
    }

    public Order(ArrayList<Hamper> hampers) {
        this.hampers = hampers;
    }

    public boolean canComplete() {
        return hampers.size() > 0;
    }

    public void addHamper(Hamper newHamper) {
        hampers.add(newHamper);
    }

    public void resetOrder() {
    }

    public ArrayList<Hamper> getHampers() {
        return hampers;
    }*/
