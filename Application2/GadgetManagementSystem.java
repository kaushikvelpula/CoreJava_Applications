package com.evergent.CoreJAVA.kaushik.Application2;

import java.util.Scanner;

public class GadgetManagementSystem {

    enum Module {O, P, B, Q}
    enum Submodule {S, L, W, M}
    
    static int gadgetCost;
    static int totalAmount;
    static int discountedAmount;
    static int itemCount;
    static String profession;
    
    public static void main(String[] args) {
        String module = null;
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n\t\tWelcome To ELECTRONIC GADGET MANAGEMENT SYSTEM");
        
        System.out.println("Enter your profession (S for Student, E for Employee, O for Other): ");
        char professionCode = scanner.nextLine().trim().toUpperCase().charAt(0);

        switch (professionCode) {
            case 'S':
                profession = "student";
                break;
            case 'E':
                profession = "employee";
                break;
            case 'O':
            default:
                profession = "other";
                break;
        }
        
        while (true) {
            System.out.println("======================");
            System.out.println(" Gadget Management Main Menu");
            System.out.println("======================");
            System.out.println("O-Order Module");
            System.out.println("P-Payment Module");
            System.out.println("B-Bill Module");
            System.out.println("Q-Quit Module");
            System.out.println("======================");
            System.out.println("Enter your Module code (O,P,B,Q): ");
            
            module = scanner.nextLine();
            System.out.println("You entered module: " + module);
            
            switch (Module.valueOf(module)) {
                case O:
                    System.out.println(" Order Module");
                    System.out.println("======================");
                    System.out.println("S-to view and order Smartphones");
                    System.out.println("L-to view and order Laptops");
                    System.out.println("W-to view and order Smart Watches");
                    System.out.println("M-Return to Main Menu");
                    System.out.println("======================");
                    System.out.println("Enter your Submodule code (S,L,W,M): ");
                    
                    String submodule = scanner.nextLine();
                    
                    switch (Submodule.valueOf(submodule)) {
                        case S:
                            System.out.println("A-OnePlus: Rs 50000");
                            System.out.println("B-iPhone: Rs 100000");
                            System.out.println("C-Redmi: Rs 30000");
                            System.out.println("Enter your Gadget code (A,B,C): ");
                            
                            String gadgetCodeS = scanner.nextLine();
                            
                            switch (gadgetCodeS) {
                                case "A":
                                    gadgetCost = 50000;
                                    break;
                                case "B":
                                    gadgetCost = 100000;
                                    break;
                                case "C":
                                    gadgetCost = 30000;
                                    break;
                            }
                            itemCount++;
                            totalAmount += gadgetCost;
                            System.out.println("Gadget added to cart. Total Amount: Rs" + totalAmount);
                            break;
                            
                        case L:
                            System.out.println("A-HP: Rs 80000");
                            System.out.println("B-Dell: Rs 75000");
                            System.out.println("C-Mac: Rs 150000");
                            System.out.println("Enter your Gadget code (A,B,C): ");
                            
                            String gadgetCodeL = scanner.nextLine();
                            
                            switch (gadgetCodeL) {
                                case "A":
                                    gadgetCost = 80000;
                                    break;
                                case "B":
                                    gadgetCost = 75000;
                                    break;
                                case "C":
                                    gadgetCost = 150000;
                                    break;
                            }
                            itemCount++;
                            totalAmount += gadgetCost;
                            System.out.println("Gadget added to cart. Total Amount: Rs" + totalAmount);
                            break;
                            
                        case W:
                            System.out.println("A-Bolt: Rs 1500");
                            System.out.println("B-iWatch: Rs 40000");
                            System.out.println("C-Redmi: Rs 2000");
                            System.out.println("Enter your Gadget code (A,B,C): ");
                            
                            String gadgetCodeW = scanner.nextLine();
                            
                            switch (gadgetCodeW) {
                                case "A":
                                    gadgetCost = 1500;
                                    break;
                                case "B":
                                    gadgetCost = 40000;
                                    break;
                                case "C":
                                    gadgetCost = 2000;
                                    break;
                            }
                            itemCount++;
                            totalAmount += gadgetCost;
                            System.out.println("Gadget added to cart. Total Amount: Rs" + totalAmount);
                            break;
                            
                        case M:
                            // Return to Main Menu
                            break;
                    }
                    break;
                    
                case P:
                    System.out.println(" Payment Module");
                    System.out.println("======================");
                    System.out.println("T-to display total amount to be paid");
                    System.out.println("D-to apply discount");
                    System.out.println("P-to proceed with payment");
                    System.out.println("M-Return to Main Menu");
                    System.out.println("======================");
                    System.out.println("Enter your option (T,D,P,M): ");
                    
                    String paymentOption = scanner.nextLine();
                    
                    switch (paymentOption) {
                        case "T":
                            System.out.println("Total Amount: Rs" + totalAmount);
                            break;
                            
                        case "D":
                            // Apply discounts based on the profession
                            if (profession.equals("student")) {
                                if (totalAmount > 5000 && totalAmount <= 20000) {
                                    discountedAmount = (int) (totalAmount * 0.90); // 10% discount for students
                                } else if (totalAmount > 20000) {
                                    discountedAmount = (int) (totalAmount * 0.85); // 15% discount for students
                                } else {
                                    discountedAmount = totalAmount;
                                }
                            } else {
                                if (totalAmount > 10000 && totalAmount <= 25000) {
                                    discountedAmount = (int) (totalAmount * 0.95); // 5% discount for other professions
                                } else if (totalAmount > 25000) {
                                    discountedAmount = (int) (totalAmount * 0.90); // 10% discount for other professions
                                } else {
                                    discountedAmount = totalAmount;
                                }
                            }
                            System.out.println("Discounted Amount: Rs" + discountedAmount);
                            break;
                            
                        case "P":
                            if (discountedAmount > 0) {
                                System.out.println("Proceeding with payment of Rs" + discountedAmount);
                            } else {
                                System.out.println("Proceeding with payment of Rs" + totalAmount);
                            }
                            break;
                            
                        case "M":
                            // Return to Main Menu
                            break;
                            
                        default:
                            System.out.println("Invalid option. Please try again.");
                            break;
                    }
                    break;
                    
                case B:
                    System.out.println(" Bill Module");
                    System.out.println("======================");
                    System.out.println("Number of items purchased: " + itemCount);
                    if (discountedAmount > 0) {
                        System.out.println("Total Amount to be Paid after discount: Rs" + discountedAmount);
                    } else {
                        System.out.println("Total Amount to be Paid: Rs" + totalAmount);
                    }
                    break;
                    
                case Q:
                    System.out.println("Quit Module");
                    System.out.println("Thank you for using the Electronic Gadget Management System. Goodbye!");
                    System.exit(0);
                    break;
                    
                default:
                    System.out.println("Invalid module. Please try again.");
            }
        }
    }
}







