package edu.ucalgary.ensf409;

public class Food
{
    private final int ITEM_ID;
    private final String NAME;
    private final int GRAIN_PERCENT;
    private final int FV_PERCENT;
    private final int PROTEIN_PERCENT;
    private final int OTHER_PERCENT;
    private final double GRAIN_CONTENT;
    private final double FV_CONTENT;
    private final double PROTEIN_CONTENT;
    private final double OTHER_CONTENT;
    private final int CALORIES;

    //constructor
    public Food(int itemID, String name, int grainContent, int FVContent, int proteinContent, int other, int calories) {
        this.ITEM_ID = itemID;
        this.NAME = name;
        this.GRAIN_CONTENT = .01 * grainContent * calories;
        this.FV_CONTENT = .01 * FVContent * calories;
        this.PROTEIN_CONTENT = .01 * proteinContent * calories;
        this.OTHER_CONTENT = .01 * other * calories;
        this.GRAIN_PERCENT = grainContent;
        this.FV_PERCENT = FVContent;
        this.PROTEIN_PERCENT = proteinContent;
        this.OTHER_PERCENT =  other;
        this.CALORIES = calories;
    }
    public int getITEM_ID() {
        return ITEM_ID;
    }
    public String getNAME() {
        return NAME;
    }
    public int getGRAIN_PERCENT() {
        return GRAIN_PERCENT;
    }
    public int getFV_PERCENT() {
        return FV_PERCENT;
    }
    public int getPROTEIN_PERCENT() {
        return PROTEIN_PERCENT;
    }
    public int getOTHER_PERCENT() {
        return OTHER_PERCENT;
    }
    public double getGRAIN_CONTENT() {
        return GRAIN_CONTENT;
    }
    public double getFV_CONTENT() {
        return FV_CONTENT;
    }
    public double getPROTEIN_CONTENT() {
        return PROTEIN_CONTENT;
    }
    public double getOTHER_CONTENT() {
        return OTHER_CONTENT;
    }
    public int getCALORIES() {
        return CALORIES;
    }

}