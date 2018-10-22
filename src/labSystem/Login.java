package labSystem;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import component.Util;

public class Login extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JTextField jtLogin;
	protected JPasswordField jPassword;

	protected JButton jbOpen;
	protected JButton jbForget;
	protected JButton jbHelp;
	protected JButton jbAddEmployee;
	protected JButton jbEye;

	protected ImageIcon imgOpen;
	protected ImageIcon imgHelp;
	protected ImageIcon imgHelpPress; // cor
	protected ImageIcon imgEmployee;
	protected ImageIcon imgEmployeePress;
	protected ImageIcon imgWrong;
	protected ImageIcon background;
	protected ImageIcon imgEyeFalse;
	protected ImageIcon imgEyeTrue;
	protected ImageIcon backgroundEye;

	public Login() {

		jtLogin = new JTextField();
		jPassword = new JPasswordField();

		jbOpen = new JButton();
		jbForget = new JButton();
		jbHelp = new JButton();
		jbAddEmployee = new JButton();
		jbEye = new JButton();

		imgOpen = new ImageIcon("res\\button\\entrar.png");
		imgHelp = new ImageIcon("res\\button\\lampada.png");
		imgHelpPress = new ImageIcon("res\\button\\lampadaAmarela.png");
		imgEmployee = new ImageIcon("res\\button\\novoFuncionario.png");
		imgEmployeePress = new ImageIcon("res\\button\\FuncionarioAmarelo.png");
		imgWrong = new ImageIcon("res\\backGround\\ModeloLoginErro.png");
		background = new ImageIcon("res\\backGround\\ModeloLogin.png");
		imgEyeFalse = new ImageIcon("res\\button\\olhoSim.png");
		imgEyeTrue = new ImageIcon("res\\button\\olhoNao.png");
		backgroundEye = new ImageIcon("res\\background\\ModeloLoginEye.png");

		setLayout(null);

		// posição dos campos e botões
		jtLogin.setBounds(280, 267, 385, 33);
		jPassword.setBounds(280, 349, 343, 33);
		jbForget.setBounds(244, 337, 200, 34);
		jbHelp.setBounds(Util.DEFAULT_SCREEN_WIDTH - 50, 0, imgHelp.getIconWidth(), imgHelp.getIconWidth());
		jbAddEmployee.setBounds(Util.DEFAULT_SCREEN_WIDTH - 90, 2, imgHelp.getIconWidth(), imgHelp.getIconWidth());

		add(jtLogin);
		add(jPassword);
		add(jbOpen);
		add(jbEye);
		// add(jbForget);
		// add(jbHelp);
		// add(jbAddEmployee);

		// fundo
		jtLogin.setBackground(Util.colorBackground);
		jPassword.setBackground(Util.colorBackground);

		// cor da fonte
		jtLogin.setForeground(Util.jColortext);
		jPassword.setForeground(Util.jColortext);

		// borda
		jtLogin.setBorder(BorderFactory.createEtchedBorder(Util.jColor, Util.jColor));
		jPassword.setBorder(BorderFactory.createEtchedBorder(Util.jColor, Util.jColor));

		// fonte
		jtLogin.setFont(new Font("Arial", Font.BOLD, 18));
		jPassword.setFont(new Font("Arial", Font.BOLD, 18));

		// Entrar
		Util.setButton(jbOpen, null, 593, 392, 100, imgOpen.getIconHeight());

		// Olho
		Util.setButton(jbEye, null, 621, 354, 50, 28);

		// esqueci minha senha
		jbForget.setIcon(new ImageIcon(" ")); // texto do botão
		jbForget.setFont((new Font("Gill Sans Ultra Bold", Font.PLAIN, 10)));
		jbForget.setText("Esqueci minha senha");
		jbForget.setForeground(Color.LIGHT_GRAY);
		jbForget.setPressedIcon(new ImageIcon(" ")); // Imagem ao clicar
		jbForget.setBorderPainted(false);
		jbForget.setContentAreaFilled(false);

		// Ajuda
		jbHelp.setText(null);
		jbHelp.setIcon(imgHelp); // texto do botão
		jbHelp.setPressedIcon(imgHelpPress); // Imagem ao clicar
		jbHelp.setBorderPainted(false);
		jbHelp.setContentAreaFilled(false);

		jbAddEmployee.setText(null);
		jbAddEmployee.setIcon(imgEmployee); // texto do botão
		jbAddEmployee.setPressedIcon(imgEmployeePress); // Imagem ao clicar
		jbAddEmployee.setBorderPainted(false);
		jbAddEmployee.setContentAreaFilled(false);

	}

	protected void paintComponent(Graphics g) {
		Image img;
		// fundo
		if (Util.isPassword) {
			img = backgroundEye.getImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
		} else {
			img = background.getImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		}
		// Erro
		if (Util.isWrong) {
			// mensagem
			img = imgWrong.getImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
		}

	}
}
