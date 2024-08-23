package com.evergent.CoreJAVA.kaushik.Application4;
import java.util.*;
public class GadgetManagementSystem extends ExitClass implements ModulesInterface {
    // Static variables shared across instances
    static int discountedAmount;
    static String profession; 
    
    // Final constant for base discount
    static final int BASE_DISCOUNT = 5;
    
    private String module;
    Cart cart; // HAS-A relationship

    // Constructor for initializing GadgetManagementSystem
    public GadgetManagementSystem() {
        this.module = "";
        this.discountedAmount = 0;
        this.cart = new Cart(); // Initialize the Cart object (HAS-A relationship)
    }

    // Method to implement ordering module (HAS-A relationship with Cart)
    public void orderModule() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Order Module");
        System.out.println("======================");
        System.out.println("S - View and order Smartphones");
        System.out.println("L - View and order Laptops");
        System.out.println("W - View and order Smart Watches");
        System.out.println("M - Return to Main Menu");
        System.out.println("======================");
        System.out.println("Enter your Submodule code (S, L, W, M) : ");
        module = sc.nextLine().toUpperCase();

        int gadgetCost = 0;
        String itemName = "";

        switch (module) {
            case "S":
                System.out.println("A - OnePlus: Rs 50000");
                System.out.println("B - iPhone: Rs 100000");
                System.out.println("C - Redmi: Rs 30000");
                System.out.println("Enter your Gadget code (A, B, C): ");
                module = sc.nextLine().toUpperCase();

                switch (module) {
                    case "A":
                        gadgetCost = 50000;
                        itemName = "OnePlus Smartphone";
                        break;
                    case "B":
                        gadgetCost = 100000;
                        itemName = "iPhone Smartphone";
                        break;
                    case "C":
                        gadgetCost = 30000;
                        itemName = "Redmi Smartphone";
                        break;
                }
                cart.setItem(itemName, gadgetCost);
                System.out.println(itemName + " added to cart. Total Amount: Rs " + cart.getPrice());
                break;

            case "L":
                System.out.println("A - HP: Rs 80000");
                System.out.println("B - Dell: Rs 75000");
                System.out.println("C - Mac: Rs 150000");
                System.out.println("Enter your Gadget code (A, B, C): ");
                module = sc.nextLine().toUpperCase();

                switch (module) {
                    case "A":
                        gadgetCost = 80000;
                        itemName = "HP Laptop";
                        break;
                    case "B":
                        gadgetCost = 75000;
                        itemName = "Dell Laptop";
                        break;
                    case "C":
                        gadgetCost = 150000;
                        itemName = "Mac Laptop";
                        break;
                }
                cart.setItem(itemName, gadgetCost);
                System.out.println(itemName + " added to cart. Total Amount: Rs " + cart.getPrice());
                break;

            case "W":
                System.out.println("A - Bolt: Rs 1500");
                System.out.println("B - iWatch: Rs 40000");
                System.out.println("C - Redmi: Rs 2000");
                System.out.println("Enter your Gadget code (A, B, C): ");
                module = sc.nextLine().toUpperCase();

                switch (module) {
                    case "A":
                        gadgetCost = 1500;
                        itemName = "Bolt Smart Watch";
                        break;
                    case "B":
                        gadgetCost = 40000;
                        itemName = "iWatch Smart Watch";
                        break;
                    case "C":
                        gadgetCost = 2000;
                        itemName = "Redmi Smart Watch";
                        break;
                }
                cart.setItem(itemName, gadgetCost);
                System.out.println(itemName + " added to cart. Total Amount: Rs " + cart.getPrice());
                break;

            case "M":
                // Return to main menu
                break;
        }
    }

    // Method to implement payment module
    public void paymentModule() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Payment Module");
        System.out.println("======================");
        System.out.println("T - Display total amount to be paid");
        System.out.println("D - Apply discount");
        System.out.println("P - Proceed with payment");
        System.out.println("M - Return to Main Menu");
        System.out.println("======================");
        System.out.println("Enter your option (T, D, P, M) : ");
        module = sc.nextLine().toUpperCase();

        switch (module) {
            case "T":
                System.out.println("Total Amount: Rs " + cart.getPrice());
                break;

            case "D":
                applyDiscount();
                System.out.println("Discounted Amount: Rs " + discountedAmount);
                break;

            case "P":
                if (discountedAmount > 0) {
                    System.out.println("Proceeding with payment of Rs " + discountedAmount);
                } else {
                    System.out.println("Proceeding with payment of Rs " + cart.getPrice());
                }
                break;

            case "M":
                // Return to main menu
                break;

            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    // Method to apply discount based on profession
    private void applyDiscount() {
        int totalAmount = cart.getPrice();
        if ("S".equals(profession)) {  // Student
            if (totalAmount > 5000 && totalAmount <= 20000) {
                discountedAmount = totalAmount * (100 - (BASE_DISCOUNT + 5)) / 100; // 10% discount for students
            } else if (totalAmount > 20000) {
                discountedAmount = totalAmount * (100 - (BASE_DISCOUNT + 10)) / 100; // 15% discount for students
            } else {
                discountedAmount = totalAmount;
            }
        } else {  // Employee or other professions
            if (totalAmount > 10000 && totalAmount <= 25000) {
                discountedAmount = totalAmount * (100 - BASE_DISCOUNT) / 100; // 5% discount for employees
            } else if (totalAmount > 25000) {
                discountedAmount = totalAmount * (100 - (BASE_DISCOUNT + 5)) / 100; // 10% discount for employees
            } else {
                discountedAmount = totalAmount;
            }
        }
    }

    // Method to implement report module
    public void reportModule() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Report Module");
        System.out.println("======================");
        System.out.println("I - Display invoice for order made");
        System.out.println("S - Display summary of orders and payments made");
        System.out.println("M - Return to Main Menu");
        System.out.println("======================");
        System.out.println("Enter your Module code (I, S, M) : ");
        module = sc.nextLine().toUpperCase();

        switch (module) {
            case "I":
                System.out.println("Invoice Display");
                System.out.println("==================");
                System.out.println("Order Id: " + (Math.ceil(Math.random())));
                System.out.println("Item Purchased: " + cart.getItem());
                System.out.println("Total Amount: Rs " + (discountedAmount > 0 ? discountedAmount : cart.getPrice()));
                break;

            case "S":
                System.out.println("Summary Of Order");
                System.out.println("======================");
                System.out.println("Item Purchased: " + cart.getItem());
                System.out.println("Total Amount to be Paid: Rs " + (discountedAmount > 0 ? discountedAmount : cart.getPrice()));
                break;

            case "M":
                // Return to main menu
                break;

            default:
                System.out.println("Invalid option. Please try again.");
                break;
        }
    }

    public void exitModule() {
        System.out.println("Quit Module");
        System.exit(0);
    }

    public static void main(String[] args) {
        GadgetManagementSystem system = new GadgetManagementSystem();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("======================");
            System.out.println("GMS Main Menu");
            System.out.println("======================");
            System.out.println("O - Order Module");
            System.out.println("P - Payment Module");
            System.out.println("R - Report Module");
            System.out.println("E - Exit Module");
            System.out.println("======================");
            System.out.println("Enter your Module code (O, P, R, E) : ");
            String module = sc.nextLine().toUpperCase();
            switch (module) {
                case "O":
                    system.orderModule();
                    break;
                case "P":
                    system.paymentModule();
                    break;
                case "R":
                    system.reportModule();
                    break;
                case "E":
                    system.exitModule();
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}
