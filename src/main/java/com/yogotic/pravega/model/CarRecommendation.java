package com.yogotic.pravega.model;

import org.springframework.data.neo4j.annotation.QueryResult;
import org.springframework.data.neo4j.annotation.ResultColumn;

@QueryResult
public interface CarRecommendation {

	@ResultColumn("otherCar")
	public Car getCar();
	
	@ResultColumn("rating")
	public int getRating();
}
