package model;
import java.awt.Graphics2D;

public class Snorlax extends AI_Chars {

	public Snorlax(int x, int y) {
		super(x, y);
	}

	@Override
	public void render(Graphics2D g2) {
		g2.drawImage(getImage(), null, getX(), getY());
	}

	@Override
	public int getCount() {
		return 0;
	}

	@Override
	public void incrementCount() {
	}
}