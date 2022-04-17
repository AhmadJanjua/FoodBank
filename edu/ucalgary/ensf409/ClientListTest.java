package edu.ucalgary.ensf409;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * ENSF 409 Final Project Group 7
 * @author Ahmad Janjua, Pedro Ghodsi, Zohaib Ashfaq, Farica Mago
 * @version 1.0
 * @since 1.0
 */
public class ClientListTest {
    
    public static void main(String[] args) {
            ClientList clientOne = testClientList();
        }

    @Test
    public static ClientList testClientList() {
        ClientList clientOne = new ClientList(1, 1, 1, 1, false);
        return clientOne;

    }

    // Test of getTotalGrainCalories method of class ClientList
    @Test
    public void testgetTotalGrainCalories(ClientList clientOne) {

        System.out.println("GrainCalories");

        int expResult = 200;

        int result = calories.getTotalGrainCalories();
        assertEquals("Error in testgetTotalGrainCalories: ", expResult, result);

    }

    // Test of setTotalGrainCalories method of class ClientList
    @Test
    public void testsetTotalGrainCalories(ClientList clientOne) {

        clientList calories = new clientList(200);

        int currentCalories = calories.getTotalGrainCalories();
        calories.setTotalGrainCalories(250);

        int expResult = 250;

        System.out.println("GrainCalories");

        int result = calories.getTotalGrainCalories();
        assertEquals("Error in testsetTotalGrainCalories: ", expResult, result);

    }


    // Test of getTotalProteinCalories method of class ClientList
    @Test
    public void testgetTotalProteinCalories(ClientList clientOne) {
        System.out.println("ProteinCalories");

        clientList calories = new clientList(250);

        int expResult = 250;

        int result = calories.getTotalProteinCalories();
        assertEquals("Error in testgetTotalProteinCalories: ", expResult, result);

    }

    // Test of setTotalProteinCalories method of class ClientList
    @Test
    public void testsetTotalProteinCalories(ClientList clientOne) {

        clientList calories = new clientList(250);

        int currentCalories = calories.getTotalProteinCalories();
        calories.setTotalProteinCalories(300);

        int expResult = 250;

        System.out.println("ProteinCalories");

        int result = calories.getTotalProteinCalories();
        assertEquals("Error in testsetTotalProteinCalories: ", expResult, result);

    }

    // Test of getTotalOtherCalories method of class ClientList
    @Test
    public void testgetTotalOtherCalories(ClientList clientOne) {

        System.out.println("OtherCalories");

        clientList calories = new clientList(400);

        int expResult = 400;

        int result = calories.getTotalOtherCalories();
        assertEquals("Error in testgetTotalOtherCalories: ", expResult, result);

    }

    // Test of setTotalOtherCalories method of class ClientList
    @Test
    public void testsetTotalOtherCalories(ClientList clientOne) {

        clientList calories = new clientList(400);

        int currentCalories = calories.getTotalOtherCalories();
        calories.setTotalOtherCalories(450);

        int expResult = 250;

        System.out.println("OtherCalories");

        int result = calories.getTotalOtherCalories();
        assertEquals("Error in testsetTotalOtherCalories: ", expResult, result);

    }

    // Test of getMobilityStruggled method of class ClientList
    @Test
    public void testgetMobilityStruggled(ClientList clientOne) {

        System.out.println("MobilityStruggled");

        clientList mobility = new clientList();

        assertTrue(mobility.MobilityStruggled("True"));
        assertFalse(mobility.MobilityStruggled("False"));

    }

    // Test of setMobilityStruggled method of class ClientList
    @Test
    public void testsetMobilityStruggled(ClientList clientOne) {

        System.out.println("MobilityStruggled");

        clientList mobility = new clientList();

        assertTrue(mobility.MobilityStruggled("True"));
        assertFalse(mobility.MobilityStruggled("False"));

    }

    // Test of getAddress method of class ClientList
    @Test
    public void testgetAddress(ClientList clientOne) {

        clientList address = new clientList("123 smth drive", "456 other lane");

        System.out.println("Address");

        String expResult = "123 smth drive";

        String result = address.getAddress();

        assertEquals("Error in testgetAddress: ", expResult, result);

    }

    // Test of setAddress method of class ClientList
    @Test
    public void testsetAddress(ClientList clientOne) {

        clientList address = new clientList("123 smth drive", "456 other lane");

        System.out.println("Address");

        String expResult = "123 smth drive";

        String result = address.getAddress();

        assertEquals("Error in testsetAddress: ", expResult, result);

    }

    /**
     * Test to see if the addClient method successfully adds a Client object
     */
    @Test
    public void testaddClient(ClientList clientOne) {
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
    public void testRemoveClient_ClientList(ClientList clientOne) {
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

    // Test of getClientString method of class ClientList
    @Test
    public void testgetClientString(ClientList clientOne) {

        assertEquals("The getClientString method does not produce the expected results.", getClientString, one.getClientString());


    }
    
}
