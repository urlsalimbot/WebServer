package com.DDPointofSale.domain.dao;

import com.DDPointofSale.domain.Paytype;
import com.DDPointofSale.domain.Purchasetype;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_id_gen")
    @SequenceGenerator(name = "transaction_id_gen", sequenceName = "transaction_transacid_seq", allocationSize = 1)
    @Column(name = "transacid", nullable = false)
    private Integer id;

    @Column(name = "total", precision = 8, scale = 2)
    private BigDecimal total;

    @Column(name = "payment", precision = 8, scale = 2)
    private BigDecimal payment;

    @Column(name = "change", precision = 8, scale = 2)
    private BigDecimal change;

    @Column(name = "transactiondate", nullable = false)
    private final Instant transactiondate = Instant.now().truncatedTo(ChronoUnit.SECONDS);

    @Enumerated(EnumType.STRING)
    private Paytype paytype;

    @Enumerated(EnumType.STRING)
    private Purchasetype purchasetype;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private Customer customer_id;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable
    @JsonManagedReference
    private List<Sale> sales;
}