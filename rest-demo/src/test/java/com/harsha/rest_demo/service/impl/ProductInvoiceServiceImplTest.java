package com.harsha.rest_demo.service.impl;

import com.harsha.rest_demo.model.ProductInvoice;
import com.harsha.rest_demo.repository.ProductInvoiceRepository;
import com.harsha.rest_demo.service.ProductInvoiceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ProductInvoiceServiceImplTest {

    @Mock
    private ProductInvoiceRepository productInvoiceRepository;
    private ProductInvoiceService productInvoiceService;
    AutoCloseable autoCloseable;
    ProductInvoice productInvoice;

    @BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        productInvoiceService=new ProductInvoiceServiceImpl(productInvoiceRepository);
          productInvoice = new ProductInvoice(12, "laptop", "dell", "yes");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    @Test
    void createProductInvoice() {
        mock(ProductInvoice.class);
        mock(ProductInvoiceRepository.class);
        when(productInvoiceRepository.save(productInvoice)).thenReturn(productInvoice);
        assertThat(productInvoiceService.createProductInvoice(productInvoice)).isEqualTo("success");
    }

    @Test
    void updateProductInvoice() {
        mock(ProductInvoice.class);
        mock(ProductInvoiceRepository.class);
        when(productInvoiceRepository.save(productInvoice)).thenReturn(productInvoice);
        assertThat(productInvoiceService.updateProductInvoice(productInvoice)).isEqualTo("success");
    }

    @Test
    void deleteProductInvoice() {
        mock(ProductInvoice.class);
        mock(ProductInvoiceRepository.class, Mockito.CALLS_REAL_METHODS);
        doAnswer(Answers.CALLS_REAL_METHODS).when(productInvoiceRepository).deleteById(any());
        assertThat(productInvoiceService.deleteProductInvoice(12)).isEqualTo("Success");
    }

    @Test
    void getProductInvoice() {
        mock(ProductInvoice.class);
        mock(ProductInvoiceRepository.class);
        when(productInvoiceRepository.findById(12)).thenReturn(Optional.ofNullable(productInvoice));
        assertThat(productInvoiceService.getProductInvoice(12).getPName()).isEqualTo(productInvoice.getPName());
    }

    @Test
    void getAllProductInvoice() {
        mock(ProductInvoice.class);
        mock(ProductInvoiceRepository.class);
        when(productInvoiceRepository.findAll()).thenReturn(new ArrayList<ProductInvoice>
                (Collections.singleton(productInvoice)));
        assertThat(productInvoiceService.getAllProductInvoice().get(0).getPName())
                .isEqualTo(productInvoice.getPName());
    }
}