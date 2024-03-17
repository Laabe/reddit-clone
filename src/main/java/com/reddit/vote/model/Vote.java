package com.reddit.vote.model;

import com.reddit.post.model.Post;
import com.reddit.user.model.User;
import com.reddit.vote.enums.VoteType;
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
public class Vote {
    private Long id;
    private VoteType voteType;
    private Post post;
    private User createdBy;
}
