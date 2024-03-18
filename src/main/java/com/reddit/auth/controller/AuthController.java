package com.reddit.auth.controller;

import com.reddit.auth.dto.RegisterRequest;
import com.reddit.auth.service.AuthService;
import com.reddit.email.exception.SpringRedditException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth")
@AllArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping(path = "/signup")
    public ResponseEntity<String> signUp(@RequestBody RegisterRequest registerRequest) throws SpringRedditException {
        authService.signUp(registerRequest);
        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
    }
}
