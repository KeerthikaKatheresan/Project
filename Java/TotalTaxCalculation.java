package services;

import entities.Property;
import entities.Vehicle;
import exceptions.InvalidInputException;

public class TotalTaxCalculation {
	private PropertyOperation propertyCalc;
	private VehicleOperation vehicleCalc;

	double propertyTax;
	double vehicleTax;

	public TotalTaxCalculation(PropertyOperation propertyCalc, VehicleOperation vehicleCalc) {
		super();
		this.propertyCalc = propertyCalc;
		this.vehicleCalc = vehicleCalc;

	}

	public void calculateTotalTax() {
		propertyTax = 0;
		vehicleTax = 0;
		for (Property p : propertyCalc.getProperties()) {
			propertyTax += p.getPropertyTax();
		}
		for (Vehicle v : vehicleCalc.getVehicles()) {
			vehicleTax += v.getVehicleTax();
		}
	}

	public void display() {
		System.out.println("Total property tax:" + propertyTax);
		System.out.println("Total vehicle tax:" + vehicleTax);
		System.out.println("Total tax:" + (propertyTax + vehicleTax));
	}

}
