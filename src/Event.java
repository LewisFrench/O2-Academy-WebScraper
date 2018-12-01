import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {
	public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd EEEE h.mma MMMM yyyy");
	
	private String time;
	private String title;
	private LocalDate date;
	private String status;

	public Event (String title, String month, String day, String date, String time, String status) {
		this.title = title;
		this.date = LocalDate.parse(String.format("%s %s %s %s", date, day, time, month), formatter);
		this.time = time;
		this.status = status;
	}
	public String getStatus() {
		return status;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}
	public int getHour() {
		//System.out.println (this.getTime().charAt(0));
		return 13 + Character.getNumericValue(this.getTime().charAt(0)) ;
	}
	public int getMinutes() {
		//System.out.println (this.getTime().charAt(2) + (this.getTime().charAt(3) + "  " + this.getTime()));
		return 10* Character.getNumericValue(this.getTime().charAt(this.getTime().length()-4)) ;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Event [title=" + title + ", date=" + date + ", time="+time+", status="+status+"]";
	}
}
