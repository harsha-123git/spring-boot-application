package com.harsha.rest_demo.controller;

import com.harsha.rest_demo.model.ProductInvoice;
import com.harsha.rest_demo.response.ResponseHandler;
import com.harsha.rest_demo.service.ProductInvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productinvoice")
public class ProductInvoiceController {

    ProductInvoiceService productInvoiceService;

    public ProductInvoiceController(ProductInvoiceService productInvoiceService) {
        this.productInvoiceService = productInvoiceService;
    }
//read specific product invoice from DB
    @GetMapping("{pid}")
    public ResponseEntity<Object> getProductInvoiceDetails(@PathVariable("pid") long pid)
    {
        return ResponseHandler.responseBuilder("Requested invoice details are given here", HttpStatus.OK,productInvoiceService.getProductInvoice(pid));
    }
//read all product invoices from DB
    @GetMapping()
    public List<ProductInvoice> getAllProductInvoiceDetails()
    {
    return productInvoiceService.getAllProductInvoice();
    }

    @PostMapping
    public String createProductInvoiceDetails(@RequestBody ProductInvoice productInvoice)
    {
        productInvoiceService.createProductInvoice(productInvoice);
      return "product invoice created successfully";
    }

    @PutMapping
    public String updateProductInvoiceDetails(@RequestBody ProductInvoice productInvoice)
    {
    productInvoiceService.updateProductInvoice(productInvoice);
    return "product invoice updated successfully";
    }

    @DeleteMapping("{pid}")
    public String deleteProductInvoiceDetails(@PathVariable("pid") long pid)
    {
        productInvoiceService.deleteProductInvoice(pid);
        return "product invoice deleted successfully";
    }
}