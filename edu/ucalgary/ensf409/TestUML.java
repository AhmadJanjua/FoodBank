package edu.ucalgary.ensf409;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * ENSF 409 Final Project Group 7
 * @author Ahmad Janjua, Pedro Ghodsi, Zohaib Ashfaq
 * @version 1.5
 * @since 1.0
 */

/**
 * The class uses junit tests to test the functionality of classes which are a part of the
 * UML diagram.
 */
public class TestUML {

    /**
     * Calling the constructor with an empty ArrayList of food
     * should cause the program to throw an illegal arguement exception
     */
    @Test
    public void testEmptyListConstructor_FoodList() {
        boolean exceptionThrown = false;
        //Creating an empty arraylist to pass in as arguement.
        ArrayList<Food> badList = new ArrayList<>();
        try {
            new FoodList(badList);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("FoodList class constructor didn't throw an IllegalArgumentException when empty list was passed through.", exceptionThrown);
    }

    /**
     * Testing to see if the setter in FoodList throws an exception if an empty ArrayList of food is passed
     */
    @Test
    public void testEmptyListSetter_FoodList() {
        boolean exceptionThrown = false;

        //Instantiate Food object
        Food tomato = new Food(23,"Tomato Sauce, jar", 0, 80, 10, 10, 120, 2);
        //Instantiate FoodList object
        FoodList foodList = new FoodList(tomato);
        //Create empty ArrayList to pass into setter
        ArrayList<Food> badList = new ArrayList<>();
        try {
            foodList.setFoodList(badList);
        } catch (IllegalArgumentException e) {
            exceptionThrown = true;
        }
        assertTrue("FoodList class setter didn't throw an IllegalArgumentException when empty list was passed through.", exceptionThrown);
    }

    /** 
     * Tests the FoodList constructor that takes in Food object arguement
    */
    @Test
    public void testFoodConstructor_FoodList() {
        //Instantiate Food object
        Food tomato = new Food(23,"Tomato Sauce, jar", 0, 80, 10, 10, 120, 2);
        //Create ArrayList of food objects
        ArrayList<Food> expectedList = new ArrayList<>();
        expectedList.add(tomato);
        //Instantiate FoodList object
        FoodList foodListObject = new FoodList(tomato);
        assertEquals("Constructor that takes in Food arguement does not match the expected result.",expectedList, foodListObject.getFoodList());
    }

    /**
     * Tests the FoodList constructor that takes in FoodList object arguement
     */
    @Test
    public void testFoodListConstructor_FoodList() {
        //Instantiate Food object
        Food tomato = new Food(23,"Tomato Sauce, jar", 0, 80, 10, 10, 120, 2);
        //Create an arraylist of Food objects
        ArrayList<Food> expectedList = new ArrayList<>();
        expectedList.add(tomato);
        //Instantiate FoodList object
        FoodList foodListObject = new FoodList(expectedList);
        assertEquals("Constructor that takes in FoodList arguement does not match the expected result.",expectedList, foodListObject.getFoodList());
    }

    /**
     * Tests the setter in FoodList
     */
    @Test
    public void testSetFoodlist_FoodList() {
        //Instantiate Food object
        Food tomato = new Food(23,"Tomato Sauce, jar", 0, 80, 10, 10, 120, 2);
        Food apple = new Food(24,"Apple, dozen", 0, 100, 0, 0, 624, 4);
        //Instantiate FoodList object
        FoodList foodObject = new FoodList(tomato);
        //Create an arraylist of Food
        ArrayList<Food> foodArray = new ArrayList<>();
        foodArray.add(apple);
        foodObject.setFoodList(foodArray);
        assertEquals("The setter does not produce the expected results",foodArray, foodObject.getFoodList());
    }
    /**
     * Test the getter in the FoodList class to see if the return type is correct
     */
    @Test
    public void testGetFoodlist_FoodList() {
        //Instantiate Food objects
        Food tomato = new Food(23,"Tomato Sauce, jar", 0, 80, 10, 10, 120, 2);
        Food apple = new Food(24,"Apple, dozen", 0, 100, 0, 0, 624, 4);
        //Create an ArrayList of Food
        ArrayList<Food> foodArray = new ArrayList<>();
        foodArray.add(tomato);
        foodArray.add(apple);
        //Instantiate FoodList object
        FoodList foodObject = new FoodList(foodArray);
        assertEquals("The getter does not produce the expected results",foodArray, foodObject.getFoodList());
    }

    /**
     * Testing to if addFood method successfully adds another Food object
     */
    @Test
    public void testAddFood_FoodList() {
        //Instantiate Food object
        Food tomato = new Food(23,"Tomato Sauce, jar", 0, 80, 10, 10, 120, 2);
        Food apple = new Food(24,"Apple, dozen", 0, 100, 0, 0, 624, 4);
        Food carrot = new Food(26,"Baby carrots, pound", 0, 100, 0, 0, 159, 9);
        //Create an arraylist of food objects
        ArrayList<Food> foodList = new ArrayList<Food>();
        foodList.add(tomato);
        foodList.add(apple);
        ////Instantiate FoodList object and add another Food object
        FoodList foodListObject = new FoodList(foodList);
        foodListObject.addFood(carrot);
        // Add Food object to the existing arraylist
        foodList.add(carrot);
        assertEquals("The addFood method does not produce the expected results.",foodList, foodListObject.getFoodList());
    }

    /**
     * Test to see if the removeFood method successfully removes a Food object
     */
    @Test
    public void testRemoveFood_FoodList() {
        //Instantiate Food object
        Food tomato = new Food(23,"Tomato Sauce, jar", 0, 80, 10, 10, 120, 2);
        Food apple = new Food(24,"Apple, dozen", 0, 100, 0, 0, 624, 4);
        Food carrot = new Food(26,"Baby carrots, pound", 0, 100, 0, 0, 159, 9);
        //Create an arraylist and add to Food to it
        ArrayList<Food> foodList = new ArrayList<Food>();
        foodList.add(tomato);
        foodList.add(apple);
        foodList.add(carrot);
        //Instantiate FoodList object
        FoodList foodListObject = new FoodList(foodList);
        // Attempt to remove from foodlist
        foodListObject.removeFood(carrot.getITEM_ID());
        // Remove from foodlist
        foodList.remove(carrot);
        assertEquals("The removeFood method does not produce the expected results.",foodList, foodListObject.getFoodList());
    }

    /**
     * Test to see if the Hamper stores the correct items in the its ArrayList of Strings
     */
    @Test
    public void testGetInHamper_Hamper() {
        //Instantiate Client object
        Client first  = new Client("Adult Male",0,0,0,100,40);
        Client second = new Client("Adult Female",100,0,0,0,30);
        //Instantiate Food object
        Food grain= new Food(1,"Grain", 100, 0, 0, 0, 10, 100);
        Food fruit = new Food(2,"FandV", 0, 100, 0, 0, 10, 100);
        Food protein = new Food(3,"Protein", 0, 0, 100, 0, 10, 100);
        Food other = new Food(4,"Other", 0, 0, 0, 100, 10, 100);
        //Create and add to arraylist of food
        ArrayList<Food> allFoods = new ArrayList<>();
        allFoods.add(grain);
        allFoods.add(fruit);
        allFoods.add(protein);
        allFoods.add(other);
        //Instantiate FoodList object
        FoodList foodList = new FoodList(allFoods);
        //Create an arraylist of all clients and add clients to it
        ArrayList<Client> allclients = new ArrayList<>();
        allclients.add(first);
        allclients.add(second);
        //Instantiate ClientList object
        ClientList clientList = new ClientList(allclients);
        //Instantiate Hamper object
        Hamper hamper = new Hamper(clientList, foodList);
        //Create the expected ArrayList<String>
        ArrayList<String> output = new ArrayList<String>();
        output.add("3       Grain");
        output.add("4       Other");
        assertEquals("The resulting String arraylist is different than expected", output, hamper.getInHamper());
    }
    /**
     * Test to see if the getter returns the correct clientlist
     */
    @Test
    public void testGetNutrientNeeds_Hamper() {
        //Instantiate Client object
        Client first  = new Client("Adult Male",0,0,0,100,30);
        Client second = new Client("Adult Female",100,0,0,0,30);
        //Instantiate Food object
        Food grain= new Food(1,"Grain", 100, 0, 0, 0, 10, 100);
        Food fruit = new Food(2,"FandV", 0, 100, 0, 0, 10, 100);
        Food protein = new Food(3,"Protein", 0, 0, 100, 0, 10, 100);
        Food other = new Food(4,"Other", 0, 0, 0, 100, 10, 100);
        //Create arraylist of food and add to it
        ArrayList<Food> allFoods = new ArrayList<>();
        allFoods.add(grain);
        allFoods.add(fruit);
        allFoods.add(protein);
        allFoods.add(other);
        //Instantiate FoodList object
        FoodList foodList = new FoodList(allFoods);
        //Create an arraylist of clients and add to it
        ArrayList<Client> allclients = new ArrayList<>();
        allclients.add(first);
        allclients.add(second);
        //Instantiate ClientList object
        ClientList clientList = new ClientList(allclients);
        //Instantiate Hamper object
        Hamper hamper = new Hamper(clientList, foodList);
        assertEquals("The getter for the nutrients does not produce expected resut.", clientList, hamper.getNutrientNeeds());
    }

    /**
     * Test to see if the object encapsulating the nutrient needs can be changed properly
     */
    @Test
    public void testSetNutrientNeeds_Hamper() {
        //Instantiate Client objects
        Client first  = new Client("Adult Male",0,0,0,100,30);
        Client second = new Client("Adult Female",100,0,0,0,30);
        //Instantiate Food object
        Food grain= new Food(1,"Grain", 100, 0, 0, 0, 10, 100);
        //Create an arraylist of food and add to it
        ArrayList<Food> allFoods = new ArrayList<>();
        allFoods.add(grain);
        //Instantiate FoodList object
        FoodList foodList = new FoodList(allFoods);
        //Create two seperate arraylist of clients
        ArrayList<Client> clients1 = new ArrayList<>();
        clients1.add(first);
        ArrayList<Client> clients2 = new ArrayList<>();
        clients2.add(second);
        //Instantiate ClientList objects
        ClientList clientList1 = new ClientList(clients1);
        ClientList clientList2 = new ClientList(clients2);
        //Instantiate Hamper object and use setter to change the clients
        Hamper hamper = new Hamper(clientList1, foodList);
        hamper.setNutrientNeeds(clientList2);
        //Create expected result
        ArrayList<String> expected = new ArrayList<>();
        assertEquals("Setter for nutrientNeeds didnt produce expected result.",clients2, hamper.getNutrientNeeds());
        assertEquals("Setter for nutrientNeeds didnt clear hamper after client change.",expected, hamper.getInHamper());
    }
    /**
     * Test to see that the output format of the function is correct
     */
    @Test
    public void testCreateOrderForm_Hamper() {
        //Instantiate client objects
        Client first  = new Client("Adult Male",0,50,50,0,60);
        Client second = new Client("Adult Female",50,0,0,50,40);
        //Instantiate Food object
        Food grain= new Food(1,"Grain", 100, 0, 0, 0, 10, 100);
        Food fruit = new Food(2,"FandV", 0, 100, 0, 0, 10, 100);
        Food protein = new Food(3,"Protein", 0, 0, 100, 0, 10, 100);
        Food other = new Food(4,"Other", 0, 0, 0, 100, 10, 100);
        //Create an arraylist of food and add to it
        ArrayList<Food> allFoods = new ArrayList<>();
        allFoods.add(grain);
        allFoods.add(fruit);
        allFoods.add(protein);
        allFoods.add(other);
        //Instantiate FoodList object
        FoodList foodList = new FoodList(allFoods);
        //Create an arraylist of clients and add clients
        ArrayList<Client> allclients = new ArrayList<>();
        allclients.add(first);
        allclients.add(second);
        //Instantiate Clientlist object
        ClientList clientList = new ClientList(allclients);
        //Instantiate Hamper object
        Hamper hamper = new Hamper(clientList, foodList);
        // Create the expected output
        String expected ="";
        expected += "2       Grain\n";
        expected += "3       FandV\n";
        expected += "3       Protein\n";
        expected += "2       Other\n";
        assertEquals("The outputted format didnt match the expected value",expected, hamper.createOrderFormat());
    }
    
    // Test Delivery, Order, Order Format
    String OUTPUT_FILENAME = "orderout.txt";

    Delivery testDelivery;
    Hamper testHamper;
    Order testOrder;
    OrderFormat testOrderFormat;
    
    
    // setup methods beofe testing
    @Before
    public void setup() {
        testHamper = new Hamper();
        testOrder = new Order();
        testOrderFormat = new OrderFormat();

        // Delete the orderout file
        File orderoutFile = new File(OUTPUT_FILENAME);
        orderoutFile.delete();
    }
    
    @Test //Test to see if the expected deliveryID matches the true delivery ID, as well as type
    public void testGetDeliveryId() {
        int expectedDeliveryId = 1;
        testDelivery = new Delivery(expectedDeliveryId, 0);
        assertEquals(expectedDeliveryId, testDelivery.getDeliveryId());
    }

    @Test //Test to see if the DeliveryTime expected matches needed DeliveryTime
    public void testGetDeliveryTime() {
        int expectedDeliveryTime = 1;
        testDelivery = new Delivery(0, expectedDeliveryTime);
        assertEquals(expectedDeliveryTime, testDelivery.getDeliveryTime());
    }

    @Test //Tests the setter for the DeliveryID
    public void testSetDeliveryId() {
        int expectedDeliveryId = 1;
        testDelivery = new Delivery(0, 0);
        testDelivery.setDeliveryId(expectedDeliveryId);
        assertEquals(expectedDeliveryId, testDelivery.getDeliveryId());
    }

    @Test //Tests the setter for the deliverytime
    public void testSetDeliveryTime() {
        int expectedDeliveryTime = 1;
        testDelivery = new Delivery(0, 0);
        testDelivery.setDeliveryTime(expectedDeliveryTime);
        assertEquals(expectedDeliveryTime, testDelivery.getDeliveryTime());
    }

    @Test //Tests to see if orderform is properly created, formatted
    public void testCreateOrderForm() {
        testOrderFormat.createOrderForm();
        File file = new File(OUTPUT_FILENAME);

        assertTrue(file.exists());
    }

    @Test //Will test to see if stock is properly updated through the method; test unable to be finished, greater progress required in main code
    public void testUpdateStock() {
        testOrderFormat.updateStock();

        // Unable to assert test yet, further information about SQL needed
    }

    @Test //Boolean test to see if the hamper can actually be fulfilled
    public void testCanComplete() {
        Hamper newHamper = new Hamper(new ArrayList<Integer>() {{ add(1); }});
        testOrder.addHamper(newHamper);
        assertTrue(testOrder.canComplete());
    }

    @Test //Test for seeing whether or not the Hamper can be added properly or not
    public void testAddHamper() {
        int expectedHamperSize = 1;
        Hamper newHamper = new Hamper(new ArrayList<Integer>() {{ add(1); }});
        testOrder.addHamper(newHamper);
        assertEquals(expectedHamperSize, testOrder.getHampers().size());
    }

    @Test //Similar to previous, hard to test without implementation first, here for a reminder
    public void testResetOrder() {
        // Unable to assert test yet
    }

    @Test //Getter Tester for Hamper
    public void testGetHampers() {
        Hamper newHamper = new Hamper(new ArrayList<Integer>() {{ add(1); }});
        testOrder.addHamper(newHamper);
        assertEquals(new ArrayList<Hamper>() {{ add(newHamper); }}, testOrder.getHampers());
    }
}


