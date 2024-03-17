package com.reddit.vote.repository;

import com.reddit.vote.model.Vote;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IVoteRepository extends MongoRepository<Vote, Long> {
}
