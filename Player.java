package apcsa;

public class Player {
	private String name;
	private String sign;
	private int points;
	public Player(String aName , String aSign , int points) {
		name = aName;
		sign = aSign;
		points = getPoints();
	}
	public String getName() {
		return this.name;
	}
	public String getSign() {
		return this.sign;
	}
	public int getPoints() {
		return this.points;
	}
	public boolean equals(Object o) {
		if(o instanceof Player) {
			Player otherPlayer = (Player) o;
			if(otherPlayer.name.equals(this.name)) {
				return true;
			}
		}
		return false;
	}
}
