package pieces;

import player.Player;

public abstract class Pieces {

	private String colour;
	private int points;
	private String rep;
	private int identityno;
	private int positionr;
	private int positionc;
	
	public int getIdentityno() {
		return identityno;
	}

	public void setIdentityno(int identityno) {
		this.identityno = identityno;
	}
	
	
	public int getPositionr() {
		return positionr;
	}

	public void setPositionr(int positionr) {
		this.positionr = positionr;
	}

	public int getPositionc() {
		return positionc;
	}

	public void setPositionc(int positionc) {
		this.positionc = positionc;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public String getRep() {
		return rep;
	}

	public void setRep(String rep) {
		this.rep = rep;
	}

	public abstract boolean validMove(Player currentPlayer,int r1,int c1,int r2,int c2);
	public abstract boolean canreach(int r2,int c2);
	public abstract boolean canBlockCheckMate(Pieces[]opppieces);
	public abstract boolean traversePieces(Pieces[]oppPieces,int r,int c);
}
