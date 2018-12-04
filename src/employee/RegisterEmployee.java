package employee;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import object.ConnectionFactory;
import object.Util;

public class RegisterEmployee extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private ImageIcon background;
	private ImageIcon imgBall;
	private JLabel jlBall;
	private JButton jbYes;
	private JButton jbNot;
	private JButton jbSave;
	private JTextField jtName;
	private JTextField jtMatriculetion;
	private JPasswordField jpPassword;
	private JPasswordField jpConfirm;
	private String adm;
	
	public RegisterEmployee() {
		
		Util.screen = "funcionario";
		
		jtName = new JTextField();
		jtMatriculetion = new JTextField();
		jpConfirm = new JPasswordField();
		jlBall = new JLabel();
		jbYes = Util.setButton(jbYes, 500, 400, 60, 20, this);
		jbNot = Util.setButton(jbYes, 601, 400, 60, 20, this);
		jbSave = Util.setButton(jbSave, 745, 448, 65, 25, this);
		jpPassword = Util.setPassword(401, 263, 300, this);
		jpConfirm = Util.setPassword(500, 326, 300, this);		
		background = new ImageIcon("res\\admin\\funcionario\\ModeloAdicionar.png");
		imgBall = new ImageIcon("res\\admin\\funcionario\\ball.png");
		jlBall.setIcon(imgBall);
		
		Util.setText(jtName, 396, 137, 275, 28);
		Util.setText(jtMatriculetion, 430, 200, 300, 28);
		
		Util.createButtonAdm(this);
		Util.newMenu(this);
		
		add(jtMatriculetion);
		add(jtName);
		add(jlBall);
		jlBall.setVisible(false);
	}
	
	public void register() {
		
		Connection connection = new ConnectionFactory().getConnection();
		EmployeeDAO funcDAO = new EmployeeDAO();
		funcDAO.register(this);
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* preenche o campo selecionado */
	public void ball(boolean is) {
		
		if(is) {
			jlBall.setBounds(502, 403, imgBall.getIconWidth(), imgBall.getIconHeight());
			adm = "a";
		}else { 
			jlBall.setBounds(603, 403, imgBall.getIconWidth(), imgBall.getIconHeight());
			adm = "f";
		}
		jlBall.setVisible(true);
		this.repaint();
	}
	
	
	
	public String getAdm() {
		return adm;
	}

	public void setAdm(String adm) {
		this.adm = adm;
	}

	public JLabel getJlBall() {
		return jlBall;
	}

	public void setJlBall(JLabel jlBall) {
		this.jlBall = jlBall;
	}

	public JButton getJbSave() {
		return jbSave;
	}

	public void setJbSave(JButton jbSave) {
		this.jbSave = jbSave;
	}

	public JTextField getJtName() {
		return jtName;
	}

	public void setJtName(JTextField jtName) {
		this.jtName = jtName;
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

	public JPasswordField getJpConfirm() {
		return jpConfirm;
	}

	public void setJpConfirm(JPasswordField jpConfirm) {
		this.jpConfirm = jpConfirm;
	}

	public JButton getJbYes() {
		return jbYes;
	}

	public void setJbYes(JButton jbYes) {
		this.jbYes = jbYes;
	}

	public JButton getJbNot() {
		return jbNot;
	}

	public void setJbNot(JButton jbNot) {
		this.jbNot = jbNot;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	protected void paintComponent(Graphics g) {
		Image img;
		
		img = background.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		
	}
}
