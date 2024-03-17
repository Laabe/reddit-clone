package com.reddit.subreddit;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ISubredditRepository extends MongoRepository<Subreddit, Long> {
}
