package com.reddit.subreddit.repository;

import com.reddit.subreddit.model.Subreddit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISubredditRepository extends MongoRepository<Subreddit, Long> {
}
