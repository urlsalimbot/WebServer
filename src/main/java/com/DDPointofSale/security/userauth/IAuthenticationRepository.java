package com.DDPointofSale.security.userauth;

public interface IAuthenticationRepository {
    public UserAuth getbyUsername(String username);
    public void save(UserAuth user);
}
