package com.br.vanessa.vote.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception exception, HttpServletRequest request) {
        String path = request.getRequestURI();
        ErrorResponse exceptionMessage = ErrorResponse.of(path, exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        logger.error("An exception occurred: {}", exceptionMessage);
        return exceptionMessage.toResponseEntity();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(HttpServletRequest request, MethodArgumentNotValidException exception) {
        String path = request.getRequestURI();
        ErrorResponse exceptionMessage = ErrorResponse.of(path, exception.getMessage(), HttpStatus.BAD_REQUEST);
        logger.error("Method argument not valid: {}", exceptionMessage);
        return exceptionMessage.toResponseEntity();
    }

}
