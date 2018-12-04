package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Delete extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon background;
	private ImageIcon backgroundText;
	public JTextField jtName;
	public JButton jbSearch;
	public JButton jbDelete;
	private int code;

	public Delete() {

		Util.screen = "objeto";
		
		backgroundText = new ImageIcon("res\\backGround\\Consulta\\FundoDoTexto.png");
		background = new ImageIcon("res\\backGround\\ModeloExcluir.png");
		jtName = new JTextField();
		jbSearch = new JButton();
		jbDelete = new JButton();

		setLayout(null);

		Util.newMenu(this);
		Util.setText(jtName, 394, 231, 340, 30);
		jbSearch = Util.setButton(jbSearch, 650, 285, 90, 30, this);
		jbDelete = Util.setButton(jbDelete, 725, 325, 90, 30, this);

		add(jtName);
		add(jbSearch);

	}

	public void showObject() {

		jtName.setVisible(false);
		jbSearch.setVisible(false);

		Connection conn;
		JLabel jlObject;
		int xTexto = 400, yTexto = 165;

		try {
			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);

			String sqlPesq = "select nome, codigo, descricao, situacao, qtde from objeto where nome=?";
			String sqlExclui = "delete from objeto where codigo=?";

			PreparedStatement pstPesq = conn.prepareStatement(sqlPesq);
			PreparedStatement pstExc = conn.prepareStatement(sqlExclui);

			pstPesq.setString(1, Util.name);
			ResultSet rs = pstPesq.executeQuery();

			if (rs.next()) {

				code = rs.getInt("codigo");

				jlObject = new JLabel(rs.getString("NOME"));
				jlObject.setFont(Util.font);
				jlObject.setForeground(Color.WHITE);
				jlObject.setBounds(530 - rs.getString("NOME").length() / 3 * rs.getString("NOME").length(), yTexto, 400,
						70);
				add(jlObject);

				add(Util.setLabel(xTexto, yTexto += 30, "Descrição", rs.getString("DESCRICAO")));

				add(Util.setLabel(xTexto, yTexto += 30, "Situação", rs.getString("SITUACAO")));

				add(Util.setLabel(xTexto, yTexto += 30, "Quantidade", rs.getString("QTDE")));

				jlObject = new JLabel();
				jlObject.setIcon(backgroundText);

				jlObject.setBounds(300, -50, backgroundText.getIconWidth(), background.getIconHeight());
				add(jlObject);

				add(Util.setLabel(725, 300, "Apagar", ""));
				add(jbDelete);

			} else {
				System.out.println("Código não existe");
			}
			pstPesq.close();
			pstExc.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public void delete() {

		Connection conn;

		try {

			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);

			String sqlExclui = "delete from objeto where codigo=?";

			PreparedStatement pstExc = conn.prepareStatement(sqlExclui);

			pstExc.setInt(1, code);
			pstExc.executeUpdate();

			pstExc.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	protected void paintComponent(Graphics g) {
		Image img;

		img = background.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
	}
}
