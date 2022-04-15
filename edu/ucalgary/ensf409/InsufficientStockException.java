package edu.ucalgary.ensf409;


/**
@author Pedro Ghodsi
@version 1.0
@since 1.0
*/
public class InsufficientStockException extends Exception{
    public InsufficientStockException(String errorMessage){
        super(errorMessage);
    }
}