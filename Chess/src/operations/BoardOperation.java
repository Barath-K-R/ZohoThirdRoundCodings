package operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Pieces;
import pieces.Queen;
import pieces.Rook;
import pieces.empty;
import player.Player;

public class BoardOperation {

	public static Pieces[][] board=new Pieces[9][9];
	public static Player player1=null,player2=null,threateningplayer;
	public static Pieces[]blackpieces=new Pieces[16],whitepieces=new Pieces[16];
	static Pieces threateningpiece;
	public static boolean check=false;
	static int pawns=8,others=0;
	
	
	public static void initialiseBoard() {
		System.out.println("initialising");
		int num1=1,num2=1;
		board[0][0]=new empty(" ",0,0);
		for(int r=0;r<9;++r)
		{
			for(int c=0;c<9;++c)
			{
				if(r==0 && c==0)
				board[r][c]=new empty(" ",0,0);
				else if(r==0 && c!=0)
					board[r][c]=new empty(Integer.toString(num1++),r,c);
				else if(r!=0 && c==0)
					board[r][c]=new empty(Integer.toString(num2++),r,c);
				else if(r==1)
				{
					if(c==1 || c==8)
					{
						
						if(blackpieces[8]!=null)
						{
							board[r][c]=new Rook("black",r,c,15);
							blackpieces[15]=board[r][c];
						}
						else
						{
							board[r][c]=new Rook("black",r,c,8);
							blackpieces[8]=board[r][c];
						}
							
					}
					else if(c==2 || c==7)
					{
						
						if(blackpieces[9]!=null)
						{
							board[r][c]=new Knight("black",r,c,14);
							blackpieces[14]=board[r][c];
						}
						else
						{
							board[r][c]=new Knight("black",r,c,9);
							blackpieces[9]=board[r][c];
						}
					}
					else if(c==3 || c==6)
					{
						
						if(blackpieces[10]!=null)
						{
							board[r][c]=new Bishop("black",r,c,13);
							blackpieces[13]=board[r][c];
						}
						else
						{
							board[r][c]=new Bishop("black",r,c,10);
							blackpieces[10]=board[r][c];
						}
					}
					else if(c==5)
					{
						board[r][c]=new King("black",r,c);
						blackpieces[11]=board[r][c];
					}
					else 
					{
						board[r][c]=new Queen("black",r,c);
						blackpieces[12]=board[r][c];
					}
					
				}
				else if(r==8)
				{
					if(c==1 || c==8)
					{
						
						if(whitepieces[8]!=null)
						{
							board[r][c]=new Rook("white",r,c,15);
							whitepieces[15]=board[r][c];
						}
						else
						{
							board[r][c]=new Rook("white",r,c,8);
							whitepieces[8]=board[r][c];
						}
					}
					else if(c==2 || c==7)
					{
						
						if(whitepieces[9]!=null)
						{
							board[r][c]=new Knight("white",r,c,14);
							whitepieces[14]=board[r][c];
						}
						else
						{
							board[r][c]=new Knight("white",r,c,9);
							whitepieces[9]=board[r][c];
						}
					}
					else if(c==3 || c==6)
					{
						
						if(whitepieces[10]!=null)
						{
							board[r][c]=new Bishop("white",r,c,13);
							whitepieces[13]=board[r][c];
						}
						else
						{
							board[r][c]=new Bishop("white",r,c,10);
							whitepieces[10]=board[r][c];
						}
					}
					else if(c==4)
					{
						board[r][c]=new King("white",r,c);
						whitepieces[11]=board[r][c];
						
					}
					else 
					{
						board[r][c]=new Queen("white",r,c);
						whitepieces[12]=board[r][c];
					}
				}
				else if(r==2)
				{
				    board[r][c]=new Pawn("black",r,c,c);
				    blackpieces[c-1]=board[r][c];
				}
				else if(r==7)
				{
					board[r][c]=new Pawn("white",r,c,c);
					whitepieces[c-1]=board[r][c];
				}
				else 
					board[r][c]=null;
			}
		}
		
		
	}
	
	public void initialiseplayers() {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("player1 enter your name");
		String name1=sc.nextLine();
		player1=new Player(name1,"white");
		
		
		System.out.println("player2 enter your name");
		String name2=sc.nextLine();
		player2=new Player(name2,"black");
		
		
		
		
	}
	public static void printboard() {
		for(int i=0;i<9;++i)
		{
			for(int j=0;j<9;++j)
			{
				if(board[i][j]==null)
					System.out.print("    ");
				else if(i==0 && (board[i][j].getRep().charAt(0)>=48 && board[i][j].getRep().charAt(0)<=57))
				System.out.print(board[i][j].getRep()+"   ");
				else
				System.out.print(board[i][j].getRep()+"  ");
			}
			
			System.out.println();
			System.out.println();
			
		}
	}
	
