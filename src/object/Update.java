package object;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon background;
	public JTextField jtName;
	public JButton jbSearch;
	public JButton jbSave;

	public JTextField jtDescription;
	public JTextField jtAmount;

	public JComboBox<String> jcCategory;
	public JComboBox<String> jcSector;

	public boolean update;
	public int code;

	public Update() {
		
		Util.screen = "objeto";
		
		background = new ImageIcon("res\\backGround\\ModeloAtualizar.png");
		jtName = new JTextField();
		update = false;

		setLayout(null);

		Util.setText(jtName, 425, 221, 285, 30);
		jbSearch = Util.setButton(jbSearch, 640, 280, 75, 30, this);

		Util.newMenu(this);
		add(jtName);
	}

	/* Pesquisa o nome que o usuário digitou */
	public void searchName(JTextField name) {

		jtName.setVisible(false);
		jbSearch.setVisible(false);

		Connection conn;

		try {
			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);

			String sqlPesq = "select codigo, nome, descricao, situacao, qtde from objeto where nome=?";
			PreparedStatement pstPesq = conn.prepareStatement(sqlPesq);

			pstPesq.setString(1, name.getText());
			ResultSet rs = pstPesq.executeQuery();

			if (rs.next()) {

				jtName = new JTextField();
				jtDescription = new JTextField();
				jtAmount = new JTextField();

				jcCategory = new JComboBox<String>();
				jcSector = new JComboBox<String>();

				Util.setText(jtName, 430, 100, 310, 28);
				Util.setText(jtDescription, 467, 171, 310, 28);
				Util.setText(jtAmount, 480, 378, 310, 28);

				jbSave = Util.setButton(jbSave, 705, 455, 70, 30, this);
				jcCategory.setBounds(460, 246, 310, 28);
				jcSector.setBounds(460, 317, 310, 28);

				add(jtName);
				add(jtDescription);
				add(jcCategory);
				add(jcSector);
				add(jtAmount);

				code = rs.getInt("codigo");
				jtName.setText(rs.getString("NOME"));
				jtDescription.setText(rs.getString("DESCRICAO"));
				rs.getString("SITUACAO");
				jtAmount.setText(rs.getString("QTDE"));

			} else {
				System.out.println("Código não existe");
			}
			rs.close();
			pstPesq.close();
			conn.close();

			Util.returnItens(this.jcCategory, this.jcSector);

		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public void updateItens() {

		Connection conn;

		try {
			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);

			String sqlAltera = "update objeto set nome=?, descricao=?, situacao=?, qtde=?, catCod=?, setorNum=? where codigo=?";
			PreparedStatement pstAlt = conn.prepareStatement(sqlAltera);		
			pstAlt.setString(1, jtName.getText());
			pstAlt.setString(2, jtDescription.getText());
			pstAlt.setString(3, "Em uso");
			pstAlt.setString(4, jtAmount.getText());
			pstAlt.setInt(5, Util.CategoryCode(jcCategory.getSelectedItem().toString()));
			pstAlt.setInt(6, Util.sectorNumber(jcSector.getSelectedItem().toString()));
			pstAlt.setInt(7, code);
			pstAlt.executeUpdate();
			
			pstAlt.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}
	


	protected void paintComponent(Graphics g) {
		Image img;

		if (!update) {
			background = new ImageIcon("res\\backGround\\ModeloAtualizar.png");
			img = background.getImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
		} else {
			background = new ImageIcon("res\\backGround\\atualizar\\ModeloAtualizarComponentes.png");
			img = background.getImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);
		}
	}

}
