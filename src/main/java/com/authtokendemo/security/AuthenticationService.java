package com.authtokendemo.security;


import com.authtokendemo.exception.AuthenticationException;
import com.authtokendemo.model.Employee;
import com.authtokendemo.model.dto.GoogleLoginDto;
import java.io.IOException;

public interface AuthenticationService {
    Employee login(GoogleLoginDto googleLoginDto) throws AuthenticationException, IOException;
}
