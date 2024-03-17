package com.reddit.subreddit.model;

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
public class Subreddit {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private User createdBy;
}
