package com.WebServTest.domain.repository;

import com.WebServTest.domain.User;

import java.util.List;
import java.util.Optional;

/**
 * Repository dealing with Users.
 */
public interface UserRepository {

    List<User> readUsers();

    Optional<User> readUser(String username);

}