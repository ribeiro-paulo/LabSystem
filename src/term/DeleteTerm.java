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

import object.ConnectionFactory;
import object.Util;

public class DeleteTerm extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private JComboBox<String> jc;
	private JButton jbSearch;
	private boolean back;
	private JButton jbYes;
	private JButton jbNot;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public DeleteTerm() {
		
		background = new ImageIcon("res\\termo\\ModeloExcluir.png");
		jc = Util.getComboBoxBlue(369, 223, this);
		jbSearch = Util.setButton(jbSearch, 686, 305, 80, 25, this);
		jbYes = Util.setButton(jbYes, 435, 307, 40, 20, this);
		jbNot = Util.setButton(jbNot, 660, 307, 40, 20, this);
		
		jbNot.setVisible(false);
		jbYes.setVisible(false);
		
		Connection connection = new ConnectionFactory().getConnection();
		TermDAO terDAO = new TermDAO();
		jc.setModel(new DefaultComboBoxModel(new Vector(terDAO.getList())));
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Util.createButtonEmployee(this);
		Util.newMenu(this);
	}
	
	public void search() {
		
		int tNumber;

		ArrayList<Integer> keys = new ArrayList<Integer>();
		keys = (ArrayList<Integer>) Util.getListKey("numero", "TermoResponsabilidade");
		
		Connection connection = new ConnectionFactory().getConnection();
		TermDAO terDAO = new TermDAO();
		
		tNumber = keys.get(jc.getSelectedIndex());
		
		terDAO.getDelete(this, tNumber);
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jbYes.setVisible(true);
		jbNot.setVisible(true);
		jc.setVisible(false);
		jbSearch.setVisible(false);
		
		back = true;
		this.repaint();
	}
	
	public JButton getJbYes() {
		return jbYes;
	}

	public void setJbYes(JButton jbYes) {
		this.jbYes = jbYes;
	}

	public JButton getJbNot() {
		return jbNot;
	}

	public void setJbNot(JButton jbNot) {
		this.jbNot = jbNot;
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
			
			background = new ImageIcon("res\\termo\\ModeloExcluir2.png");
			img = background.getImage();
			g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		}
	}
}
