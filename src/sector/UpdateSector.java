package sector;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import object.ConnectionFactory;
import object.Util;

public class UpdateSector extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private JTextField jtName;
	private JButton jbSearch;
	private JLabel jlMenssage;
	private JLabel jlAction;
	private JButton jbSave;
	private JTextField jtLimit;
	private int code;
	private int limit;
	
	public UpdateSector() {
		
		background = new ImageIcon("res\\admin\\setor\\ModeloAtualizar.png");
		jtName = new JTextField();
		jtLimit = new JTextField();
		jlMenssage = Util.setMenssage(420, 180, "Insira o nome do setor", this);
		jlAction = Util.setMenssage(730, 305, "Buscar", this);
		jbSearch = Util.setButton(jbSearch, 730, 315, 75, 20, this);
		jbSave = Util.setButton(jbSave, 730, 320, 70, 30, this);
		
		jbSave.setVisible(false);
		
		Util.setText(jtName, 396, 249, 300, 28);
		Util.newMenu(this);
		Util.createButtonAdm(this);
	
		add(jtName);
	}
	
	/*
	 * cria a nova interface quando clica em buscar
	 */
	public void modeUpdate() {
		
		if(Util.returnKey("numero", "setor", getJtName().getText()) != 0) {
			
			code = Util.returnKey("numero", "setor", getJtName().getText());
			
			jlMenssage.setVisible(false);
			Util.setMenssage(385, 100, "Insira o NOVOS valores dos campos", this);
			
			jlAction.setVisible(false);
			//Util.setMenssage(730, 305, "Salvar", this);
			
			jbSearch.setVisible(false);
			jbSave.setVisible(true);
			
			Connection connection = new ConnectionFactory().getConnection();
			SectorDAO setDAO = new SectorDAO();
			limit = setDAO.getLimit(code);
			
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			/*
			 * modelo atualizar
			 */

			
			background = new ImageIcon("res\\admin\\setor\\ModeloAtualizar2.png");
			
			Util.setText(jtName, 396, 172, 407, 28);
			Util.setText(jtLimit, 481, 235, 323, 28);
			jtLimit.setText(limit + "");
			
			add(jtLimit);
			add(jtName);
		}
		
		this.repaint();
	}
	
	public void update() {
		Connection connection = new ConnectionFactory().getConnection();
		SectorDAO setDAO = new SectorDAO();
		setDAO.update(this);
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public JTextField getJtLimit() {
		return jtLimit;
	}

	public void setJtLimit(JTextField jtLimit) {
		this.jtLimit = jtLimit;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public JTextField getJtName() {
		return jtName;
	}

	public void setJtName(JTextField jtName) {
		this.jtName = jtName;
	}

	public JButton getJbSearch() {
		return jbSearch;
	}

	public void setJbSearch(JButton jbSearch) {
		this.jbSearch = jbSearch;
	}

	public JLabel getJlMenssage() {
		return jlMenssage;
	}

	public void setJlMenssage(JLabel jlMenssage) {
		this.jlMenssage = jlMenssage;
	}

	public JLabel getJlAction() {
		return jlAction;
	}

	public void setJlAction(JLabel jlAction) {
		this.jlAction = jlAction;
	}

	public JButton getJbSave() {
		return jbSave;
	}

	public void setJbSave(JButton jbSave) {
		this.jbSave = jbSave;
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
