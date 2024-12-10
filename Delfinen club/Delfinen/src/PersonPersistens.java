import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonPersistens {

    public static void writePerson(Member p)
    {
        String personFile = "Member info.txt"; //navn på output-filen

        try (FileWriter writer = new FileWriter(personFile, true))
        {
            String name = p.getName();
            int age = p.getAge();
            String tlfNr = p.getTlfNr();
            String mail = p.getMail();
            String membership = p.getMembership();
            String membershiptype = p.getMembershiptype();
            String category = p.getCategory();
            Double record = p.getRecord();
            LocalDate recordDate = p.getRecordDate();
            String memberDetect = p.getMemberDetect();
            boolean isPaid = p.getIsPaid();
            int year = p.getYear();


            writer.append("Navn: " + name + " | ");
            writer.append("Alder: " + age + " (" + memberDetect + ")" + " | ");
            writer.append("Tlf. nr: " + tlfNr + " | ");
            writer.append("Mail:" + mail + " | ");
            writer.append("Medlem status: " + membership + " | ");
            writer.append("Medlemstype: " + membershiptype + " | ");
            writer.append("Svømme kategori: " + category + " | ");
            writer.append("Rekordtid: " + record + " | ");
            if (p.getRecordDate() != null) {
                writer.append("Dato: " + p.getRecordDate() + " | ");
            }

            String paymentStatus;
            if (isPaid)
            {
                paymentStatus = "betalt";
            } else {
                paymentStatus = "ikke betalt";
            }

            writer.append(" Betalings status: " + paymentStatus + " | ");
            writer.append("Medlemsgebyr: " + p.calculateFees() + " kr. | ");
            writer.append("aar: " + year + " | ");
            writer.append("\n"); // tilføjelse af ny linje for næste Medlemmer

            System.out.println("Kundeoplysninger gemt");
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static List<Member> readPerson()
    {
        String skilleTegn = " \\| "; // Skilletegn mellem attributer er " | "
        String line = "";
        String personFile = "Member info.txt";
        List<Member> membersFromFile = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(personFile)))
        {
            // Læs hver linje fra filen
            while ((line = br.readLine()) != null)
            {
                // Split linjen vha. " | " som skilletegn
                String[] data = line.split(skilleTegn);

                if (data.length < 9)
                {
                    System.out.println("" + line); //Ugyldig data
                    continue;
                }

                // Hvis der mangler data tilføjes "N/A" ved manglende felter
                int feltMangel = 12 - data.length;
                for (int i = 0; i < feltMangel; i++) {
                    System.out.print("N/A | ");
                }
                try {
                    String name = data[0].split(": ")[1].trim();
                    int age = Integer.parseInt(data[1].split(": ")[1].trim());
                    String tlfNr = data[2].split(": ")[1].trim();
                    String mail = data[3].split(": ")[1].trim();
                    String membership = data[4].split(": ")[1].trim();
                    String membershiptype = data[5].split(": ")[1].trim();
                    String category = data[6].split(": ")[1].trim();
                    Double record = Double.parseDouble(data[7].split(": ")[1].trim());
                    LocalDate recordDate = data.length > 8 && data[8].contains("Dato") ? LocalDate.parse(data[8].split(": ")[1].trim()) : null;
                    int year = Integer.parseInt(data[9].split(": ")[1].trim());

                    boolean isPaid = data[9].contains("betalt");

                    Member member = new Member (name,age, tlfNr, mail, membership, membershiptype, category, record, recordDate, isPaid, year);
                    membersFromFile.add(member);

                } catch (Exception e) {
                    System.out.println("" + line); //"Ugylde data
                }
            }
        } catch (IOException e) {
            System.out.println("Der opstod en fejl ved læsning af fil");
            e.printStackTrace();
        }
        return membersFromFile;
    }
}
