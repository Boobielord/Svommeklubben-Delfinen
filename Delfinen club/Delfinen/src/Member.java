import java.time.LocalDate;

public class Member {
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
    public Member(String name, int age, String tlfNr, String mail, String membership, String membershiptype,
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

    public int getAge() {
        return age;
    }

    public String getTlfNr() {
        return tlfNr;
    }

    public String getMail() {
        return mail;
    }

    // medlems info
    public String getMembership() {
        return membership;
    }

    public String getMembershiptype() {
        return membershiptype;
    }

    public String getMemberDetect() {
        return memberDetect;
    }

    // registrering af svømning
    public String getCategory() {
        return category;
    }

    public Double getRecord() {
        return record;
    }

    public LocalDate getRecordDate() {
        return recordDate;
    }

    // betaling
    public boolean getIsPaid() {
        return isPaid;
    }

    public int getYear() {
        return year;
    }

    // Method to calculate membership fees
    public double calculateFees() {
        double seniorFee = 1600.00;
        double juniorFee = 1000.00;
        double passiveFee = 500.00;
        double discountRate_60_above = 0.25;

        // Udregn ift. alder og medlemstype
        if (this.membership.equalsIgnoreCase("Passiv")) {
            return passiveFee * this.year; // Passiv medlemskab der betales årligt
        } else if (this.age < 18) {
            return juniorFee * this.year; // Junior medlemskab årlig betaling
        } else if (this.age > 60) {
            return seniorFee * discountRate_60_above * this.year; // Rabat for sr. over 60 år
        }

        return seniorFee * this.year;
    }
}
