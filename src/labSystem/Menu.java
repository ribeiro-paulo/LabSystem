package labSystem;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.sun.prism.paint.Color;

import component.Util;

public class Menu  extends JPanel{
		
	protected ImageIcon logo;
	protected ImageIcon imgRegister;
	protected ImageIcon imgUpdate;
	protected ImageIcon imgConsult;
	
	protected JButton jbRegister;
	protected JButton jbUpdate;
	protected JButton jbConsult;
	
	// posição do primeiro botão
	protected int x = 350, y = 250;
	protected static int width = 200, height = 35;
	protected static int space = 18;
	
	
	public Menu() {
		
		jbRegister = new JButton();
		jbUpdate = new JButton();
		jbConsult = new JButton();
		
		logo = new ImageIcon("res\\menus\\logo.png");
		
		// imagem do botão
		imgRegister = new ImageIcon("res\\menus\\cadastrar.png");
		imgUpdate = new ImageIcon("res\\menus\\atualizar.png");
		imgConsult = new ImageIcon("res\\menus\\consultar.png");
		
		setLayout(null);
		
		// conf. da posição dos botões
		jbRegister.setBounds(x, y, width, height);
		jbUpdate.setBounds(x, y += height + space, width, height);
		jbConsult.setBounds(x, y += height + space, width, height);
		
		add(jbRegister);
		add(jbUpdate);
		add(jbConsult);
		
		// texto e borda do botão de cadastrar
		jbRegister.setIcon(imgRegister);
		jbRegister.setText(null);
		jbRegister.setContentAreaFilled(false);
		jbRegister.setBorderPainted(false);
		jbRegister.setContentAreaFilled(false);
		
		// texto e borda do botão de atualizar
		jbUpdate.setIcon(imgUpdate);
		jbUpdate.setText(null);
		jbUpdate.setContentAreaFilled(false);
		jbUpdate.setBorderPainted(false);
		jbUpdate.setContentAreaFilled(false);
		
		// texto e borda do botão de consulta
		jbConsult.setIcon(imgUpdate);
		jbConsult.setText(null);
		jbConsult.setContentAreaFilled(false);
		jbConsult.setBorderPainted(false);
		jbConsult.setContentAreaFilled(false);
		
		
	}
	
	protected void paintComponent(Graphics g) {
		
		Image img = Util.menuBackGround.getImage();
		g.drawImage(img, 0, 0, getWidth() , getHeight(), this);
		
		img = logo.getImage();
		g.drawImage(img, Util.DEFAULT_SCREEN_WIDTH - 610, 20, 300, 200, this);
	}
}	
