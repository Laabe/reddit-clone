package com.reddit.user.model;

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
public class User {
    private String id;
    private String email;
    private String username;
    private String password;
    private Boolean enabled = false;
    private LocalDateTime createdAt = LocalDateTime.now();
}
