package com.reddit.auth.controller;

import com.reddit.auth.dto.RegisterRequest;
import com.reddit.auth.service.AuthService;
import com.reddit.email.exception.SpringRedditException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(path = "/account-verification/{token}")
    public ResponseEntity<String> verifyAccount(@PathVariable String token) throws SpringRedditException {
        authService.verifyAccount(token);
        return new ResponseEntity<>("User Activated Successfully", HttpStatus.OK);
    }
}
