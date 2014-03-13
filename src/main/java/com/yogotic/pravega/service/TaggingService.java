package com.yogotic.pravega.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogotic.pravega.model.Car;
import com.yogotic.pravega.model.Tagging;
import com.yogotic.pravega.model.User;
import com.yogotic.pravega.repository.CarRepository;
import com.yogotic.pravega.repository.UserRepository;
import com.yogotic.pravega.utils.PravegaRelationships;

@Service
public class TaggingService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private Neo4jOperations template;

	@Transactional
	public void rate(Long userId, Long carId, String tag) {
		User user = userRepository.findOne(userId);
		Car car = carRepository.findOne(carId);
		Tagging tagging = template.createRelationshipBetween(user, car, Tagging.class, PravegaRelationships.TAGGED, false);
		tagging.setTag(tag);
		template.save(tagging);
	}
}
