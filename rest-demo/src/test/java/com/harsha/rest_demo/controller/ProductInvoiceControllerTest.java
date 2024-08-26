package com.harsha.rest_demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.harsha.rest_demo.model.ProductInvoice;
import com.harsha.rest_demo.service.ProductInvoiceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductInvoiceController.class)
class ProductInvoiceControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductInvoiceService productInvoiceService;
    ProductInvoice productInvoiceone;
    ProductInvoice productInvoicetwo;
    List<ProductInvoice> productInvoiceList= new ArrayList<>();


    @BeforeEach
    void setUp() {
        productInvoiceone = new ProductInvoice(12,"Laptop","hp","yes");
        productInvoicetwo = new ProductInvoice(13,"mobile","iphone","yes");
        productInvoiceList.add(productInvoiceone);
        productInvoiceList.add(productInvoicetwo);
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void getProductInvoiceDetails() throws Exception {
        when(productInvoiceService.getProductInvoice(12))
                .thenReturn(productInvoiceone);
        this.mockMvc.perform(get("/productinvoice/12"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void getAllProductInvoiceDetails() throws  Exception {
        when(productInvoiceService.getAllProductInvoice())
                .thenReturn(productInvoiceList);
        this.mockMvc.perform(get("/productinvoice/12")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    void createProductInvoiceDetails() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(productInvoiceone);

        when(productInvoiceService.createProductInvoice(productInvoiceone))
                .thenReturn("success");
        this.mockMvc.perform(post("/productinvoice/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void updateProductInvoiceDetails() throws Exception{
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
            ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
            String requestJson=ow.writeValueAsString(productInvoiceone);

            when(productInvoiceService.updateProductInvoice(productInvoiceone))
                    .thenReturn("product invoice Updated Successfully");
            this.mockMvc.perform(put("/productinvoice")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(requestJson))
                    .andDo(print()).andExpect(status().isOk());
        }

    @Test
    void deleteProductInvoiceDetails() throws Exception {
        when(productInvoiceService.deleteProductInvoice(12))
                .thenReturn("success");
        this.mockMvc.perform(delete("/productInvoice/")).andDo(print()).andExpect(status().isOk());
    }
}