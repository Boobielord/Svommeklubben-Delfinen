public class Fee {
    // Method to calculate membership fees
    public double calculateFees() {
        double seniorFee = 1600.00;
        double juniorFee = 1000.00;
        double passiveFee = 500.00;
        double discountRate_60_above = 0.25;

        if (year < 1) {
            return passiveFee;
        } else if (age < 18) {
            return juniorFee * year;
        } else if (age > 60) {
            return seniorFee * discountRate_60_above * year;
        }

        return seniorFee * year;
    }

    // Method to check for special offers
    public String checkSpecialOffers() {
        if (membershiptype.equalsIgnoreCase("Over 60 år gammel")) {
            return "25% on membership.";
        } else {
            return "No special offers available.";
        }
    }

    // Method to display membership details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Membership Type: " + membershiptype);
        System.out.println("Duration: " + year + " months");
        System.out.println("Membership Fees: $" + calculateFees());
        System.out.println("Special Offers: " + checkSpecialOffers());
    }
}
