package model;

import java.util.TimerTask;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import static javax.swing.JOptionPane.*;

import view.CoffeeSlingerCanvas;
import view.CoffeeSlingerPanel;
import view.MenuScreen;

public class TimerHelper extends TimerTask{

    public static int i = 0;
    private CoffeeSlingerPanel panel;
    private CoffeeSlingerCanvas canvas;
    
    public TimerHelper(CoffeeSlingerPanel panel, CoffeeSlingerCanvas canvas) {
        this.panel = panel;
        this.canvas = canvas;
	}

    public void run() 
    { 
        Icon icon = new ImageIcon( "snorlax.gif" );
        String ttl = "What a Swell Guy!";
		IRender pic = panel.getCanvas().getPictures().get(0);
        String msg = "You provided " + pic.getCount() +" Snorlaxes with their morning coffee!";
        showMessageDialog( null, msg, ttl, 0, icon );
        canvas.getTimer().cancel();
        panel.getWindow().getContentPane().removeAll();
        var menu = new MenuScreen(panel.getWindow());
        menu.init();
        panel.getWindow().pack();
        panel.getWindow().revalidate();

    } 
} 
  
