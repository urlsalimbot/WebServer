package com.WebServTest.domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "sales", schema = "public")
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_id_gen")
    @SequenceGenerator(name = "sales_id_gen", sequenceName = "sales_saleid_seq", allocationSize = 1)
    @Column(name = "saleid", nullable = false)
    private Integer id;

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

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transacid")
    private Transaction transacid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Transaction getTransacid() {
        return transacid;
    }

    public void setTransacid(Transaction transacid) {
        this.transacid = transacid;
    }

}