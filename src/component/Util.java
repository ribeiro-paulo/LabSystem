package component;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public final class Util {

	// erro
	public static boolean isWrong = false;

	// tamanho da tela
	public static final int DEFAULT_SCREEN_WIDTH = 900;
	public static final int DEFAULT_SCREEN_HEIGHT = 600;

	// fonte
	public static final Font font = new Font("Arial", Font.PLAIN, 15);

	/*
	 * Constantes para a cor de fundo RGB Link:
	 * https://www.webpagefx.com/web-design/hex-to-rgb/
	 */
	public static final Color colorBackground = Color.WHITE;
	public static final Color jColor = Color.WHITE;
	public static final Color jPressedColor = Color.WHITE;

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
	public static void setButton(JButton button, ImageIcon img) {
		button.setIcon(img);
		button.setText(null);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
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
		
		 x = 5; y = 156;
		 width = 240; height = 50;
		 space = 17;
		
		jbRegister = new JButton();
		jbUpdate = new JButton();
		jbConsult = new JButton();
		jbDelete = new JButton();

		imgRegister = new ImageIcon("res\\menus\\adicionar.png");
		imgUpdate = new ImageIcon("res\\menus\\atualizar.png");
		imgDelete = new ImageIcon("res\\menus\\excluir.png");
		imgConsult = new ImageIcon("res\\menus\\consultar.png");

		jbRegister.setBounds(x, y, width, height);
		jbConsult.setBounds(x, y += height + space, width, height);
		jbUpdate.setBounds(x, y += height + space, width, height);
		jbDelete.setBounds(x, y += height + space, width, height);

		// texto e borda do botão de cadastrar
		setButton(jbRegister, null);

		// Atualizar
		setButton(jbUpdate, null);

		// texto e borda do botão de excluir
		setButton(jbDelete, null);

		// texto e borda do botão de consulta
		setButton(jbConsult, null);
	}

}
