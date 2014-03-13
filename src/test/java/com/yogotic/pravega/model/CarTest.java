package com.yogotic.pravega.model;

import javax.validation.ValidationException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-config.xml")
@Transactional
public class CarTest {

	@Autowired
	private Neo4jTemplate template;

	@Test
	public void testValidations() {
		Car car = new Car("", 11, 11, 11, 11, 11, 11, FuelType.PETROL, 11, 11, 11);
		try {
			template.save(car);
			Assert.fail("Should throw validation exception");
		} catch (ValidationException validationException) {
		}
		car.setVehicleName(null);
		try {
			template.save(car);
			Assert.fail("Should throw validation exception");
		} catch (ValidationException validationException) {
		}
	}

	@Test
	public void testCreateModifyDelete() {
		Car car = new Car("MyCar", 11, 11, 11, 11, 11, 11, FuelType.PETROL, 11, 11, 11);
		Car carSaved = template.save(car);
		Car carRetrieved = template.findOne(carSaved.getId(), Car.class);
		Assert.assertNotNull(carRetrieved);
		Assert.assertEquals(carSaved, carRetrieved);
		carRetrieved.setVehicleName("MySecondCar");
		carSaved = template.save(carRetrieved);
		carRetrieved = template.findOne(carSaved.getId(), Car.class);
		Assert.assertEquals(carSaved, carRetrieved);
		template.delete(carRetrieved);
	}
	
}
