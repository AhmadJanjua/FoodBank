package edu.ucalgary.ensf409;

/**
@author Pedro Ghodsi
@version 2.1
@since 1.0
*/
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;

public class Order {

    private static int counter = 2; // Counter used to track hamper number past hamper number 1
    /**
     * 
     * @throws InsufficientFoodException when upon attempting to create a hamper, there is an insufficient amount of food stored in the database to create the hamper
     * @throws InsufficientStockException when attempting to remove items from a hamper, there is an error; cannot be caused without user error while setting up the database/not refreshing it
     */
    public void orderCreation() throws InsufficientFoodException, InsufficientStockException {
        //checkers to see if GUI inputs are valid
        if (GUI.adultMaleBox.getText().isEmpty() || (!(GUI.adultMaleBox.getText().matches("[0-9]+")))) {
            GUI.errorBox("Error, enter valid # for adult males", "error");
        }
        if (GUI.adultFemaleBox.getText().isEmpty() || (!(GUI.adultFemaleBox.getText().matches("[0-9]+")))) {
            GUI.errorBox("Error, enter valid # for adult females", "error");
        }
        if (GUI.under8Box.getText().isEmpty() || (!(GUI.under8Box.getText().matches("[0-9]+")))) {
            GUI.errorBox("Error, enter valid # for children under 8", "error");
        }
        if (GUI.over8Box.getText().isEmpty() || (!(GUI.over8Box.getText().matches("[0-9]+")))) {
            GUI.errorBox("Error, enter valid # for children over 8", "error");
        }

        String postCode = GUI.postCodeBox.getText().replaceAll("[^a-zA-Z0-9]", "");
        if(GUI.mobReqBox.isSelected()) {
            postCode = postCode.toUpperCase();
            if (!(postCode.matches("^[A-Z][0-9][A-Z][0-9][A-Z][0-9]$"))){
                GUI.postCodeError("Invalid Postal Code", "Error");
                decrement();
                return;
            }
        }
        // String postCode = GUI.postCodeBox.getText().replaceAll("[^a-zA-Z0-9]", "");
        // postCode = postCode.toUpperCase();
        // if (!(postCode.matches("^[A-Z][0-9][A-Z][0-9][A-Z][0-9]$"))){
        //     GUI.postCodeError("Invalid Postal Code", "Error");
        //     decrement();
        //     return;
        // }
        //clientlist inserted with arguments from gui
        ClientList cList = new ClientList(Integer.parseInt(GUI.adultMaleBox.getText().trim()),
                Integer.parseInt(GUI.adultFemaleBox.getText().trim()), Integer.parseInt(GUI.under8Box.getText().trim()),
                Integer.parseInt(GUI.over8Box.getText().trim()), GUI.mobReqBox.isSelected());
        //creation of available food from the database 
        FoodMap fList = new FoodMap();
        //calling on hamper to create required hamper based off of inputs from GUI
        Hamper hamper = new Hamper(cList, fList);
        //write hamper to file
        try {
            FileWriter fileWriter = new FileWriter("Finalized Hamper Order.txt", true);
            //GUI Checkbox for postalcode existence
            if (GUI.mobReqBox.isSelected() == true) {
                    fileWriter.append(
                            "Mobility Accomodations Requested, Hamper will be delivered to the address associated with the Postal Code\n");
                    fileWriter.append("Your Postal Code: " + postCode + "\n"); //If postcode,then allow delivery

            }
            //more output text formatting
            fileWriter.append("Original Request" + "\n");
            fileWriter.append("Hamper " + counter + ": " + cList.getClientString() + "\n\n");
            fileWriter.append("Hamper " + counter + " Items:\n");
            fileWriter.append(hamper.createOrderFormat() + "\n\n"); //create order format for hamper items exclusively
            /////////////////////////////////////////////////////
            {
                System.out.println(hamper.getTotalCalories());
                System.out.println(hamper.getGrain()+hamper.getFv()+hamper.getProtein()+hamper.getOther());
            }
            fList.removeFromDatabase(hamper.getItemList()); //database update
            Order.increment();
            GUI.successBox("Hamper added Successfully", "Addition Successful"); //success prompt
            fileWriter.flush();
            fileWriter.close(); //close writer
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * 
     * @throws InsufficientFoodException orderCreation() same
     * @throws InsufficientStockException orderCreation() same
     */

     // Lack of comments, refer to orderCreation() for details on some parts
    public void addFirstOrder() throws InsufficientFoodException, InsufficientStockException {

        if (GUI.adultMaleBox.getText().isEmpty() || (!(GUI.adultMaleBox.getText().matches("[0-9]+")))) {
            GUI.errorBox("Error, enter valid # for adult males", "error");
        }
        if (GUI.adultFemaleBox.getText().isEmpty() || (!(GUI.adultFemaleBox.getText().matches("[0-9]+")))) {
            GUI.errorBox("Error, enter valid # for adult females", "error");
        }
        if (GUI.under8Box.getText().isEmpty() || (!(GUI.under8Box.getText().matches("[0-9]+")))) {
            GUI.errorBox("Error, enter valid # for children under 8", "error");
        }
        if (GUI.over8Box.getText().isEmpty() || (!(GUI.over8Box.getText().matches("[0-9]+")))) {
            GUI.errorBox("Error, enter valid # for children over 8", "error");
        }
        String postCode = GUI.postCodeBox.getText().replaceAll("[^a-zA-Z0-9]", "");
        if(GUI.mobReqBox.isSelected()) {
            postCode = postCode.toUpperCase();
            if (!(postCode.matches("^[A-Z][0-9][A-Z][0-9][A-Z][0-9]$"))){
                GUI.postCodeError("Invalid Postal Code", "Error");
                decrement();
                return;
            }
        }

        ClientList cList = new ClientList(Integer.parseInt(GUI.adultMaleBox.getText().trim()),
                Integer.parseInt(GUI.adultFemaleBox.getText().trim()), Integer.parseInt(GUI.under8Box.getText().trim()),
                Integer.parseInt(GUI.over8Box.getText().trim()), GUI.mobReqBox.isSelected());
        FoodMap fList = new FoodMap();
        int hamperNumber = 1; //constant order number always for order #1
        Hamper hamper = new Hamper(cList, fList);

        String nameInput = "Name:" + GUI.name.getText(); // Name input from GUI ONLY ON FIRST ORDER
        try {
            FileWriter headerWriter = new FileWriter("Finalized Hamper Order.txt", true);
            headerWriter.append(nameInput + "\n");
            DateTimeFormatter today = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //time of day, only for first order
            LocalDateTime now = LocalDateTime.now();
            headerWriter.append("Date: " + today.format(now) + "\n" + "\n");
            if (GUI.mobReqBox.isSelected() == true) {
                    headerWriter.append(
                            "Mobility Accomodations Requested, Hamper will be delivered to the address associated with the Postal Code\n");
                    headerWriter.append("Your Postal Code: " + postCode + "\n");
            }
            headerWriter.append("Original Request" + "\n");
            headerWriter.append("Hamper " + hamperNumber + ": " + cList.getClientString() + "\n\n");
            headerWriter.append("Hamper " + hamperNumber + " Items:\n");
            headerWriter.append(hamper.createOrderFormat() + "\n\n");
            fList.removeFromDatabase(hamper.getItemList());
            {
                System.out.println(hamper.getTotalCalories());
                System.out.println(hamper.getGrain()+hamper.getFv()+hamper.getProtein()+hamper.getOther());
            }
            GUI.successBox("Hamper added Successfully", "Addition Successful");
            headerWriter.flush();
            headerWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void increment() {
        counter++; //accessible increment for counter
    }

    public static int getCounter() {
        return counter; //getter
    }

    public static void decrement() {
        counter--; //accessible decrement for counter
    }
}