    @Test
    public void testClientList() {
        (["sam","bob","other client"], true)
    }

    // Test of getTotalGrainCalories method of class ClientList
    @Test
    public void testgetTotalGrainCalories() {

        System.out.println("GrainCalories");

        clientList calories = new clientList(200);

        int expResult = 200;

        int result = calories.getTotalGrainCalories();
        assertEquals("Total Calories from grains: ", expResult, result);

    }

    // Test of setTotalGrainCalories method of class ClientList
    @Test
    public void testsetTotalGrainCalories() {

        clientList calories = new clientList(200);

        int currentCalories = calories.getTotalGrainCalories();
        calories.setTotalGrainCalories(250);

        int expResult = 250;

        System.out.println("GrainCalories");

        int result = calories.getTotalGrainCalories();
        assertEquals("Total Calories from grains: ", expResult, result);

    }


    // Test of getTotalProteinCalories method of class ClientList
    @Test
    public void testgetTotalProteinCalories() {

        System.out.println("ProteinCalories");

        clientList calories = new clientList(250);

        int expResult = 250;

        int result = calories.getTotalProteinCalories();
        assertEquals("Total Calories from protein: ", expResult, result);

    }

    // Test of setTotalProteinCalories method of class ClientList
    @Test
    public void testsetTotalProteinCalories() {

        clientList calories = new clientList(250);

        int currentCalories = calories.getTotalProteinCalories();
        calories.setTotalProteinCalories(300);

        int expResult = 250;

        System.out.println("ProteinCalories");

        int result = calories.getTotalProteinCalories();
        assertEquals("Total Calories from protein: ", expResult, result);

    }

