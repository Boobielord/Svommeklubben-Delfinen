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
            System.out.println("Indtast kundeoplysninger for kunde " + (i + 1) + ":");
            System.out.println("--------------------------------------");

            System.out.println("Navn:");
            String name = scan.nextLine();

            System.out.println("Alder:");
            int age = scan.nextInt();
            scan.nextLine();

            System.out.println("Medlemsstatus (aktiv/passiv):");
            String membership = scan.nextLine();

            // Hvis det er passive medlemmer
            String category = "N/A"; // Besked i tekst for kategori
            Double record = 0.0; // Default rekordtid
            LocalDate recordDate = null; // Ingen dato for passive medlemmer


            // Hvis det er aktive medlemmer
            if (membership.equals("aktiv"))
            {
                System.out.println("Svømme kategori: ");
                category = scan.nextLine();

                System.out.println("Rekordtid: "); // tid skrives med ","
                record = scan.nextDouble();
                scan.nextLine();

                System.out.println("Rekord dato (YYYY-MM-DD): ");
                String recordDateInput = scan.nextLine();
                recordDate = LocalDate.parse(recordDateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }


            else if (membership.equals("passiv"))
            {
                System.out.println("Passivt medlem registreret");
            }

            // Tilføj kunden til listen
            customers.add(new Customer(name, age, membership, category, record, recordDate));
        }

        // Skriv alle kunder til fil
        for (int i = 0; i < customers.size(); i++)
        {
            Customer customer = customers.get(i);
            PersonPersistens.writePerson(customer);
        }

        PersonPersistens.readPerson();

        scan.close();
    }
}
