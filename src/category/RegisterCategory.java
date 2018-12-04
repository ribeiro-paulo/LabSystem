package category;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import object.Util;

public class RegisterCategory extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon background;
	private JTextField jtName;
	private JButton jbSave;
	
	public RegisterCategory() {
		
		Util.screen = "categoria";
		
		background = new ImageIcon("res\\admin\\categoria\\ModeloAdicionar.png");
		jtName = new JTextField();
		
		setLayout(null);
		
		Util.createButtonAdm(this);
		Util.newMenu(this);
		
		Util.setText(jtName, 360, 175, 408, 28);
		jbSave = Util.setButton(jbSave, 700, 235, 70, 30, this);
		
		add(jtName);
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	protected void paintComponent(Graphics g) {
		Image img;
		
		img = background.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
	}
}
