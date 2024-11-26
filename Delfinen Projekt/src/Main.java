// Define the Main class
public class Main {
    // jeg definer the main method af programe
    public static void main(String[] args) {
        // Første customer data
        Customer customer1 = new Customer("Victor",15, "Normal", "Butterfly", 90.17);
        // Anden customer
        Customer customer2 = new Customer("Charlie", 20, "Professional", "crawl", 60.20 );


        System.out.println(customer1.getName() + " is " + customer1.getAge() + "years old.");

        System.out.println(customer2.getName() + " is " + customer2.getAge() + "years old.");

    }
}