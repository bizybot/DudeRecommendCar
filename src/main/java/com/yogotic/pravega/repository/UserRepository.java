package com.yogotic.pravega.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import org.springframework.stereotype.Repository;

import com.yogotic.pravega.model.User;

@Repository
public interface UserRepository extends GraphRepository<User>, RelationshipOperationsRepository<User> {

	public User findByUserName(String userName);

}
