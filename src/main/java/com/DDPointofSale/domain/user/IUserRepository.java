package com.DDPointofSale.domain.user;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {

    public List<User> getAllUsers();

    public List<User> getbyName(String username);

    public User addUser(User user);

    public Optional<User> getbyID(int id);
}
