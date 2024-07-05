package com.example.demo.controllers;

import com.example.demo.controllers.dto.UserDto;
import com.example.demo.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/create")
    public String register(@RequestBody UserDto dto) throws UserDetailsServiceImpl.UserAlreadyRegisteredException {
        return userDetailsService.registerUser(dto.username(), passwordEncoder.encode(dto.password()));
    }

    @ExceptionHandler(UserDetailsServiceImpl.UserAlreadyRegisteredException.class)
    public ResponseEntity<String> handle() {
        return new ResponseEntity<>("User already registered", HttpStatusCode.valueOf(400));
    }
}
