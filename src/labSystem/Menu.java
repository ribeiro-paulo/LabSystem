package labSystem;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import component.Util;

public class Menu  extends JPanel{
	
	protected ImageIcon logo;
	
	public Menu() {
		
		logo = new ImageIcon("res\\menus\\logo.png");
		
	}
	
	protected void paintComponent(Graphics g) {
		
		Image img = Util.menuBackGround.getImage();
		g.drawImage(img, 0, 0, getWidth() , getHeight(), this);
		
		img = logo.getImage();
		g.drawImage(img, Util.DEFAULT_SCREEN_WIDTH / 2 - 180, 5, 370, 225, this);
	}
}	
