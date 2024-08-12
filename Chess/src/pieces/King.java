package pieces;

import operations.BoardOperation;
import player.Player;

public class King extends Pieces{

	
	
	public King(String colour,int r,int c) {
		super.setPoints(Integer.MAX_VALUE);
		super.setColour(colour);
		if(colour=="white")
		{
			super.setRep("Kw");
			super.setPositionr(r);
			super.setPositionc(c);
		}
		else
		{
			super.setPositionr(r);
			super.setPositionc(c);
			super.setRep("Kb");
		}
	}

	


	@Override
	public boolean validMove(Player currentPlayer, int r1, int c1, int r2, int c2) {
		if(r2==0 || c2==0)
			return false;
		
		if((Math.abs(r1-r2)==0 || Math.abs(r1-r2)==1) && (Math.abs(c1-c2)==0 || Math.abs(c1-c2)==1))
		{
			
			return true;
		}
		
		return false;
	}


	@Override
	public boolean canreach(int r2,int c2) {
		
		return false;
	}




	@Override
	public boolean canBlockCheckMate(Pieces[]opppieces) {
		int r=this.getPositionr(),c=this.getPositionc();
		
		
		if(traversePieces(opppieces,r-1,c-1) || traversePieces(opppieces, r-1, c) || traversePieces(opppieces, r-1, c+1)
				|| traversePieces(opppieces, r, c-1) || traversePieces(opppieces, r, c+1) 
				|| traversePieces(opppieces, r+1, c-1) ||traversePieces(opppieces, r+1, c)|| traversePieces(opppieces, r+1, c+1))
				return false;
		
		return true;
	}
	
	//to check the king can make a move to escape
	public boolean traversePieces(Pieces[]oppPieces,int r,int c) {
		if(BoardOperation.board[r][c]!=null && (r>0 && r<=8) && (c>0 && c<=8))
		{
			System.out.println("king cant move to "+r+" "+c);
			return false;
		}
		System.out.println(r+" "+c);
		for(int i=0;i<16;++i)
		{
		    if(oppPieces[i].canreach(r, c)) {
		    	return false;
		    }
		}
		return true;
	}

	
}
