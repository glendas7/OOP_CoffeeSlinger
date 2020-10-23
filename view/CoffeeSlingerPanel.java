package view;

import java.awt.Container;
import java.util.ArrayList;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.MovementEvents;
import model.Snorlax;
import model.CoffeeTruck;
import model.IRender;
import model.images.ImageStore;

public class CoffeeSlingerPanel {
	private JFrame window;
	private CoffeeSlingerCanvas canvas;
	private JButton quitButton = new JButton("Quit");
	private JLabel counter = new JLabel("Delivered Coffees: " + Integer.toString(0));
	private JLabel location = new JLabel("Location: (0, 0)");


	public CoffeeSlingerPanel(JFrame window){
		this.window = window;
	}
	public void init(){
		Container cp = window.getContentPane();
		canvas = new CoffeeSlingerCanvas(this);
		JPanel southPanel = new JPanel();
		counter.setForeground(Color.RED);
		location.setForeground(Color.BLUE);
		southPanel.add(counter);
		southPanel.add(quitButton);
		southPanel.add(location);
		cp.add(BorderLayout.CENTER, canvas);
		cp.add(BorderLayout.SOUTH, southPanel);
		populatePictures();

		MovementEvents listener = new MovementEvents(this);
		canvas.addMouseListener(listener);
		canvas.addKeyListener(listener);
		canvas.requestFocusInWindow();
		canvas.setFocusable(true);
		quitButton.setFocusable(false);
		quitButton.addActionListener(listener);
	}

	private void populatePictures(){
		ArrayList<IRender> pics = canvas.getPictures();
		int lo = 0;
		Random rand = new Random();
		int hi = 425;
		int randX[] = {0, 0, 0, 0};
		int randY[] = {0, 0, 0, 0};
		for(int i =0; i < 4; i++){
			randX[i] = rand.nextInt(hi-lo) + lo;
			randY[i] = rand.nextInt(hi-lo) + lo;

		}

		CoffeeTruck c1 = (new CoffeeTruck(50, 50, 0));
		pics.add(c1);
		c1.setImage(ImageStore.coffeeTruck);
		var s1 = new Snorlax(randX[0], randY[0]);
		pics.add(s1);
		s1.setImage(ImageStore.snorlaxChar);
		var s2 = new Snorlax(randX[1], randY[1]);
		pics.add(s2);
		s2.setImage(ImageStore.snorlaxChar);
		var s3 = new Snorlax(randX[2], randY[2]);
		pics.add(s3);
		s3.setImage(ImageStore.snorlaxChar);
		var s4 = new Snorlax(randX[3], randY[3]);
		pics.add(s4);
		s4.setImage(ImageStore.snorlaxChar);
	}

	public CoffeeSlingerCanvas getCanvas() {
		return canvas;
	}
	public JButton getQuitButton() {
		return quitButton;
	}
	public JFrame getWindow() {
		return window;
	}
	public JLabel getCounter() {
		return counter;
	}
	public JLabel getLocation() {
		return location;
	}

}
