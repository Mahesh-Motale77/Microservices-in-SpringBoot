package com.mahesh.microservice1.advice;

import com.mahesh.microservice1.exception.DataNotFoundException;
import com.mahesh.microservice1.exception.MovieNameException;
import com.mahesh.microservice1.exception.MovieTypeException;
import com.mahesh.microservice1.responce.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.NoSuchElementException;

import javax.validation.ConstraintViolation;


@ControllerAdvice
public class MyControllerAdvice extends ResponseEntityExceptionHandler {
//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException noSuchElementException){
//        return new ResponseEntity<String>("This Movie is not found in Database", HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException dataNotFoundException){
//        return new ResponseEntity<Object>("This Movie is not found in Database inside DataNotFoundException", HttpStatus.NOT_FOUND);
        ErrorResponse errorResponse = new ErrorResponse(dataNotFoundException.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(ConstraintViolationException.class)
//    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException constraintViolationException){
//        ErrorResponse errorResponse = new ErrorResponse(constraintViolationException.getMessage(), HttpStatus.BAD_REQUEST.value());
//        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//    }



    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException constraintViolationException) {
        StringBuilder messageBuilder = new StringBuilder();
        for (ConstraintViolation<?> violation : constraintViolationException.getConstraintViolations()) {
            messageBuilder.append(violation.getMessage()).append(" , ");
        }
        String errorMessage = messageBuilder.toString().trim();

        ErrorResponse errorResponse = new ErrorResponse(errorMessage, HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }


//    @ExceptionHandler(MovieTypeException.class)
//    public ResponseEntity<ErrorResponse> handleMovieTypeException(MovieTypeException movieTypeException){
//        ErrorResponse errorResponse = new ErrorResponse("Movie type must be of Action|Drama|Horror|Comedy|Comedy plus Horror|Sci-Fi", HttpStatus.BAD_REQUEST.value());
//        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
//    }



//    @Override
//    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
//    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
//        return new ResponseEntity<Object>("Please Change your api url", HttpStatus.NOT_FOUND);
//    }
}
