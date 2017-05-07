package craw;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
@WebServlet(name="SErvler",urlPatterns={"/servlet"})
public class Controller extends HttpServlet {
    public static void main(String[] args) throws Exception {
        String crawlStorageFolder = "/crawler/testdata";
        int numberOfCrawlers = 4;
        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);
        controller.addSeed("http://ozgurbircan.com");
        controller.start(Crawler.class, numberOfCrawlers);
    }
}