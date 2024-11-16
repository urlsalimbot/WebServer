package com.DDPointofSale.domain.dto;

import com.DDPointofSale.domain.Purchasetype;
import com.DDPointofSale.domain.dao.Sale;
import com.DDPointofSale.domain.Paytype;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class TransactionDTO implements Serializable {

    public BigDecimal total;
    public BigDecimal payment;
    public Paytype paytype;
    public Purchasetype purchasetype;
    public List<SaleDTO> sales;
    public String username;
}
