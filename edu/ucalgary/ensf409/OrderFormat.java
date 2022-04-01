import java.io.File;
import java.io.IOException;

public class OrderFormat {
    
    private String ORDEROUT = "orderout.txt";

    public boolean createOrderForm() {
        try {
            File myObj = new File(ORDEROUT);
            if (myObj.createNewFile()) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } 
    }

    public void updateStock() {
        // Not sure what to do here
    }
}
