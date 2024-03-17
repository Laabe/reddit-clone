package com.reddit.subreddit;

import com.reddit.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Subreddit {
    private Long id;
    private String name;
    private String description;
    private User createdBy;
}
