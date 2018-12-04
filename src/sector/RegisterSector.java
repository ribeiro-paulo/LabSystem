package sector;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import object.ConnectionFactory;
import object.Util;

public class RegisterSector extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private JTextField jtName;
	private JTextField jtLimit;
	private JButton jbSave;

	public RegisterSector() {
		
		Util.screen = "setor";
		
		background = new ImageIcon("res\\admin\\setor\\ModeloAdicionar.png");
		jtName = new JTextField();
		jtLimit = new JTextField();
		
		Util.createButtonAdm(this);
		Util.newMenu(this);
		Util.setText(jtName, 396, 172, 407, 28);
		Util.setText(jtLimit, 481, 235, 323, 28);
		jbSave = Util.setButton(jbSave, 730, 320, 70, 30, this);
		
		add(jtLimit);
		add(jtName);
	}
	
	public void register() {
		Connection connection = new ConnectionFactory().getConnection();
		SectorDAO setDAO = new SectorDAO();
		setDAO.register(this);
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JTextField getJtName() {
		return jtName;
	}

	public void setJtName(JTextField jtName) {
		this.jtName = jtName;
	}

	public JTextField getJtLimit() {
		return jtLimit;
	}

	public void setJtLimit(JTextField jtLimit) {
		this.jtLimit = jtLimit;
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
