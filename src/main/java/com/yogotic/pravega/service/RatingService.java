package com.yogotic.pravega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogotic.pravega.model.Car;
import com.yogotic.pravega.model.Rating;
import com.yogotic.pravega.model.User;
import com.yogotic.pravega.repository.CarRepository;
import com.yogotic.pravega.repository.UserRepository;
import com.yogotic.pravega.utils.PravegaRelationships;

@Service
public class RatingService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private Neo4jOperations template;
	
	@Transactional
	public void rate(Long userId, Long carId, int stars, String comment) {
		User user = userRepository.findOne(userId);
		Car car = carRepository.findOne(carId);
		Rating rating = template.createRelationshipBetween(user, car, Rating.class, PravegaRelationships.RATED, false);
		rating.setStars(stars);
		rating.setComment(comment);
		template.save(rating);
	}

}
