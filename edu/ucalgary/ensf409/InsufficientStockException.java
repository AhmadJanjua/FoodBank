package edu.ucalgary.ensf409;

public class InsufficientStockException extends Exception{
    public InsufficientStockException(String errorMessage){
        super(errorMessage);
    }
}