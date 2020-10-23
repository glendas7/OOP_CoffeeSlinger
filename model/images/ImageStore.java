package model.images;

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

public class ImageStore {
	public static BufferedImage coffeeTruck;
	public static BufferedImage snorlaxChar;

	static{
		coffeeTruck = readImage("model/images/coffeetruck.png", 70, 50);
		snorlaxChar = readImage("model/images/snorelax.gif", 50, 50);
	}

	public static BufferedImage readImage(String path, int width, int height){
		try{
			BufferedImage originalImage = ImageIO.read(new File(path));
			Image temp = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
			//blank canvas for resizing image
			BufferedImage resizedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g2 = resizedImage.createGraphics();
			g2.drawImage(temp, 0, 0, null);
			return resizedImage;
		} catch(Exception e){
			System.out.println("Image file load error");
		}
		return null;
	}
	
}
