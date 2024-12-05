import java.time.LocalDate;

public class Customer {
    // Registrering af stam oplysninger for medlemmer
    private String name;
    private int age;
    private String tlfNr;
    private String mail;

    // Medlem info
    private String membership; // er medlemsskabet aktiv / passiv
    private String membershiptype; // for medlemstypen - motionist, konkurrence
    private String memberDetect; // detect for junior / senior svømmer afhængig af alder

    // Registering af svømning
    private String category; // svømmekategori
    private Double record; // rekord tid for svømmekategori
    private LocalDate recordDate; // Dato for rekord tider YYYY-MM-DD

    // Betaling system
    private boolean isPaid; // betaling status
    private int year; // definer antal år til betaling

    // Constructor med parametre
    public Customer(String name, int age, String tlfNr, String mail, String membership, String membershiptype,
                    String category, Double record, LocalDate recordDate, boolean isPaid, int year) {
        this.name = name;
        this.age = age;
        if (age < 18) {
            this.memberDetect = "Junior";
        } else {
            this.memberDetect = "Senior";
        }
        this.tlfNr = tlfNr;
        this.mail = mail;

        this.membership = membership;
        this.membershiptype = membershiptype;

        this.category = category;
        this.record = record;
        this.recordDate = recordDate;

        this.year = year;
        this.isPaid = isPaid; // sætter som ikke betalt by default
    }

    // Getters og setters
    // stam oplysninger
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        if (age < 18) {
            this.memberDetect = "Junior";
        } else {
            this.memberDetect = "Senior";
        }
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public void setTlfNr(String tlfNr) {
        this.tlfNr = tlfNr;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


    // medlems info
    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public String getMembershiptype() {
        return membershiptype;
    }

    public void setMembershiptype(String membershiptype) {
        this.membershiptype = membershiptype;
    }

    public String getMemberDetect() {
        return memberDetect;
    }

    public void setMemberDetect(String memberDetect) {
        this.memberDetect = memberDetect;
    }


    // registrering af svømning
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getRecord() {
        return record;
    }

    public void setRecord(Double record) {
        this.record = record;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(LocalDate recordDate) {
        this.recordDate = recordDate;
    }

    // betaling
    public boolean getIsPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    // Method to calculate membership fees
    public double calculateFees()
    {
        double seniorFee = 1600.00;
        double juniorFee = 1000.00;
        double passiveFee = 500.00;
        double discountRate_60_above = 0.25;

        // Udregn ift. alder og medlemstype
        if (this.membership.equalsIgnoreCase("Passiv"))
        {
            return passiveFee * this.year; // Passiv medlemskab der betales årligt
        } else if (this.age < 18)
        {
            return juniorFee * this.year; // Junior medlemskab årlig betaling
        } else if (this.age > 60)
        {
            return seniorFee * discountRate_60_above * this.year; // Rabat for sr. over 60 år
        }

        return seniorFee * this.year;
    }

    // Method to display membership details
    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Membership Type: " + membershiptype);
        System.out.println("Varighed: " + year + " år");
        System.out.println("Medlemsgebyr: " + calculateFees() + " kr.");
        //System.out.println("Special Offers: " + checkSpecialOffers());
    }
}
