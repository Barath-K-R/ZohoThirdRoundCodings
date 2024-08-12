package pieces;

import operations.BoardOperation;
import player.Player;

public class Knight extends Pieces{

	
	
	public Knight(String colour,int r,int c,int identityno) {
		super.setPoints(3);
		super.setColour(colour);
		super.setIdentityno(identityno);
		if(colour=="white")
		{
			super.setRep("Hw");
			super.setPositionr(r);
			super.setPositionc(c);
		}
		else
		{
			super.setRep("Hb");
			super.setPositionr(r);
			super.setPositionc(c);
		}
	}

	

	@Override
	public boolean validMove(Player currentPlayer, int r1, int c1, int r2, int c2) {
		if(r2==0 || c2==0)
			return false;
		
		//up and right
		if(r2<r1 && c2>c1){
			if((r2==(r1-1) && c2==(c1+2)) || (r2==(r1-2) && c2==(c1+1)))
				return true;
			else
				return false;
		}
		//up and left
		else if(r2<r1 && c2<c1) {
			if((r2==(r1-1) && c2==(c1-2)) || (r2==(r1-2) && c2==(c1-1)))
				return true;
			else
				return false;
		}
		//down and right
		else if(r2>r1 && c2>c1) {
			if((r2==(r1+1) && c2==(c1+2)) || (r2==(r1+2) && c2==(c1+1)))
				return true;
			else
				return false;
		}
		//down and left
		else if(r2>r1 && c2<c1) {
			if((r2==(r1+1) && c2==(c1-2)) || (r2==(r1+2) && c2==(c1-1)))
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
		
		
		
		//checking king present in the knight trajectory
		if((Math.abs(r2-r1)==1 || Math.abs(r2-r1)==2)&& (Math.abs(c2-c1)==1 || Math.abs(r2-r1)==2)) {
			//up and right
			if(r2<r1 && c2>c1){
				if((r2==(r1-1) && c2==(c1+2)) || (r2==(r1-2) && c2==(c1+1)))
					return true;
				else
					return false;
			}
			//up and left
			else if(r2<r1 && c2<c1) {
				if((r2==(r1-1) && c2==(c1-2)) || (r2==(r1-2) && c2==(c1-1)))
					return true;
				else
					return false;
			}
			//down and right
			else if(r2>r1 && c2>c1) {
				if((r2==(r1+1) && c2==(c1+2)) || (r2==(r1+2) && c2==(c1+1)))
					return true;
				else
					return false;
			}
			//down and left
			else if(r2>r1 && c2<c1) {
				if((r2==(r1+1) && c2==(c1-2)) || (r2==(r1+2) && c2==(c1-1)))
					return true;
				else
					return false;
			}
		}
		return false;
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
