package com.insurance.app.ui;

import com.insurance.app.models.model.InsuredPerson;
import com.insurance.app.models.service.InsuranceRegistry;

import java.util.List;
import java.util.Scanner;

public class ConsoleInterface {
    private Scanner scanner = new Scanner(System.in);
    private InsuranceRegistry registry = new InsuranceRegistry();

    public void run() {
        int choice;
        do {
            showMenu();
            choice = readInt("Choose an option: ");
            switch (choice) {
                case 1 -> addInsuredPerson();
                case 2 -> displayAll();
                case 3 -> searchPerson();
                case 4 -> System.out.println("Exiting application.");
                default -> System.out.println("Invalid option.");
            }
        } while (choice != 4);
    }

    private void showMenu() {
        System.out.println("\n--- Insurance Registry ---");
        System.out.println("1. Add insured person");
        System.out.println("2. Show all insured persons");
        System.out.println("3. Search for an insured person");
        System.out.println("4. Exit");
    }

    private void addInsuredPerson() {
        String firstName = readNonEmptyText("Enter first name: ");
        String lastName = readNonEmptyText("Enter last name: ");
        int age = readInt("Enter age: ");
        String phone = readNonEmptyText("Enter phone number: ");
        registry.addInsuredPerson(new InsuredPerson(firstName, lastName, age, phone));
        System.out.println("Insured person has been added.");
    }

    private void displayAll() {
        List<InsuredPerson> list = registry.getAll();
        if (list.isEmpty()) {
            System.out.println("No insured persons found.");
        } else {
            for (InsuredPerson p : list) {
                System.out.println(p);
            }
        }
    }

    private void searchPerson() {
        String firstName = readNonEmptyText("Enter first name: ");
        String lastName = readNonEmptyText("Enter last name: ");
        List<InsuredPerson> results = registry.search(firstName, lastName);
        if (results.isEmpty()) {
            System.out.println("No matching insured person found.");
        } else {
            for (InsuredPerson p : results) {
                System.out.println(p);
            }
        }
    }

    private String readNonEmptyText(String prompt) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty.");
            }
        } while (input.isEmpty());
        return input;
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}