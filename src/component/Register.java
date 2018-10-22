package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ImageIcon background;
	public ImageIcon imgClear;
	public ImageIcon imgSave;

	public JTextField jtName;
	public JTextField jtCategory;
	public JTextField jtSector;
	public JTextField jtDescription;
	public JTextField jtAmount;

	public JButton jbSave;
	public JButton jbClear;

	public JComboBox<String> jcCategory;
	public JComboBox<String> jcSector;
	
	public int catCod;
	public int setorNum;

	public Register() {

		background = new ImageIcon("res\\backGround\\modeloCadastro.png");
		imgClear = new ImageIcon("res\\button\\limparTudo.png");

		jtName = new JTextField();
		jtCategory = new JTextField();
		jtSector = new JTextField();
		jtDescription = new JTextField();
		jtAmount = new JTextField();
		
		jbSave = new JButton();
		jbClear = new JButton();
		jcCategory = new JComboBox<String>();
		jcSector = new JComboBox<String>();

		setLayout(null);

		// Barra de menu
		Util.newMenu();
		add(Util.jbRegister);
		add(Util.jbConsult);
		add(Util.jbUpdate);
		add(Util.jbDelete);

		// Campos
		Util.setText(jtName, 430, 100, 310, 28);
		Util.setText(jtDescription, 467, 171, 310, 28);
		Util.setText(jtCategory, 465, 246, 310, 28);
		Util.setText(jtSector, 426, 317, 310, 28);
		Util.setText(jtAmount, 480, 378, 310, 28);	

		Util.setButton(jbClear, null, 358, 402, 140, 30);
		Util.setButton(jbSave, null, 705, 455, 70, 30);

		jcCategory.setBounds(460, 246, 310, 28);
		jcSector.setBounds(460, 317, 310, 28);

		jcCategory.setBackground(Color.white);
		jcSector.setBackground(Color.white);

		add(jtName);
		add(jtDescription);
		add(jcCategory);
		add(jcSector);
		add(jtAmount);
		
		add(jbSave);
		// add(jtCategory);
		// add(jtSector);
		// add(jbClear);

		jcCategory.addItem("");
		jcSector.addItem("");
		returnItens();
	}

	/* insere os valores do comboBox */
	private void returnItens() {

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
	
	/* Salva os dados no banco de dados */
	public void insertObject(JTextField name, JTextField description, JTextField amount, JComboBox<String> category, JComboBox<String> sector) {
		
		
        Connection conn;
        
        try {
            Class.forName(Util.driver);
            conn = DriverManager.getConnection(Util.url, Util.user, Util.password);
            String sql = "insert into objeto ( nome, descricao, situacao, qtde, catCod, setorNum) values(?,?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(sql);
			    
                pst.setString(1, name.getText());
                pst.setString(2, description.getText());
                pst.setString(3, "Em uso");
                pst.setString(4,amount.getText());
                pst.setInt(5, category.getSelectedIndex());
                pst.setInt(6, sector.getSelectedIndex());
                
                pst.executeUpdate();
            
            pst.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
		
		
	}

	protected void paintComponent(Graphics g) {

		Image img = background.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);

	}

}
