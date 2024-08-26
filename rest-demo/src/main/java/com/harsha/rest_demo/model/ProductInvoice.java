package com.harsha.rest_demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="product_invoice")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class ProductInvoice {
    @Id
    private long pid;
    private String pName;
    private String pBrand;
    private String warranty;
}
