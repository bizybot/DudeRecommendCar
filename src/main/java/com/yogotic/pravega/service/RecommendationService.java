package com.yogotic.pravega.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogotic.pravega.converter.CarRecommendationDtoConverter;
import com.yogotic.pravega.dto.CarRecommendationDto;
import com.yogotic.pravega.repository.CarRepository;
import com.yogotic.pravega.repository.UserRepository;

@Service
public class RecommendationService {
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CarRecommendationDtoConverter converter;

	@Transactional
	public Set<CarRecommendationDto> getRecommendations(Long userId) {
		return converter.fromDo(carRepository.getRecommendations(userRepository.findOne(userId)));
	}
	
}
