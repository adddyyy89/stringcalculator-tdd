package com.anandgautam.tdd;

public class NegativeNumberException extends Exception {

    private static final long serialVersionUID = 1L;
    
    private String message;

    NegativeNumberException(String message) {
        super(message);
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

}