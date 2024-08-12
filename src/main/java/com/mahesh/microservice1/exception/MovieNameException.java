package com.mahesh.microservice1.exception;

public class MovieNameException extends RuntimeException{
    String message;

    MovieNameException(){};

    public MovieNameException(String msg){
        super(msg);
        this.message = msg;
    }


}
