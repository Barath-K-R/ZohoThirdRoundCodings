package player;

public class Player {

	static int id=1;
	private int playerno;
	private String name;
    private String colour;
    private int totalpoints;
    private boolean isWin;
    
	public Player(String name, String colour) {
		
		this.playerno =id++;
		this.name = name;
		this.colour = colour;
		this.totalpoints = 0;
		this.isWin = false;
	}

	public static int getId() {
		return id;
	}

	public static void setId(int id) {
		Player.id = id;
	}

	public int getPlayerno() {
		return playerno;
	}

	public void setPlayerno(int playerno) {
		this.playerno = playerno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public int getTotalpoints() {
		return totalpoints;
	}

	public void setTotalpoints(int totalpoints) {
		this.totalpoints = totalpoints;
	}

	public boolean isWin() {
		return isWin;
	}

	public void setWin(boolean isWin) {
		this.isWin = isWin;
	}
    
}
