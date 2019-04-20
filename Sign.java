package exerciseTris;

public class Sign {
	private Character sign;
	private int x, y;

	public Sign(Character sign, int x, int y) {
		this.sign = sign;
		this.x = x;
		this.y = y;
	}

	public Character getSign() {
		return sign;
	}

	public void setSign(Character sign) {
		this.sign = sign;
	}

}