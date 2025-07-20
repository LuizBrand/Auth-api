package com.LuizBrand.AuthRoles.controller;

import com.LuizBrand.AuthRoles.dto.request.UserRequest;
import com.LuizBrand.AuthRoles.dto.response.LoginResponse;
import com.LuizBrand.AuthRoles.dto.response.UserResponse;
import com.LuizBrand.AuthRoles.services.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody UserRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.registerUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody UserRequest request) {
        return ResponseEntity.ok().body(authService.login(request));
    }

}
