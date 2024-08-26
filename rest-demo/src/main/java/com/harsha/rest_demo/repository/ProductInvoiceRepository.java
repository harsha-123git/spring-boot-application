package com.harsha.rest_demo.repository;

import com.harsha.rest_demo.model.ProductInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductInvoiceRepository extends JpaRepository<ProductInvoice,Long> {
     List<ProductInvoice> findByPName(String pName);

     Optional<ProductInvoice> findById(int i);
}
