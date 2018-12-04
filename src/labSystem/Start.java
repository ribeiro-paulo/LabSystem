package labSystem;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import object.Util;

public class Start extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private JButton jbStart;
	
	public Start() {
		
		background = new ImageIcon("res\\iniciar\\ModeloIniciar.png");
		jbStart = Util.setButton(jbStart, 690, 450, 70, 70, this);
		
	}
	
	public JButton getJbStart() {
		return jbStart;
	}

	public void setJbStart(JButton jbStart) {
		this.jbStart = jbStart;
	}

	protected void paintComponent(Graphics g) {
		
		Image img;
		
		img = background.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
	}
}
