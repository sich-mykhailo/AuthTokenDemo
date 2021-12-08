package com.authtokendemo.controller;

import com.authtokendemo.model.User;
import com.authtokendemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final UserService userService;

    public InjectController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String injectData() {

        // save users
        User bob = new User();
        bob.setEmail("bob");
        bob.setPassword("1234");
        userService.save(bob);

        User alice = new User();
        alice.setEmail("alice");
        alice.setPassword("1234");
        userService.save(alice);
        return "Done!";
    }
}
