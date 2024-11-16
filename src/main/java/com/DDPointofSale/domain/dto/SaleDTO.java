package com.DDPointofSale.domain.dto;

import com.DDPointofSale.domain.dao.Sale;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO for {@link Sale}
 */
@Data
public class SaleDTO implements Serializable {
    private Integer quantity;
    private Integer productid;
}