package com.DDPointofSale.domain.user;

import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

public class UserService {
    IUserRepository userRepo;

    @Inject
    public UserService(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAll() {
        return userRepo.getAllUsers();
    }

    public User addUser(User user) {
        return userRepo.addUser(user);
    }

    public List<User> getUserbyName(String name){
        return userRepo.getbyName(name);
    }

    public Optional<User> getUserbyID(int id) {
        return userRepo.getbyID(id);
    }
}
