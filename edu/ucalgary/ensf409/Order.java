import java.util.ArrayList;

public class Order {
    
    private ArrayList<Hamper> hampers;

    public Order() {
        hampers = new ArrayList<Hamper>();
    }

    public Order(ArrayList<Hamper> hampers) {
        this.hampers = hampers;
    }

    public boolean canComplete() {
        return hampers.size() > 0;
    }

    public void addHamper(Hamper newHamper) {
        hampers.add(newHamper);
    }

    public void resetOrder() {
    }

    public ArrayList<Hamper> getHampers() {
        return hampers;
    }
}
