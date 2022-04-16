package edu.ucalgary.ensf409;

import javax.swing.JOptionPane;

/**
 * @author Pedro Ghodsi
 * @version 1.0
 * @since 1.0
 */
public class InsufficientStockException extends Exception {
    public InsufficientStockException(String errorMessage) {
        super(errorMessage);
        stockExceptionBox("There is not enough stock to satisfy that order, try again.", "Not Enough Stock");
    }


    public static void stockExceptionBox(String info, String title) {
        JOptionPane.showMessageDialog(null, info, "Error: Not enough stock", JOptionPane.INFORMATION_MESSAGE);
    }
}