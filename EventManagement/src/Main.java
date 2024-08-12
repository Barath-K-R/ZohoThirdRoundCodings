import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		EventManagers em = new EventManagers();
		int n = sc.nextInt();
		System.out.println("enter the events");
		for (int i = 0; i < n; ++i) {
			String s = sc.nextLine();
			Event e = new Event(s);
			em.eventlist.add(e);
		}
		em.setevent(0);

	}

}
