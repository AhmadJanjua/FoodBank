package edu.ucalgary.ensf409;

public class Food
{
    private final int ITEM_ID;
    private final String NAME;
    private final int GRAIN_CONTENT;
    private final int FV_CONTENT;
    private final int PROTEIN_CONTENT;
    private final int OTHER;
    private final int CALORIES;

    //constructor

    public Food(int itemID, String name, int grainContent, int FVContent, int proteinContent, int other, int calories)
    {
        this.ITEM_ID = itemID;
        this.NAME = name;
        this.GRAIN_CONTENT = grainContent;
        this.FV_CONTENT = FVContent;
        this.PROTEIN_CONTENT = proteinContent;
        this.OTHER = other;
        this.CALORIES = calories;
    }

    public int getITEM_ID()
    {
        return this.ITEM_ID;
    }

    public String getNAME()
    {
        return this.NAME;
    }

    public int getGRAIN_PERCENTAGE()
    {
        return this.GRAIN_CONTENT;
    }

    public int getGRAIN_CONTENT()
    {
        return (int) Math.ceil(((double)this.GRAIN_CONTENT / 100 * (double)this.CALORIES));
    }

    public int getFV_PERCENTAGE()
    {
        return this.FV_CONTENT;
    }

    public int getFV_CONTENT()
    {
        return (int) Math.ceil(((double)this.FV_CONTENT / 100 * (double)this.CALORIES));
    }

    public int getPROTEIN_PERCENTAGE()
    {
        return this.PROTEIN_CONTENT;
    }

    public int getPROTEIN_CONTENT()
    {
        return (int) Math.ceil(((double)this.PROTEIN_CONTENT / 100 * (double)this.CALORIES));
    }

    public int getOTHER()
    {
        return this.OTHER;
    }

    public int getOTHER_CONTENT()
    {
        return (int) Math.ceil(((double)this.OTHER / 100 * (double)this.CALORIES));
    }
    
    public int getCALORIES()
    {
        return this.CALORIES;
    }
}