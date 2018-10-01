package component;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Update extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ImageIcon background;
	
	public Update() {
		
		background = new ImageIcon("res\\backGround\\ModeloAtualizar.png");
		
		setLayout(null);

		Util.newMenu();
		
		add(Util.jbRegister);
		add(Util.jbConsult);
		add(Util.jbUpdate);
		add(Util.jbDelete);
		
	}
	
	protected void paintComponent(Graphics g) {
		Image img;
		
		img = background.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);
	}

}
