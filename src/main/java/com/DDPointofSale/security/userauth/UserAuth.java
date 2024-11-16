package com.DDPointofSale.security.userauth;

import com.DDPointofSale.domain.dao.User;
import com.DDPointofSale.security.RoleUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.common.aliasing.qual.Unique;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserAuth {

    @Id
    @Unique
    private String username;

    @JsonIgnore
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private RoleUser roles;

    @OneToOne(mappedBy = "userAuth", fetch = FetchType.EAGER)
    @JsonBackReference
    private User user;

}
