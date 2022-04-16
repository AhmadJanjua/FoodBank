package edu.ucalgary.ensf409;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 * ENSF 409 Final Project Group 7
 * @author Ahmad Janjua, Pedro Ghodsi, Zohaib Ashfaq, Farica Mago
 * @version 1.0
 * @since 1.0
 */
public class ClientTest {

    @Test
    public void testGetCalories() {
        // making an object of class Client with correct arguments
        var client = new Client("Adult Male",16,28,26,30,2500);
        assertEquals("the getter method for Calories failed!",2500,client.getCalories());
    }

    @Test
    public void testGetClientType() {

        // making an object of class Client with correct arguments
        var client = new Client("Adult Male",16,28,26,30,2500);
        assertEquals("the getter method for ClientType failed!","Adult Male",client.getClientType());
        
    }

    @Test
    public void testGetFVPercent() {
        // making an object of class Client with correct arguments
      	var client = new Client("Adult Male",16,28,26,30,2500);
  	    assertEquals("the getter method for FruitsVeggies(%) failed!",28,client.getFVPercent());
    }

    @Test
    public void testGetGrainPercent() {
        // making an object of class Client with correct arguments
      	var client = new Client("Adult Male",16,28,26,30,2500);
      	assertEquals("The getter method for WholeGrains(%) failed!",16,client.getGrainPercent());
        
    }

    @Test
    public void testGetOtherPercent() {
        // making an object of class Client with correct arguments
      	var client = new Client("Adult Male",16,28,26,30,2500);
      	assertEquals("the getter method for Other(%) failed!",30,client.getOtherPercent());
    }

    @Test
    public void testGetProteinPercent() {
        // making an object of class Client with correct arguments
      	var client = new Client("Adult Male",16,28,26,30,2500);
  	    assertEquals("The getter method for Protein(%) failed!",26,client.getProteinPercent());	 
    }

    @Test
    public void testGetclientID() {
        // making an object of class Client with correct arguments
        var client = new Client("Adult Male",16,28,26,30,2500);
        assertEquals("the getter method for ClientID failed!",1,client.getclientID());
    }

    @Test
    public void testSetCalories() {
        // making an object of class Client with correct arguments
      	var client = new Client("Adult Male",16,28,26,30,2500);
      	client.setCalories(1500);
      	assertEquals("the setter method for Calories failed!",1500,client.getCalories());
    }

    @Test
    public void testSetFVPercent() {
        // making an object of class Client with correct arguments
  	    var client = new Client("Adult Male",16,28,26,30,2500);
  	    client.setFVPercent(15);
  	    assertEquals("the setter method for FruitsVeggies(%) failed!",15,client.getFVPercent());
        
    }

    @Test
    public void testSetGrainPercent() {
        // making an object of class Client with correct arguments
      	var client = new Client("Adult Male",16,28,26,30,2500);
  	    client.setGrainPercent(15);
  	    assertEquals("the setter method for WholeGrains(%) failed!",15,client.getGrainPercent());
    }

    @Test
    public void testSetOtherPercent() {
        // making an object of class Client with correct arguments
     	var client = new Client("Adult Male",16,28,26,30,2500);
      	client.setOtherPercent(15);
      	assertEquals("the setter method for Other(%) failed!",15,client.getOtherPercent());
    }

    @Test
    public void testSetProteinPercent() {
        // making an object of class Client with correct arguments
      	var client = new Client("Adult Male",16,28,26,30,2500);
    	client.setProteinPercent(15);
      	assertEquals("The setter method for Protein(%) failed!",15,client.getProteinPercent());	 
        
    }
    
}
