package com.company.U1M6Summative.controller;


import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ControllerExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> customerValidationError(MethodArgumentNotValidException e, WebRequest request) {
        BindingResult res = e.getBindingResult();
        List<FieldError> fieldErrors = res.getFieldErrors();

        List<VndErrors.VndError> vndErrorList = new ArrayList<>();

        for(FieldError fieldError : fieldErrors) {
            VndErrors.VndError vndError = new VndErrors.VndError(request.toString(), fieldError.getDefaultMessage());
            vndErrorList.add(vndError);
        }

        VndErrors vndErrors = new VndErrors(vndErrorList);

        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(vndErrors, HttpStatus.UNPROCESSABLE_ENTITY);

        return responseEntity;
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> outOfRangeException(IllegalArgumentException e, WebRequest request) {
        VndErrors err = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }

    @ExceptionHandler(value = {NumberFormatException.class})
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResponseEntity<VndErrors> numberFormatException(NumberFormatException e, WebRequest request) {
        VndErrors err = new VndErrors(request.toString(), e.getMessage());
        ResponseEntity<VndErrors> responseEntity = new ResponseEntity<>(err, HttpStatus.UNPROCESSABLE_ENTITY);
        return responseEntity;
    }
}
