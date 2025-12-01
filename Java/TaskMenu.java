package com.mphasis.TAX_CALULATION;

import java.util.Scanner;

import com.mphasis.TAX_CALULATION.PropertyTaxCalculation;

public class TaskMenu {
	Scanner sc = new Scanner(System.in);

	public void showMenu() {
		double propertyTax = 0;
		double vehicleTax = 0;
		double total = 0;
		while (true) {
			System.out.println("1.PROPERTY TAX");
			System.out.println("2.VEHICLE TAX");
			System.out.println("3. TOATL ");
			System.out.println("4.EXIT");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				PropertyTaxCalculation propertyObj=new PropertyTaxCalculation();
				 propertyObj.propertyMenu();
				break;
			case 2:
				VehicleTaxCalculation vehicleObj=new VehicleTaxCalculation();
				 vehicleObj.vehicleMenu();;
				break;
			case 3:
				//total = propertyTax + vehicleTax;
				//System.out.println("Total tax:" + total);
			case 4:
				System.out.println("THANKS VISIT AGAIN");
			default:
				System.out.println("Invalid choice");
			}

		}
	}

}
