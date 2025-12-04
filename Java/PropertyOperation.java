package com.mphasis.TAX_CALULATION;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class PropertyOperation implements Taxable {
	private Scanner sc = new Scanner(System.in);
	private List<Property> properties = new ArrayList<>();
	private int propertyTax;

	public List<Property> getProperties() {
		return properties;
	}

	public void propertyMenu() {
	    int choice = 0; // initialize

	    do {
	        System.out.println("1.ADD PROPERTY DETAILS");
	        System.out.println("2.CALCULATE THE PROPERTY TAX");
	        System.out.println("3.DISPLAY ALL PROPERTIES");
	        System.out.println("4.BACK TO MAIN MENU");

	        try {
	            choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    addPropertyDetails();
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
	                    break; // exit loop after going back
	                default:
	                	System.out.println("Enter valid number");
	                	break;
	                    //throw new InvalidInputException("Invalid menu choice. Please enter 1–4.");
	            }
	        }
	            catch (InvalidInputException e) {
		            // Handles wrong menu numbers like 7
		            System.out.println("Error: " + e.getMessage());
		            choice = -1;   // reset choice so loop continues
		        }
	         

	    } while (choice != 4); // loop until user chooses "Back to Main Menu"
	}



	private void addPropertyDetails() throws InvalidInputException {
		System.out.println("Enter property details");

		try {
			int baseValue;
			do {
				System.out.println("Enter the base value of land:");
				baseValue = sc.nextInt();
				if (baseValue <= 0) {
					throw new InvalidInputException("Enter value greater than 0");
				}
			} while (baseValue <= 0);

			System.out.println("ENTER THE BUILT-UP AREA OF LAND:");
			int buildUpArea = sc.nextInt();

			int landAge;
			do {
				System.out.println("ENTER THE AGE OF LAND IN YEARS:");
				landAge = sc.nextInt();
				if (landAge <= 0) {
					throw new InvalidInputException("Enter value greater than 0");
				}
			} while (landAge <= 0);

			char landLocation;
			do {
				System.out.println("IS THE LAND LOCATED IN CITY? (Y: YES, N: NO)");
				landLocation = sc.next().toUpperCase().charAt(0);
				if (landLocation != 'Y' && landLocation != 'N') {
					throw new InvalidInputException("Enter Y or N");
				}
			} while (landLocation != 'Y' && landLocation != 'N');

			Property property = new Property(baseValue, buildUpArea, landAge, landLocation);
			properties.add(property);
			System.out.println("Details saved");

		} catch (Exception e) {
			System.out.println("Invalid input type.");
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
