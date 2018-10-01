package labSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import component.Util;

public class AddEmployee extends JPanel {

	protected JButton jbSelectPhoto;
	protected JButton jbSave;
	protected JButton jbCancel;

	protected JTextField jtName;
	protected JPasswordField jpPassword;
	protected JPasswordField jpConfirmPassword;
	protected JTextField jtPhoto;
	protected JTextField jtTip;
	protected JTextField jtRegistration;

	protected ImageIcon imgPassword;
	protected ImageIcon imgConfirmPassword;
	protected ImageIcon imgUser;
	protected ImageIcon imgSelectPhoto;
	protected ImageIcon imgAddEmployee;
	protected ImageIcon imgCancel;
	protected ImageIcon imgCancelTransparent;
	protected ImageIcon imgSave;
	protected ImageIcon imgSaveTransparent;
	
	protected boolean save = false;

	/*
	 * aux para as posições dos campos
	 */

	private int x = 100, y = 100;
	private int width = 350, height = 30, space = 60;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AddEmployee() {

		jbSelectPhoto = new JButton();
		jbCancel = new JButton();

		jtName = new JTextField();
		jpPassword = new JPasswordField();
		jpConfirmPassword = new JPasswordField();
		jtPhoto = new JTextField();
		jtTip = new JTextField();
		jtRegistration = new JTextField();
		jbSave = new JButton();

		imgPassword = new ImageIcon("res\\menus\\senhaCadastro.png");
		imgConfirmPassword = new ImageIcon("res\\menus\\confirmarSenha.png");
		imgUser = new ImageIcon("res\\menus\\user.png");
		imgSelectPhoto = new ImageIcon("res\\menus\\selecionarFoto.png");
		imgAddEmployee = new ImageIcon("res\\menus\\CadasatroDeFuncionarios.png");
		imgCancel = new ImageIcon("res\\menus\\cancelar.png");
		imgSave = new ImageIcon("res\\menus\\salvar.png");
		imgSaveTransparent = new ImageIcon("res\\menus\\salvarTransparente.png");
		imgCancelTransparent = new ImageIcon("res\\menus\\cancelarTransparente.png");

		setLayout(null);

		// salvar
		jbSave.setBounds(Util.DEFAULT_SCREEN_WIDTH - 350, Util.DEFAULT_SCREEN_HEIGHT - 200, imgCancel.getIconWidth(),
				imgCancel.getIconHeight());
		jbSave.setText(null);
		jbSave.setIcon(imgSaveTransparent); // texto do botão
		jbSave.setPressedIcon(imgSaveTransparent); // Imagem ao clicar
		jbSave.setBorderPainted(false);
		jbSave.setContentAreaFilled(false);
		add(jbSave);

		// Cancelar
		jbCancel.setBounds(Util.DEFAULT_SCREEN_WIDTH / 3, Util.DEFAULT_SCREEN_HEIGHT - 200, imgCancel.getIconWidth(),
				imgCancel.getIconHeight());
		jbCancel.setText(null);
		jbCancel.setIcon(imgCancelTransparent); // texto do botão
		jbCancel.setPressedIcon(imgCancelTransparent); // Imagem ao clicar
		jbCancel.setBorderPainted(false);
		jbCancel.setContentAreaFilled(false);
		add(jbCancel);

		// selecionar foto;
		jbSelectPhoto.setBounds(700, 230, imgSelectPhoto.getIconWidth(), imgSelectPhoto.getIconHeight());
		jbSelectPhoto.setText(null);
		jbSelectPhoto.setIcon(imgSelectPhoto); // texto do botão
		jbSelectPhoto.setPressedIcon(imgSelectPhoto); // Imagem ao clicar
		jbSelectPhoto.setBorderPainted(false);
		jbSelectPhoto.setContentAreaFilled(false);
		add(jbSelectPhoto);

		// nome
		jtName.setBounds(x, y, width, height);
		jtName.setBackground(Util.colorBackground);
		jtName.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
		jtName.setFont(Util.font);
		jtName.setForeground(Color.WHITE);
		jtName.setSelectedTextColor(Color.white);
		jtName.setCaretColor(Color.WHITE);
		jtName.setText("Nome completo*");
		add(jtName);

		// matricula
		jtRegistration.setBounds(x, y += space, width, height);
		jtRegistration.setBackground(Util.colorBackground);
		jtRegistration.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
		jtRegistration.setFont(Util.font);
		jtRegistration.setForeground(Color.WHITE);
		jtRegistration.setSelectedTextColor(Color.white);
		jtRegistration.setCaretColor(Color.WHITE);
		jtRegistration.setText("Matrícula*");
		add(jtRegistration);

		// senha
		jpPassword.setBounds(x, y += space + 30, width, height);
		jpPassword.setBackground(Util.colorBackground);
		jpPassword.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
		jpPassword.setForeground(Color.WHITE);
		jpPassword.setSelectedTextColor(Color.white);
		jpPassword.setCaretColor(Color.WHITE);
		add(jpPassword);

		// confirmar senha
		jpConfirmPassword.setBounds(x, y += space, width, height);
		jpConfirmPassword.setBackground(Util.colorBackground);
		jpConfirmPassword.setBorder(BorderFactory.createEtchedBorder(Color.WHITE, Color.WHITE));
		jpConfirmPassword.setForeground(Color.WHITE);
		jpConfirmPassword.setSelectedTextColor(Color.white);
		jpConfirmPassword.setCaretColor(Color.WHITE);
		add(jpConfirmPassword);

	}

	public void insertEmployee(JTextField name, JTextField registration,  JPasswordField thisPassword, JPasswordField confirmPassword) {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/systemlab";
		String user = "root";
		String password = "1234";
		Connection conn;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			Statement st = conn.createStatement();
			String sql = "INSERT INTO CADASTRO VALUES ('" + name.getText() + "','" + registration.getText() + "', '"+thisPassword.getText()+"', '"+confirmPassword.getText()+"')";
			st.executeUpdate(sql);
			st.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

	}

	protected void paintComponent(Graphics g) {
		Image img;

		// imagens
		img = Util.background.getImage();
		g.drawImage(img, 0, 0, getWidth(), getHeight(), null);

		img = imgAddEmployee.getImage();
		g.drawImage(img, Util.DEFAULT_SCREEN_WIDTH / 3 + 15, 10, img.getWidth(this), img.getHeight(this), null);

		// campos

		img = imgPassword.getImage();
		g.drawImage(img, x, y -= space + 15, img.getWidth(this), img.getHeight(this), null);

		img = imgConfirmPassword.getImage();
		g.drawImage(img, x, y -= space - 120, img.getWidth(this), img.getHeight(this), null);

		img = imgUser.getImage();
		g.drawImage(img, x += 450, 78, img.getWidth(this), img.getHeight(this), null);

	}

}