    // Test of getTotalOtherCalories method of class ClientList
    @Test
    public void testgetTotalOtherCalories() {

        System.out.println("OtherCalories");

        clientList calories = new clientList(400);

        int expResult = 400;

        int result = calories.getTotalOtherCalories();
        assertEquals("Total Calories from other: ", expResult, result);

    }

    // Test of setTotalOtherCalories method of class ClientList
    @Test
    public void testsetTotalOtherCalories() {

        clientList calories = new clientList(400);

        int currentCalories = calories.getTotalOtherCalories();
        calories.setTotalOtherCalories(450);

        int expResult = 250;

        System.out.println("OtherCalories");

        int result = calories.getTotalOtherCalories();
        assertEquals("Total Calories from other: ", expResult, result);

    }

    // Test of getMobilityStruggled method of class ClientList
    @Test
    public void testgetMobilityStruggled() {

        System.out.println("MobilityStruggled");

        clientList mobility = new clientList();

        assertTrue(mobility.MobilityStruggled("True"));
        assertFalse(mobility.MobilityStruggled("False"));

    }

    // Test of setMobilityStruggled method of class ClientList
    @Test
    public void testsetMobilityStruggled() {

        System.out.println("MobilityStruggled");

        clientList mobility = new clientList();

        assertTrue(mobility.MobilityStruggled("True"));
        assertFalse(mobility.MobilityStruggled("False"));

    }

