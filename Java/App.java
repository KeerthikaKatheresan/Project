package com.mphasis.TAX_CALULATION;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Welcome message
        System.out.println("+------------------------------------+");
        System.out.println("|  WELCOME TO TAX CALCULATION APP	|");
        System.out.println("+------------------------------------+");
        System.out.println("Please Login to Continue");

        // Asking user for login credentials
        Scanner sc = new Scanner(System.in);
        System.out.println("USERNAME:");
        String username = sc.nextLine();
        System.out.println("PASSWORD:");
        String password = sc.nextLine();

        // Simple condition check instead of DB
        if (username.equals("admin") && password.equals("admin123")) {
            System.out.println("Login Successful");
            System.out.println();
            TaskMenu menu = new TaskMenu();
            menu.showMenu();
        } else {
            System.out.println("Login failed. Username or Password invalid");
        }

        sc.close(); // Always close Scanner
    }
}
