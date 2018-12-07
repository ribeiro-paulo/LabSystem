package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Delete extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon background;
	private ImageIcon backgroundText;
	public JButton jbSearch;
	public JButton jbDelete;
	private int code;
	private JComboBox<String> jc;
	private List<String> obj;
	public boolean a = false;
	int cat;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Delete() {

		Util.screen = "objeto";
		
		Connection connection = new ConnectionFactory().getConnection();
		ObjDAO objDAO = new ObjDAO();
		obj = objDAO.getList();
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		jc = Util.getComboBoxBlue(369, 223, this);
		jbSearch = Util.setButton(jbSearch, 686, 305, 80, 25, this);
		jc.setModel(new DefaultComboBoxModel(new Vector(obj)));
		backgroundText = new ImageIcon("res\\backGround\\fundo.png");
		background = new ImageIcon("res\\backGround\\ModeloExcluir.png");
		
		jbDelete = new JButton();

		setLayout(null);

		Util.newMenu(this);
		Util.createButtonEmployee(this);

		jbDelete = Util.setButton(jbDelete, 686, 305, 80, 25, this);
		
		jbDelete.setVisible(false);
		add(jbSearch);

	}
	
	
	public JButton getJbSearch() {
		return jbSearch;
	}


	public void setJbSearch(JButton jbSearch) {
		this.jbSearch = jbSearch;
	}


	public JButton getJbDelete() {
		return jbDelete;
	}


	public void setJbDelete(JButton jbDelete) {
		this.jbDelete = jbDelete;
	}


	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public JComboBox<String> getJc() {
		return jc;
	}


	public void setJc(JComboBox<String> jc) {
		this.jc = jc;
	}


	public List<String> getObj() {
		return obj;
	}


	public void setObj(List<String> obj) {
		this.obj = obj;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public void showObject() {
		
		jbDelete.setVisible(true);
		jc.setVisible(false);
		jbSearch.setVisible(false);

		Connection conn;
		JLabel jlObject;
		int xTexto = 425, yTexto = 155;

		try {
			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);

			String sqlPesq = "select nome, catCod, codigo, descricao, situacao, qtde from objeto where nome=?";
			

			PreparedStatement pstPesq = conn.prepareStatement(sqlPesq);
			

			pstPesq.setString(1, Util.name);
			ResultSet rs = pstPesq.executeQuery();

			if (rs.next()) {

				code = rs.getInt("codigo");
				cat = rs.getInt("catCod");

				jlObject = new JLabel(rs.getString("NOME"));
				jlObject.setFont(Util.font);
				jlObject.setForeground(Color.WHITE);
				jlObject.setBounds(530 - rs.getString("NOME").length() / 3 * rs.getString("NOME").length(), yTexto, 400,
						70);
				add(jlObject);

				add(Util.setLabel(xTexto, yTexto += 45, "Descrição", rs.getString("DESCRICAO")));

				add(Util.setLabel(xTexto, yTexto += 30, "Situação", rs.getString("SITUACAO")));

				add(Util.setLabel(xTexto, yTexto += 30, "Quantidade", rs.getString("QTDE")));

				jlObject = new JLabel();
				jlObject.setIcon(backgroundText);

				jlObject.setBounds(312, -60, backgroundText.getIconWidth(), background.getIconHeight());
				add(jlObject);

				//add(Util.setLabel(740, 325, "Apagar", ""));
				add(jbDelete);

			} else {
				System.out.println("Código não existe");
			}
			pstPesq.close();
			
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

			String sqlExclui = "delete from objeto where codigo=? and catCod = " + cat;

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
		
		if(!a) {
			img = background.getImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
		}else {
			background = new ImageIcon("res\\backGround\\ModeloExcluir2.png");
			img = background.getImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
		}
	}
}
