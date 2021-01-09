package com.atom.application.handlers;

import java.io.IOException;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;

@ControllerAdvice
public class ValidationErrorHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    protected void handleConstraingViolationException(ConstraintViolationException exc, ServletWebRequest request)
            throws IOException {
        request.getResponse().sendError(HttpStatus.BAD_REQUEST.value(), exc.getMessage());
    }
    
}
