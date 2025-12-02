package com.mphasis.TAX_CALULATION;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleTaxCalculation {
	private Scanner sc = new Scanner(System.in);
	private List<Vehicle> vehicles = new ArrayList<>();
	private int vehicleTax;
	private String vehicleRegNo;
	private String vehicleBrand;
	private String regex = "^(?!0000)\\d{4}$";
	private int maxVelocity = 0;
	private int capacity = 0;
	private int vehicleType;
	private double purchaseCost = 0;

	public List<Vehicle> getVehicles() {
	    return vehicles;
	}

	public void vehicleMenu() {
		while (true) {
			System.out.println("1.ADD VEHICLE DETAILS");
			System.out.println("2.CALCULATE VEHICLE TAX");
			System.out.println("3.DISPLAY ALL VEHICLE");
			System.out.println("4.BACK TO MAIN MENU");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addVehicleDetails();
				break;
			case 2:
				calculateVehicleTax();

				break;
			case 3:
				display();
				break;
			case 4:
				TaskMenu menu = new TaskMenu();
				menu.showMenu();
				break;
			default:
				System.out.println("Enter valid number");
			}
		}
	}

	private void addVehicleDetails() {
		System.out.println("Enter Vehicle details");
		try {

			System.out.println("Enter the Vehicle registration number:");
			vehicleRegNo = sc.next();
			if (!vehicleRegNo.matches(regex)) {
				System.out.println("Enter valid registration number");
				return;
			}

			System.out.println("Enter the Brand:");
			vehicleBrand = sc.next();
			System.out.println("ENTER THE Max velocity of the vehicle (kmph):");
			maxVelocity = sc.nextInt();
			if (maxVelocity < 120 || maxVelocity > 300) {
				System.out.println("Enter valid velocity");
				return;
			}

			System.out.println("ENTER CAPACITY(NUMBER OF SEATS) OF THE VEHICLE:");
			capacity = sc.nextInt();
			if (capacity <= 0) {
				System.out.println("Enter value greater than 0");
				return;
			}

			System.out.println("CHOOSE THE TYPE OF THE VEHICLE:");
			System.out.println("1.PETEROL DRIVEN");
			System.out.println("2.DIESEL DRIVEN");
			System.out.println("2.CND/LPG DRIVEN");
			vehicleType = sc.nextInt();

			if (vehicleType != 1 && vehicleType != 2 && vehicleType != 3) {
				System.out.println("Enter valid Vehicle type");
				return;
			}
			System.out.println("ENTER PURCHASE COST OF THE VEHICLE");
			purchaseCost = sc.nextDouble();
			if (purchaseCost < 50000 || purchaseCost > 1000000) {
				System.out.println("Enter valid cost");
				return;
			}
			Vehicle vehicleObj = new Vehicle(vehicleRegNo, vehicleBrand, purchaseCost, maxVelocity, capacity,
					vehicleType);
			vehicles.add(vehicleObj);
			System.out.println("Details saved ");
		} catch (Exception e) {
			System.out.println("Enter valid input");
		}

	}

	private void calculateVehicleTax() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter vehicle registration number to calculate the tax:");
		String regNo = sc.nextLine();

		if (vehicles.isEmpty()) {
			System.out.println("No vehicle in the list");
			return;
		}

		for (Vehicle v : vehicles) {
			if (v.getVehicleRegNo().equalsIgnoreCase(regNo)) {
				double vehicleTax;
				if (v.getTypeOfVehicle() == 1) {
					vehicleTax = v.getMaxVelocity() + v.getCapacity() + (0.10 * v.getPurchaseCost());
				} else if (v.getTypeOfVehicle() == 2) {
					vehicleTax = v.getMaxVelocity() + v.getCapacity() + (0.11 * v.getPurchaseCost());
				} else {
					vehicleTax = v.getMaxVelocity() + v.getCapacity() + (0.12 * v.getPurchaseCost());
				}

				// store tax in the object
				v.setVehicleTax(vehicleTax);

				System.out.println("Tax for vehicle " + regNo + " is: " + vehicleTax);
				return; // exit after finding and updating the vehicle
			}
		}

		System.out.println("Vehicle with registration number " + regNo + " not found.");
	}

	private void display() {
		if (vehicles.isEmpty()) {
			System.out.println("No properties to display");
			return;
		}
		System.out.println("VEHICLE REGISTRATION NO" + "BRAND" + "PURCHASE COST" + "MAX VELOCITY" + "GET CAPACITY"
				+ "TYPE OF VEHICLE" + "TAX ");
		for (Vehicle v : vehicles) {
			System.out.println(v.getVehicleRegNo() + v.getBrand() + v.getPurchaseCost() + v.getMaxVelocity()
					+ v.getCapacity() + v.getTypeOfVehicle() + v.getVehicleTax() + v.getVehicleTax());
		}
	}

}
