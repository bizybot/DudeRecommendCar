package com.yogotic.pravega.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yogotic.pravega.converter.CarDtoConverter;
import com.yogotic.pravega.dto.CarDto;
import com.yogotic.pravega.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CarDtoConverter carDtoConverter;
	
	@Transactional
	public CarDto saveCar(CarDto carDto) {
		return carDtoConverter.fromDo(carRepository.save(carDtoConverter.toDo(carDto)));
	}
	
	@Transactional
	public void deleteCar(Long id) {
		carRepository.delete(id);
	}
	
	@Transactional
	public CarDto getCar(Long id) {
		return carDtoConverter.fromDo(carRepository.findOne(id));
	}
	
	@Transactional
	public Set<CarDto> getAllCars() {
		return carDtoConverter.fromDo(carRepository.findAll().as(Set.class));
	}
	
	@Transactional
	public Set<CarDto> searchCar(String carName) {
		return carDtoConverter.fromDo(carRepository.findByVehicleNameContaining(carName));
	}
}
