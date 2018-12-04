package category;

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

public class UpdateCategory extends JPanel{
	
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
	private int code;
	
	public UpdateCategory() {
		
		background = new ImageIcon("res\\admin\\categoria\\ModeloAtualizar.png");
		jtName = new JTextField();
		
		Util.createButtonAdm(this);
		Util.newMenu(this);
		
		Util.setText(jtName, 396, 249, 300, 28);
		jbSearch = Util.setButton(jbSearch, 730, 315, 75, 20, this);
		jbSave = Util.setButton(jbSearch, 730, 315, 75, 20, this);
		jbSave.setVisible(false);
		
		jlMenssage = Util.setMenssage(420, 180, "Insira o nome da categoria", this);
		jlAction = Util.setMenssage(730, 305, "Buscar", this);
		
		add(jtName);
	}
	
	public void modeUpdate() {
		
		/* verifica se o nome da categoria existe */
		if(Util.returnKey("codigo", "categoria", getJtName().getText()) != 0) {
			/* troca as menssagens na tela */
			
			code = Util.returnKey("codigo", "categoria", getJtName().getText());
			
			jlMenssage.setVisible(false);
			Util.setMenssage(400, 180, "Insira o NOVO nome da categoria", this);
			
			jlAction.setVisible(false);
			Util.setMenssage(730, 305, "Salvar", this);
			
			jbSearch.setVisible(false);
			jbSave.setVisible(true);
			
		}else {
			// -------------- gif 
		}
		
		this.repaint();
	}
	
	/* Altera no banco de dados */
	public void update() {
		
		Connection connection = new ConnectionFactory().getConnection();
		CategoryDAO catDAO = new CategoryDAO();
		catDAO.Update(this);
		
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

	public void setBackground(ImageIcon background) {
		this.background = background;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	protected void paintComponent(Graphics g) {
		Image img;
		
		img = background.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
	}
}
