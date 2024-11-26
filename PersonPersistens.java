import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test
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


            // writer.append tager kun String så andet skal konverteres
            writer.append("Navn: " + name + ", ");
            writer.append("Alder: " + Integer.toString(age) +  ", ");
            writer.append("Membership status: " + membership + ", ");
            writer.append("Svømme kategori: " + category + ", ");
            writer.append("Rekordtid: " + Double.toString(record) + '\n');

            System.out.println("Customer info has been saved");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void readPerson()
    {
        // Skilletegn mellem atributter er et komma
        String komma = ",";
        String line = "";
        String personFile = "Customer info.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(personFile)))
        {
            // Read each line from the file
            while ((line = br.readLine()) != null)
            {
                String[] data = line.split(komma);

                // Print the data - name, age, membership, category, record
                System.out.println("Navn: " + data[0] + ", Alder: " + data[1] + ", Medlems status: " + data[2]+", Svømmertype: " + data[3] + ", ");
            }
        }

        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}