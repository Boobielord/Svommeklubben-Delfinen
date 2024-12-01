// Customer class that wants to swing
public class Customer {
    // Private variable to store the name of the customer
    private String name;
    // Declare a private variable to store the age of the customer
    private int age;
    // Jeg skal definer om de er aktive eller passiv, almindelig eller konkurrence
    private String membership;
    //definer membership om den er active eller passiv
    private String membershiptype;
    //definer antal år til betaling
    protected int year;
    // I hvilket category er person tilmeldt
    private String category;
    // Der skal definer record for de top 5 i hver category
    private Double record;


    // Constructor for the Customer class that initializes the name and variables
    public Customer(String name, int age, String membership, String membershiptype, int year, String category, Double record) {
        this.name = name;
        this.age = age;
        this.membership = membership;
        this.membershiptype = membershiptype;
        this.year = year;
        this.category = category;
        this.record = record;
    }

    // Method to retrieve the name of the customer
    public String getName() {
        return name;
    }

    // Method to set the name of the customer
    public void setName(String name) {
        this.name = name;
    }

    // Method to retrieve the age of the customer
    public int getAge() {
        return age;
    }

    // Method to set the age of the customer
    public void setAge(int age)
    {
        this.age = age;
    }
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

    public int getYear() {
        return year;
    }

    // Method to set the age of the customer
    public void setYear(int year)
    {
        this.year = year;
    }

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


}
