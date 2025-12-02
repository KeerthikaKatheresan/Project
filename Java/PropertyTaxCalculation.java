package com.mphasis.TAX_CALULATION;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PropertyTaxCalculation {
	private Scanner sc = new Scanner(System.in);
	private List<Property> properties = new ArrayList<>();
	private int propertyTax;

	public List<Property> getProperties() {
	    return properties;
	}

	public void propertyMenu() {
		while (true) {
			System.out.println("1.ADD PROPERTY DETAILS");
			System.out.println("2.CALCULATE THE PROPERTY TAX");
			System.out.println("3.DISPLAY ALL PROPERTIES");
			System.out.println("4.BACK TO MAIN MENU");

			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addPropertyDetails();
				break;
			case 2:
				 calculatePropertyTax();
				
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

	private void addPropertyDetails() {
		System.out.println("Enter property details");
		try {

			System.out.println("Enter the base value of land:");
			int baseValue = sc.nextInt();
			if (baseValue <= 0) {
				System.out.println("Enter value greater than 0");
				return;
			}

			System.out.println("ENTER THE BUILT-UP AREA OF LAND:");
			int buildUpArea = sc.nextInt();

			System.out.println("ENTER THE AGE OF LAND IN YEARS:");
			int landAge = sc.nextInt();
			if (landAge <= 0) {
				System.out.println("Enter value greater than 0");
				return;
			}

			System.out.println("IS THE LAND LOCATED IN CITY?(Y :YES ,N:NO");
			char landLocation = sc.next().charAt(0);
			if (landLocation != 'Y' && landLocation != 'N') {
				System.out.println("Enter Y or N");
				return;
			}
			Property property = new Property(baseValue, buildUpArea, landAge, landLocation);
			properties.add(property);
			System.out.println("Details saved ");
		} catch (Exception e) {
			System.out.println("Enter valid input");
		}

	}

	private void calculatePropertyTax() {

		display();
		System.out.println("Enter property id to calculate the tax:");
		int propertyId = sc.nextInt();

		if (properties.isEmpty()) {
			System.out.println("No property in the list");
			return;
		}

		for (Property p : properties) {
			if (p.getId() == propertyId) { // assuming Property has getId()
				int propertyTax;
				if (p.getLandLocation() == 'Y') {
					propertyTax = (int) ((p.getBuildUpArea() * p.getLandAge() * p.getBaseValue())
							+ (0.5 * p.getBuildUpArea()));
				} else {
					propertyTax = (int) (p.getBuildUpArea() * p.getLandAge() * p.getBaseValue());
				}

				
				p.setPropertyTax(propertyTax); // assuming Property has setPropertyTax()

				System.out.println("Tax for property ID " + propertyId + " is: " + propertyTax);
				return ; 
			}
		}

		System.out.println("Property ID not found.");
	}

	private void display() {
	    if (properties.isEmpty()) {
	        System.out.println("No properties to display");
	        return;
	    }

	    // Table header
	    System.out.printf("%-5s %-12s %-12s %-8s %-10s %-12s%n",
	            "ID", "BUILT-UP", "BASE PRICE", "AGE", "IN CITY", "PROPERTY TAX");

	    // Table rows
	    for (Property p : properties) {
	        System.out.printf("%-5d %-12d %-12d %-8d %-10c %-12d%n",
	                p.getId(),
	                p.getBuildUpArea(),
	                p.getBaseValue(),
	                p.getLandAge(),
	                p.getLandLocation(),
	                p.getPropertyTax());
	    }
	}


}
