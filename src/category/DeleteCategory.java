package category;

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

public class DeleteCategory extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	@SuppressWarnings("rawtypes")
	private JComboBox jcCategory;
	private JButton jbDelete;
	private int code;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DeleteCategory() {
		
		jcCategory = new JComboBox();
		background = new ImageIcon("res\\admin\\categoria\\ModeloExcluir.png");
		
		List<String> cat;
		
		/* retorna os dados */
		Connection connection = new ConnectionFactory().getConnection();
		CategoryDAO catDAO = new CategoryDAO();
		cat = catDAO.getList();
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		jbDelete = Util.setButton(jbDelete, 605, 340, 80, 20, this);
		Util.createButtonAdm(this);
		Util.newMenu(this);
		
		jcCategory.setBounds(390, 250, 289, 30);
		jcCategory.setModel(new DefaultComboBoxModel(new Vector(cat)));
		jcCategory.setBackground(Color.WHITE);
		jcCategory.setFont(Util.font);
		
		add(jcCategory);
	}
	
	public void delete() {
		
		code = Util.returnKey("codigo", "categoria", jcCategory.getSelectedItem().toString());
		
		Connection connection = new ConnectionFactory().getConnection();
		CategoryDAO catDAO = new CategoryDAO();
		catDAO.delete(this);
		
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
	
	public JButton getJbDelete() {
		return jbDelete;
	}

	public void setJbDelete(JButton jbDelete) {
		this.jbDelete = jbDelete;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getJcCategory() {
		return jcCategory;
	}

	@SuppressWarnings("rawtypes")
	public void setJcCategory(JComboBox jcCategory) {
		this.jcCategory = jcCategory;
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
