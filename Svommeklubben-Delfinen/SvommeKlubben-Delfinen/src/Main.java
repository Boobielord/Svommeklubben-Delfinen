import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        List<Customer> customers = new ArrayList<>();

        System.out.println("Indtast antal kunder der skal tilføjes:");
        int antal = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < antal; i++)
        {
            System.out.println("Indtast kundeoplysninger for kunde " + (i + 1) + ":"); // (i + 1) --> tællingen starter fra "Kunde 1" i stedet for "Kunde 0"
            System.out.println("--------------------------------------");

            System.out.println("Navn:");
            String name = scan.nextLine();

            System.out.println("Alder:");
            int age = scan.nextInt();
            scan.nextLine();

            String memberDetect;
            if (age < 18)
            { memberDetect = "Junior";
            } else
            { memberDetect = "Senior";}

            System.out.println("Telefonnummer:");
            int tlfNr = scan.nextInt();
            scan.nextLine();

            System.out.println("Mail:");
            String mail = scan.nextLine();

            String membership = "";
            while(true)
            {
                System.out.println("Vælg medlemsstatus (tast 1 for aktiv, 2 for passiv):");
                int membershipChoice = scan.nextInt();
                scan.nextLine();

                if (membershipChoice == 1)
                {
                    membership = "Aktiv";
                    break;
                } else if (membershipChoice == 2)
                {
                    membership = "Passiv";
                    break;
                } else {
                    System.out.println("Ugyldigt valg");
                }
            }


            String membershiptype = "N/A"; // Standard for passive medlemmer
            if (membership.equals("Aktiv"))
            {
                while(true)
                {
                    System.out.println("Vælg medlemstype (tast 1 for motionist, 2 for konkurrence):");
                    int membershipTypeChoice = scan.nextInt();
                    scan.nextLine();

                    if (membershipTypeChoice == 1)
                    {
                        membershiptype = "Motionist";
                        break;
                    } else if (membershipTypeChoice == 2)
                    {
                        membershiptype = "Konkurrence";
                        break;
                    } else {
                        System.out.println("Ugyldigt valg");
                    }
                }
            }


            // Hvis det er passive medlemmer
            String category = "N/A"; // Besked i tekst for kategori
            Double record = 0.0; // Default rekordtid
            LocalDate recordDate = null; // Ingen dato for passive medlemmer

            // Hvis det er aktive medlemmer
            if (membership.equals("Aktiv"))
            {
                System.out.println("Svømme kategori: ");
                category = scan.nextLine();

                System.out.println("Rekordtid: "); // tid skrives med ","
                String recordInput = scan.nextLine().replace("," , ".");
                record = Double.parseDouble(recordInput);

                System.out.println("Rekord dato (YYYY-MM-DD): ");
                String recordDateInput = scan.nextLine();
                recordDate = LocalDate.parse(recordDateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }


            // Tilføj kunden til listen
            customers.add(new Customer(name, age, tlfNr, mail, membership, membershiptype, category, record, recordDate));
        }


        // Skriv alle kunder til fil
        for (int i = 0; i < customers.size(); i++)
        {
            Customer customer = customers.get(i);
            PersonPersistens.writePerson(customer);
        }
        List<Customer> allCustomers = PersonPersistens.readPerson();
        allCustomers.addAll(customers);

        printTop5Results("Butterfly", allCustomers, "Butterfly");
        printTop5Results("Crawl", allCustomers, "Crawl");
        printTop5Results("RygCrawl", allCustomers, "RygCrawl");
        printTop5Results("Brystvonning", allCustomers, "Brystvonning");
        scan.close();
    }
    public static void printTop5Results(String categoryName, List<Customer> customers, String discipline)
    {
        System.out.println("top 5 " + categoryName + " Results:");
        customers.stream()
                .filter(c -> c.getCategory().equalsIgnoreCase(discipline) && c.getRecordDate() != null)
                .sorted(Comparator.comparingDouble(Customer::getRecord))
                .limit(5)
                .forEach(c -> System.out.println(c.getName() + " - time: " + c.getRecord() + " seconds"));
    }
}
