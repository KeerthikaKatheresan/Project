package main;

import java.util.Scanner;

import services.PropertyOperation;

public class PropertyMenu {

    private Scanner sc = new Scanner(System.in);
    private PropertyOperation propertyOperation;

    public PropertyMenu(PropertyOperation propertyOperation) {
		super();
		this.propertyOperation = propertyOperation;
	}

	public void showMenu() {

        while (true) {
            System.out.println("\n--- PROPERTY MENU ---");
            System.out.println("1. ADD PROPERTY DETAILS");
            System.out.println("2. CALCULATE PROPERTY TAX");
            System.out.println("3. DISPLAY ALL PROPERTIES");
            System.out.println("4. BACK TO MAIN MENU");

            try {
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        propertyOperation.addPropertyDetails();
                        break;

                    case 2:
                        propertyOperation.calculateTax();
                        break;

                    case 3:
                        propertyOperation.display();
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
