package com.reddit.post.repository;

import com.reddit.post.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPostInterface extends MongoRepository<Post, Long> {
}
