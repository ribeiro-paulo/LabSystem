package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Register extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Register register;
	
	private ImageIcon background;
	public ImageIcon imgClear;
	public ImageIcon imgSave;
	public ImageIcon imgSaved;
	public ImageIcon imgAgain;

	public JTextField jtName;
	public JTextField jtDescription;
	public JTextField jtAmount;

	public JButton jbSave;
	public JButton jbClear;

	public JComboBox<String> jcCategory;
	public JComboBox<String> jcSector;
	

	public JLabel jlSaved;

	public int catCod;
	public int setorNum;

	public Register() {
		
		this.register = this;
		Util.screen = "objeto";
		
		background = new ImageIcon("res\\backGround\\modeloCadastro.png");
		imgClear = new ImageIcon("res\\button\\limparTudo.png");
		imgSaved = new ImageIcon("res\\gif\\dadosSalvos.gif");
		imgAgain = new ImageIcon("res\\gif\\preenchaTodosOsCampos.gif");
		jlSaved = new JLabel();

		jtName = new JTextField();
		jtDescription = new JTextField();
		jtAmount = new JTextField();
		
		jcCategory = new JComboBox<String>();
		jcSector = new JComboBox<String>();

		setLayout(null);

		// Barra de menu
		Util.newMenu(this);
		Util.createButtonEmployee(this);

		// Campos
		Util.setText(jtName, 430, 100, 310, 28);
		Util.setText(jtDescription, 467, 171, 310, 28);
		Util.setText(jtAmount, 480, 237, 310, 28);
		jbClear = Util.setButton(jbClear, 358, 402, 140, 30, this);
		jbSave = Util.setButton(jbSave, 705, 455, 70, 30, this);
		
		jcCategory.setBounds(372, 340, 185, 28);
		jcSector.setBounds(587, 340, 185, 28);
		jcCategory.setBackground(Color.white);
		jcSector.setBackground(Color.white);
		
		
		add(jtName);
		add(jtDescription);
		add(jcCategory);
		add(jtAmount);


		jcCategory.addItem("");
		jcSector.addItem("");
		Util.returnItens(jcCategory, jcSector);
		
	}
	
	/* Dados salvos */
	public void paintSaved() {
		
		this.repaint();
		
		jlSaved.setBounds(450, 1, register.imgSaved.getIconWidth(), register.imgSaved.getIconHeight());
		imgSaved.getImage().flush(); // zera o gif
		jlSaved.setIcon(register.imgSaved);
		
		this.add(register.jlSaved);
	}
	
	/* Preencha todos os campos */
	public void paintAllField(Register register) {
		
		this.repaint();
		
		jlSaved.setBounds(375, 1, imgAgain.getIconWidth(), imgAgain.getIconHeight());
		imgAgain.getImage().flush(); // zera o gif
		jlSaved.setIcon(imgAgain);
		
		this.add(jlSaved);
	}

	public ImageIcon getImgClear() {
		return imgClear;
	}

	public void setImgClear(ImageIcon imgClear) {
		this.imgClear = imgClear;
	}

	public ImageIcon getImgSave() {
		return imgSave;
	}

	public void setImgSave(ImageIcon imgSave) {
		this.imgSave = imgSave;
	}

	public ImageIcon getImgSaved() {
		return imgSaved;
	}

	public void setImgSaved(ImageIcon imgSaved) {
		this.imgSaved = imgSaved;
	}

	public ImageIcon getImgAgain() {
		return imgAgain;
	}

	public void setImgAgain(ImageIcon imgAgain) {
		this.imgAgain = imgAgain;
	}

	public JTextField getJtName() {
		return jtName;
	}

	public void setJtName(JTextField jtName) {
		this.jtName = jtName;
	}

	public JTextField getJtDescription() {
		return jtDescription;
	}

	public void setJtDescription(JTextField jtDescription) {
		this.jtDescription = jtDescription;
	}

	public JTextField getJtAmount() {
		return jtAmount;
	}

	public void setJtAmount(JTextField jtAmount) {
		this.jtAmount = jtAmount;
	}

	public JButton getJbSave() {
		return jbSave;
	}

	public void setJbSave(JButton jbSave) {
		this.jbSave = jbSave;
	}

	public JButton getJbClear() {
		return jbClear;
	}

	public void setJbClear(JButton jbClear) {
		this.jbClear = jbClear;
	}

	public JComboBox<String> getJcCategory() {
		return jcCategory;
	}

	public void setJcCategory(JComboBox<String> jcCategory) {
		this.jcCategory = jcCategory;
	}

	public JComboBox<String> getJcSector() {
		return jcSector;
	}

	public void setJcSector(JComboBox<String> jcSector) {
		this.jcSector = jcSector;
	}

	public JLabel getJlSaved() {
		return jlSaved;
	}

	public void setJlSaved(JLabel jlSaved) {
		this.jlSaved = jlSaved;
	}

	public int getCatCod() {
		return catCod;
	}

	public void setCatCod(int catCod) {
		this.catCod = catCod;
	}

	public int getSetorNum() {
		return setorNum;
	}

	public void setSetorNum(int setorNum) {
		this.setorNum = setorNum;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void save() {
		
		new RegisterDAO(this);
	}

	protected void paintComponent(Graphics g) {

		Image img = background.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
		
	}
	

}
