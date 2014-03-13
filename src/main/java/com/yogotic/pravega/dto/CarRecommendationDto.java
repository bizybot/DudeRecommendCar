package com.yogotic.pravega.dto;

public class CarRecommendationDto {

	private String carName;
	private int avgStars;
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public int getAvgStars() {
		return avgStars;
	}
	public void setAvgStars(int avgStars) {
		this.avgStars = avgStars;
	}
	public CarRecommendationDto(String carName, int avgStars) {
		super();
		this.carName = carName;
		this.avgStars = avgStars;
	}
	public CarRecommendationDto() {
		super();
	}
}
