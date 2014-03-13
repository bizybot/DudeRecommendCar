package com.yogotic.pravega.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.neo4j.repository.RelationshipOperationsRepository;
import org.springframework.stereotype.Repository;

import com.yogotic.pravega.model.Car;
import com.yogotic.pravega.model.CarRecommendation;
import com.yogotic.pravega.model.User;

@Repository
public interface CarRepository extends GraphRepository<Car>, RelationshipOperationsRepository<Car> {

	
	public Set<Car> findByVehicleNameContaining(String vehicleName);
	
	@Query(
			"start user=node({0}) "+
					" match user-[r:RATED]->car<-[r2:RATED]-other-[r3:RATED]->otherCar "+
					" where r.stars >=3 and r2.stars >= r.stars and r3.stars >= r.stars "+
					" return otherCar, avg(r3.stars) as rating, count(*) as cnt"+
					" order by rating desc, cnt desc"
			)
	public List<CarRecommendation> getRecommendations(User user);

	@Query(
					" match user-[r:TAGGED]->car "+
					" where r.tag IN {0} "+
					" return car"
			)
	public List<Car> getTaggedCars(String[] tags);
}
