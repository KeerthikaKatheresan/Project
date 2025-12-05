package entities;

import enums.VehicleType;

public class Vehicle {

	private String vehicleRegNo;
	private String brand;
	private double purchaseCost;
	private int maxVelocity;
	private int capacity;
	private VehicleType typeOfVehicle;
	private double vehicleTax;

	/**
	* 
	*/
	public Vehicle() {
		super();
	}

	/**
	 * @param vehicleRegNo
	 * @param brand
	 * @param purchaseCost
	 * @param maxVelocity
	 * @param capacity
	 * @param typeOfVehicle
	 */
	public Vehicle(String vehicleRegNo, String brand, double purchaseCost, int maxVelocity, int capacity,
			VehicleType typeOfVehicle) {
		super();
		this.vehicleRegNo = vehicleRegNo;
		this.brand = brand;
		this.purchaseCost = purchaseCost;
		this.maxVelocity = maxVelocity;
		this.capacity = capacity;
		this.typeOfVehicle = typeOfVehicle;
		this.vehicleTax=0;
	}

	public String getVehicleRegNo() {
		return vehicleRegNo;
	}

	public String getBrand() {
		return brand;
	}

	public double getPurchaseCost() {
		return purchaseCost;
	}

	public int getMaxVelocity() {
		return maxVelocity;
	}

	public int getCapacity() {
		return capacity;
	}

	public VehicleType getTypeOfVehicle() {
		return typeOfVehicle;
	}
	
	public double getVehicleTax()
	{
		return vehicleTax;
	}

	
	public void setVehicleTax(double vehicleTax) {
		this.vehicleTax = vehicleTax;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleRegNo=" + vehicleRegNo + ", brand=" + brand + ", purchaseCost=" + purchaseCost
				+ ", maxVelocity=" + maxVelocity + ", capacity=" + capacity + ", typeOfVehicle=" + typeOfVehicle + "]";
	}

}
