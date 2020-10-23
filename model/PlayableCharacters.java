package model;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public abstract class PlayableCharacters implements IRender{
	private int x;
	private int y;
	private int count;
	private BufferedImage image;

	public PlayableCharacters(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;

	}
	@Override
	public int getX() {
		return x;
	}
	@Override
	public int getY() {
		return y;
	}
	@Override
	public void setX(int x) {
		this.x = x;

	}

	@Override
	public void setY(int y) {
		this.y = y;

	}
	@Override
	public int getCount() {
		return count;
	}
	@Override
	public void incrementCount() {
		count++;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}

	@Override
	public Rectangle getBoundingBox(){
		return new Rectangle(x, y, image.getWidth(), image.getHeight());
	}
	@Override
	public void translate(int dx, int dy){
		x += dx;
		y += dy;
	}
}