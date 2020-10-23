package model;

import java.awt.Graphics2D;

public class CoffeeTruck extends PlayableCharacters {

	public CoffeeTruck(int x, int y, int count) {
		super(x, y, count);
	}

	@Override
	public void render(Graphics2D g2) {
		g2.drawImage(getImage(), null, getX(), getY());
	}
}