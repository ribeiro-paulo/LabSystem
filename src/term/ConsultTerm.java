package term;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import object.ConnectionFactory;
import object.Util;

public class ConsultTerm extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private boolean back = false;
	private JTabbedPane jtTable;
	private JComboBox<String> jc;
	private JButton jbSearch;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsultTerm() {
		
		background = new ImageIcon("res\\termo\\ModeloConsultar.png");
		jc = Util.getComboBoxBlue(369, 223, this);
		jbSearch = Util.setButton(jbSearch, 686, 305, 80, 25, this);
		
		Connection connection = new ConnectionFactory().getConnection();
		TermDAO terDAO = new TermDAO();
		
		jc.setModel(new DefaultComboBoxModel(new Vector(terDAO.getList())));
		
		Util.createButtonEmployee(this);
		Util.newMenu(this);
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void search() {
		
		ArrayList<Integer> keys = new ArrayList<Integer>();
		keys = (ArrayList<Integer>) Util.getListKey("numero", "TermoResponsabilidade");
		
		Connection connection = new ConnectionFactory().getConnection();
		TermDAO terDAO = new TermDAO();
		
		terDAO.getTerm(this, keys.get(jc.getSelectedIndex()));
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		back = true;
		this.repaint();
	}
	
	
	public JTabbedPane getJtTable() {
		return jtTable;
	}


	public void setJtTable(JTabbedPane jtTable) {
		this.jtTable = jtTable;
	}


	public JComboBox<String> getJc() {
		return jc;
	}


	public void setJc(JComboBox<String> jc) {
		this.jc = jc;
	}


	public JButton getJbSearch() {
		return jbSearch;
	}


	public void setJbSearch(JButton jbSearch) {
		this.jbSearch = jbSearch;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	protected void paintComponent(Graphics g) {

		Image img;
		
		if(!back) {
			img = background.getImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		}else {
			
			jc.setVisible(false);
			background = new ImageIcon("res\\termo\\ModeloConsultar2.png");
			img = background.getImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		}
	}
}
