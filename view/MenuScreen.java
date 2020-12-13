package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuScreen {
	private JFrame window;

	public MenuScreen(JFrame window){
		this.window = window;

	}
	public void init(){
    	window.setSize(510, 200);
		Container cp = window.getContentPane();
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 200));
		panel.setLayout(new GridLayout(2, 1));

		JButton playButton = new JButton("Play");
		JLabel title = new JLabel("Coffee Slinger");
		title.setFont(new Font("Serif", Font.BOLD, 63));
		title.setForeground(Color.GREEN);
		title.setBackground(Color.MAGENTA);
		title.setOpaque(true);


		panel.add(title);	
		panel.add(playButton);

		cp.add(BorderLayout.CENTER, panel);
		playButton.addActionListener(event ->{
			window.getContentPane().removeAll();
			var menu = new CoffeeSlingerPanel(window);
			menu.init();
			window.pack();
			window.revalidate();
		});
	}
}
