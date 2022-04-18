// package edu.ucalgary.ensf409;

// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.fail;
// import static org.mockito.ArgumentMatchers.any;
// import static org.mockito.Mockito.atLeastOnce;
// import static org.mockito.Mockito.mock;
// import static org.mockito.Mockito.verify;

// import java.io.FileWriter;

// import org.junit.Before;
// import org.junit.Test;

// /**
//  * ENSF 409 Final Project Group 7 - OrderTest.java
//  * @author Pedro Ghodsi
//  * @version 1.2
//  * @since 1.0
//  */
// public class OrderTest {

//     private OrderTestHelper mockOrder;
//     private FileWriter mockFileWriter;
//     private ClientList mockClientList;
//     private FoodList mockFoodList;
//     private Hamper mockHamper;

//     @Before
//     public void initialize() {
//         mockFileWriter = mock(FileWriter.class);
//         mockClientList = mock(ClientList.class);
//         mockFoodList = mock(FoodList.class);
//         mockHamper = mock(Hamper.class);
//         mockOrder = new OrderTestHelper(mockFileWriter, mockClientList, mockFoodList, mockHamper);
//     }

//     @Test
//     public void testAddFirstOrder() {
//         GUIOrderTestHelper gui = new GUIOrderTestHelper();
//         GUIOrderTestHelper.adultMaleBox.setText("1");
//         GUIOrderTestHelper.adultFemaleBox.setText("1");
//         GUIOrderTestHelper.over8Box.setText("1");
//         GUIOrderTestHelper.under8Box.setText("1");
//         GUIOrderTestHelper.postCodeBox.setText("T3R 1S4");
//         try {
//             mockOrder.addFirstOrder();
//             verify(mockFileWriter, atLeastOnce()).append(any());
//             verify(mockFoodList, atLeastOnce()).removeFromDatabase(any());
//             verify(mockFileWriter, atLeastOnce()).flush();
//             verify(mockFileWriter, atLeastOnce()).close();
//         } catch (Exception e) {
//             fail(e.getMessage());
//         }
//     }

//     @Test
//     public void testDecrement() {
//         int expectedNumber = OrderTestHelper.getCounter() - 1;
//         OrderTestHelper.decrement();
//         assertEquals(expectedNumber, OrderTestHelper.getCounter());
//     }

//     @Test
//     public void testGetCounter() {
//         int expectedNumber = 3;
//         assertEquals(expectedNumber, OrderTestHelper.getCounter());
//     }

//     @Test
//     public void testIncrement() {
//         int expectedNumber = OrderTestHelper.getCounter() + 1;
//         OrderTestHelper.increment();
//         assertEquals(expectedNumber, OrderTestHelper.getCounter());
       
//     }

//     @Test
//     public void testOrderCreation() {
//         GUIOrderTestHelper gui = new GUIOrderTestHelper();
//         GUIOrderTestHelper.adultMaleBox.setText("1");
//         GUIOrderTestHelper.adultFemaleBox.setText("1");
//         GUIOrderTestHelper.over8Box.setText("1");
//         GUIOrderTestHelper.under8Box.setText("1");
//         GUIOrderTestHelper.postCodeBox.setText("T3R 1S4");
//         try {
//             mockOrder.orderCreation();
//             verify(mockFileWriter, atLeastOnce()).append(any());
//             verify(mockFoodList, atLeastOnce()).removeFromDatabase(any());
//             verify(mockFileWriter, atLeastOnce()).flush();
//             verify(mockFileWriter, atLeastOnce()).close();
//         } catch (Exception e) {
//             fail(e.getMessage());
//         }
       
//     }
    
// }
