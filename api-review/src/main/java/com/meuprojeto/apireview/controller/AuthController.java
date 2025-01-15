package com.meuprojeto.apireview.controller;

import com.meuprojeto.apireview.model.User;
import com.meuprojeto.apireview.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        // futuro: validate user, encode password, etc.
        User newUser = userService.registerUser(user);
        return ResponseEntity.ok(newUser);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        // futuro: valida user, gera JWT, etc.
        return ResponseEntity.ok("Simulação de login - JWT não implementado ainda");
    }
}
