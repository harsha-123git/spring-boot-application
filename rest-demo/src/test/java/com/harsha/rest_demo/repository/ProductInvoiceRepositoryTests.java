package com.harsha.rest_demo.repository;

import com.harsha.rest_demo.model.ProductInvoice;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class ProductInvoiceRepositoryTests {

    @Autowired
    private ProductInvoiceRepository productInvoiceRepository;
    ProductInvoice productInvoice;

    @BeforeEach
    void setUp() {
   productInvoice =new ProductInvoice(12,"laptop","hp","yes");
   productInvoiceRepository.save(productInvoice);
    }

    @AfterEach
    void tearDown() {
     productInvoice=null;
     productInvoiceRepository.deleteAll();
    }
    //Test case for success
    @Test
    void testFindByProductName_Found()
    {
      List<ProductInvoice> productInvoiceList=productInvoiceRepository.findByPName("Laptop");
      assertThat(productInvoiceList.get(0).getPid()).isEqualTo(productInvoice.getPid());
      assertThat(productInvoiceList.get(0).getPName()).isEqualTo(productInvoice.getPName());
    }

    //Test case for failure
    @Test
    void testFindByProductName_NotFound()
    {
        List<ProductInvoice> productInvoiceList=productInvoiceRepository.findByPName("Mobile");
        assertThat(productInvoiceList.isEmpty()).isTrue();
    }
}
