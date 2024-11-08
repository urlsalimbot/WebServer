package com.WebServTest.domain.repository;

import com.WebServTest.domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private static final Map<String, User> users = new HashMap<>();

    @Override
    public List<User> readUsers() {
        return List.of();
    }

    /**
     * @param username
     * @return
     */
    @Override
    public Optional<User> readUser(String username) {
        return Optional.empty();
    }
}
