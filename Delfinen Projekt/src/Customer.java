// Define the Customer class
public class Customer {
    // Declare a private variable to store the name of the customer
    private String name;
    // Declare a private variable to store the age of the customer
    private Int age;

    // Constructor for the Dog class that initializes the name and breed variables
    public Customer(String name, Int age) {
        // Set the name variable to the provided name parameter
        this.name = name;
        // Set the age variable to the provided age parameter
        this.age = age;
    }

    // Method to retrieve the name of the customer
    public String getName() {
        // Return the value of the name variable
        return name;
    }

    // Method to set the name of the customer
    public void setName(String name)
    {
        // Set the name variable to the provided name parameter
        this.name = name;
    }

    // Method to retrieve the age of the customer
    public Int getAge()
    {
        // Return the value of the breed variable
        return age;
    }

    // Method to set the age of the customer
    public void setAge(Int age) {
        // Set the breed variable to the provided breed parameter
        this.age = age;
    }
}