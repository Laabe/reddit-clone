package com.reddit.verificationToken.repository;

import com.reddit.verificationToken.model.VerificationToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface IVerificationTokenRepository extends MongoRepository<VerificationToken, Long> {
    Optional<VerificationToken> findByToken(String token);
}
