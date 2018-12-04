package login;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import employee.RegisterEmployee;
import labSystem.LabSystem;
import object.ConnectionFactory;
import object.Register;
import object.Util;

public class Login extends JPanel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon backgorund;
	private JTextField jtMatriculetion;
	private JPasswordField jpPassword;
	private ImageIcon bar;
	private JButton jbLogin;
	private JButton jbBefore;
	private JButton jbEye;
	private boolean eye = false;
	
	public Login() {
		
		backgorund = new ImageIcon("res\\login\\ModeloLogin.png");
		bar = new ImageIcon("res\\login\\bar.png");
		
		jtMatriculetion = Util.setField(275, 240, 400, this);
		jpPassword = Util.setPassword(275, 322, 350, this);
		jbEye = Util.setButton(jbEye, 626, 325, 36, 22, this);
		jbBefore = Util.setButton(jbBefore, 165, 450, 70, 70, this);
		jbLogin = Util.setButton(jbLogin, 690, 450, 70, 70, this);
		jbEye.setIcon(bar);
		
		jtMatriculetion.requestFocus();
	}
	
	/* verificação dos dados após clicar em entrar */
	public void login(LabSystem lab) {
		
		int is;
		Connection connection = new ConnectionFactory().getConnection();
		LoginDAO loDAO = new LoginDAO();
		is = loDAO.searchPerson(this);
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// funcio
		if(is == 1) {
			lab.anotherScreen(Util.thisScreen, lab.register = new Register());
		}
		
		// Administrador
		if(is == 2) {
			lab.anotherScreen(Util.thisScreen, lab.rEmployee = new RegisterEmployee());
		}
		
		
	}
	
	/*
	 * congigura o olho
	 */
	public void Eye() {
		
		if(eye) {
			
			eye = false;
			jbEye.setIcon(bar);
			jpPassword.setEchoChar(Util.invisible);
			
		}else {
			
			eye = true;
			jbEye.setIcon(null);
			jpPassword.setEchoChar(Util.seePasword);
		}
		
		jpPassword.requestFocus();
	}
	
	
	
	public JButton getJbBefore() {
		return jbBefore;
	}

	public void setJbBefore(JButton jbBefore) {
		this.jbBefore = jbBefore;
	}

	public JButton getJbLogin() {
		return jbLogin;
	}

	public void setJbLogin(JButton jbLogin) {
		this.jbLogin = jbLogin;
	}

	public JButton getJbEye() {
		return jbEye;
	}

	public void setJbEye(JButton jbEye) {
		this.jbEye = jbEye;
	}

	public JTextField getJtMatriculetion() {
		return jtMatriculetion;
	}

	public void setJtMatriculetion(JTextField jtMatriculetion) {
		this.jtMatriculetion = jtMatriculetion;
	}

	public JPasswordField getJpPassword() {
		return jpPassword;
	}

	public void setJpPassword(JPasswordField jpPassword) {
		this.jpPassword = jpPassword;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ImageIcon getBackgorund() {
		return backgorund;
	}

	protected void paintComponent(Graphics g) {
		
		Image img;
		
		img = backgorund.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
	}
}
