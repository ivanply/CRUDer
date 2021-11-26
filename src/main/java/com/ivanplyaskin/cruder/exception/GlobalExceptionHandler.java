package com.ivanplyaskin.cruder.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<DefaultErrorResponse> handleEntityNotFoundException(Exception exception, WebRequest request) {

        DefaultErrorResponse responseBody = new DefaultErrorResponse();
        responseBody.setTimestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(new Date()));
        responseBody.setStatus(HttpStatus.NOT_FOUND.value());
        responseBody.setErrors(Collections.singletonList(exception.getMessage()));
        responseBody.setPath(request.getContextPath());

        return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
        HttpHeaders headers, HttpStatus status, WebRequest request) {

        DefaultErrorResponse responseBody = new DefaultErrorResponse();
        responseBody.setTimestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").format(new Date()));
        responseBody.setStatus(HttpStatus.BAD_REQUEST.value());
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        responseBody.setErrors(errors);
        responseBody.setPath(request.getContextPath());

        return new ResponseEntity<>(responseBody, headers, status);
    }
}
