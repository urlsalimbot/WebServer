package com.DDPointofSale.domain.dto;

import com.DDPointofSale.domain.dao.Sale;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

/**
 * DTO for {@link Sale}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SaleDTO implements Serializable {

    private Integer id;
    private String name;

    @JsonIgnore
    private BigDecimal price;

    private Integer qty;

    @JsonIgnore
    private String type;

    @JsonIgnore
    private String img;
}