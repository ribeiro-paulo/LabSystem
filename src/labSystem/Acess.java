package labSystem;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import component.Util;

import java.awt.Image;

public class Acess extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected ImageIcon background;
	protected ImageIcon imgAdm;
	protected ImageIcon imgEmployee;
	
	protected JButton jbEmployee;
	protected JButton jbAdm;
	
	public Acess() {
		background = new ImageIcon("res\\backGround\\ModeloAcesso.png");
		imgAdm = new ImageIcon("res\\Button\\acessoAdm.png");
		imgEmployee = new ImageIcon("res\\Button\\acessoFun.png");
		
		jbEmployee = new JButton();
		jbAdm = new JButton();
		
		setLayout(null);
		Util.setButton(jbAdm, null, 306, 273, imgAdm.getIconWidth(), imgAdm.getIconHeight());
		Util.setButton(jbEmployee, null, 306, 350, imgEmployee.getIconWidth(), imgEmployee.getIconHeight());
		
		add(jbAdm);
		add(jbEmployee);
	}
	
	protected void paintComponent(Graphics g) {
		Image img;
		
		img = background.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);

	}
	
}
