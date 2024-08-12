package pieces;

import player.Player;

public class empty extends Pieces{
	String rep;
	public empty(String s,int r,int c) {
		super.setPoints(0);
		super.setColour("empty");
		super.setRep(s);
		super.setPositionr(r);
		super.setPositionc(c);
	}

	

	@Override
	public boolean validMove(Player currentPlayer, int r1, int c1, int r2, int c2) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean canreach(int r2,int c2) {
		
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
