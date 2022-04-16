package edu.ucalgary.ensf409;

/**
 * @author Pedro Ghodsi
 * @version 1.0
 * @since 1.0
 */
public class InsufficientFoodException extends Exception {
    public InsufficientFoodException(String errormessage) {
        super(errormessage);
    }
}
