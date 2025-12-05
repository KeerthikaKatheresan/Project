package services;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Property;
import exceptions.InvalidInputException;
import interfaces.Taxable;

public class PropertyOperation implements Taxable {
	private Scanner sc = new Scanner(System.in);
	private List<Property> properties = new ArrayList<>();
	
	public List<Property> getProperties() {
		return properties;
	}

	public void addPropertyDetails() {
	    System.out.println("Enter property details");

	    try {
	        while (true) {
	            System.out.println("Enter the base value of land:");
	            int baseValue = sc.nextInt();
	            if (baseValue <= 0) {
	                throw new InvalidInputException("Base value must be greater than 0");
	            }

	            System.out.println("ENTER THE BUILT-UP AREA OF LAND:");
	            int buildUpArea = sc.nextInt();

	            System.out.println("ENTER THE AGE OF LAND IN YEARS:");
	            int landAge = sc.nextInt();
	            if (landAge <= 0) {
	                throw new InvalidInputException("Age must be greater than 0");
	            }

	            System.out.println("IS THE LAND LOCATED IN CITY? (Y: YES, N: NO)");
	            char landLocation = sc.next().toUpperCase().charAt(0);
	            if (landLocation != 'Y' && landLocation != 'N') {
	                throw new InvalidInputException("Enter Y or N");
	            }

	            // If all inputs are valid, save property and break loop
	            Property property = new Property(baseValue, buildUpArea, landAge, landLocation);
	            properties.add(property);
	            System.out.println("Details saved");
	            break; // exit while loop after successful entry
	        }
	    } catch (InvalidInputException e) {
	        System.out.println("Validation error: " + e.getMessage());
	    } catch (InputMismatchException e) {
	        System.out.println("Invalid input type. Please enter numbers where required.");
	        sc.nextLine(); // clear buffer
	    }
	}



	@Override
	public void calculateTax() {

		if (properties.isEmpty()) {
			System.out.println("No property in the list");
			return;
		}
		display();
		System.out.println("Enter property id to calculate the tax:");
		int propertyId = sc.nextInt();
		for (Property p : properties) {
			if (p.getId() == propertyId) { // Property has getId()
				int propertyTax;
				if (p.getLandLocation() == 'Y') {
					propertyTax = (int) ((p.getBuildUpArea() * p.getLandAge() * p.getBaseValue())
							+ (0.5 * p.getBuildUpArea()));
				} else {
					propertyTax = (int) (p.getBuildUpArea() * p.getLandAge() * p.getBaseValue());
				}

				p.setPropertyTax(propertyTax); // Property has setPropertyTax()

				System.out.println("Tax for property ID " + propertyId + " is: " + propertyTax);
				return;
			}
		}

		System.out.println("Property ID not found.");
		return;
	}

	@Override
	public void display() {
		if (properties.isEmpty()) {
			System.out.println("No properties to display");
			return;
		}

		// Table border (top)
		System.out.println("------------------------------------------------------------------------------------");
		System.out.printf(" %-5s  %-12s  %-12s  %-8s  %-10s  %-12s %n", "ID", "BUILT-UP", "BASE PRICE", "AGE",
				"IN CITY", "PROPERTY TAX");
		System.out.println("------------------------------------------------------------------------------------");

		// Table rows
		for (Property p : properties) {
			System.out.printf(" %-5d  %-12d  %-12d  %-8d  %-10c  %-12d %n", p.getId(), p.getBuildUpArea(),
					p.getBaseValue(), p.getLandAge(), p.getLandLocation(), p.getPropertyTax());
		}

		// Table border (bottom)
		System.out.println("------------------------------------------------------------------------------------");
	}

}
