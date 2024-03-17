package com.reddit.comment.repository;

import com.reddit.comment.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICommentRepository extends MongoRepository<Comment, Long> {
}
