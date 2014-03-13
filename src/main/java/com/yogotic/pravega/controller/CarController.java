package com.yogotic.pravega.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.yogotic.pravega.dto.CarDto;
import com.yogotic.pravega.service.CarService;

@Controller
@RequestMapping("/car")
public class CarController {
	@Autowired
	private CarService carService;

	@RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody CarDto saveCar(@RequestBody CarDto dto) {
		return carService.saveCar(dto);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCar(@PathVariable Long id) {
		carService.deleteCar(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody CarDto getCar(@PathVariable Long id) {
		return carService.getCar(id);
	}
	
	@RequestMapping(value = "/find/{carName}", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Set<CarDto> getCar(@PathVariable String carName) {
		return carService.searchCar(carName);
	}
	
	@RequestMapping(value = "/listAll", method = RequestMethod.GET, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody Set<CarDto> getAllCars() {
		return carService.getAllCars();
	}
}
