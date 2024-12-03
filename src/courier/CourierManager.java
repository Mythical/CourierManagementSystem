package courier;

import java.util.ArrayList;

class CourierManager {
    ArrayList<Package> packages = new ArrayList<>();

    void addPackage(Package pkg) {
        packages.add(pkg);
        System.out.println("Package added successfully!");
    }

    void displayPackages() {
        for (Package pkg : packages) {
            System.out.printf("Tracking ID: %s | Destination: %s | Weight: %.2f | Cost: %.2f%n",
                    pkg.trackingID, pkg.destination, pkg.weight, pkg.calculateShippingCost());
        }
    }

    void sortPackagesByWeight() {
        for (int i = 0; i < packages.size() - 1; i++) {
            for (int j = 0; j < packages.size() - i - 1; j++) {
                if (packages.get(j).weight > packages.get(j + 1).weight) {
                    Package temp = packages.get(j);
                    packages.set(j, packages.get(j + 1));
                    packages.set(j + 1, temp);
                }
            }
        }
        System.out.println("Packages sorted by weight!");
    }

    Package searchByTrackingID(String trackingID) {
        int low = 0, high = packages.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = packages.get(mid).trackingID.compareTo(trackingID);
            if (comparison == 0) return packages.get(mid);
            else if (comparison < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }
}
