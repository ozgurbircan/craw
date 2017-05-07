package craw;

import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.url.WebURL;

public class Crawler extends WebCrawler   {

	@Override
	public boolean shouldVisit(Page referringPage, WebURL url) {
		// TODO Auto-generated method stub
	     return url.getURL().startsWith("https://www.kodcu.com");
	}

	@Override
	public void visit(Page page) {
		// TODO Auto-generated method stub
		 String url = page.getWebURL().getURL();
		    try {
			Document document = Jsoup.connect(url).get();
			// get the first <h1> HTML element in the page source code
			Element titleElement = document.getElementsByTag("h1").first();
			// print title text
			System.out.println(titleElement.ownText());			
		     }
		     catch (IOException e) {
		    }
	}
	

}
