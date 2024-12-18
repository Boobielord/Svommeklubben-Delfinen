import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        List<Member> members = new ArrayList<>();

        System.out.println("Indtast antal kunder der skal tilføjes:");
        int antal = scan.nextInt();
        scan.nextLine();

        for (int i = 0; i < antal; i++)
        {
            System.out.println("Indtast Oplysninger for Medlemmer " + (i + 1) + ":"); // (i + 1) --> tællingen starter fra "Kunde 1" i stedet for "Kunde 0"
            System.out.println("--------------------------------------");

            System.out.println("Navn:");
            String name = scan.nextLine();

            System.out.println("Alder:");
            int age = scan.nextInt();
            scan.nextLine();

            System.out.println("Telefonnummer:");
            String tlfNr = scan.nextLine();

            System.out.println("Mail:");
            String mail = scan.nextLine();

            String membership;
            while (true)
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
                } else
                {
                    System.out.println("Ugyldigt valg");
                }
            }

            String membershiptype = "N/A"; // Standard for passive medlemmer
            if (membership.equals("Aktiv"))
            {
                while (true)
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
                    } else
                    {
                        System.out.println("Ugyldigt valg");
                    }
                }
            }

            // Hvis det er passive medlemmer
            String category = "N/A"; // Besked i tekst for kategori
            Double record = 0.0; // Default rekordtid
            LocalDate recordDate = null; // Ingen dato for passive medlemmer

            if (membership.equals("Aktiv"))
            {
                while(true)
                {
                    System.out.println("Svømme kategori (1 for Butterfly, 2 for Crawl, 3 for RygCrawl, 4 for Brystvonning");
                    int svommeCategory = scan.nextInt();
                    scan.nextLine();

                    if (svommeCategory == 1)
                    {
                        category = "butterfly";
                        break;
                    }else if (svommeCategory == 2)
                    {
                        category = "crawl";
                        break;
                    }else if (svommeCategory == 3)
                    {
                        category = "rygCrawl";
                        break;
                    }else if (svommeCategory == 4)
                    {
                        category = "brystvonning";
                        break;
                    } else
                    {
                        System.out.println("ugyldig category");
                    }
                }

                System.out.println("Rekordtid: "); // tid skrives med ","
                String recordInput = scan.nextLine().replace(",", ".");
                record = Double.parseDouble(recordInput);

                System.out.println("Rekord dato (YYYY-MM-DD): ");
                String recordDateInput = scan.nextLine();
                recordDate = LocalDate.parse(recordDateInput, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            }

            // Antal år medlemskab varer
            System.out.println("Antal år medlemskab varer: ");
            int year = scan.nextInt();
            scan.nextLine();

            // Betalingsstatus
            boolean isPaid; // default --> ikke betalt
            while (true)
            {
                System.out.println("Er medlemsskab betalt? (tast 1 for ja, 2 for nej):");
                int betalingsValg = scan.nextInt();
                scan.nextLine();

                if (betalingsValg == 1)
                {
                    isPaid = true;
                    break;
                }
                else if (betalingsValg == 2)
                {
                    isPaid = false;
                    break;
                }
                else
                {
                    System.out.println("Ugyldigt valg");
                }
            }

            // Tilføj kunden til listen
            members.add(new Member(name, age, tlfNr, mail, membership, membershiptype, category, record, recordDate, isPaid, year));

        }

        // Skriv alle kunder til fil
        for (int i = 0; i < members.size(); i++)
        {
            Member member = members.get(i);
            PersonPersistens.writePerson(member);
        }

        List<Member> allMembers = PersonPersistens.readPerson();
        allMembers.addAll(members);

        printTop5Results("Butterfly", allMembers, "Butterfly");
        printTop5Results("Crawl", allMembers, "Crawl");
        printTop5Results("RygCrawl", allMembers, "RygCrawl");
        printTop5Results("Brystvonning", allMembers, "Brystvonning");

        scan.close();
    }

    public static void printTop5Results(String categoryName, List<Member> members, String discipline)
    {
        System.out.println("top 5 " + categoryName + " Results:");
        members.stream()
                .filter(c -> c.getCategory().equalsIgnoreCase(discipline) && c.getRecordDate() != null)
                .sorted(Comparator.comparingDouble(Member::getRecord))
                .limit(5)
                .forEach(c -> System.out.println(c.getName() + " - time: " + c.getRecord() + " seconds"));
    }
}
