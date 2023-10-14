package com.yteintern.springweb.errors;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<String> handleValidationExceptions(MethodArgumentNotValidException ex){
        return ex.getFieldErrors()
                .stream()
                .map(e->e.getField()+": "+e.getDefaultMessage())
                .collect(Collectors.toList());
    }
}
