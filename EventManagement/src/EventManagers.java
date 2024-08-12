import java.util.ArrayList;
import java.util.HashMap;

public class EventManagers {

	static int hour = 9, min = 0;
	int phour = 0, pmins = 0;
	static ArrayList<Event> eventlist = new ArrayList<Event>();
	static ArrayList<String> finalevent = new ArrayList<String>();

	public void setevent(int index) {

		for (int i = index; index < eventlist.size(); ++i) {
			pmins = min + eventlist.get(index).mins;
			phour = hour;
			if (pmins > 60) {
				pmins = pmins - 60;
				phour++;

			}
			if (hour < 12) {

				if (phour == 12 && pmins > 0) {
					setevent(i + 1);
				} else {
					String finalisedevent = hour + ":" + min + " AM " + eventlist.get(i).name;
					finalevent.add(finalisedevent);
					hour = phour;
					min = pmins;
				}
			} else if (hour >= 1) {
				if (phour == 5 && pmins > 0) {
					setevent(i + 1);
				} else {
					String finalisedevent = hour + ":" + min + " PM " + eventlist.get(i).name;
					finalevent.add(finalisedevent);
					hour = phour;
					min = pmins;
				}
			}
		}

	}
}
