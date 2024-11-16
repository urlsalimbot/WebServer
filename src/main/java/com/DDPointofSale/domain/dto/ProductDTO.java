package com.DDPointofSale.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * DTO for {@link com.DDPointofSale.domain.dao.Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private Integer id;
    private String productname;
    private Integer stock;
    private BigDecimal price;
    private Integer categoryidId;
}