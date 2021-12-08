package com.authtokendemo.service;

import com.authtokendemo.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    Optional<User> findByEmail(String email);

    List<User> findAll();
}
