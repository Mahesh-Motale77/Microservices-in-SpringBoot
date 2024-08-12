package com.mahesh.microservice1.exception;

public class MovieTypeException extends RuntimeException{
    String message;

    MovieTypeException(){};

    public MovieTypeException(String msg){
        super(msg);
        this.message = msg;
    }
}
