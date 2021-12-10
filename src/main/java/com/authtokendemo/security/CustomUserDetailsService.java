package com.authtokendemo.security;

import com.authtokendemo.model.Employee;
import com.authtokendemo.service.EmployeeService;
import java.util.Optional;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final EmployeeService employeeService;

    public CustomUserDetailsService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Employee> userOptional = employeeService.findEmployeeByEmail(email);

        UserBuilder builder;
        if (userOptional.isPresent()) {
            builder = org.springframework.security.core.userdetails.User.withUsername(email);
            builder.roles("USER");
            builder.password("1234");
            return builder.build();
        }
        throw new UsernameNotFoundException("Employee not found.");
    }
}
