package com.DDPointofSale.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class LineChartDTO implements Serializable {
    private String date;
    private BigDecimal qty;
}
