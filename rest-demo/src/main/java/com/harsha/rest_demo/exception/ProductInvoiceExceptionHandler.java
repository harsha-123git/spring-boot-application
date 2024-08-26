package com.harsha.rest_demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductInvoiceExceptionHandler {

    @ExceptionHandler(value={ProductInvoiceNotFoundException.class})

    public ResponseEntity <Object> handleProductInvoiceNotFoundException
            (ProductInvoiceNotFoundException productInvoiceNotFoundException)
    {
        ProductInvoiceException productInvoiceException=new ProductInvoiceException(
                productInvoiceNotFoundException.getMessage(),
                productInvoiceNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(productInvoiceException, HttpStatus.NOT_FOUND);
    }
}
