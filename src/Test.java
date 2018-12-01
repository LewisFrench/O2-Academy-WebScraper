import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;

public class Test {
	public static void main(String[] args) throws IOException {
		Scraper s = new Scraper();
		 ArrayList<Month> monthList = new ArrayList<>();
		 monthList = s.Scrape();
		 //System.out.println(monthList);
		 toFile(monthList);
	}
	
	public static void toFile(ArrayList<Month> monthList) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("eventData.csv"));
		ZoneId zone = ZoneId.of("Europe/Berlin");
		for (Month m : monthList) {
			for (Event e : m.getEvents()) {
				ZoneOffset zoneOffSet = zone.getRules().getOffset(e.getDate().atStartOfDay());
				//pw.printf("\"%s\",%d\n", e.getTitle(), e.getDate().atStartOfDay(ZoneId.systemDefault()).toEpochSecond());
				//pw.printf("\"%s\",%d, %s\n", e.getTitle(), e.getDate().atTime(e.getHour(), e.getMinutes()).toEpochSecond(zoneOffSet), e.getStatus());	
				pw.printf("\"%s\",%d, %s\n", e.getTitle(), e.getDate().atTime(e.getHour(), e.getMinutes()).toEpochSecond(zoneOffSet), e.getStatus());
			}
		}
		pw.flush();
		pw.close();
	}
}
