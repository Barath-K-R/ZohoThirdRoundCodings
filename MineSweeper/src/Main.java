import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int gameover=1;
		MineOperations m=new MineOperations();
		m.initialisemines();
		m.setmines();
		m.displaymines();
		int r,c;
		String move;
		while(gameover==1) {
			System.out.println("enter the mine you want to open");
			move=sc.nextLine();
			r=move.charAt(0)-64;
			c=move.charAt(1)-64;
			System.out.println(r+" "+c);
			gameover=m.checkmine(r,c);
			m.displaymines();
			
			
		}
		if(gameover==0)
			System.out.println("you lose the game");

	}

}
