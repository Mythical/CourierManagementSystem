package courier;

class StandardPackage extends Package {
    public StandardPackage(String trackingID, String destination, double weight) {
        super(trackingID, destination, weight);
    }

    @Override
    double calculateShippingCost() {
        return weight * 2.5;
    }
}