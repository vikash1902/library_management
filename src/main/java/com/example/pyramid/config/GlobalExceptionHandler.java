package com.example.pyramid.config;

import com.example.pyramid.model.ValidationErrorMessage;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@Order(1)
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new ValidationErrorMessage(getErrorList(ex.getBindingResult())), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<?> customExceptionHandler(CustomException ex) {
        Map<String,String> errorMessage = new HashMap<>();
        errorMessage.put("message",ex.getMessage());
        return new ResponseEntity<>(errorMessage, ex.getHttpStatus());
    }


    public List<Map<String, String>> getErrorList(BindingResult bindingResult) {
        List<Map<String, String>> hashList = new ArrayList<>();
        bindingResult.getAllErrors().forEach((error) -> {
            Map<String, String> errors = new HashMap<>();
            if (error instanceof FieldError fieldError) {
                System.err.println("fieldError.getField()---> " + fieldError.getField()
                        + "  error.getDefaultMessage() --> " + error.getDefaultMessage());
                errors.put(fieldError.getField(), error.getDefaultMessage());
            } else if (error != null) {
                errors.put(((ObjectError) error).getObjectName(), error.getDefaultMessage());
            }
            hashList.add(errors);
        });
        return hashList;
    }
}
