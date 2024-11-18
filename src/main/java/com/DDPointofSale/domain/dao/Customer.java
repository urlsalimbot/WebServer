package com.DDPointofSale.domain.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_gen")
    @SequenceGenerator(name = "customer_id_gen", sequenceName = "customer_customerid_seq", allocationSize = 1)
    @Column(name = "customerid", nullable = false)
    private Integer customerid;

    @Column(name = "name")
    private String name;

    @Column(name = "addr")
    private String addr;

    @Column(name = "phone", length = 20)
    private String phone;

    @OneToOne()
    @JsonIgnore
    private Transaction transaction;
}