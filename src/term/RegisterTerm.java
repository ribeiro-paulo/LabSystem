package term;

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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import object.ConnectionFactory;
import object.Util;

public class RegisterTerm extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private JComboBox<String> jcComponent;
	private JComboBox<String> jcSector;
	private JTextField jtDescrip;
	private JButton jbYes;
	private JButton jbNot;
	private ImageIcon ball;
	private JLabel jlBall;
	private char situetion;
	private JButton jbSave;
	private int termKey;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RegisterTerm() {
		
		Util.screen = "termo";
		
		background = new ImageIcon("res\\termo\\ModeloAdicionar.png");
		ball = new ImageIcon("res\\admin\\funcionario\\ball.png");
		jlBall = new JLabel();
		
		
		jcComponent = (Util.getComboBox(370, 140, 400, this));
		jcSector = Util.getComboBox(370, 231, 400, this);
		jtDescrip = Util.setField(468, 292, 304, this);
		jbYes = Util.setButton(jbYes, 460, 385, 55, 20, this);
		jbNot = Util.setButton(jbNot, 570, 385, 55, 20, this);
		jbSave = Util.setButton(jbSave, 705, 425, 80, 25, this);
		
		jcComponent.setModel(new DefaultComboBoxModel(new Vector(Util.getList("nome", "objeto"))));
		jcSector.setModel(new DefaultComboBoxModel(new Vector(Util.getList("nome", "setor"))));
		
		Util.newMenu(this);
		Util.createButtonEmployee(this);
		
		jlBall.setIcon(ball);
		add(jlBall);
	}
	
	public void register() {
		
		// pega a chave primaria do próximo termo
		List<Integer>list = Util.getListKey("numero", "TermoResponsabilidade");
		if(list.size() > 0){
			
			termKey = list.get(list.size() - 1) + 1;
		}else {
			termKey = 1;
		}
		
		Connection connection = new ConnectionFactory().getConnection();
		TermDAO terDAO = new TermDAO();
		terDAO.register(this);
		
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/* config o sim e não */
	public void ball(boolean ball) {
		
		if(ball) {
			jlBall.setBounds(463, 390, this.ball.getIconWidth(), this.ball.getIconHeight());
			situetion = 'A';
		}else {
			jlBall.setBounds(574, 390, this.ball.getIconWidth(), this.ball.getIconHeight());
			situetion = 'D';
		}
		
		this.repaint();
	}
	
	
	
	public int getTermKey() {
		return termKey;
	}

	public void setTermKey(int termKey) {
		this.termKey = termKey;
	}

	public JButton getJbSave() {
		return jbSave;
	}

	public void setJbSave(JButton jbSave) {
		this.jbSave = jbSave;
	}

	public char getSituetion() {
		return situetion;
	}

	public void setSituetion(char situetion) {
		this.situetion = situetion;
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



	public JComboBox<String> getJcSector() {
		return jcSector;
	}



	public void setJcSector(JComboBox<String> jcSector) {
		this.jcSector = jcSector;
	}



	public JTextField getJtDescrip() {
		return jtDescrip;
	}



	public void setJtDescrip(JTextField jtDescrip) {
		this.jtDescrip = jtDescrip;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@SuppressWarnings("rawtypes")
	public JComboBox getJcComponent() {
		return jcComponent;
	}

	protected void paintComponent(Graphics g) {

		Image img;

		img = background.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
	}
}
