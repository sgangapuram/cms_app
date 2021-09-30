package com.srione.cms.api;

import com.srione.cms.exception.ApplicationError;
import com.srione.cms.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @Value("${api_doc_url}")
    private String details;

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError> handleCustomerNotFoundException(CustomerNotFoundException exception, WebRequest request){
        ApplicationError error = new ApplicationError();
        error.setErrorMessage("The customer you are trying to fetch is not available");
        error.setStatusCode(404);
        error.setDetails(details);
        //here we are setting  HttpStatus.NOT_FOUND 404 so not needed in Exception class
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
