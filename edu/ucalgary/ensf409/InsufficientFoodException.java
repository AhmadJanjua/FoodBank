package edu.ucalgary.ensf409;

public class InsufficientFoodException extends Exception {
    public InsufficientFoodException(String errormessage){
        super(errormessage);
    }
}
