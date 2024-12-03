import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class PersonPersistens
{
    public static void writePerson(Customer p)
    {
        String personFile = "Customer info.txt"; //navn på output-filen

        try (FileWriter writer = new FileWriter(personFile, true))
        {
            String name = p.getName();
            int age = p.getAge();
            int tlfNr = p.getTlfNr();
            String mail = p.getMail();
            String membership = p.getMembership();
            String membershiptype = p.getMembershiptype();
            String category = p.getCategory();
            Double record = p.getRecord();
            LocalDate recordDate = p.getRecordDate();
            String memberDetect = p.getMemberDetect();


            writer.append("Navn: " + name + " | ");
            writer.append("Alder: " + age + " (" + memberDetect + ")" + " | ");
            writer.append("Tlf. nr: " + tlfNr + " | ");
            writer.append("Mail:" + mail + " | ");
            writer.append("Medlem status: " + membership + " | ");
            writer.append("Medlemstype: " + membershiptype + " | ");
            writer.append("Svømme kategori: " + category + " | ");
            writer.append("Rekordtid: " + record + " | ");


            if(recordDate != null)
            {
                writer.append("Dato: " + recordDate);
            }

            writer.append("\n"); // tilføjelse af ny linje for næste customer
            System.out.println("Kundeoplysninger gemt");
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    public static void readPerson()
    {
        String skilleTegn = " \\| "; // Skilletegn mellem attributer er " | "
        String line = "";
        String personFile = "Customer info.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(personFile)))
        {
            // Læs hver linje fra filen
            while ((line = br.readLine()) != null)
            {
                // Split linjen vha. " | " som skilletegn
                String[] data = line.split(skilleTegn);

                // Udskrivining af det der er
                System.out.println("Data fra fil: ");
                for (int i = 0; i < data.length; i++)
                {
                    System.out.print(data[i].trim() + " | ");
                }

                // Hvis der mangler data tilføjes "N/A" ved manglende felter
                int feltMangel = 8 - data.length;
                for (int i = 0; i < feltMangel; i++) {
                    System.out.print("N/A | ");
                }

                // Gå til næste linje
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Der opstod en fejl ved læsning af fil");
            e.printStackTrace();
        }
    }

}
