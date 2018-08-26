package labSystem;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



import component.Util;

public class Login extends JPanel{

	
	
	JTextField jtLogin;
	JPasswordField jPassword;
	
	JButton jbOpen;
	JButton jbForget;
	
	ImageIcon openText;
	
	public Login() {
		
		jtLogin = new JTextField();
		jPassword = new JPasswordField();
		openText = new ImageIcon("res\\menus\\login.png");
		jbOpen = new JButton();
		jbForget = new JButton();
		
		setLayout(null);
		
		// posição dos campos e botões
		jtLogin.setBounds(280, 250, 350, 30);
		jPassword.setBounds(280, 303, 350, 30);
		jbOpen.setBounds(532, 340, 100, 34);
		jbForget.setBounds(240, 345, 200, 34);
		
		add(jtLogin);
		add(jPassword);
		add(jbOpen);
		add(jbForget);
		
		jtLogin.setBackground(Color.darkGray);
		jPassword.setBackground(Color.DARK_GRAY);
		
		// cor da fonte
		jtLogin.setForeground(Color.WHITE); 
		jPassword.setForeground(Color.WHITE);
		
		//borda
		jtLogin.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
		jPassword.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
		
		
		jbOpen.setText(null);
		jbOpen.setIcon(openText); // texto do botão
		jbOpen.setPressedIcon( new ImageIcon(" ") ); // Imagem ao clicar
		
		jbForget.setIcon(new ImageIcon(" ")); // texto do botão
		jbForget.setText("Esqueci minha senha");
		jbForget.setForeground(Color.LIGHT_GRAY);
		jbForget.setPressedIcon( new ImageIcon(" ") ); // Imagem ao clicar
		
		// borda
		jbOpen.setBorderPainted(false);
		jbOpen.setContentAreaFilled(false);
		
		jbForget.setBorderPainted(false);
		jbForget.setContentAreaFilled(false);
	}
	
	protected void paintComponent(Graphics g) {
		
		Image img = Util.menuBackGround.getImage();
		g.drawImage(img, 0, 0, getWidth() , getHeight(), this);
		
		img = Util.logo.getImage();
		g.drawImage(img, Util.DEFAULT_SCREEN_WIDTH - 610, 20, 300, 200, this);
		
		g.setColor(Color.WHITE);
		
		g.drawString("LOGIN:", 280, 247);
		g.drawString("SENHA", 280, 300);
	}
}
