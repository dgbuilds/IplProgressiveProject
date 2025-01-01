package com.wecp.progressive.controller;

import com.wecp.progressive.dto.LoginRequest;
import com.wecp.progressive.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserLoginController {
    public ResponseEntity<User> registerUser(User user) {
        return null;
    }

    public ResponseEntity loginUser(LoginRequest loginRequest) {
        return null;
    }
}
