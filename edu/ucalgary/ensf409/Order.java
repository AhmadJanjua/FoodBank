package edu.ucalgary.ensf409;


/**
@author Pedro Ghodsi
@version 1.8
@since 1.0
*/
//import java.util.ArrayList;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.Scanner;
//import edu.ucalgary.ensf409.GUI.ClickListener;

//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;

public class Order {
    
    private static int counter = 2;

    public void orderCreation() throws InsufficientFoodException, InsufficientStockException{
        
        if (GUI.adultMaleBox.getText().isEmpty()){
            GUI.errorBox("Error, enter valid # for adultMaleNumbers", "error");
        }
        if (GUI.adultFemaleBox.getText().isEmpty()){
            GUI.errorBox("Error, enter valid # for adultFemaleNumbers", "error");
        }
        if (GUI.under8Box.getText().isEmpty()){
            GUI.errorBox("Error, enter valid # for adultUnder8Numbers", "error");
        }
        if (GUI.over8Box.getText().isEmpty()){
            GUI.errorBox("Error, enter valid # for adultOver8Numbers", "error");
        }
        
        
        ClientList cList = new ClientList(Integer.parseInt(GUI.adultMaleBox.getText()), Integer.parseInt(GUI.adultFemaleBox.getText()), Integer.parseInt(GUI.under8Box.getText()), Integer.parseInt(GUI.over8Box.getText()), GUI.mobReqBox.isSelected());
        //System.out.println(cList.getClientString());   ADDED to Check if it prints out the clientlist properly
        FoodList fList = new FoodList();
        fList.fillFromDatabase();
        Hamper hamper = new Hamper(cList, fList);
        //System.out.println(hamper.createOrderFormat());
        try
        {
            FileWriter fileWriter = new FileWriter("ExampleOutputUnfinished.txt", true);
            if(GUI.mobReqBox.isSelected() == true){
                fileWriter.append("Mobility Accomodations Requested, Hamper will be delivered to the address associated with the Postal Code\n");
                fileWriter.append("Your Postal Code: " + GUI.postCodeBox.getText() + "\n");
            }
            fileWriter.append("Original Request" +"\n");
            fileWriter.append("Hamper " + counter + ": " + cList.getClientString() + "\n\n" );
            fileWriter.append("Hamper " + counter +" Items:\n");
            fileWriter.append(hamper.createOrderFormat() + "\n\n");
            System.out.println(counter);
            Order.increment();
            fileWriter.flush();
            fileWriter.close();
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
    }

    public static synchronized void increment(){
        counter++;
    }
    public static synchronized int getCounter(){
        return counter;
    }




    public void addFirstOrder() throws InsufficientFoodException{
        
        if (GUI.adultMaleBox.getText().isEmpty()){
            GUI.errorBox("Error, enter valid # for adultMaleNumbers", "error");
        }
        if (GUI.adultFemaleBox.getText().isEmpty()){
            GUI.errorBox("Error, enter valid # for adultFemaleNumbers", "error");
        }
        if (GUI.under8Box.getText().isEmpty()){
            GUI.errorBox("Error, enter valid # for adultUnder8Numbers", "error");
        }
        if (GUI.over8Box.getText().isEmpty()){
            GUI.errorBox("Error, enter valid # for adultOver8Numbers", "error");
        }
        
        ClientList cList = new ClientList(Integer.parseInt(GUI.adultMaleBox.getText()), Integer.parseInt(GUI.adultFemaleBox.getText()), Integer.parseInt(GUI.under8Box.getText()), Integer.parseInt(GUI.over8Box.getText()), GUI.mobReqBox.isSelected());
        //System.out.println(cList.getClientString());   ADDED to Check if it prints out the clientlist properly
        FoodList fList = new FoodList();
        int hamperNumber = 1;
        fList.fillFromDatabase();
        Hamper hamper = new Hamper(cList, fList);
        
        String nameInput = "Name:" + GUI.name.getText(); // to be fixed with gui later
        try{
            FileWriter headerWriter = new FileWriter("ExampleOutputUnfinished.txt", true);
            headerWriter.append(nameInput + "\n");
            DateTimeFormatter today = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            headerWriter.append("Date: " +today.format(now) + "\n" + "\n");
            if(GUI.mobReqBox.isSelected() == true){
                headerWriter.append("Mobility Accomodations Requested, Hamper will be delivered to the address associated with the Postal Code\n");
                headerWriter.append("Your Postal Code: " + GUI.postCodeBox.getText() + "\n");
            }
            headerWriter.append("Original Request" +"\n");
            headerWriter.append("Hamper " + hamperNumber + ": " + cList.getClientString() + "\n\n" );
            headerWriter.append("Hamper " + hamperNumber +" Items:\n");
            headerWriter.append(hamper.createOrderFormat() + "\n\n");
            headerWriter.flush();
            headerWriter.close();
        }
        catch(IOException ioException)
        {
            ioException.printStackTrace();
        }
    }



    
    
    
    /*public static void main(String[] args) throws InsufficientFoodException, InsufficientStockException {
        ClientList cList = new ClientList(1, 1, 1, 1, true); // to be fixed with GUI later
        //System.out.println(cList.getClientString());   ADDED to Check if it prints out the clientlist properly
        FoodList fList = new FoodList();
        String nameInput = "Name:" + ""; // to be fixed with gui later
        DateTimeFormatter today = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        int hamperNumber = 1;
        LocalDateTime now = LocalDateTime.now();
        fList.fillFromDatabase();
        Hamper hamper = new Hamper(cList, fList);
        System.out.println(hamper.createOrderFormat());
        try
        {
            FileWriter fileWriter = new FileWriter("ExampleOutputUnfinished.txt");
            fileWriter.write(nameInput + "\n");
            fileWriter.write("Date: " +today.format(now) + "\n" + "\n");
            fileWriter.write("Original Request" +"\n");
            fileWriter.write("Hamper " + hamperNumber + ": " + cList.getClientString() + "\n\n" );
            fileWriter.write("Hamper " + hamperNumber +" Items:\n");
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
    }*/
    
    
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
