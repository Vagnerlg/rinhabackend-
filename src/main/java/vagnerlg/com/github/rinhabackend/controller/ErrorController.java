package vagnerlg.com.github.rinhabackend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vagnerlg.com.github.rinhabackend.controller.exception.NotFoundException;

@RestControllerAdvice
public class ErrorController {
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handleValidationExceptions(
            MethodArgumentNotValidException ex) {

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public void handleEntityNotFoundException(
            NotFoundException ex) {

    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(IllegalArgumentException.class)
    public void handleIllegalArgumentException(
            IllegalArgumentException ex) {

    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public void httpMessageNotReadableException(
            HttpMessageNotReadableException ex) {

    }
}
