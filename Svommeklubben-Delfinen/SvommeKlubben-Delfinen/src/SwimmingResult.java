import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Write a description of class SwimmingResult here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SwimmingResult
{
    private ArrayList <SwimmingDiscipline> butterflyResults;
    private ArrayList <SwimmingDiscipline> crawlResults;
    private ArrayList <SwimmingDiscipline> rygCrawlResults;
    private ArrayList <SwimmingDiscipline> brystvonningResults;

    public SwimmingResult()
    {
        butterflyResults = new ArrayList<>();
        crawlResults = new ArrayList<>();
        rygCrawlResults = new ArrayList<>();
        brystvonningResults = new ArrayList<>();
    }

    public void addResult(String discipline, SwimmingDiscipline result)
    {
        switch (discipline.toLowerCase())
        {
            case "butterfly":
                butterflyResults.add(result);
                break;
            case "crawl":
                crawlResults.add(result);
                break;
            case "ryg crawl":
                rygCrawlResults.add(result);
                break;
            case "brystvonning":
                brystvonningResults.add(result);
                break;
            default:
                System.out.println("Invalid discipline: " + discipline);
        }
    }

    public void printTop5Results(String disciplineName, ArrayList<SwimmingDiscipline> results)
    {
        if (results.isEmpty())
        {
            System.out.println("No results for " + disciplineName);
            return;
        }

        Collections.sort(results, Comparator.comparingDouble(SwimmingDiscipline::getTime));

        // print top 5
        System.out.println("Top 5 " + disciplineName + " Results:");
        for (int i = 0; i < Math.min(5, results.size()); i++)
        {
            SwimmingDiscipline sd = results.get(i);
            System.out.println((i + 1) + ". " + sd.getSwimmerName().getName() + " - Time: " + sd.getTime() + " seconds");
        }
        System.out.println();
    }

    public void printResults()
    {
        printTop5Results("Butterfly", butterflyResults);
        printTop5Results("Crawl ", crawlResults);
        printTop5Results("Backstroke (RygCrawl)", rygCrawlResults);
        printTop5Results("Breaststroke (Brystvonning)", brystvonningResults);
    }
}
