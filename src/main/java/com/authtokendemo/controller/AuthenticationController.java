package com.authtokendemo.controller;

import com.authtokendemo.exception.AuthenticationException;
import com.authtokendemo.model.Employee;
import com.authtokendemo.model.dto.GoogleLoginDto;
import com.authtokendemo.security.AuthenticationService;
import com.authtokendemo.security.jwt.JwtTokenProvider;
import com.authtokendemo.service.EmployeeService;
import java.io.IOException;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtTokenProvider jwtTokenProvider;
    private final EmployeeService employeeService;


    public AuthenticationController(AuthenticationService authenticationService,
                                    JwtTokenProvider jwtTokenProvider, EmployeeService employeeService) {
        this.authenticationService = authenticationService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.employeeService = employeeService;
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody GoogleLoginDto googleLoginDto)
            throws AuthenticationException, IOException {
        Employee employee = authenticationService.login(googleLoginDto);
        String token = jwtTokenProvider.createToken(employee.getEmail());
        if(employeeService.findEmployeeByEmail(employee.getEmail()).isEmpty()) {
            employeeService.save(employee);
        }
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
