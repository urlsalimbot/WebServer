package com.DDPointofSale.security.userauth;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserAuthDTO implements Serializable
{
    private String username;
    private String password;
    private String roles;

}
