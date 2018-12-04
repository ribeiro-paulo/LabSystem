package object;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicComboBoxUI;


public final class Util {
	
	public static String screen;
	public static JFrame jf;
	
	/* matricula do funcionário */
	public static int matriculation;
	
	
	/* Adm botões */
	public static JButton jbEmployee;
	public static JButton jbSector;
	public static JButton jbCategory;
	
	/* funcionário botões */
	public static JButton jbTerm;
	public static JButton jbComponent;

	/* Constantes do BANCO DE DADOS */
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

	/* nome */

	public static String name;

	// fonte
	public static final Font font = new Font("Arial", Font.BOLD, 18);

	/*
	 * Constantes para a cor de fundo RGB Link: new Color(15,34,71)
	 * https://www.webpagefx.com/web-design/hex-to-rgb/
	 */
	public static final Color colorBackground = Color.WHITE;
	public static final Color jColor = Color.WHITE;
	public static final Color jPressedColor = Color.WHITE;
	public static final Color jColortext = Color.black;

	/*
	 * imagens
	 */
	
	public static final ImageIcon imgNotNull = new ImageIcon("res\\gif\\preenchaTodosOsCampos.gif");
	public static final ImageIcon imgSaved = new ImageIcon("res\\gif\\dadosSalvos.gif");
	public static final ImageIcon imgDeleted = new ImageIcon("res\\gif\\dadosExcluidos.gif");
	
	public static JLabel setDeleted(JPanel jp) {
		JLabel jl = new JLabel();

		imgDeleted.getImage().flush();
		jl.setIcon(imgDeleted);
		jl.setBounds(450, 1, imgDeleted.getIconWidth(), imgDeleted.getIconHeight());

		jp.add(jl);
		jp.repaint();
		return jl;
	}
	
	public static JLabel setSaved(JPanel jp) {
		JLabel jl = new JLabel();

		imgSaved.getImage().flush();
		jl.setIcon(imgSaved);
		jl.setBounds(450, 1, imgSaved.getIconWidth(), imgSaved.getIconHeight());

		jp.add(jl);
		jp.repaint();
		return jl;
	}

	public static JLabel setNotNull(JPanel jp) {
		JLabel jl = new JLabel();
		
		imgNotNull.getImage().flush();
		jl.setIcon(imgNotNull);
		jl.setBounds(375, 1, imgNotNull.getIconWidth(), imgNotNull.getIconHeight());
		
		jp.add(jl);
		jp.repaint();
		return jl;
	}
	
	// fundo
	public static final ImageIcon background = new ImageIcon("res\\backGround\\back.png");
	public static final ImageIcon logo = new ImageIcon("res\\logo\\logo.png");

	/*
	 * Controla as telas pro esc
	 */
	public static JPanel thisScreen;
	public static JPanel lastScreen;
	
	/* retorna a data  */
	public static Date getDate() {
		return new Date(System.currentTimeMillis());
	}

	/* Verifica se tem algo escrito na String */
	public static boolean notNull(String string) {
		if (string.isEmpty() || string.toCharArray()[string.length() - 1] == ' ') 
			return false; // null
		else
			return true;
	}
	
	/*
	 * converter para inteiro
	 */
	public static int convertInt(JTextField field) {
		return Integer.parseInt(field.getText().trim());
	}
	
	public static String convertDate(String date) {
		
		String data = date.replaceAll("-", "/");
		String[] s = data.split("/");
		String newDate = s[2]+"/"+s[1]+"/"+s[0];
		
		return newDate;
	}
	
	public static String convertUp(String string) {
		
		return string.toUpperCase();
		
	}
	
	public static String convertLower(String string) {
		
		return string.toLowerCase();
		
	}
	
	public static JLabel ball(int x, int y, JPanel jp) {
		
		JLabel jl = new JLabel();
		jl.setIcon(new ImageIcon("res\\termo\\ball.png"));
		jl.setBounds(x, y, 25, 25);
		jp.add(jl);
		
		return jl;
		
	}
	
