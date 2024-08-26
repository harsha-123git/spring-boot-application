package com.harsha.rest_demo.service.impl;

import com.harsha.rest_demo.exception.ProductInvoiceNotFoundException;
import com.harsha.rest_demo.model.ProductInvoice;
import com.harsha.rest_demo.repository.ProductInvoiceRepository;
import com.harsha.rest_demo.service.ProductInvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductInvoiceServiceImpl implements ProductInvoiceService {

    public ProductInvoiceServiceImpl(ProductInvoiceRepository productInvoiceRepository) {
        this.productInvoiceRepository = productInvoiceRepository;
    }

    ProductInvoiceRepository productInvoiceRepository;

    @Override
    public String createProductInvoice(ProductInvoice productInvoice) {
        productInvoiceRepository.save(productInvoice);
        return "Success";
    }

    @Override
    public String updateProductInvoice(ProductInvoice productInvoice) {
        productInvoiceRepository.save(productInvoice);
        return "success";
    }

    @Override
    public String deleteProductInvoice(long ProductInvoiceId) {
        productInvoiceRepository.deleteById(ProductInvoiceId);
        return "success";
    }

    @Override
    public ProductInvoice getProductInvoice(long ProductInvoiceId) {
        if(productInvoiceRepository.findById(ProductInvoiceId).isEmpty()){
            throw new ProductInvoiceNotFoundException("Requested product invoice doesn't exist");
        }
        return   productInvoiceRepository.findById(ProductInvoiceId).get();
    }

    @Override
    public List<ProductInvoice> getAllProductInvoice() {
        return productInvoiceRepository.findAll();
    }
}
