package operations;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc=new Scanner(System.in);
		BoardOperation b=new BoardOperation();
		
		b.initialiseplayers();
		b.initialiseBoard();
		b.printboard();
		
		int game=1,player1move=1,player2move=1;
		int r1=0,c1=0,r2=0,c2=0;
		while(game==1)
		{
			while(player1move==1) {
			System.out.println(BoardOperation.player1.getName()+" enter your move");
			r1=sc.nextInt();
			c1=sc.nextInt();
			r2=sc.nextInt();
			c2=sc.nextInt();
			player1move=b.makemove(b.player1, r1, c1, r2, c2);
			if(player1move==-1)
				game=0;
			}
			
			while(player2move==1) {
			System.out.println(BoardOperation.player2.getName()+" enter your move");
			r1=sc.nextInt();
			c1=sc.nextInt();
			r2=sc.nextInt();
			c2=sc.nextInt();
			
			player2move=b.makemove(b.player2, r1, c1, r2, c2);
			if(player2move==-1)
				game=0;
			}
			
			player1move=player2move=1;
		}
		
		if(game==0)
			System.out.println("game over");
	}

}
