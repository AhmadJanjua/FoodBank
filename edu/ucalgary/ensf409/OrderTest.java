package edu.ucalgary.ensf409;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.io.FileWriter;

import org.junit.Before;
import org.junit.Test;

/**
 * ENSF 409 Final Project Group 7 - OrderTest.java
 * @author Pedro Ghodsi
 * @version 1.2
 * @since 1.0
 */
public class OrderTest {

    private Order mockOrder;
    private FileWriter mockFileWriter;
    private ClientList mockClientList;
    private FoodList mockFoodList;
    private Hamper mockHamper;

    @Before
    public void initialize() {
        mockFileWriter = mock(FileWriter.class);
        mockClientList = mock(ClientList.class);
        mockFoodList = mock(FoodList.class);
        mockHamper = mock(Hamper.class);
        mockOrder = new Order(mockFileWriter, mockClientList, mockFoodList, mockHamper);
    }

    @Test
    public void testAddFirstOrder() {
        GUI gui = new GUI();
        GUI.adultMaleBox.setText("1");
        GUI.adultFemaleBox.setText("1");
        GUI.over8Box.setText("1");
        GUI.under8Box.setText("1");
        GUI.postCodeBox.setText("T3R 1S4");
        try {
            mockOrder.addFirstOrder();
            verify(mockFileWriter, atLeastOnce()).append(any());
            verify(mockFoodList, atLeastOnce()).removeFromDatabase(any());
            verify(mockFileWriter, atLeastOnce()).flush();
            verify(mockFileWriter, atLeastOnce()).close();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testDecrement() {
        int expectedNumber = Order.getCounter() - 1;
        Order.decrement();
        assertEquals(expectedNumber, Order.getCounter());
    }

    @Test
    public void testGetCounter() {
        int expectedNumber = 3;
        assertEquals(expectedNumber, Order.getCounter());
    }

    @Test
    public void testIncrement() {
        int expectedNumber = Order.getCounter() + 1;
        Order.increment();
        assertEquals(expectedNumber, Order.getCounter());
       
    }

    @Test
    public void testOrderCreation() {
        GUI gui = new GUI();
        GUI.adultMaleBox.setText("1");
        GUI.adultFemaleBox.setText("1");
        GUI.over8Box.setText("1");
        GUI.under8Box.setText("1");
        GUI.postCodeBox.setText("T3R 1S4");
        try {
            mockOrder.orderCreation();
            verify(mockFileWriter, atLeastOnce()).append(any());
            verify(mockFoodList, atLeastOnce()).removeFromDatabase(any());
            verify(mockFileWriter, atLeastOnce()).flush();
            verify(mockFileWriter, atLeastOnce()).close();
        } catch (Exception e) {
            fail(e.getMessage());
        }
       
    }
    
}
