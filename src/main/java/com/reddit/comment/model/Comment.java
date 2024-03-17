package com.reddit.comment.model;

import com.reddit.post.model.Post;
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
public class Comment {
    private Long id;
    private String text;
    private Post post;
    private User createdBy;
    private LocalDateTime createdAt;
}
