package controller;

import java.awt.event.MouseEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import model.IRender;
import java.awt.Rectangle;
import view.CoffeeSlingerPanel;
import view.MenuScreen;

public class MovementEvents implements MouseListener, KeyListener, ActionListener{

	private CoffeeSlingerPanel panel;
	public static final int UNIT_MOVE = 5;

	public MovementEvents(CoffeeSlingerPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		ArrayList<IRender> pictures = panel.getCanvas().getPictures();
		for (int i = 0; i < pictures.size(); i++) {
			Rectangle r = pictures.get(i).getBoundingBox();
			if (r.contains(e.getX(), e.getY())) {
				System.out.println("Selected index = " + i);
				panel.getCanvas().setSelectIndex(i);
				panel.getCanvas().repaint();
				return;
			}
		}
		panel.getCanvas().setSelectIndex(-1);
		panel.getCanvas().repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}// combination

	@Override
	public void keyPressed(KeyEvent e) {
		var key = e.getKeyCode();
		int selectIndex = panel.getCanvas().getSelectIndex();
		if (selectIndex < 0)
			return;
		IRender pic = panel.getCanvas().getPictures().get(selectIndex);

		switch (key) {
			case KeyEvent.VK_LEFT:
			if(pic.getX()!= 0){
				pic.translate(-UNIT_MOVE, 0);
				panel.getLocation().setText("Location: (" + pic.getX() + ", " + pic.getY() + ")");
			}
				break;
			case KeyEvent.VK_RIGHT:
			if(pic.getX()!= 440){
				pic.translate(UNIT_MOVE, 0);
				panel.getLocation().setText("Location: (" + pic.getX() + ", " + pic.getY() + ")");
			}
				break;
			case KeyEvent.VK_UP:
			if(pic.getY()!= 0){
				pic.translate(0, -UNIT_MOVE);
				panel.getLocation().setText("Location: (" + pic.getX() + ", " + pic.getY() + ")");
			}
				break;
			case KeyEvent.VK_DOWN:
			if(pic.getY()!= 460){
				pic.translate(0, UNIT_MOVE);
				panel.getLocation().setText("Location: (" + pic.getX() + ", " + pic.getY() + ")");
			}
				break;
		}
		ArrayList<IRender> pics = panel.getCanvas().getPictures();
		Random rand = new Random();
		int lo = 0;
		int hi = 435;
		for(int i = 1; i < panel.getCanvas().getPictures().size(); i++){
		IRender otherPic = pics.get(i);
		Rectangle r = pic.getBoundingBox();
		if (r.contains(otherPic.getX(), otherPic.getY()) || r.contains(otherPic.getX() + 50, otherPic.getY())
				|| r.contains(otherPic.getX() + 50, otherPic.getY() + 50)
				|| r.contains(otherPic.getX(), otherPic.getY() + 50)) {
			pic.incrementCount();
			panel.getCounter().setText("Delivered Coffees: " + Integer.toString(pic.getCount()));
			int randX = rand.nextInt(hi-lo) + lo;
			int randY = rand.nextInt(hi-lo) + lo;
			otherPic.setX(randX);
			otherPic.setY(randY);
		}
	}
		panel.getCanvas().repaint();
		return;

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}


	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == panel.getQuitButton()){
				JFrame window = panel.getWindow();
				window.getContentPane().removeAll();
				var menu = new MenuScreen(window);
				menu.init();
				window.pack();
				window.setVisible(true);
			}
	}

	
	
}

