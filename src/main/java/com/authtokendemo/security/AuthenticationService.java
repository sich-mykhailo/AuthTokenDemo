package com.authtokendemo.security;


import com.authtokendemo.exception.AuthenticationException;
import com.authtokendemo.model.User;

public interface AuthenticationService {
    User register(String email, String password);

    User login(String login, String password) throws AuthenticationException;
}
