package services;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Vehicle;
import enums.VehicleType;
import exception.InvalidInputException;
import interfaces.Taxable;
import main.TaskMenu;




public class VehicleOperation implements Taxable {
	private Scanner sc = new Scanner(System.in);
	private List<Vehicle> vehicles = new ArrayList<>();
	private String regex = "^(?!0000)\\d{4}$";

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void vehicleMenu() {
		while (true) {
			System.out.println("1.ADD VEHICLE DETAILS");
			System.out.println("2.CALCULATE VEHICLE TAX");
			System.out.println("3.DISPLAY ALL VEHICLE");
			System.out.println("4.BACK TO MAIN MENU");
			try {
				int choice = sc.nextInt();
				switch (choice) {
				case 1:

					addVehicleDetails(); // catch here

					break;
				case 2:
					calculateTax();
					break;
				case 3:
					display();
					break;
				case 4:
					TaskMenu menu = new TaskMenu();
					menu.showMenu();
					return;
				default:
					throw new InvalidInputException("Enter valid input");

				}
			} catch (InvalidInputException e) {
				System.out.println("Error:" + e.getMessage());
				sc.nextLine();
			} 
		}
	}

	public void addVehicleDetails() throws InvalidInputException {
		System.out.println("Enter Vehicle details");

		System.out.println("Enter the Vehicle registration number:");
		String vehicleRegNo = sc.next();
		if (!vehicleRegNo.matches(regex)) {
			throw new InvalidInputException("Invalid registration number. Must be 4 digits and not 0000.");
		}

		System.out.println("Enter the Brand:");
		String vehicleBrand = sc.next();

		System.out.println("ENTER THE Max velocity of the vehicle (kmph):");
		int maxVelocity = sc.nextInt();
		if (maxVelocity < 120 || maxVelocity > 300) {
			throw new InvalidInputException("Velocity must be between 120 and 300 kmph.");
		}

		System.out.println("ENTER CAPACITY(NUMBER OF SEATS) OF THE VEHICLE:");
		int capacity = sc.nextInt();
		if (capacity <= 0) {
			throw new InvalidInputException("Capacity must be greater than 0.");
		}

		System.out.println("CHOOSE THE TYPE OF THE VEHICLE:");
		System.out.println("1.PETROL DRIVEN");
		System.out.println("2.DIESEL DRIVEN");
		System.out.println("3.CNG/LPG DRIVEN");
		int choice = sc.nextInt();
		VehicleType vehicleType;
		switch (choice) {
		case 1:
			vehicleType = VehicleType.PETROL_DRIVEN;
			break;
		case 2:
			vehicleType = VehicleType.DIESEL_DRIVEN;
			break;
		case 3:
			vehicleType = VehicleType.CNG_LPG_DRIVEN;
			break;
		default:
			throw new InvalidInputException("Invalid vehicle type choice.");
		}

		System.out.println("ENTER PURCHASE COST OF THE VEHICLE");
		double purchaseCost = sc.nextDouble();
		if (purchaseCost < 50000 || purchaseCost > 1000000) {
			throw new InvalidInputException("Purchase cost must be between 50,000 and 1,000,000.");
		}

		Vehicle vehicleObj = new Vehicle(vehicleRegNo, vehicleBrand, purchaseCost, maxVelocity, capacity, vehicleType);
		vehicles.add(vehicleObj);
		System.out.println("Details saved ");
	}

	@Override
	public void calculateTax() {
		if (vehicles.isEmpty()) {
			System.out.println("No vehicle in the list");
			return;
		}
		display();
		System.out.println("Enter vehicle registration number to calculate the tax:");
		String regNo = sc.next();

		for (Vehicle v : vehicles) {
			if (v.getVehicleRegNo().equalsIgnoreCase(regNo)) {
				double vehicleTax;
				if (v.getTypeOfVehicle() == VehicleType.PETROL_DRIVEN) {
					vehicleTax = v.getMaxVelocity() + v.getCapacity() + (0.10 * v.getPurchaseCost());
				} else if (v.getTypeOfVehicle() == VehicleType.DIESEL_DRIVEN) {
					vehicleTax = v.getMaxVelocity() + v.getCapacity() + (0.11 * v.getPurchaseCost());
				} else {
					vehicleTax = v.getMaxVelocity() + v.getCapacity() + (0.12 * v.getPurchaseCost());
				}

				v.setVehicleTax(vehicleTax);
				System.out.println("Tax for vehicle " + regNo + " is: " + vehicleTax);
				return;
			}
		}

		System.out.println("Vehicle with registration number " + regNo + " not found.");
	}

	@Override
	public void display() {
		if (vehicles.isEmpty()) {
			System.out.println("No vehicles to display");
			return;
		}

		System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s%n", "REG NO", "BRAND", "COST", "VELOCITY",
				"CAPACITY", "TYPE", "TAX");

		for (Vehicle v : vehicles) {
			System.out.printf("%-15s %-15s %-15.2f %-15d %-15d %-15s %-15.2f%n", v.getVehicleRegNo(), v.getBrand(),
					v.getPurchaseCost(), v.getMaxVelocity(), v.getCapacity(), v.getTypeOfVehicle(), v.getVehicleTax());
		}
	}
}
