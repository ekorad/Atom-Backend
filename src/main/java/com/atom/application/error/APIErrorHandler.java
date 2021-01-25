package com.atom.application.error;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class APIErrorHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "HTTP message is not readable";
        String error = ex.getLocalizedMessage();
        APIError apiError = new APIError(status, message, error);
        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "Request method is not supported";
        String error = ex.getLocalizedMessage();
        APIError apiError = new APIError(status, message, error);
        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        String message = "Path variable is missing";
        String error = ex.getLocalizedMessage();
        APIError apiError = new APIError(status, message, error);
        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "Specified media type is not supported";
        String error = ex.getLocalizedMessage();
        APIError apiError = new APIError(status, message, error);
        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
            HttpHeaders headers, HttpStatus status, WebRequest request) {
        String message = "Request parameter is missing";
        String error = ex.getLocalizedMessage();
        APIError apiError = new APIError(status, message, error);
        return handleExceptionInternal(ex, apiError, headers, status, request);
    }

    @ExceptionHandler({ ConstraintViolationException.class })
    protected ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        String message = "Constraint violation has occured: specified variable values do not respect imposed constraints";
        List<String> errors = new ArrayList<>();
        for (ConstraintViolation<?> cv : ex.getConstraintViolations()) {
            errors.add(cv.getRootBeanClass().getName() + " - " + cv.getPropertyPath() + ": " + cv.getMessage());
        }

        APIError apiError = new APIError(HttpStatus.BAD_REQUEST, message, errors);
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

    @ExceptionHandler({ EntityNotFoundException.class })
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        String message = "One ore more entities have not been found using the provided query parameters";
        APIError apiError = new APIError(HttpStatus.NOT_FOUND, message, ex.getLocalizedMessage());
        return handleExceptionInternal(ex, apiError, new HttpHeaders(), apiError.getStatus(), request);
    }

}
