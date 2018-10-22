package component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public final class Util {

	/* Constantes do BANCO DE DADOS*/
	public static String driver = "com.mysql.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/LabSystem";
	public static String user = "root";
	public static String password = "1234";
	
	// erro
	public static boolean isWrong = false;
	
	// senha
	public final static char seePasword = '\u0000';
	public final static char invisible = '\u2022';
	public static boolean isPassword = false;

	// tamanho da tela
	public static final int DEFAULT_SCREEN_WIDTH = 900;
	public static final int DEFAULT_SCREEN_HEIGHT = 600;

	// fonte
	public static final Font font = new Font("Arial", Font.BOLD, 18);

	/*
	 * Constantes para a cor de fundo RGB Link:  new Color(15,34,71)
	 * https://www.webpagefx.com/web-design/hex-to-rgb/ 
	 */
	public static final Color colorBackground = Color.WHITE;
	public static final Color jColor = Color.WHITE;
	public static final Color jPressedColor = Color.WHITE;
	public static final Color jColortext =  Color.black;

	/*
	 * imagens
	 */

	// fundo
	public static final ImageIcon background = new ImageIcon("res\\backGround\\back.png");
	public static final ImageIcon logo = new ImageIcon("res\\logo\\logo.png");

	/*
	 * Controla as telas pro esc
	 */
	public static JPanel thisScreen;
	public static JPanel lastScreen;

	/*
	 * Insere as imagens do botão
	 */
	public static void setButton(JButton button, ImageIcon img, int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
		button.setIcon(img);
		button.setText(null);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
	}
	
	public static void setText(JTextField text, int x, int y, int width, int height) {
		text.setBounds(x, y, width, height);
		text.setBackground(colorBackground);// fundo
		text.setForeground(jColortext);// cor da fonte
		text.setBorder(BorderFactory.createEtchedBorder(Util.jColor, Util.jColor)); // borda
		text.setFont(font);// font
	}
	
	public static JLabel setLabel(int x, int y, String text, String value) {
		
		JLabel jlabel = new JLabel("-" + text + " " + value);
		jlabel.setFont(Util.font);
		jlabel.setBounds(x, y, 400, 70);
		
		return jlabel;
	}

	public static ImageIcon imgRegister;
	public static ImageIcon imgUpdate;
	public static ImageIcon imgConsult;
	public static ImageIcon imgDelete;

	public static JButton jbRegister;
	public static JButton jbUpdate;
	public static JButton jbConsult;
	public static JButton jbDelete;

	private static int x, y;
	private static int width, height;
	private static int space;

	public static void newMenu() {
		
		 x = 6; y = 165;
		 width = 240; height = 50;
		 space = 20;
		
		jbRegister = new JButton();
		jbUpdate = new JButton();
		jbConsult = new JButton();
		jbDelete = new JButton();

		imgRegister = new ImageIcon("res\\menus\\adicionar.png");
		imgUpdate = new ImageIcon("res\\menus\\atualizar.png");
		imgDelete = new ImageIcon("res\\menus\\excluir.png");
		imgConsult = new ImageIcon("res\\menus\\consultar.png");

		// texto e borda do botão de cadastrar
		setButton(jbRegister, null, 0, 0, 0, 0);

		// Atualizar
		setButton(jbUpdate, null, 0, 0, 0, 0);

		// texto e borda do botão de excluir
		setButton(jbDelete, null, 0, 0, 0, 0);

		// texto e borda do botão de consulta
		setButton(jbConsult, null, 0, 0, 0, 0);
		
		jbRegister.setBounds(x, y, width, height);
		jbConsult.setBounds(x, y += height + space, imgConsult.getIconWidth(), imgConsult.getIconHeight());
		jbUpdate.setBounds(x, y += height + space, imgUpdate.getIconWidth(), imgUpdate.getIconHeight());
		jbDelete.setBounds(x, y += height + space , imgDelete.getIconWidth(), imgDelete.getIconHeight());
	}

}
