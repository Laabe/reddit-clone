package com.reddit.auth.service;

import ch.qos.logback.core.subst.Token;
import com.reddit.auth.dto.RegisterRequest;
import com.reddit.email.exception.SpringRedditException;
import com.reddit.email.model.NotificationEmail;
import com.reddit.email.service.MailService;
import com.reddit.user.model.User;
import com.reddit.user.repository.IUserRepository;
import com.reddit.verificationToken.model.VerificationToken;
import com.reddit.verificationToken.repository.IVerificationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final IUserRepository userRepository;
    private final IVerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;

    public void signUp(RegisterRequest registerRequest) throws SpringRedditException {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setEmail(registerRequest.getEmail());
        user.setUsername(registerRequest.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);

        String token = generateVerificationToken(user);

        mailService.sendMail(
                new NotificationEmail(
                        "Please activate your account",
                        user.getEmail(),
                        "Thank you for signing up to Reddit, please click on the link below to activate your account: "
                                + "http://localhost:8080/api/auth/account-verification/" + token)
        );
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setId(UUID.randomUUID().toString());
        verificationToken.setToken(token);
        verificationToken.setUser(user);
        verificationTokenRepository.save(verificationToken);
        return token;
    }

    public void verifyAccount(String token) throws SpringRedditException {
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        verificationToken.orElseThrow(() -> new SpringRedditException("Invalid Token"));
        fetchUserAndEnable(verificationToken.get());
    }

    private void fetchUserAndEnable(VerificationToken verificationToken) throws SpringRedditException {
        User user = verificationToken.getUser();
        User fetchedUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new SpringRedditException("User Not Found"));
        fetchedUser.setEnabled(true);
        userRepository.save(fetchedUser);
    }


}
