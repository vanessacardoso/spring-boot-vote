package com.br.vanessa.vote.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception, HttpServletRequest request) {
        String path = request.getRequestURI();
        ErrorResponse exceptionMessage = ErrorResponse.of(path, exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        return exceptionMessage.toResponseEntity();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException exception) {
        String path = request.getRequestURI();
        ErrorResponse exceptionMessage = ErrorResponse.of(path, exception.getMessage(), HttpStatus.BAD_REQUEST);
        return exceptionMessage.toResponseEntity();
    }

}
