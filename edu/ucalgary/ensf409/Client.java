package edu.ucalgary.ensf409;

import org.junit.experimental.categories.Categories;

/**
 * Client
 */
public class Client {
    private static int counter = 1;
    private final int CLIENT_ID;
    private final String CLIENT_TYPE;
    private int percentGrain;
    private int percentFV;
    private int percentProtein;
    private int percentOther;
    private int calories;
    public Client(String CLIENT_TYPE, int percentGrain, int percentFV, int percentProtein, int percentOther, int calories) {
        this.CLIENT_ID = counter++;
        this.CLIENT_TYPE = CLIENT_TYPE;
        this.percentGrain = percentGrain;
        this.percentFV = percentFV;
        this.percentProtein = percentProtein;
        this.percentOther = percentOther;
        this.calories = calories;
    }
    
    public int getCLIENT_ID() {
        return CLIENT_ID;
    }
    public String getCLIENT_TYPE() {
        return CLIENT_TYPE;
    }
    public int getPercentGrain() {
        return percentGrain;
    }
    public void setPercentGrain(int percentGrain) {
        this.percentGrain = percentGrain;
    }
    public int getPercentFV() {
        return percentFV;
    }
    public void setPercentFV(int percentFV) {
        this.percentFV = percentFV;
    }
    public int getPercentProtein() {
        return percentProtein;
    }
    public void setPercentProtein(int percentProtein) {
        this.percentProtein = percentProtein;
    }
    public int getPercentOther() {
        return percentOther;
    }
    public void setPercentOther(int percentOther) {
        this.percentOther = percentOther;
    }
    public int getCalories() {
        return calories;
    }
    public void setCalories(int calories) {
        this.calories = calories;
    }
    
}