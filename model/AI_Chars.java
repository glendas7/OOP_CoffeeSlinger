package model;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

public abstract class AI_Chars implements IRender {
	private int x;
	private int y;
	private BufferedImage image;

	public AI_Chars(int x, int y){
		this.x = x;
		this.y = y;
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
	public void setY(int y) {
		this.y = y;
		
	}
	@Override
	public void setX(int x) {
		this.x = x;
		
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