	public static void alterpieceslist(Pieces targetpiece) {
		
		
		if(targetpiece!=null)
			{
			if(targetpiece.getRep().contains("P"))
			{
				if(targetpiece.getColour().equals("black"))
				blackpieces[targetpiece.getIdentityno()]=null;
				else
					whitepieces[targetpiece.getIdentityno()]=null;
			}
			else if(targetpiece.getRep().contains("R")) {
				if(targetpiece.getColour().equals("black"))
				{
				  blackpieces[targetpiece.getIdentityno()]=null;
				}
				else
				{
					whitepieces[targetpiece.getIdentityno()]=null;
				}
			}
			else if(targetpiece.getRep().contains("B")) {
				if(targetpiece.getColour().equals("black"))
				{
				  blackpieces[targetpiece.getIdentityno()]=null;
				}
				else
				{
					whitepieces[targetpiece.getIdentityno()]=null;
				}
			}
			else if(targetpiece.getRep().contains("H")) {
				if(targetpiece.getColour().equals("black"))
				{
				  blackpieces[targetpiece.getIdentityno()]=null;
				}
				else
				{
					whitepieces[targetpiece.getIdentityno()]=null;
				}
			}
			else if(targetpiece.getRep().contains("Q")) {
				if(targetpiece.getColour().equals("black"))
				{
				  blackpieces[12]=null;
				}
				else
				{
					whitepieces[12]=null;
				}
			}
		}
		
	}
	public static void redo(Pieces currentpiece,int r1,int c1,Pieces targetpiece,int r2,int c2) {
		board[r1][c1]=currentpiece;
		currentpiece.setPositionr(r1);
		currentpiece.setPositionc(c1);
		
		
		board[r2][c2]=targetpiece;
		if(targetpiece!=null)
		{
			targetpiece.setPositionr(r2);
			targetpiece.setPositionc(c2);
		}
		printboard();
		
	}
	
	public static boolean ischeckmate(Pieces threateningpiece,Player threateningplayer) {
		System.out.println("checking for checkmate");
		Pieces[]oppPlayerPieces=new Pieces[16],currPlayerPieces=new Pieces[16];
		if(threateningplayer.getPlayerno()==1)
		{
			oppPlayerPieces=blackpieces;
			currPlayerPieces=whitepieces;
		}
		else
		{
			oppPlayerPieces=whitepieces;
			currPlayerPieces=blackpieces;
		}
		
		
		//can we attack threateningpiece
		for(int i=0;i<16;++i)
		{
			
			if(oppPlayerPieces[i]!=null && oppPlayerPieces[i].canreach(threateningpiece.getPositionr(),threateningpiece.getPositionc()))
				return false;
		}
		System.out.println("one step closer");
		
		//can block the check
		if(!threateningpiece.canBlockCheckMate(oppPlayerPieces))
			return false;
		
		
		//can king can dodge from check
		if(!oppPlayerPieces[11].canBlockCheckMate(currPlayerPieces)) {
			return false;
		}
		System.out.println("checkmate");
		return true;
		
	}
	public int makemove(Player currentplayer,int r1,int c1,int r2,int c2) {
		Pieces currentpiece=board[r1][c1],targetpiece=board[r2][c2];
		Pieces[]oppPiecesList=new Pieces[16];
		
		if(currentplayer.getColour().contains("black"))
			oppPiecesList=whitepieces;
		else
			oppPiecesList=blackpieces;
		 
		
		
		if(currentpiece.validMove(currentplayer,r1,c1,r2,c2)) {
			System.out.println("valid move");
			if(board[r2][c2]!=null)
			System.out.println( board[r2][c2].getColour()+" "+currentplayer.getColour());
			
			//checking whether attacking same colour piece
			if(board[r2][c2]!=null && (board[r2][c2].getColour().contains(currentplayer.getColour())))
			{
				System.out.println("you can't attack your own piece");
				return 1;
			}
			
			//if place has other piece
			if(board[r2][c2]!=null)
			{
				int points=currentplayer.getTotalpoints()+board[r2][c2].getPoints();
				currentplayer.setTotalpoints(points);
			}
			
			board[r2][c2]=board[r1][c1];
			board[r1][c1]=null;
			currentpiece.setPositionr(r2);
			currentpiece.setPositionc(c2);
			alterpieceslist(targetpiece);
		}
		else 
		{
			System.out.println("invalid move");
			return 1;
		}
		BoardOperation.printboard();
		
		//checking is there any check
		if(check==false && currentpiece.canreach(oppPiecesList[11].getPositionr(),oppPiecesList[11].getPositionc())) {
			System.out.println("check true");
			check=true;
			threateningpiece=currentpiece;
			threateningplayer=currentplayer;
			if(ischeckmate(threateningpiece,threateningplayer))
			return -1;
		}
		else if(check==true){
			System.out.println("checking player can escape from check");
			check=threateningpiece.canreach(threateningplayer.getPlayerno()==1?blackpieces[11].getPositionr():whitepieces[11].getPositionr(),threateningplayer.getPlayerno()==1?blackpieces[11].getPositionc():blackpieces[11].getPositionc());
            if(check)
            {
            	System.out.println("you are in check");
            	redo(currentpiece,r1,c1,targetpiece,r2,c2);
            	return 1;
            }
            else
            {
            	System.out.println("player escaped from check");
            	return 0;
            }
		}
		return 0;
		
	}
}
