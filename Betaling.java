import java.util.*;

public class Betaling
{
    public static void main(String[] args)
    {
        Person Testy = new Person("Tester Gester", "24", "Aktiv", 24);
        Dato TestyD = new Dato(20200519);

        Person Festy = new Person("Festy Mester", "42", "Passiv", 24);
        Dato FestyD = new Dato(20160324);

        List<Person> personer;

        personer = new ArrayList<Person>();
        personer.addFirst(Testy);

        for(int i = 0; i < personer.size(); i++)
            PersonPersistens.writePerson(personer.get(i));



    }
}
