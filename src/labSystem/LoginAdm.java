package labSystem;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import component.Util;

public class LoginAdm extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected ImageIcon background;
	protected ImageIcon imgOpen;
	protected ImageIcon imgEyeFalse;
	protected ImageIcon imgEyeTrue;
	
	protected JTextField jtLogin;
	protected JPasswordField jPassword;
	protected JButton jbOpen;
	protected JButton jbEye;
	
	public LoginAdm() {
		
		imgOpen = new ImageIcon("res\\button\\entrar.png");
		background = new ImageIcon("res\\backGround\\ModeloLoginAdm.png");
		
		jtLogin = new JTextField();
		jPassword = new JPasswordField();
		jbOpen = new JButton();
		jbEye = new JButton();
		
		setLayout(null);

		// posição dos campos e botões
		Util.setText(jtLogin, 280, 267, 385, 33);
		Util.setText(jPassword,280, 349, 343, 33);
		Util.setButton(jbOpen, null, 593, 392, 100, imgOpen.getIconHeight());
		Util.setButton(jbEye, null, 621, 354, 50, 28);
		
		add(jtLogin);
		add(jPassword);
		add(jbOpen);
		add(jbEye);
	}
	
	protected void paintComponent(Graphics g) {
		Image img;
		
		img = background.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
	}
}
