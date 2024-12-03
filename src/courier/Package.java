package courier;

import java.util.regex.*;

abstract class Package {
    String trackingID;
    String destination;
    double weight;

    public Package(String trackingID, String destination, double weight) {
        if (!validateTrackingID(trackingID)) throw new IllegalArgumentException("Invalid Tracking ID");
        if (!validateDestination(destination)) throw new IllegalArgumentException("Invalid Destination");
        if (weight <= 0) throw new IllegalArgumentException("Weight must be positive");

        this.trackingID = trackingID;
        this.destination = destination;
        this.weight = weight;
    }

    abstract double calculateShippingCost();

    boolean validateTrackingID(String trackingID) {
        return Pattern.matches("PKG\\d{5}", trackingID);
    }

    boolean validateDestination(String destination) {
        return Pattern.matches("[A-Za-z\\s]+", destination);
    }

}
