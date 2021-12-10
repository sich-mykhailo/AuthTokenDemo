package com.authtokendemo.security;

import com.authtokendemo.exception.AuthenticationException;
import com.authtokendemo.model.Employee;
import com.authtokendemo.model.dto.GoogleLoginDto;
import com.authtokendemo.service.GoogleService;
import java.io.IOException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    public static final String NERDY_DOMAIN = "nerdysoft.com";
    private final GoogleService googleService;


    public AuthenticationServiceImpl(GoogleService googleService) {
        this.googleService = googleService;
    }

    @Override
    public Employee login(GoogleLoginDto googleLoginDto) throws AuthenticationException, IOException {
        Employee employee = googleService.getEmployeeFromToken(googleLoginDto);
        String employeeDomain = employee.getEmail().substring(employee.getEmail().indexOf("@") + 1);
        if (NERDY_DOMAIN.equals(employeeDomain)) {
            return employee;
        }
        throw new AuthenticationException("Incorrect domain!!");
    }
}
