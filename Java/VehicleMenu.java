package main;

import java.util.Scanner;

import services.VehicleOperation;

public class VehicleMenu {

    private Scanner sc = new Scanner(System.in);
    private VehicleOperation vehicleOperation;
    
    

    public VehicleMenu(VehicleOperation vehicleOperation) {
		super();
		this.vehicleOperation = vehicleOperation;
	}



	public void showMenu() {

        while (true) {
            System.out.println("\n--- VEHICLE MENU ---");
            System.out.println("1. ADD VEHICLE DETAILS");
            System.out.println("2. CALCULATE VEHICLE TAX");
            System.out.println("3. DISPLAY ALL VEHICLES");
            System.out.println("4. BACK TO MAIN MENU");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        vehicleOperation.addVehicleDetails(); // must be PUBLIC
                        break;

                    case 2:
                        vehicleOperation.calculateTax();
                        break;

                    case 3:
                        vehicleOperation.display();
                        break;

                    case 4:

                        return; 

                    default:
                        System.out.println("Please enter a valid option (1–4)");
                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine(); // clear buffer
            }
        }
    }
}
