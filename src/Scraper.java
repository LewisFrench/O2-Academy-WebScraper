import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;



public class Scraper {
	
	public ArrayList<Month> Scrape() throws IOException {
		ArrayList<String> fullString = new ArrayList<String>();
		ArrayList<Month> monthList = new ArrayList<Month>();
		Document doc = Jsoup.connect("https://www.academymusicgroup.com/o2academynewcastle/events/all").get();
		Elements months = doc.getElementsByClass("item-list");
		
		Elements headers = doc.select("h3:not(.m0)");
		headers.remove(headers.size()-1);
		
		//for (Element element : months) {
		for (int i = 0; i<months.size()-1; i++) {
			fullString.removeAll(fullString);
			Element element = months.get(i);
			Elements titles = element.select("h3 >a[href]");
			Elements eventTime = element.getElementsByClass("col col-2 event-date");
			//Elements eventStatus = element.getElementsByClass("btn sml right mt1 ticket-status-$ticket_status_id ticket-sold-out");
			Elements eventStatus = element.getElementsByClass("col col-3 event-actions");
			for (int y = 0; y<eventTime.size();y++) {
				//fullString.add(titles.get(y).text() +"~~" +eventTime.get(y).text());
				String status = eventStatus.get(y).text();
				status = status.substring(10, status.length());
				System.out.println(status);
				if (status != "Buy Tickets") {
					fullString.add(titles.get(y).text() +"~~" +eventTime.get(y).text()+"~~"+status);
				} else {
					fullString.add(titles.get(y).text() +"~~" +eventTime.get(y).text()+"~~"+"Event is on");
				}
				// delimiter cannot be | or space as they are used in presentation on site
			}
		    Marshaller m = new Marshaller(headers.get(i).text(), fullString);
		    monthList.add(m.marshallEvents());
		}
		return monthList;
	}
}
