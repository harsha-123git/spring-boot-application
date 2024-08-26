package com.harsha.rest_demo.exception;

public class ProductInvoiceNotFoundException extends  RuntimeException{
    public ProductInvoiceNotFoundException(String message) {
        super(message);
    }

    public ProductInvoiceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
