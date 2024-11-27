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
            String membership = p.getMembership();
            String category = p.getCategory();
            Double record = p.getRecord();
            LocalDate recordDate = p.getRecordDate();


            writer.append("Navn: " + name + ", ");
            writer.append("Alder: " + age +  ", ");
            writer.append("Membership status: " + membership + ", ");
            writer.append("Svømme kategori: " + category + ", ");
            writer.append("Rekordtid: " + record + ", ");


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
        // Skilletegn mellem atributer er et komma
        String komma = ",";
        String line = "";
        String personFile = "Customer info.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(personFile)))
        {
            // Læs hver linje fra filen
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(komma);

                // Udskriv data: navn, alder, medlemsstatus, kategori, rekordtid, og dato
                System.out.print(data[0].trim() + ", ");
                System.out.print(data[1].trim() + ", ");
                System.out.print(data[2].trim() + ", ");
                System.out.print(data[3].trim() + ", ");
                System.out.print(data[4].trim());

                // Hvis dato for rekord tid findes tilføjes den også
                if (data.length > 5)
                {
                    System.out.print(", " + data[5].trim());
                }

                System.out.println(); // Gå til næste linje
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}