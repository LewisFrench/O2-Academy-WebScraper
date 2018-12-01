import java.util.ArrayList;

public class Month {
	private String month;
	private String year;
	private ArrayList<Event> events = new ArrayList<Event>();
	
	
	public Month (String month, String year, ArrayList<Event> events) {
		this.month = month;
		this.year = year;
		this.events = events;
	}
	
	
	public String toString() {
		String output = "";
		output += ("\n\n-	-	-	-	-	-	-	-	-	-	-\nEvents scheduled for " + month + " " + year+"\n");
		for (int i=0; i<events.size();i++) {
			output += ("\n\n" + events.get(i).toString());
		}
		return output;
	}


	public ArrayList<Event> getEvents() {
		return events;
	}
}
