package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;
import model.IRender;
import model.TimerHelper;

import java.awt.Color;
import java.awt.Dimension;

public class CoffeeSlingerCanvas extends JPanel {
	private static final long serialVersionUID = 1L;
	private CoffeeSlingerPanel panel;
	private ArrayList<IRender> pictures = new ArrayList<>();
	private int selectIndex = 0;
	private Timer timer = new Timer();
	private int time;

	public CoffeeSlingerCanvas(CoffeeSlingerPanel panel) {
		this.panel = panel;
		setPreferredSize(new Dimension(500, 500));
		setBackground(Color.MAGENTA);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < pictures.size(); i++) {
			IRender pic = pictures.get(i);
			pic.render(g2);
		}

        TimerTask task = new TimerHelper(panel, this); 
          
		timer.schedule(task, 25000, 5000);
	}
	public ArrayList<IRender> getPictures() {
		return pictures;
	}
	public int getSelectIndex() {
		return selectIndex;
	}
	public void setSelectIndex(int selectIndex) {
		this.selectIndex = selectIndex;
	}
	public Timer getTimer() {
		return timer;
	}
}
