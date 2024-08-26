package com.harsha.rest_demo.service;

import com.harsha.rest_demo.model.ProductInvoice;

import java.util.List;

public interface ProductInvoiceService {
    public String createProductInvoice(ProductInvoice productInvoice);
    public String updateProductInvoice(ProductInvoice productInvoice);
    public String deleteProductInvoice(long ProductInvoiceId);
    public ProductInvoice getProductInvoice(long ProductInvoiceId);
     public List<ProductInvoice> getAllProductInvoice();
}
