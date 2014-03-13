package com.yogotic.pravega.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedToVia;

import com.yogotic.pravega.utils.PravegaRelationships;

@NodeEntity
public class Car implements Comparable<Car>{
	@GraphId
	private Long id;
	@Indexed(unique=true)
	@NotNull @NotBlank
	private String vehicleName;
	private int length;
	private int width;
	private int height;
	private int weight;
	private int capacity;
	private int fuelTankCapacity;
	private FuelType fuelType;
	private int maxPower;
	private int noOfGears;
	private int displacement;
	
	@RelatedToVia(type=PravegaRelationships.RATED, direction=Direction.INCOMING)
	@Fetch private Set<Rating> ratings;
	
	@RelatedToVia(type=PravegaRelationships.TAGGED, direction=Direction.INCOMING)
	@Fetch private Set<Tagging> taggings;
	
	public Car() {}

	public Car(String vehicleName, int length, int width, int height,
			int weight, int capacity, int fuelTankCapacity, FuelType fuelType,
			int maxPower, int noOfGears, int displacement) {
		super();
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

	public FuelType getFuelType() {
		return fuelType;
	}

	public void setFuelType(FuelType fuelType) {
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
	
	public int getStars() {
		if (ratings == null) return 0;
        int stars=0, count=0;
        for (Rating rating : ratings) {
            stars += rating.getStars();
            count++;
        }
        return count==0 ? 0 : stars / count;
	}

	public Set<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(Set<Rating> ratings) {
		this.ratings = ratings;
	}

	public Set<Tagging> getTaggings() {
		return taggings;
	}

	public void setTaggings(Set<Tagging> taggings) {
		this.taggings = taggings;
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
		Car other = (Car) obj;
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
		return "Car [id=" + id + ", vehicleName=" + vehicleName + ", length="
				+ length + ", width=" + width + ", height=" + height
				+ ", weight=" + weight + ", capacity=" + capacity
				+ ", fuelTankCapacity=" + fuelTankCapacity + ", fuelType="
				+ fuelType + ", maxPower=" + maxPower + ", noOfGears="
				+ noOfGears + ", displacement=" + displacement + "]";
	}

	public int compareTo(Car o) {
		return this.vehicleName.compareTo(o.vehicleName);
	}

	public void setId(Long id) {
		this.id = id;
	}

}
