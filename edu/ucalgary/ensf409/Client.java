package edu.ucalgary.ensf409;

public class Client
{
    private static int counter = 1;
    private int clientID;
    private final String CLIENT_TYPE;
    private int percentGrain;
    private int percentFV;
    private int percentProtein;
    private int percentOther;
    private int calories;

    // constructor

    public Client(String ID,int grain, int fruitFV, int protien,int others,int calories)
    {
        this.clientID = counter++;
        this.CLIENT_TYPE = ID;
        this.percentGrain = grain;
        this.percentFV = fruitFV;
        this.percentProtein = protien;
        this.percentOther = others;
        this.calories = calories;
    }

    // getters
    public String getClientType(){
        return this.CLIENT_TYPE;
    }

    public int getGrainPercent()
    {
        return this.percentGrain;
    }

    public int getProteinPercent()
    {
        return this.percentProtein;
    }

    public int getFVPercent()
    {
        return this.percentFV;
    }

    public int getOtherPercent()
    {
        return this.percentOther;
    }

    public int getCalories()
    {
        return this.calories;
    }

    public int getclientID()
    {
        return this.clientID;
    }

    // setters

    public void setGrainPercent(int grainPercent)
    {
        this.percentGrain = grainPercent;
    }

    public void setProteinPercent(int protienPercent)
    {
        this.percentProtein = protienPercent;
    }

    public void setFVPercent(int fvPercent)
    {
        this.percentFV = fvPercent;
    }

    public void setOtherPercent(int other)
    {
        this.percentOther = other;
    }

    public void setCalories(int calories)
    {
        this.calories = calories;
    }
}