package com.mphasis.TAX_CALULATION;

import java.util.Scanner;

import com.mphasis.TAX_CALULATION.PropertyOperation;

public class TaskMenu {
	Scanner sc = new Scanner(System.in);

	public void showMenu() {
		double propertyTax = 0;
		double vehicleTax = 0;
		double total = 0;
		while (true) {
			System.out.println("1.PROPERTY TAX");
			System.out.println("2.VEHICLE TAX");
			System.out.println("3.TOTAL");
			System.out.println("4.EXIT");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				PropertyOperation propertyObj=new PropertyOperation();
				 propertyObj.propertyMenu();
				break;
			case 2:
				VehicleOperation vehicleObj=new VehicleOperation();
				 vehicleObj.vehicleMenu();;
				break;
			case 3:
				TotalTaxCalculation totaltax=new TotalTaxCalculation();
				totaltax.calculateTotalTax();
				totaltax.display();
				break;
			case 4:
				System.out.println("THANKS VISIT AGAIN");
				return;
			default:
				System.out.println("Invalid choice");
			}

		}
	}

}
