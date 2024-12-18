import java.time.LocalDate;
/**
 * Write a description of class SwimmingDiscipline here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SwimmingDiscipline
{
    private Member swimmerName; // implement angelo classe
    private String discipline; // type af discipliner
    private double time; // tid recorded for discipline
    private LocalDate recordDate; // recorder datoen

    public SwimmingDiscipline(Member swimmerName, String discipline, double time, LocalDate recordDate)
    {
        this.swimmerName = swimmerName;
        this.discipline = discipline;
        this.time = time;
        this.recordDate = recordDate;
    }

    public double getTime()
    {
        return time;
    }
    public Member getSwimmerName()
    {
        return swimmerName;
    }
}
