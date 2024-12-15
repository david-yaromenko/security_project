package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.RoleEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RequiredArgsConstructor
@RestController
public class MyController {
    private final UserService userService;

    @GetMapping("/public/greeting")
    public String publicGreeting() {
        return "PUBLIC Hello World, " + userService.getUserName().orElse("");
    }

    @GetMapping("/api/greeting")
    public String authenticatedGreeting() {
        return "AUTHENTICATED Hello World, " + userService.getUserName().orElse("");
    }

    @GetMapping("/api/admin/greeting")
    public String adminGreeting() {
        return "AUTHENTICATED ADMIN Hello World, " + userService.getUserName().orElse("");
    }

    @PostMapping("/registration")
    public String registration(@RequestBody UserDTO userDTO) throws Exception {
        var newUser = new UserEntity();
        newUser.setUsername(userDTO.username());
        newUser.setPassword(userDTO.password());
        if(userService.saveUser(newUser))
            System.out.println("GOOD");
        else
            System.out.println("BAD");
        return "Welcome, " + newUser.getUsername();
    }


}
