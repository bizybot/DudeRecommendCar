package com.yogotic.pravega.dto;

import java.util.Set;


public class CarDto {

	private Long id;
	private String vehicleName;
	private int length;
	private int width;
	private int height;
	private int weight;
	private int capacity;
	private int fuelTankCapacity;
	private String fuelType;
	private int maxPower;
	private int noOfGears;
	private int displacement;
	
	private int avgRating;
	private Set<UserRatingDto> ratings;
	private Set<UserTagDto> tags;
	
	public CarDto() {}
	public CarDto(Long id, String vehicleName, int length, int width,
			int height, int weight, int capacity, int fuelTankCapacity,
			String fuelType, int maxPower, int noOfGears, int displacement) {
		super();
		this.id = id;
		this.vehicleName = vehicleName;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.capacity = capacity;
		this.fuelTankCapacity = fuelTankCapacity;
		this.fuelType = fuelType;
		this.maxPower = maxPower;
		this.noOfGears = noOfGears;
		this.displacement = displacement;
	}


	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getFuelTankCapacity() {
		return fuelTankCapacity;
	}
	public void setFuelTankCapacity(int fuelTankCapacity) {
		this.fuelTankCapacity = fuelTankCapacity;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public int getMaxPower() {
		return maxPower;
	}
	public void setMaxPower(int maxPower) {
		this.maxPower = maxPower;
	}
	public int getNoOfGears() {
		return noOfGears;
	}
	public void setNoOfGears(int noOfGears) {
		this.noOfGears = noOfGears;
	}
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<UserRatingDto> getRatings() {
		return ratings;
	}
	public void setRatings(Set<UserRatingDto> ratings) {
		this.ratings = ratings;
	}
	public Set<UserTagDto> getTags() {
		return tags;
	}
	public void setTags(Set<UserTagDto> tags) {
		this.tags = tags;
	}
	public int getAvgRating() {
		return avgRating;
	}
	public void setAvgRating(int avgRating) {
		this.avgRating = avgRating;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + displacement;
		result = prime * result + fuelTankCapacity;
		result = prime * result
				+ ((fuelType == null) ? 0 : fuelType.hashCode());
		result = prime * result + height;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + length;
		result = prime * result + maxPower;
		result = prime * result + noOfGears;
		result = prime * result
				+ ((vehicleName == null) ? 0 : vehicleName.hashCode());
		result = prime * result + weight;
		result = prime * result + width;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CarDto other = (CarDto) obj;
		if (capacity != other.capacity)
			return false;
		if (displacement != other.displacement)
			return false;
		if (fuelTankCapacity != other.fuelTankCapacity)
			return false;
		if (fuelType != other.fuelType)
			return false;
		if (height != other.height)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (length != other.length)
			return false;
		if (maxPower != other.maxPower)
			return false;
		if (noOfGears != other.noOfGears)
			return false;
		if (vehicleName == null) {
			if (other.vehicleName != null)
				return false;
		} else if (!vehicleName.equals(other.vehicleName))
			return false;
		if (weight != other.weight)
			return false;
		if (width != other.width)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CarDto [id=" + id + ", vehicleName=" + vehicleName
				+ ", length=" + length + ", width=" + width + ", height="
				+ height + ", weight=" + weight + ", capacity=" + capacity
				+ ", fuelTankCapacity=" + fuelTankCapacity + ", fuelType="
				+ fuelType + ", maxPower=" + maxPower + ", noOfGears="
				+ noOfGears + ", displacement=" + displacement + ", avgRating="
				+ avgRating + ", ratings=" + ratings + ", tags=" + tags + "]";
	}
	
	
}
