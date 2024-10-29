package com.WebServTest.service.user;

import java.util.List;
import java.util.Optional;

/**
 * Repository dealing with Users.
 */
public interface UserRepository {

    List<User> readUsers();

    Optional<User> readUser(String username);

}