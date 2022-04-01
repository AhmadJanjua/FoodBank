package edu.ucalgary.ensf409;

public class Food {
    private final String NAME;
    private final int ITEM_ID;
    private final int GRAIN_CONTENT;
    private final int FV_CONTENT;
    private final int PROTEIN_CONTENT;
    private final int OTHER;
    private final int CALORIES;
    private int stock;
    
    public Food(int ITEM_ID, String NAME, int GRAIN_CONTENT, int FV_CONTENT, int PROTEIN_CONTENT, int OTHER, int CALORIES, int stock) {
        this.NAME = NAME;
        this.ITEM_ID = ITEM_ID;
        this.GRAIN_CONTENT = GRAIN_CONTENT;
        this.FV_CONTENT = FV_CONTENT;
        this.PROTEIN_CONTENT = PROTEIN_CONTENT;
        this.OTHER = OTHER;
        this.CALORIES = CALORIES;
        this.stock = stock;
    }

    public String getNAME() {
        return NAME;
    }

    public int getITEM_ID() {
        return ITEM_ID;
    }

    public int getGRAIN_CONTENT() {
        return GRAIN_CONTENT;
    }

    public int getFV_CONTENT() {
        return FV_CONTENT;
    }

    public int getPROTEIN_CONTENT() {
        return PROTEIN_CONTENT;
    }

    public int getOTHER() {
        return OTHER;
    }

    public int getCALORIES() {
        return CALORIES;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