	/*
	 *  configura o comboBox
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox getComboBoxBlue(int x, int y, JPanel jp) {
		
		UIManager.put("ComboBox.buttonDarkShadow", new Color(15,34,71));
	    UIManager.put("ComboBox.buttonBackground", Color.WHITE);
	    UIManager.put("ComboBox.buttonHighlight",  Color.WHITE);
	    UIManager.put("ComboBox.buttonShadow",     Color.WHITE);
		
		JComboBox jc = new JComboBox();
		jc.setBounds(x, y, 400, 30);
		jc.addItem("");
		
		jc.setBackground(new Color(15,34,71));
		jc.setFont(font);
		jc.setForeground(Color.WHITE);
		jc.setFocusCycleRoot(false);
		
		jc.setFocusable(false);
		jc.setBorder(null);
		
		jc.setUI(new BasicComboBoxUI());
		
		jp.setLayout(null);
		jp.add(jc);
		
		
		return jc; 
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static JComboBox getComboBox(int x, int y, int width, JPanel jp) {
		
		JComboBox jc = new JComboBox();
		jc.setBounds(x, y, width, 30);
		jc.addItem("");
		jc.setBorder(BorderFactory.createEtchedBorder(Util.jColor, Util.jColor));
		jc.setBackground(Color.WHITE);
		jc.setFont(font);
		jc.setForeground(jColortext);
		
		jp.setLayout(null);
		jp.add(jc);
		
		return jc; 
	}
	
	/*
	 * Configura o botão
	 */
	public static final JButton setButton(JButton button, int x, int y, int width, int height, JPanel jp) {
		button = new JButton();
		button.setBounds(x, y, width, height);
		button.setIcon(null);
		button.setText(null);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		
		
		jp.setLayout(null);
		jp.add(button);
		
		return button;
	}
	
	public static JTextField setField(int x, int y, int width, JPanel jp) {
		JTextField jt = new JTextField();
		jt.setBounds(x, y, width, 28);
		jt.setBackground(colorBackground);// fundo
		jt.setForeground(jColortext);// cor da fonte
		jt.setBorder(BorderFactory.createEtchedBorder(Util.jColor, Util.jColor)); // borda
		jt.setFont(font);// font
		
		jp.setLayout(null);
		jp.add(jt);
		
		return jt;
	}
	
	public static JPasswordField setPassword(int x, int y, int width, JPanel jp) {
		
		JPasswordField password = new JPasswordField();
		password.setBounds(x, y, width, 28);
		password.setBackground(colorBackground);// fundo
		password.setForeground(jColortext);// cor da fonte
		password.setBorder(BorderFactory.createEtchedBorder(Util.jColor, Util.jColor)); // borda
		password.setFont(font);// font
		
		jp.setLayout(null);
		jp.add(password);
		
		return password;
	}

	public static void setText(JTextField text, int x, int y, int width, int height) {
		text.setBounds(x, y, width, height);
		text.setBackground(colorBackground);// fundo
		text.setForeground(jColortext);// cor da fonte
		text.setBorder(BorderFactory.createEtchedBorder(Util.jColor, Util.jColor)); // borda
		text.setFont(font);// font
	}

	public static JLabel setLabel(int x, int y, String text, String value) {

		JLabel jlabel = new JLabel(text + " " + value);
		jlabel.setFont(Util.font);
		jlabel.setForeground(new Color(15,34,71));
		jlabel.setBounds(x, y, 400, 30);

		return jlabel;
	}
	
