package com.DDPointofSale.domain.dao;

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
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @Column(name = "categoryid", nullable = false)
    private Integer id;

    @Column(name = "catename", length = 25)
    private String catename;

    @Column(name = "catedesc", length = 75)
    private String catedesc;

    @OneToMany(mappedBy = "categoryid", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Product> products;


}