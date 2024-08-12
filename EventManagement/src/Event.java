
public class Event {
	String name;
	int mins;
	boolean set;

	public Event(String name) {

		this.name = name;
		this.mins = this.gettime();
		this.set = false;
	}

	public int gettime() {
		int time = Integer.valueOf(this.name.replaceAll("\\D+", ""));
		return time;
	}

}
