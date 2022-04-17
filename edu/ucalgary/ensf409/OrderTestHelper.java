package edu.ucalgary.ensf409;

/**
@author Pedro Ghodsi
@version 1.2
@since 1.0
*/
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.FileWriter;
import java.io.IOException;


/**
 * THIS FILE IS USED ONLY FOR MOCKITO PURPOSES TO MAKE TESTING MORE STREAMLINED, OTHERWISE IT IS ALMOST IDENTICAL TO Order.java
 */
public class OrderTestHelper {

    private static int counter = 2; // Counter used to track hamper number past hamper number 1
    private FileWriter fileWriter;
    private ClientList cList;
    private FoodList fList;
    private Hamper hamper;

    public OrderTestHelper(FileWriter fileWriter, ClientList cList, FoodList fList, Hamper hamper) {
       this.fileWriter = fileWriter; 
       this.cList = cList;
       this.fList = fList;
       this.hamper = hamper;
    }

    /**
     * 
     * @throws InsufficientFoodException when upon attempting to create a hamper, there is an insufficient amount of food stored in the database to create the hamper
     * @throws InsufficientStockException when attempting to remove items from a hamper, there is an error; cannot be caused without user error while setting up the database/not refreshing it
     */
    public void orderCreation() throws InsufficientFoodException, InsufficientStockException {
        //checkers to see if GUI inputs are valid
        if (GUIOrderTestHelper.adultMaleBox.getText().isEmpty() || (!(GUIOrderTestHelper.adultMaleBox.getText().matches("[0-9]+")))) {
            GUIOrderTestHelper.errorBox("Error, enter valid # for adult males", "error");
        }
        if (GUIOrderTestHelper.adultFemaleBox.getText().isEmpty() || (!(GUIOrderTestHelper.adultFemaleBox.getText().matches("[0-9]+")))) {
            GUIOrderTestHelper.errorBox("Error, enter valid # for adult females", "error");
        }
        if (GUIOrderTestHelper.under8Box.getText().isEmpty() || (!(GUIOrderTestHelper.under8Box.getText().matches("[0-9]+")))) {
            GUIOrderTestHelper.errorBox("Error, enter valid # for children under 8", "error");
        }
        if (GUIOrderTestHelper.over8Box.getText().isEmpty() || (!(GUIOrderTestHelper.over8Box.getText().matches("[0-9]+")))) {
            GUIOrderTestHelper.errorBox("Error, enter valid # for children over 8", "error");
        }
        String postCode = GUIOrderTestHelper.postCodeBox.getText().replaceAll("[^a-zA-Z0-9]", "");
        postCode = postCode.toUpperCase();
        if (!(postCode.matches("^[A-Z][0-9][A-Z][0-9][A-Z][0-9]$"))){
            GUIOrderTestHelper.postCodeError("Invalid Postal Code", "Error");
            decrement();
            return;
        }
        fList.fillFromDatabase();
        try {
            //GUIOrderTestHelper Checkbox for postalcode existence
            if (GUIOrderTestHelper.mobReqBox.isSelected() == true) {
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
            fList.removeFromDatabase(hamper.getItemList()); //database update
            OrderTestHelper.increment();
            GUIOrderTestHelper.successBox("Hamper added Successfully", "Addition Successful"); //success prompt
            fileWriter.flush();
            fileWriter.close(); //close writer
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


    /**
     * 
     * @throws InsufficientFoodException orderCreation() same
     * @throws InsufficientStockException orderCreation() same
     */

     // Lack of comments, refer to orderCreation() for details on some parts
    public void addFirstOrder() throws InsufficientFoodException, InsufficientStockException {

        if (GUIOrderTestHelper.adultMaleBox.getText().isEmpty() || (!(GUIOrderTestHelper.adultMaleBox.getText().matches("[0-9]+")))) {
            GUIOrderTestHelper.errorBox("Error, enter valid # for adult males", "error");
        }
        if (GUIOrderTestHelper.adultFemaleBox.getText().isEmpty() || (!(GUIOrderTestHelper.adultFemaleBox.getText().matches("[0-9]+")))) {
            GUIOrderTestHelper.errorBox("Error, enter valid # for adult females", "error");
        }
        if (GUIOrderTestHelper.under8Box.getText().isEmpty() || (!(GUIOrderTestHelper.under8Box.getText().matches("[0-9]+")))) {
            GUIOrderTestHelper.errorBox("Error, enter valid # for children under 8", "error");
        }
        if (GUIOrderTestHelper.over8Box.getText().isEmpty() || (!(GUIOrderTestHelper.over8Box.getText().matches("[0-9]+")))) {
            GUIOrderTestHelper.errorBox("Error, enter valid # for children over 8", "error");
        }
        String postCode = GUIOrderTestHelper.postCodeBox.getText().replaceAll("[^a-zA-Z0-9]", "");
        postCode = postCode.toUpperCase();
        if (!(postCode.matches("^[A-Z][0-9][A-Z][0-9][A-Z][0-9]$"))){
            GUIOrderTestHelper.postCodeError("Invalid Postal Code", "Error");
            decrement();
            return;
        }

        int hamperNumber = 1; //constant order number always for order #1
        fList.fillFromDatabase();

        String nameInput = "Name:" + GUIOrderTestHelper.name.getText(); // Name input from GUIOrderTestHelper ONLY ON FIRST ORDER
        try {
            fileWriter.append(nameInput + "\n");
            DateTimeFormatter today = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); //time of day, only for first order
            LocalDateTime now = LocalDateTime.now();
            fileWriter.append("Date: " + today.format(now) + "\n" + "\n");
            if (GUIOrderTestHelper.mobReqBox.isSelected() == true) {
                    fileWriter.append(
                            "Mobility Accomodations Requested, Hamper will be delivered to the address associated with the Postal Code\n");
                    fileWriter.append("Your Postal Code: " + postCode + "\n");

            }
            fileWriter.append("Original Request" + "\n");
            fileWriter.append("Hamper " + hamperNumber + ": " + cList.getClientString() + "\n\n");
            fileWriter.append("Hamper " + hamperNumber + " Items:\n");
            fileWriter.append(hamper.createOrderFormat() + "\n\n");
            fList.removeFromDatabase(hamper.getItemList());
            GUIOrderTestHelper.successBox("Hamper added Successfully", "Addition Successful");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

