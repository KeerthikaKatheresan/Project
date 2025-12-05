package main;

import java.util.Scanner;

import entities.Property;
import services.PropertyOperation;
import services.TotalTaxCalculation;
import services.VehicleOperation;



public class TaskMenu {
	Scanner sc = new Scanner(System.in);

	//Property property =new Property();
	PropertyOperation propertyOperation=new PropertyOperation();
	VehicleOperation vehicleOperation=new VehicleOperation();
	public void showMenu() {
	    while (true) {
	        System.out.println("1.PROPERTY TAX");
	        System.out.println("2.VEHICLE TAX");
	        System.out.println("3.TOTAL");
	        System.out.println("4.EXIT");

	        try {
	            int choice = sc.nextInt();
	            switch (choice) {
	                case 1:
	                    PropertyMenu propertyMenu = new PropertyMenu(propertyOperation);
	                    propertyMenu.showMenu();
	                    break;
	                case 2:
	                    VehicleMenu vehicleMenu = new VehicleMenu(vehicleOperation);
	                    vehicleMenu.showMenu();
	                    break;
	                case 3:
	                    TotalTaxCalculation totaltax = new TotalTaxCalculation(propertyOperation, vehicleOperation);
	                    totaltax.calculateTotalTax();
	                    totaltax.display();
	                    break;
	                case 4:
	                    System.out.println("THANKS VISIT AGAIN");
	                    return;
	                default:
	                    System.out.println("Please enter a valid option (1–4)");
	            }
	        } catch (Exception e) {
	            System.out.println("Invalid input. Kindly enter a number");
	            sc.nextLine(); // clear the invalid token so loop can continue
	        }
	    }
	}

	}


