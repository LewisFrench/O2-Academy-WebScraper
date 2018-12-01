import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Marshaller {
	private String monthYear;
	private ArrayList<String> events;
	
	Marshaller (String monthYear, ArrayList<String> events) {
		this.monthYear = monthYear;
		this.events = events;
	}	
	
	public Month marshallEvents(){
		ArrayList<Event> eventList = new ArrayList<Event>();
		for (String element : events) {
			eventList.add(marshallEvent(element));
		}
		String[] monthParts = monthYear.split(" ");
		return new Month(monthParts[0], monthParts[1], eventList);
	}
	
	public Event marshallEvent (String event) {
		String[] parts = event.toString().split("~~");
		String[] timeParts = splitTime(parts[1]);
		
		Event finalEvent = new Event(parts[0],monthYear, timeParts[0], timeParts[1], timeParts[2].toUpperCase(), parts[2]);
		return finalEvent;			
	}
	
	public String[] splitTime(String parts) {
		return parts.split(" ");
	}
	
}
