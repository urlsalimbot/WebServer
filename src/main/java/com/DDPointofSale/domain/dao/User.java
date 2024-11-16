package com.DDPointofSale.domain.dao;


import com.DDPointofSale.security.userauth.UserAuth;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empid", nullable = false)
    private Integer empID;


    @Column(name = "fname", nullable = false)
    private String fName;

    @Column(name = "lname", nullable = false)
    private String lName;

    @Column(name = "email")
    private String email;

    @Column(name = "job", nullable = false)
    private String job;

    @Column(name = "manager")
    private String manager;

    @Column(name = "phone")
    private String phone;

    @Column(name = "hiredate")
    private Date hiredate;

    @Column(name = "createdAt", nullable = false)
    @CreationTimestamp
    private final Instant createdAt = Instant.now().truncatedTo(ChronoUnit.SECONDS);

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username")
    @JsonManagedReference
    private UserAuth userAuth;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Sale> sales;

}