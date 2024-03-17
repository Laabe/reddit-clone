package com.reddit.verificationToken.repository;

import com.reddit.verificationToken.model.VerificationToken;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IVerificationTokenRepository extends MongoRepository<VerificationToken, Long> {
}
