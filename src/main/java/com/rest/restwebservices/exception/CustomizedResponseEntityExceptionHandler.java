package com.rest.restwebservices.exception;

import com.rest.restwebservices.user.UserNotFoudException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ExceptionResource exceptionResource = new ExceptionResource(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResource, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserNotFoudException.class)
    public final ResponseEntity<Object> handleUserNotFoudException(Exception ex, WebRequest request) {
        ExceptionResource exceptionResource = new ExceptionResource(new Date(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity(exceptionResource, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ExceptionResource exceptionResource = new ExceptionResource(new Date(), ex.getMessage(), ex.getBindingResult().toString());
        return new ResponseEntity(exceptionResource, HttpStatus.BAD_REQUEST);
    }

}
