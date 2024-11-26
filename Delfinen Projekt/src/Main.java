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



        /*
        import java.util.*;

        public class Main
        {
            public static void main(String[] args)
            {
                Scanner scan = new Scanner(System.in);
                List<Customer> customers = new ArrayList<>();

                System.out.println("Indtast antal kunder der skal tilføjes:");
                int antal = scan.nextInt();
                scan.nextLine(); // Rens input buffer efter nextInt()

                for(int i = 0; i < antal; i++)
                {
                    System.out.println("Indtast kundeoplysninger for kunde " + (i + 1) + ":");
                    System.out.println("--------------------------------------");

                    System.out.println("Navn:");
                    String name = scan.nextLine(); // Læs navn
                    System.out.println();

                    System.out.println("Alder:");
                    int age = scan.nextInt();
                    scan.nextLine(); // Rens input buffer efter nextInt()
                    System.out.println();

                    System.out.println("Medlemsstatus:");
                    String membership = scan.nextLine(); // Læs medlemsstatus
                    System.out.println();

                    System.out.println("Svømme kategori:");
                    String category = scan.nextLine(); // Læs kategori
                    System.out.println();

                    System.out.println("Rekordtid:");
                    Double record = scan.nextDouble();
                    scan.nextLine(); // Rens input buffer efter nextDouble()
                    System.out.println();

                    // tilføj nye kunder til listen
                    customers.add(new Customer(name, age, membership, category, record));
                }

                // skriver alle kunder til fil
                for(int i = 0; i < customers.size(); i++)
                {
                    Customer customer = customers.get(i);
                    PersonPersistens.writePerson(customer);
                }

                System.out.println("\nReading customer data from file: ");
                PersonPersistens.readPerson();

                scan.close();
            }
        }*/
    }
}