package edu.ucalgary.ensf409;


/**
@author Pedro Ghodsi
@version 1.0
@since 1.0
*/
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Order {
    
    public static void main(String[] args) throws InsufficientFoodException, InsufficientStockException {
        ClientList cList = new ClientList(1, 1, 1, 1, true); // to be fixed with GUI later
        //System.out.println(cList.getClientString());   ADDED to Check if it prints out the clientlist properly
        FoodList fList = new FoodList();
        String nameInput = "Name:" + ""; // to be fixed with gui later
        String clients = cList.getClients().toString();
        DateTimeFormatter today = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        fList.fillFromDatabase();
        Hamper hamper = new Hamper(cList, fList);
        System.out.println(hamper.createOrderFormat());
        try
        {
            FileWriter fileWriter = new FileWriter("ExampleOutputUnfinished.txt");
            fileWriter.write(nameInput + "\n");
            fileWriter.write("Date: " +today.format(now) + "\n" + "\n");
            fileWriter.write(clients + "\n");
            fileWriter.write(hamper.createOrderFormat());
            fileWriter.flush();
            fileWriter.close();
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
        

        fList.removeFromDatabase(hamper.getItemList());
        //fList.removeFromDatabase(hamper.getItemList());
    }
    
    
    //not sure what to do with this right now
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
