package edu.ucalgary.ensf409;
/**
@author Ahmad Janjua
@version 1.2
@since 1.0
*/
import java.util.*;
/*
The hamper class takes the needs of clients and the available food in the database
to create the best hamper for them.
*/
public class Hamper {
    private double totalCalories, totalProtein, totalOther, totalFV, totalGrain;
    private double minCalories, minProtein, minGrain, minOther, minFV;
    private double calories, protein, other, grain, fv;
    private double diff;
    private HashMap<Integer,Food> foodDatabase = new HashMap<Integer,Food>();
    private Set<Integer> hamperSet = new TreeSet<Integer>();
    private ClientList nutrientNeeds;
    private ArrayList<String> inHamper;

    /**
     * The Constructor
     * @param nutrientNeeds A clientlist of client needs;
     * @param foods a FoodList of all available food items.
     * @throws InsufficientFoodException If the foodlist does not contain enough items to generate
     * food that meets the needs of the clients an exception is thrown.
     */
    public Hamper(ClientList nutrientNeeds, FoodList foods) throws InsufficientFoodException {
        this.nutrientNeeds = nutrientNeeds;
        this.nutrientNeeds.setNutrientNeeds();
        this.foodDatabase = foods.getFoodList();
        this.totalCalories = nutrientNeeds.getTotalCalories()*7;
        this.totalFV = nutrientNeeds.getTotalFVCalories()*7;
        this.totalOther = nutrientNeeds.getTotalOtherCalories()*7;
        this.totalProtein = nutrientNeeds.getTotalProteinCalories()*7;
        this.totalGrain = nutrientNeeds.getTotalGrainCalories()*7;
        createHamper();
    }
    /**
     * Add a food object to the hamper
     * @param food A valid Food object
     */
    public void addToHamper(Food food){
        this.inHamper.add(food.getITEM_ID()+" "+ food.getNAME());
    }
    /**
     * Getter
     * @return Returns an arraylist of strings that are in the hamper
     */
    public ArrayList<String> getInHamper() {
        inHamper = new ArrayList<>();
        for(int i : hamperSet){
            inHamper.add(foodDatabase.get(i).getNAME());
        }
        return inHamper;
    }
    /**
     * Getter
     * @return gets a ClientList.
     */
    public ClientList getNutrientNeeds() {
        return nutrientNeeds;
    }
    /**
     * Creates a hamper with the new requirements.
     * @param nutrientNeeds Requires a clientList obeject with the clients needs.
     */
    public void setNutrientNeeds(ClientList nutrientNeeds) throws InsufficientFoodException{
        this.nutrientNeeds = nutrientNeeds;
        createHamper();
    }
    /**
     * Creates the format needed for the order form
     * @return a single string of all the needed items in the hamper.
     */
    public String createOrderFormat() {
        ArrayList<Integer> al = new ArrayList<>(hamperSet);
        String hamperString = "";
        Collections.sort(al);
        for(int x: al) {
            hamperString += x+ "\t"+ foodDatabase.get(x).getNAME() + "\n";
        }
        return hamperString;
    }
    /**
     * Runs through the algorithm to generate the least wasteful hamper.
     * @throws InsufficientFoodException
     */
    public void createHamper() throws InsufficientFoodException{
        int counter = 10;
        double tmp; 
        ArrayList<Double> list = new ArrayList<>();
        list.add(0.0);

        while(!list.isEmpty()){
            getMin();
            list.clear();
            if(totalFV-fv > 0)
                list.add(totalFV-fv);
            if(totalOther-other > 0)
                list.add(totalOther-other);
            if(totalProtein-protein> 0)
                list.add(totalProtein-protein);
            if(totalGrain-grain > 0)
                list.add(totalGrain-grain);
            list.sort(Collections.reverseOrder());
            tmp = -1000.0;
            if(!list.isEmpty()){
                tmp = list.get(0);
                list.remove(0);
            }
                

            if(tmp+fv == totalFV){
                completeFV();
            }else if(tmp+other == totalOther){
                completeOther();
            }else if(tmp+protein== totalProtein){
                completeProtein();
            }else if(tmp+grain == totalGrain){
                completeGrain();
            }

            if(counter-- == 0){
                throw new InsufficientFoodException("NOT enough items");///NOTENOUGHFOOD
            }
        }
        this.minimize();
    }
    /**
     * Hamper ItemIDs
     * @return Gets a list of all itemID added to hamper
     */
    public ArrayList<Integer> getItemList(){
        ArrayList<Integer> al = new ArrayList<>(hamperSet);
        Collections.sort(al);
        return al;
    }
    //Getter for fields.
    //Calories in hamper for week
    public double getCalories() {
        return calories;
    }
    public double getProtein() {
        return protein;
    }
    public double getOther() {
        return other;
    }
    public double getGrain() {
        return grain;
    }
    public double getFv() {
        return fv;
    }
    //Weekly food requirements for the client
    public double getTotalCalories() {
        return totalCalories;
    }
    public double getTotalProtein() {
        return totalProtein;
    }
    public double getTotalOther() {
        return totalOther;
    }
    public double getTotalFV() {
        return totalFV;
    }
    public double getTotalGrain() {
        return totalGrain;
    }
    //Private helper methods for the algorithm.
    private void getMin(){
        minCalories = minFV = minGrain = minProtein = minOther = 1000000;
        for(Map.Entry<Integer,Food> entry : foodDatabase.entrySet()){
            if(minCalories > entry.getValue().getCALORIES() && entry.getValue().getCALORIES() != 0 && !hamperSet.contains(entry.getKey())){
                minCalories = entry.getValue().getCALORIES();
            }
            if(minFV > entry.getValue().getFV_CONTENT() && entry.getValue().getFV_CONTENT() != 0 && !hamperSet.contains(entry.getKey())){
                minFV = entry.getValue().getFV_CONTENT();
            }
            if(minOther > entry.getValue().getOTHER_CONTENT() && entry.getValue().getOTHER_CONTENT() != 0 && !hamperSet.contains(entry.getKey())){
                minOther = entry.getValue().getOTHER_CONTENT();
            }
            if(minProtein > entry.getValue().getPROTEIN_CONTENT() && entry.getValue().getPROTEIN_CONTENT() != 0 && !hamperSet.contains(entry.getKey())){
                minProtein = entry.getValue().getPROTEIN_CONTENT();
            }
            if(minGrain > entry.getValue().getGRAIN_CONTENT() && entry.getValue().getGRAIN_CONTENT() != 0 && !hamperSet.contains(entry.getKey())){
                minGrain = entry.getValue().getGRAIN_CONTENT();
            }
        }
    }
    private void completeProtein(){
        for(int i = 100; i > 0; i--){
            for(Map.Entry<Integer,Food> entry : foodDatabase.entrySet()){
                if(protein< totalProtein && entry.getValue().getPROTEIN_PERCENT() >= i && !hamperSet.contains(entry.getKey())){
                    add(entry);
                    diff = Math.abs(protein- totalProtein);
                    if(protein> totalProtein && diff > minProtein){
                        subtract(entry);
                    }else{
                        hamperSet.add(entry.getKey());
                    }
                }
            }
        }
    }
    private void completeFV(){
        for(int i = 100; i > 0; i--){
            for(Map.Entry<Integer,Food> entry : foodDatabase.entrySet()){
                if(fv < totalFV && entry.getValue().getFV_PERCENT() >= i && !hamperSet.contains(entry.getKey())){
                    add(entry);
                    diff = Math.abs(fv - totalFV);
                    if(fv > totalFV && diff > minFV){
                        subtract(entry);
                    }else{
                        hamperSet.add(entry.getKey());
                    }
                }
            }
        }
    }
    private void completeGrain(){
        for(int i = 100; i > 0; i--){
            for(Map.Entry<Integer,Food> entry : foodDatabase.entrySet()){
                if(grain < totalGrain && entry.getValue().getGRAIN_PERCENT() >= i && !hamperSet.contains(entry.getKey())){
                    add(entry);
                    diff = Math.abs(grain - totalGrain);
                    if(grain > totalGrain && diff > minGrain){
                        subtract(entry);
                    }else{
                        hamperSet.add(entry.getKey());
                    }
                }
            }
        }
    }
    private void completeOther(){
        for(int i = 100; i > 0; i--){
            for(Map.Entry<Integer,Food> entry : foodDatabase.entrySet()){
                if(other < totalOther && entry.getValue().getOTHER_PERCENT() >= i && !hamperSet.contains(entry.getKey())){
                    add(entry);
                    diff = Math.abs(other - totalOther);
                    if(other > totalOther && diff > minOther){
                        subtract(entry);
                    }else{
                        hamperSet.add(entry.getKey());
                    }
                }
            }
        }
    }
    private void minimize(){
        Set<Integer> extraItems = new HashSet<Integer>(), addSet = new HashSet<Integer>();
        List<Integer> list = new ArrayList<Integer>(hamperSet);
        for(int i = 0; i < list.size(); i++){
            if(protein > totalProtein || fv > totalFV || other > totalOther || grain > totalGrain){
                calories -= foodDatabase.get(list.get(i)).getCALORIES();
                protein -= foodDatabase.get(list.get(i)).getPROTEIN_CONTENT();
                fv -= foodDatabase.get(list.get(i)).getFV_CONTENT();
                other -= foodDatabase.get(list.get(i)).getOTHER_CONTENT();
                grain -= foodDatabase.get(list.get(i)).getGRAIN_CONTENT();
                extraItems.add(list.get(i));
                if(protein < totalProtein || fv < totalFV || other < totalOther || grain < totalGrain){
                    calories += foodDatabase.get(list.get(i)).getCALORIES();
                    grain += foodDatabase.get(list.get(i)).getGRAIN_CONTENT();
                    protein += foodDatabase.get(list.get(i)).getPROTEIN_CONTENT();
                    fv += foodDatabase.get(list.get(i)).getFV_CONTENT();
                    other += foodDatabase.get(list.get(i)).getOTHER_CONTENT();
                    addSet.add(list.get(i));
                }
            }
        }
        extraItems.removeAll(addSet);
        hamperSet.removeAll(extraItems);
    }
    private void add(Map.Entry<Integer,Food> entry){
        protein += entry.getValue().getPROTEIN_CONTENT();
        calories += entry.getValue().getCALORIES();
        other += entry.getValue().getOTHER_CONTENT();
        fv += entry.getValue().getFV_CONTENT();
        grain += entry.getValue().getGRAIN_CONTENT();
        
    }
    private void subtract(Map.Entry<Integer,Food> entry){
        protein -= entry.getValue().getPROTEIN_CONTENT();
        calories -= entry.getValue().getCALORIES();
        other -= entry.getValue().getOTHER_CONTENT();
        fv -= entry.getValue().getFV_CONTENT();
        grain -= entry.getValue().getGRAIN_CONTENT();
    }
}
