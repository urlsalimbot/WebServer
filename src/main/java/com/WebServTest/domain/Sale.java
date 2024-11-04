package com.WebServTest.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "sales", schema = "public")
public class Sale {
    @Column(name = "prodid")
    private Integer prodid;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customerid")
    private Customer customerid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "empid")
    private User empid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transacid")
    private Transaction transacid;

    public Integer getProdid() {
        return prodid;
    }

    public void setProdid(Integer prodid) {
        this.prodid = prodid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public User getEmpid() {
        return empid;
    }

    public void setEmpid(User empid) {
        this.empid = empid;
    }

    public Transaction getTransacid() {
        return transacid;
    }

    public void setTransacid(Transaction transacid) {
        this.transacid = transacid;
    }

}