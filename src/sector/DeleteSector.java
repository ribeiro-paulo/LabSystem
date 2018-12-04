package sector;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import object.ConnectionFactory;
import object.Util;

public class DeleteSector extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	@SuppressWarnings("rawtypes")
	private JComboBox jcSector;
	private JButton jbDelete;
	private int pos = 0;
	private int code;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DeleteSector() {
		
		jcSector = new JComboBox();
		background = new ImageIcon("res\\admin\\setor\\ModeloExcluir.png");

		List<String> set;
		
		/* retorna os dados */
		Connection connection = new ConnectionFactory().getConnection();
		SectorDAO setDAO = new SectorDAO();
		set = setDAO.getNameList();

		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		jbDelete = Util.setButton(jbDelete, 605, 340, 80, 20, this);
		Util.createButtonAdm(this);
		Util.newMenu(this);

		jcSector.setBounds(390, 250, 289, 30);
		jcSector.setModel(new DefaultComboBoxModel(new Vector(set)));
		jcSector.setBackground(Color.WHITE);
		jcSector.setFont(Util.font);

		add(jcSector);
	}
	
	public void delete() {
		
		code = Util.returnKey("numero", "setor", jcSector.getSelectedItem().toString());
		System.out.println(code);
		Connection connection = new ConnectionFactory().getConnection();
		SectorDAO setDAO = new SectorDAO();
		setDAO.delete(this);

		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getJcSector() {
		return jcSector;
	}

	@SuppressWarnings("rawtypes")
	public void setJcSector(JComboBox jcSector) {
		this.jcSector = jcSector;
	}

	public JButton getJbDelete() {
		return jbDelete;
	}

	public void setJbDelete(JButton jbDelete) {
		this.jbDelete = jbDelete;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
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
