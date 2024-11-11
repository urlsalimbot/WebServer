package com.DDPointofSale.domain.transaction;

import com.DDPointofSale.domain.customer.Customer;
import com.DDPointofSale.domain.sales.Sale;
import jdk.jfr.DataAmount;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class TransactionDTO implements Serializable {
    public int id;
    public Customer customerid;
    public BigDecimal total;
    public BigDecimal payment;

    public List<Sale> sales;

    public TransactionDTO() {
    }
}
