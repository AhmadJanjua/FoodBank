package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.HashMap;
/*

/**
 * ENSF 409 Final Project Group 7
 * @author Ahmad Janjua, Pedro Ghodsi, Zohaib Ashfaq, Farica Mago
 * @version 1.1
 * @since 1.0
 *//*
public class FoodListTest {
    
    @Test
    public void testfillFromDatabase() {
        currentFood = new HashMap<>();
        currentFood.put("colA", "foodA");
        currentFood.put("colB", "foodB");
        currentFood.put("colC", "foodC");

        String result = getColumn();
        assertEquals(testData.keySet(), new HashSet<>(Arrays.asList(result.split(", "))));
    }
    */
    /**
     * Calling the constructor with an empty ArrayList of food
     * should cause the program to throw an illegal argument exception
     *//*
      @Test
      public void testEmptyListConstructor_FoodList() {
          boolean exceptionThrown = false;
          //Creating an empty arraylist to pass in as argument.
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
       *//*
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
      *//*
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
       *//*
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
       *//*
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
       *//*
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
       *//*
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
       * Test to see if the removeFood method successfully removes Food object
       *//*
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

  

}*/
