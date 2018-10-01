package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ImageIcon background;
	private JTextField jtName;

	public Register() {

		background = new ImageIcon("res\\backGround\\modeloCadastro.png");
		JTextField jtName = new JTextField();
		
		setLayout(null);

		Util.newMenu();
		
		add(Util.jbRegister);
		add(Util.jbConsult);
		add(Util.jbUpdate);
		add(Util.jbDelete);
		
		jtName.setBounds(295, 156, 385, 28);
		jtName.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
		
		add(jtName);
		
	}

	protected void paintComponent(Graphics g) {

		Image img = background.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		
	}

}
