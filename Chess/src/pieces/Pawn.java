package pieces;

import operations.BoardOperation;
import player.Player;

public class Pawn extends Pieces{

	boolean firstmove;
	public Pawn(String colour,int r,int c,int identityno) {
		super.setPoints(9);
		super.setColour(colour);
		super.setIdentityno(identityno);
		if(colour=="white")
		{
			super.setRep("Pw");
			super.setPositionr(r);
			super.setPositionc(c);
		}
		else
		{
			super.setRep("Pb");
			super.setPositionr(r);
			super.setPositionc(c);
		}
		this.firstmove=true;
			
	}
	
	
	@Override
	public boolean validMove(Player currentPlayer, int r1, int c1, int r2, int c2) {
		if(r2==0 || c2==0)
			return false;
		if(currentPlayer.getPlayerno()==1)
		{
		   if(this.firstmove==true && (r2==(r1-2)))
		   {
			   this.firstmove=(this.firstmove==true)?false:false;
			   return true;
		   }
		   else if(r2==(r1-1) && c2==c1)
		   {
			   this.firstmove=(this.firstmove==true)?false:false;
			   return true;
		   }
		   else if(r2==(r1-1) && (c2==(c1-1) || c2==(c1+1)))
		   {
			   if(BoardOperation.board[r2][c2]!=null)
			   {
				   this.firstmove=(this.firstmove==true)?false:false;
				   return true;
			   }
			   else
				   return false;
		   }
		   else
		   return false;
		}
		else if(currentPlayer.getPlayerno()==2)
		{
			if(this.firstmove==true && (r2==(r1+2)))
			{
				this.firstmove=(this.firstmove==true)?false:false;
				   return true;
			}
			   else if(r2==(r1+1))
			   {
				   this.firstmove=(this.firstmove==true)?false:false;
				   return true;
			   }
			   else if(r2==(r1+1) && (c2==(c1-1) || c2==(c1+1)))
			   {
				   if(BoardOperation.board[r2][c2]!=null)
				   {
					   this.firstmove=(this.firstmove==true)?false:false;
					   return true;
				   }
				   else
					   return false;
			   }
			   else
			   return false;
		}
		else 
			return false;
	}
	@Override
	public boolean canreach(int r2,int c2) {
		
		int r1=this.getPositionr(),c1=this.getPositionc();
		
		if(this.getColour()=="black")
		{
			if(BoardOperation.board[r2][c2]!=null && r2-r1==1 && Math.abs(c2-c1)==1)
			    return true;
			else if(BoardOperation.board[r2][c2]==null && r2-r1==1 && c1==c2)
				return true;
			else 
				return false;
		}
		else
		{
			if(BoardOperation.board[r2][c2]!=null && r2-r1==-1 && Math.abs(c2-c1)==1)
			    return true;
			else if(BoardOperation.board[r2][c2]==null && r2-r1==-1 && c1==c2)
				return true;
			else 
				return false;
		}
		
		
		
			
		
	}


	@Override
	public boolean canBlockCheckMate(Pieces[]opppieces) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean traversePieces(Pieces[] oppPieces, int r, int c) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
