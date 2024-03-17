package com.reddit.post.model;

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
public class Post {
    private Long id;
    private String name;
    private String description;
    private String url;
    private Integer voteCount;
    private User createdBy;
    private LocalDateTime createdAt;
}
