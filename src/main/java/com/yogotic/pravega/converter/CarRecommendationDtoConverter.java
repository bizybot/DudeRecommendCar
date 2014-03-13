package com.yogotic.pravega.converter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.yogotic.pravega.dto.CarRecommendationDto;
import com.yogotic.pravega.model.CarRecommendation;

@Component
public class CarRecommendationDtoConverter {

	public Set<CarRecommendationDto> fromDo(List<CarRecommendation> carRecommendations) {
		Set<CarRecommendationDto> recos = new HashSet<CarRecommendationDto>();
		for(CarRecommendation reco : carRecommendations)
			recos.add(new CarRecommendationDto(reco.getCar().getVehicleName(), reco.getRating()));
		return recos;
	}
}
