package com.mmelero.wokshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mmelero.wokshopmongo.domain.User;

@Repository
public interface UserRepository  extends MongoRepository<User, String>{

	
	
}
