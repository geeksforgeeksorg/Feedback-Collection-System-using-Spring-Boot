package com.app;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepo extends MongoRepository<FeedBack, String> {
	long countByCategory(String category);
}
