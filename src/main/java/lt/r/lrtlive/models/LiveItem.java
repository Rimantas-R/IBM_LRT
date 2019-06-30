package lt.r.lrtlive.models;

public class LiveItem {

	private String chanel;
	private String title;
	private String schedule;
	
	public LiveItem() {
	}

	public LiveItem(String chanel, String title, String schedule) {
		this.chanel = chanel;
		this.title = title;
		this.schedule = schedule;
	}

	public String getChanel() {
		return chanel;
	}

	public void setChanel(String chanel) {
		this.chanel = chanel;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "LiveItem [chanel=" + chanel + ", title=" + title + ", schedule=" + schedule + "]";
	}
	
	
	
	
}
