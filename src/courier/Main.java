package courier;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourierManager manager = new CourierManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add a new package");
            System.out.println("2. Display all packages and shipping costs");
            System.out.println("3. Sort packages by weight");
            System.out.println("4. Search for a package by Tracking ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter package type (Standard/Express): ");
                    String type = scanner.next();
                    System.out.print("Enter tracking ID: ");
                    String trackingID = scanner.next();
                    System.out.print("Enter destination: ");
                    scanner.nextLine(); // Consume newline
                    String destination = scanner.nextLine();
                    System.out.print("Enter weight: ");
                    double weight = scanner.nextDouble();

                    try {
                        if (type.equalsIgnoreCase("Standard")) {
                            manager.addPackage(new StandardPackage(trackingID, destination, weight));
                        } else if (type.equalsIgnoreCase("Express")) {
                            manager.addPackage(new ExpressPackage(trackingID, destination, weight));
                        } else {
                            System.out.println("Invalid package type!");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    manager.displayPackages();
                    break;

                case 3:
                    manager.sortPackagesByWeight();
                    manager.displayPackages();
                    break;

                case 4:
                    System.out.print("Enter Tracking ID: ");
                    String searchID = scanner.next();
                    Package pkg = manager.searchByTrackingID(searchID);
                    if (pkg != null) {
                        System.out.printf("Tracking ID: %s | Destination: %s | Weight: %.2f | Cost: %.2f%n",
                                pkg.trackingID, pkg.destination, pkg.weight, pkg.calculateShippingCost());
                    } else {
                        System.out.println("Package not found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Delivery Dilemmas!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
