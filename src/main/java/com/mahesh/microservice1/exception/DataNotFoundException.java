package com.mahesh.microservice1.exception;

public class DataNotFoundException extends RuntimeException{
    private String message;

    public DataNotFoundException(){};

    public DataNotFoundException(String msg){
        super(msg);
        this.message = msg;
    }
}
