package com.yogotic.pravega.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.yogotic.pravega.dto.CarDto;
import com.yogotic.pravega.dto.UserRatingDto;
import com.yogotic.pravega.dto.UserTagDto;
import com.yogotic.pravega.model.Car;
import com.yogotic.pravega.model.FuelType;
import com.yogotic.pravega.model.Rating;
import com.yogotic.pravega.model.Tagging;

@Component
public class CarDtoConverter {

	public Set<CarDto> fromDo(Set<Car> cars) {
		Set<CarDto> carsDto = new HashSet<CarDto>();
		for(Car car:cars) {
			carsDto.add(fromDo(car));
		}
		return carsDto;
	}
	
	public CarDto fromDo(Car car) {
		CarDto dto = new CarDto(car.getId(), 
				car.getVehicleName(),
				car.getLength(),
				car.getWidth(),
				car.getHeight(),
				car.getWeight(), 
				car.getCapacity(),
				car.getFuelTankCapacity(),
				car.getFuelType().name(),
				car.getMaxPower(),
				car.getNoOfGears(),
				car.getDisplacement());
		
		Set<UserRatingDto> ratings = new HashSet<UserRatingDto>();
		for(Rating rating : car.getRatings()) {
			ratings.add(new UserRatingDto(rating.getUser().getUserName(), rating.getStars(), rating.getComment()));
		}
		dto.setRatings(ratings);
		Set<UserTagDto> tags = new HashSet<UserTagDto>();
		for(Tagging tagging : car.getTaggings()) {
			tags.add(new UserTagDto(tagging.getUser().getUserName(), tagging.getTag()));
		}
		dto.setTags(tags);
		dto.setAvgRating(car.getStars());
		return dto;
		
	}
	public Car toDo(CarDto dto) {
		return new Car( 
				dto.getVehicleName(),
				dto.getLength(),
				dto.getWidth(),
				dto.getHeight(),
				dto.getWeight(), 
				dto.getCapacity(),
				dto.getFuelTankCapacity(),
				FuelType.valueOf(dto.getFuelType()),
				dto.getMaxPower(),
				dto.getNoOfGears(),
				dto.getDisplacement());
	}
}
