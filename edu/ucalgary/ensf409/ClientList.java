package edu.ucalgary.ensf409;
/**
@author Ahmad Janjua
@version 1.5
@since 1.0
*/

/*
The class the collects information about the various types of clients and returns
their daily caloric needs.
*/

public class ClientList {
    // Number of clients in each category
    private final int
            numMale,
            numFemale,
            numOver8,
            numUnder8;
    //Total calories for all the clients in the group.
    private double
            totalCalories,
            totalGrains,
            totalFruitVeg,
            totalProtein,
            totalOthers;
    private boolean mobilityAccommodation = false;
    
    /**
     * Constructor:
     * Generates a list of the requirements for the clients in the clientList
     * and gets their needs from the database.
     * @param numMale the number of male clients
     * @param numFemale number of female clients
     * @param numUnder8 number of children under 8
     * @param numOver8 number of children over 8
     * @param mobilityAccommodation Do the clients need accomodation
     */
    public ClientList(int numMale, int numFemale, int numOver8, int numUnder8, boolean mobilityAccommodation) {
        this.numMale = numMale;
        this.numFemale = numFemale;
        this.numOver8 = numOver8;
        this.numUnder8 = numUnder8;
        this.mobilityAccommodation = mobilityAccommodation;
        setNutrientNeeds();
    }

    // Private helper function to set the totals calories in each category to zero,
    // then call other add calorie function to get total calories.
    private void setNutrientNeeds() {
        totalCalories = totalGrains = totalFruitVeg = totalProtein = totalOthers = 0;
        addCalories(numMale, Client.ADULT_MALE);
        addCalories(numFemale, Client.ADULT_FEMALE);
        addCalories(numOver8, Client.CHILD_OVER_8);
        addCalories(numUnder8, Client.CHILD_UNDER_8);
    }

    // Private helper function that adds calories given the client number and type
    private void addCalories(int num, Client dailyNeeds) {
        totalCalories += num * dailyNeeds.CALORIES;
        totalGrains += num * dailyNeeds.GRAIN;
        totalFruitVeg += num * dailyNeeds.FRUIT_VEG;
        totalProtein += num * dailyNeeds.PROTEIN;
        totalOthers += num * dailyNeeds.OTHERS;
    }

    /**
    * @return A formatted list of the clients by their type and quantity.
    */
    public String getClientString() {
        String clientString = "";
        if(numMale != 0){
            clientString += numMale + " Adult Male, ";
        }
        if(numFemale != 0){
            clientString += numFemale + " Adult Female, ";
        }
        if(numUnder8 != 0){
            clientString += numUnder8 + " Child under 8, ";
        }
        if(numOver8 != 0){
            clientString += numOver8 + " Child over 8, ";
        }
        return clientString.substring(0, clientString.length()-2);
    }

    // Getters for all private feilds
    public int getNumMale() {
        return numMale;
    }

    public int getNumFemale() {
        return numFemale;
    }

    public int getNumOver8() {
        return numOver8;
    }

    public int getNumUnder8() {
        return numUnder8;
    }

    public double getTotalCalories() {
        return totalCalories;
    }

    public double getTotalGrains() {
        return totalGrains;
    }

    public double getTotalFruitVeg() {
        return totalFruitVeg;
    }

    public double getTotalProtein() {
        return totalProtein;
    }

    public double getTotalOthers() {
        return totalOthers;
    }

    public boolean isMobilityAccommodation() {
        return mobilityAccommodation;
    }
}