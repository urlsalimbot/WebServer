package com.DDPointofSale.domain.dao;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "sales", schema = "public")
public class Sale implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sales_id_gen")
    @SequenceGenerator(name = "sales_id_gen", sequenceName = "sales_saleid_seq", allocationSize = 1)
    @Column(name = "saleid", nullable = false)
    @JsonIgnore
    private Integer id;

    @Column(name = "date")
    private final Instant date = Instant.now().truncatedTo(ChronoUnit.SECONDS);

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "emp_id")
    @JsonBackReference
    private User user;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "product_id")
    @JsonIncludeProperties({"id"})
    private Product product;

}