package com.reddit.verificationToken.model;

import com.reddit.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class VerificationToken {
    private String id;
    private String token;
    private User user;
    private LocalDateTime expireAt;
}
