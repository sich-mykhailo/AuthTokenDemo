package com.authtokendemo.security;

import com.authtokendemo.model.User;
import com.authtokendemo.service.UserService;
import java.util.Optional;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByEmail(email);

        UserBuilder builder;
        if (userOptional.isPresent()) {
            builder = org.springframework.security.core.userdetails.User.withUsername(email);
            builder.password(userOptional.get().getPassword());
            builder.roles("USER");
            return builder.build();
        }
        throw new UsernameNotFoundException("User not found.");
    }
}
