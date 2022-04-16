package edu.ucalgary.ensf409;

/**
@author Pedro Ghodsi
@version 2.0
@since 1.0
*/
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;

public class Order {

    private static int counter = 2;

    public void orderCreation() throws InsufficientFoodException, InsufficientStockException {

        if (GUI.adultMaleBox.getText().isEmpty()) {
            GUI.errorBox("Error, enter valid # for adultMaleNumbers", "error");
        }
        if (GUI.adultFemaleBox.getText().isEmpty()) {
            GUI.errorBox("Error, enter valid # for adultFemaleNumbers", "error");
        }
        if (GUI.under8Box.getText().isEmpty()) {
            GUI.errorBox("Error, enter valid # for adultUnder8Numbers", "error");
        }
        if (GUI.over8Box.getText().isEmpty()) {
            GUI.errorBox("Error, enter valid # for adultOver8Numbers", "error");
        }

        ClientList cList = new ClientList(Integer.parseInt(GUI.adultMaleBox.getText().trim()),
                Integer.parseInt(GUI.adultFemaleBox.getText().trim()), Integer.parseInt(GUI.under8Box.getText().trim()),
                Integer.parseInt(GUI.over8Box.getText().trim()), GUI.mobReqBox.isSelected());
        // System.out.println(cList.getClientString()); ADDED to Check if it prints out
        // the clientlist properly
        FoodList fList = new FoodList();
        fList.fillFromDatabase();
        Hamper hamper = new Hamper(cList, fList);
        // System.out.println(hamper.createOrderFormat());
        try {
            FileWriter fileWriter = new FileWriter("Finalized Hamper Order.txt", true);
            if (GUI.mobReqBox.isSelected() == true) {

                fileWriter.append(
                        "Mobility Accomodations Requested, Hamper will be delivered to the address associated with the Postal Code\n");
                fileWriter.append("Your Postal Code: " + GUI.postCodeBox.getText().trim() + "\n");
            }
            fileWriter.append("Original Request" + "\n");
            fileWriter.append("Hamper " + counter + ": " + cList.getClientString() + "\n\n");
            fileWriter.append("Hamper " + counter + " Items:\n");
            fileWriter.append(hamper.createOrderFormat() + "\n\n");
            /////////////////////////////////////////////////////
            fList.removeFromDatabase(hamper.getItemList());
            System.out.println(counter);
            Order.increment();
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static synchronized void increment() {
        counter++;
    }

    public static synchronized int getCounter() {
        return counter;
    }

    public static synchronized void decrement(){
        counter--;
    }

    public void addFirstOrder() throws InsufficientFoodException, InsufficientStockException {

        if (GUI.adultMaleBox.getText().isEmpty()) {
            GUI.errorBox("Error, enter valid # for adultMaleNumbers", "error");
        }
        if (GUI.adultFemaleBox.getText().isEmpty()) {
            GUI.errorBox("Error, enter valid # for adultFemaleNumbers", "error");
        }
        if (GUI.under8Box.getText().isEmpty()) {
            GUI.errorBox("Error, enter valid # for adultUnder8Numbers", "error");
        }
        if (GUI.over8Box.getText().isEmpty()) {
            GUI.errorBox("Error, enter valid # for adultOver8Numbers", "error");
        }

        ClientList cList = new ClientList(Integer.parseInt(GUI.adultMaleBox.getText().trim()),
                Integer.parseInt(GUI.adultFemaleBox.getText().trim()), Integer.parseInt(GUI.under8Box.getText().trim()),
                Integer.parseInt(GUI.over8Box.getText().trim()), GUI.mobReqBox.isSelected());
        // System.out.println(cList.getClientString()); ADDED to Check if it prints out
        // the clientlist properly
        FoodList fList = new FoodList();
        int hamperNumber = 1;
        fList.fillFromDatabase();
        Hamper hamper = new Hamper(cList, fList);

        String nameInput = "Name:" + GUI.name.getText(); // to be fixed with gui later
        try {
            FileWriter headerWriter = new FileWriter("Finalized Hamper Order.txt", true);
            headerWriter.append(nameInput + "\n");
            DateTimeFormatter today = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            headerWriter.append("Date: " + today.format(now) + "\n" + "\n");
            if (GUI.mobReqBox.isSelected() == true) {

                headerWriter.append(
                        "Mobility Accomodations Requested, Hamper will be delivered to the address associated with the Postal Code\n");
                headerWriter.append("Your Postal Code: " + GUI.postCodeBox.getText().trim() + "\n");
            }
            headerWriter.append("Original Request" + "\n");
            headerWriter.append("Hamper " + hamperNumber + ": " + cList.getClientString() + "\n\n");
            headerWriter.append("Hamper " + hamperNumber + " Items:\n");
            headerWriter.append(hamper.createOrderFormat() + "\n\n");
            fList.removeFromDatabase(hamper.getItemList());
            headerWriter.flush();
            headerWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