    // Test of getAddress method of class ClientList
    @Test
    public void testgetAddress() {

        clientList address = new clientList("123 smth drive", "456 other lane");

        System.out.println("Address");

        String expResult = "123 smth drive";

        String result = address.getAddress();

        assertEquals("The address is: ", expResult, result);

    }

    // Test of setAddress method of class ClientList
    @Test
    public void testsetAddress() {

        clientList address = new clientList("123 smth drive", "456 other lane");

        System.out.println("Address");

        String expResult = "123 smth drive";

        String result = address.getAddress();

        assertEquals("The address is: ", expResult, result);

    }

    /**
     * Test to see if the addClient method successfully adds a Client object
     */
    @Test
    public void testaddClient() {
        Client one = new Client(23, 0, 80, 10, 10, 120, 2);
        Client two  = new Client(24,0, 100, 0, 0, 624, 4);
        Client three = new Client(26, 0, 100, 0, 0, 159, 9);

        ArrayList<Client> ClientList = new ArrayList<Client>();
        ClientList.add(22);
        ClientList.add(28);

        ClientList ClientListObject = new ClientList(clientList);
        ClientListObject.addClient(60);

        clientList.add(55);

        assertEquals("The addClient method does not produce the expected results.",clientList, clientListObject.getClientList());
    }

    /**
     * Test to see if the removeClient method successfully removes a Client object
     */
    @Test
    public void testRemoveClient_ClientList() {
        Client one = new Client(23, 0, 80, 10, 10, 120, 2);
        Client two  = new Client(24,0, 100, 0, 0, 624, 4);
        Client three = new Client(26, 0, 100, 0, 0, 159, 9);

        ArrayList<Client> clientList = new ArrayList<Client>();
        clientList.add(22);
        clientList.add(28);
        clientList.add(30);

        ClientList clientListObject = new ClientList(clientList);

        clientListObject.removeClient(30.getITEM_ID());
        clientList.remove(30);
        assertEquals("The removeClient method does not produce the expected results.",clientList, clientListObject.getClientList());
    }
