import java.time.LocalDate;

public class Customer {
    // Registrering af stam oplysninger for medlemmer
    private String name;
    private int age;
    private int tlfNr;
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
    public Customer(String name, int age, int tlfNr, String mail, String membership, String membershiptype,
                    String category, Double record, LocalDate recordDate, int year) {
        this.name = name;
        this.age = age;
        this.tlfNr = tlfNr;
        this.mail = mail;

        this.membership = membership;
        this.membershiptype = membershiptype;

        this.category = category;
        this.record = record;
        this.recordDate = recordDate;

        this.isPaid = false; // sætter som ikke betalt by default

        if (age < 18) {
            this.memberDetect = "Junior";
        } else {
            this.memberDetect = "Senior";
        }
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

    public int getTlfNr() {
        return tlfNr;
    }

    public void setTlfNr(int tlfNr) {
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
    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public String getMemberDetect() {
        return memberDetect;
    }

    /*
    public int getYear() {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }
    */
}
