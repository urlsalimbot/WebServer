package com.DDPointofSale.domain.dto;

import com.DDPointofSale.domain.Purchasetype;
import com.DDPointofSale.domain.dao.Sale;
import com.DDPointofSale.domain.Paytype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionDTO implements Serializable {

    public BigDecimal total;
    public BigDecimal payment;
    public List<SaleDTO> sales;
    public String username;
}
