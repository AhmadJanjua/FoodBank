// package edu.ucalgary.ensf409;
// import org.junit.*;
// import static org.junit.Assert.*;
// import java.util.ArrayList;
// /**
//  * ENSF 409 Final Project Group 7
//  * @author Ahmad Janjua, Pedro Ghodsi, Zohaib Ashfaq, Farica Mago
//  * @version 1.0
//  * @since 1.0
//  */
// public class FoodTest {

//     @Test
//     public void testGetCALORIES() {
//         // making an object of class Food with correct arguments
//       	var food = new Food(0023,"Tomato Sauce,jar",0,80,10,10,120);
//       	assertEquals("The getter method for CALORIES of food failed!",120,food.getCALORIES());
//     }

//     @Test
//     public void testGetFV_CONTENT() {
//         // making an object of class Food with correct arguments
//       	var food = new Food(0023,"Tomato Sauce,jar",0,80,10,10,120);
//         double expectedResult = 0.01*80*120;
//       	assertEquals("The getter method for FV_CONTENT of food failed!",expectedResult,food.getFV_CONTENT(),0.0);
//     }

//     @Test
//     public void testGetFV_PERCENT() {
//         // making an object of class Food with correct arguments
//       	var food = new Food(0023,"Tomato Sauce,jar",0,80,10,10,120);
//       	assertEquals("The getter method for FV_PERCENT of food failed!",80,food.getFV_PERCENT());
//     }

//     @Test
//     public void testGetGRAIN_CONTENT() {
//         // making an object of class Food with correct arguments
//       	var food = new Food(0023,"Tomato Sauce,jar",0,80,10,10,120);
//         double expectedResult = 0.01*0*120;
//       	assertEquals("The getter method for GRAIN_CONTENT of food failed!",expectedResult,food.getGRAIN_CONTENT(),0.0);
//     }

//     @Test
//     public void testGetGRAIN_PERCENT() {
//                 // making an object of class Food with correct arguments
//       	var food = new Food(0023,"Tomato Sauce,jar",0,80,10,10,120);
//       	assertEquals("The getter method for GRAIN_PERCENT of food failed!",0,food.getGRAIN_PERCENT());
//     }

//     @Test
//     public void testGetITEM_ID() {
//         // making an object of class Food with correct arguments
//       	var food = new Food(0023,"Tomato Sauce,jar",0,80,10,10,120);
//       	assertEquals("The getter method for ITEM_ID failed!",0023,food.getITEM_ID());
//     }

//     @Test
//     public void testGetNAME() {
//         // making an object of class Food with correct arguments
//       	var food = new Food(0023,"Tomato Sauce,jar",0,80,10,10,120);
//   	    assertEquals("The getter method for NAME of food failed!","Tomato Sauce,jar",food.getNAME());        
//     }

//     @Test
//     public void testGetOTHER_CONTENT() {
//         // making an object of class Food with correct arguments
//       	var food = new Food(0023,"Tomato Sauce,jar",0,80,10,10,120);
//         double expectedResult = 0.01*10*120;
//       	assertEquals("The getter method for OTHER_CONTENT of food failed!",expectedResult,food.getOTHER_CONTENT(),0.0);
//     }

//     @Test
//     public void testGetOTHER_PERCENT() {
//         // making an object of class Food with correct arguments
//       	var food = new Food(0023,"Tomato Sauce,jar",0,80,10,10,120);
//       	assertEquals("The getter method for OTHER_PERCENT of food failed!",10,food.getOTHER_PERCENT());
//     }

//     @Test
//     public void testGetPROTEIN_CONTENT() {
//          // making an object of class Food with correct arguments
//       	var food = new Food(0023,"Tomato Sauce,jar",0,80,10,10,120);
//         double expectedResult = 0.01*10*120;
//       	assertEquals("The getter method for PROTEIN_CONTENT of food failed!",expectedResult,food.getPROTEIN_CONTENT(),0.0);
//     }

//     @Test
//     public void testGetPROTEIN_PERCENT() {
//         // making an object of class Food with correct arguments
//       	var food = new Food(0023,"Tomato Sauce,jar",0,80,10,10,120);
//       	assertEquals("The getter method for PROTEIN_PERCENT of food failed!",10,food.getPROTEIN_PERCENT());
//     }
    
// }
