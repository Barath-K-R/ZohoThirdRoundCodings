package pieces;

import operations.BoardOperation;
import player.Player;

public class Bishop extends Pieces{
	
	public Bishop(String colour,int r,int c,int identityno) {
		super.setPoints(3);
		super.setColour(colour);
		super.setIdentityno(identityno);
		if(colour=="white")
		{
		    super.setRep("Bw");
		    super.setPositionr(r);
			super.setPositionc(c);
		}
		else
		{
			super.setRep("Bb");
			super.setPositionr(r);
			super.setPositionc(c);
		}
	}

	

	@Override
	public boolean validMove(Player currentPlayer, int r1, int c1, int r2, int c2) {
		if(r2==0 || c2==0)
			return false;
		int tr=r1,tc=c1;
		if(r2<r1 && c2>c1)
		{
			tr=r1-1;
			tc=c1+1;
			while(BoardOperation.board[tr][tc]==null && tr!=r2 && tc!=c2)
			{
				tr--;
				tc++;
			}
			if(tr==r2 && tc==c2)
				return true;
			else
				return false;
		}
		else if(r2>r1 && c2>c1)
		{
			tr=r1+1;
			tc=c1+1;
			while(BoardOperation.board[tr][tc]==null && tr!=r2 && tc!=c2)
			{
				tr++;
				tc++;
			}
			if(tr==r2 && tc==c2)
				return true;
			else
				return false;
		}
		else if(r2>r1 && c2<c1) {
			tr=r1+1;
			tc=c1-1;
			while(BoardOperation.board[tr][tc]==null && tr!=r2 && tc!=c2)
			{
				tr++;
				tc--;
			}
			if(tr==r2 && tc==c2)
				return true;
			else
				return false;
		}
		else if(r2<r1 && c2<c1) {
			tr=r1-1;
			tc=c1-1;
			while(BoardOperation.board[tr][tc]==null && tr!=r2 && tc!=c2)
			{
				tr--;
				tc--;
			}
			if(tr==r2 && tc==c2)
				return true;
			else
				return false;
		}
		return false;
	}



	@Override
	public boolean canreach(int r2,int c2) {
		int r1=this.getPositionr(),c1=this.getPositionc();
		
		int tr=r1,tc=c1;
		
		
		
		//checking whether king present in the bishop trajectory
		if(Math.abs(r2-r1)==Math.abs(c2-c1)) 
		{
		    //checking is there any check
			if(r2<r1 && c2>c1)
			{
				tr=r1-1;
				tc=c1+1;
				while(BoardOperation.board[tr][tc]==null && tr!=r2 && tc!=c2)
				{
					tr--;
					tc++;
				}
				if(tr==r2 && tc==c2)
					return true;
				else
					return false;
			}
			else if(r2>r1 && c2>c1)
			{
				tr=r1+1;
				tc=c1+1;
				while(BoardOperation.board[tr][tc]==null && tr!=r2 && tc!=c2)
				{
					tr++;
					tc++;
				}
				if(tr==r2 && tc==c2)
					return true;
				else
					return false;
			}
			else if(r2>r1 && c2<c1) {
				tr=r1+1;
				tc=c1-1;
				while(BoardOperation.board[tr][tc]==null && tr!=r2 && tc!=c2)
				{
					tr++;
					tc--;
				}
				if(tr==r2 && tc==c2)
					return true;
				else
					return false;
			}
			else if(r2<r1 && c2<c1) {
				tr=r1-1;
				tc=c1-1;
				while(BoardOperation.board[tr][tc]==null && tr!=r2 && tc!=c2)
				{
					tr--;
					tc--;
				}
				if(tr==r2 && tc==c2)
					return true;
				else
					return false;
			}
			return false;
		}
		return false;
	}



	@Override
	public boolean canBlockCheckMate(Pieces[]opppieces) {
		int r1=this.getPositionr(),c1=this.getPositionc();
		int r2=opppieces[11].getPositionr(),c2=opppieces[11].getPositionc();
		
		int tr=r1,tc=c1;
		if(r2<r1 && c2>c1)
		{
			tr=r1-1;
			tc=c1+1;
			while(tr!=r2 && tc!=c2)
			{
				for(int i=0;i<16;++i)
				{
					if(opppieces[i]!=null && opppieces[i].canreach(tr,tc))
						return false;
				}
				tr--;
				tc++;
			}
			if(tr==r2 && tc==c2)
				return true;
			else
				return false;
		}
		else if(r2>r1 && c2>c1)
		{
			tr=r1+1;
			tc=c1+1;
			while(tr!=r2 && tc!=c2)
			{
			    
				for(int i=0;i<16;++i)
				{
					if(opppieces[i]!=null && opppieces[i].canreach(tr,tc))
						return false;
				}
				tr++;
				tc++;
			}
			
			if(tr==r2 && tc==c2)
				return true;
			else
				return false;
		}
		else if(r2>r1 && c2<c1) {
			tr=r1+1;
			tc=c1-1;
			while(tr!=r2 && tc!=c2)
			{
				for(int i=0;i<16;++i)
				{
					if(opppieces[i]!=null && opppieces[i].canreach(tr,tc))
						return false;
				}
				tr++;
				tc--;
			}
			if(tr==r2 && tc==c2)
				return true;
			else
				return false;
		}
		else if(r2<r1 && c2<c1) {
			tr=r1-1;
			tc=c1-1;
			while(tr!=r2 && tc!=c2)
			{
				for(int i=0;i<16;++i)
				{
					if(opppieces[i]!=null && opppieces[i].canreach(tr,tc))
						return false;
				}
				tr--;
				tc--;
			}
			if(tr==r2 && tc==c2)
				return true;
			else
				return false;
		}
		return false;
	}



	@Override
	public boolean traversePieces(Pieces[] oppPieces, int r, int c) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
