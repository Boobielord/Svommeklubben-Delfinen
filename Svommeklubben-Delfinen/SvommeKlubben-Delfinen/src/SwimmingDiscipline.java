
/**
 * Write a description of class SwimmingDiscipline here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SwimmingDiscipline
{
    private String butterfly;
    private String crawl;
    private String rygCrawl;
    private String brystvonning;

    public SwimmingDiscipline(String butterfly, String crawl, String rygCrawl, String brystvonning)
    {
        this.butterfly = butterfly;
        this.crawl = crawl;
        this.rygCrawl = rygCrawl;
        this.brystvonning = brystvonning;
    }

    public String getButterfly()
    {
        return butterfly;
    }

    public String getCrawl()
    {
        return crawl;
    }

    public String getRygCrawl()
    {
        return rygCrawl;
    }

    public String getBrystvonning()
    {
        return brystvonning;
    }
}