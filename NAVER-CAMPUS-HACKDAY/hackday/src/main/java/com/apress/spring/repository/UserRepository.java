package com.apress.spring.repository;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.apress.spring.domain.User;

public interface UserRepository extends MongoRepository<User, String>{
	public ArrayList<User> findByUserIdLike(String word);
}
