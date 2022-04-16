package edu.ucalgary.ensf409;
import javax.swing.JOptionPane;
/**
 * @author Pedro Ghodsi
 * @version 1.0
 * @since 1.0
 */




public class InsufficientFoodException extends Exception {
    public InsufficientFoodException(String errormessage) {
        super(errormessage);
        foodExceptionBox("There are not enough food items to satisfy that order, try again.", "Not Enough Food");
        
    }

    public static void foodExceptionBox(String info, String title) {
        JOptionPane.showMessageDialog(null, info, "Error: Not enough food", JOptionPane.INFORMATION_MESSAGE);
    }
}