	/* Insere uma mensagem na tela */
	public static JLabel setMenssage(int x, int y, String text, JPanel jp) {
		
		JLabel jlabel = new JLabel(text);
		jlabel.setFont(new Font("Arial", Font.BOLD, 22));
		jlabel.setForeground(new Color(15,34,71));
		jlabel.setBounds(x, y, 500, 40);
		jp.add(jlabel);
		
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

	public static void newMenu(JPanel jp) {

		x = 6;
		y = 165;
		width = 240;
		height = 50;
		space = 20;

		imgRegister = new ImageIcon("res\\menus\\adicionar.png");
		imgUpdate = new ImageIcon("res\\menus\\atualizar.png");
		imgDelete = new ImageIcon("res\\menus\\excluir.png");
		imgConsult = new ImageIcon("res\\menus\\consultar.png");

		// texto e borda do botão de cadastrar
		jbRegister = setButton(jbRegister, x, y, width, height, jp);

		// Atualizar
		jbConsult = setButton(jbUpdate, x, y += height + space, imgConsult.getIconWidth(), imgConsult.getIconHeight(), jp);

		// texto e borda do botão de excluir
		jbUpdate = setButton(jbConsult, x, y += height + space, imgConsult.getIconWidth(), imgConsult.getIconHeight(), jp);

		// texto e borda do botão de consulta
		jbDelete = setButton(jbDelete, x, y += height + space, imgDelete.getIconWidth(), imgDelete.getIconHeight(), jp);

		
		
	}
	
	public static void createButtonEmployee(JPanel jp) {
		
		jbTerm = setButton(jbTerm, 550, 530, 170, 30, jp);
		jbComponent = setButton(jbTerm, 260, 530, 135, 30, jp);
		
	}
	
	/* Cria os botões inferiores da tela adm */
	public static void createButtonAdm(JPanel jp) {
		
		jbEmployee = setButton(jbEmployee, 210, 530, 135, 30, jp);
		jbSector = setButton(jbSector, 615, 530, 65, 30, jp);
		jbCategory = setButton(jbCategory, 435, 530, 100, 30, jp);

	}

	/* insere os valores no JComboBox */
	public static void returnItens(JComboBox<String> jcCategory, JComboBox<String> jcSector) {

		Connection conn;

		try {
			/* Retorna Categoria */
			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);

			Statement st = conn.createStatement();
			String sql = "select nome from Categoria";
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				jcCategory.addItem(rs.getString("nome"));
			}

			rs.close();
			st.close();
			conn.close();

			/* Retorna Setor */
			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);

			st = conn.createStatement();
			sql = "select nome from setor";
			rs = st.executeQuery(sql);

			while (rs.next()) {
				jcSector.addItem(rs.getString("nome"));
			}

			rs.close();
			st.close();
			conn.close();

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

	}

	/* Retorna Chave Estrangeira de Objeto referente à Categoria */
	public static int CategoryCode(String string) {
		Connection conn;
		int cod = 0;

		try {

			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);

			String sql = "select codigo from Categoria where nome=?";

			PreparedStatement pstPesq = conn.prepareStatement(sql);

			pstPesq.setString(1, string);
			ResultSet rs = pstPesq.executeQuery();

			if (rs.next()) {
				cod = rs.getInt("codigo");
			}

			rs.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return cod;
	}

	/* Retorna Chave Estrangeira de Objeto referente à Setor */
	public static int sectorNumber(String set) {
		Connection conn;
		int cod = 0;

		try {

			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);

			String sql = "select numero from Setor where nome=?";

			PreparedStatement pstPesq = conn.prepareStatement(sql);

			pstPesq.setString(1, set);
			ResultSet rs = pstPesq.executeQuery();

			if (rs.next()) {
				cod = rs.getInt("numero");
			}

			rs.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return cod;
	}

	/* retorna a chamave estrangeira informada */
	public static int returnKey(String key, String table, String name) {
		Connection conn;
		int cod = 0;

		try {

			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);

			String sql = "select " + key + " from " + table + " where nome = '" + name + "'";

			PreparedStatement pstPesq = conn.prepareStatement(sql);

			ResultSet rs = pstPesq.executeQuery();

			if (rs.next()) {
				cod = rs.getInt(key);
			}

			rs.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return cod;
	}
	
	/* retorna a chamave estrangeira informada */
	public static String getValue(String key, String table,String where, String name) {
		Connection conn;
		String result = "not";

		try {

			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);

			String sql = "select " + key + " from " + table + " where " + where + " = '" + name + "'";

			PreparedStatement pstPesq = conn.prepareStatement(sql);

			ResultSet rs = pstPesq.executeQuery();

			if (rs.next()) {
				result = rs.getString(key);
				
			}

			rs.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		return result;
	}
	
	/*
	 * retorna um array list do nome referente à tabela informada
	 */
	public static List<String> getList(String variable, String table){
		
		Connection conn;
		
		List<String> list = new ArrayList<>();
		
        String sql = "select " + variable + " from " + table;
        try {
        	
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);
        	
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
                //adiciona a categoria no ArrayList
                list.add(rs.getString("nome"));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
	}
	
	
	/*
	 * retorna um array list da chave primaria referente à tabela informada
	 */
	public static List<Integer> getListKey(String key, String table){
		
		Connection conn;
		
		List<Integer> list = new ArrayList<>();
		
        String sql = "select " + key + " from " + table;
        try {
        	
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);
        	
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
                //adiciona a categoria no ArrayList
                list.add(rs.getInt(key));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return list;
	}

}
