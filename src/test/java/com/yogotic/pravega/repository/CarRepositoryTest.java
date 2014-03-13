package com.yogotic.pravega.repository;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yogotic.pravega.model.Car;
import com.yogotic.pravega.model.FuelType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-config.xml")
@Transactional
public class CarRepositoryTest {
	
	@Autowired
	private CarRepository carRepository;

	@Test
	public void test() {
		Car car = new Car("MyCar", 11, 11, 11, 11, 11, 11, FuelType.PETROL, 11, 11, 11);
		Car savedCar = carRepository.save(car);
		Set<Car> retrievedCars = carRepository.findByVehicleNameContaining("My");
		Assert.assertEquals(1, retrievedCars.size());
		Assert.assertTrue(retrievedCars.contains(savedCar));
	}


}
