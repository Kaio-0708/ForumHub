package com.alura.forum.core.crud.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<StandardError> handlerFieldsError(MethodArgumentNotValidException ex, HttpServletRequest request) {
        FieldError firstFieldWithError = ex.getFieldErrors().get(ex.getFieldErrors().size() - 1);
        var nameFieldError = firstFieldWithError.getField();

        String error = "VALIDATION FAILED!";
        String message = nameFieldError + " " + firstFieldWithError.getDefaultMessage();
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), error.toUpperCase(), message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<StandardError> handleEntityNotFound(EntityNotFoundException ex, HttpServletRequest request) {
        String error = "RESOURCE NOT FOUND!";
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), error.toUpperCase(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    private ResponseEntity<StandardError> handleIllengalArgumentException(IllegalArgumentException ex, HttpServletRequest request) {
        String error = "PARAMETER NOT FOUND!";
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), error.toUpperCase(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(AccessDeniedException.class)
    private ResponseEntity<StandardError> handleAccessDenied(AccessDeniedException ex, HttpServletRequest request) {
        String error = "ACCESS DENIED!";
        StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(), error.toUpperCase(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
    }

}
