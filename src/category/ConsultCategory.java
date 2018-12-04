package category;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import object.ConnectionFactory;
import object.Util;

public class ConsultCategory extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jp;
	private JLabel jlName;
	private JScrollPane jScroll;
	private ImageIcon imgBar;
	private ImageIcon background;
	
	public ConsultCategory() {
		
		Util.screen = "categoria";
		background = new ImageIcon("res\\admin\\categoria\\ModeloConsultar.png");
		imgBar = new ImageIcon("res\\admin\\categoria\\Barra.png");
		jp = new JPanel();
		jp.setLayout(null);
	
		Util.newMenu(this);
		Util.createButtonAdm(this);
		
		listCategory();
	}
	
	protected void listCategory() {
		
		int pos = 0;
		int xTexto = 20;
		int yBack = 120;
		int yTexto = 118;
		List<String> cat;
		
		/* retorna os dados */
		Connection connection = new ConnectionFactory().getConnection();
		CategoryDAO catDAO = new CategoryDAO();
		cat = catDAO.getList();
		
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}/* fim da busca */

		
		while(cat.size() > pos) {
			
			jlName = new JLabel();
			jp.add(Util.setLabel(xTexto, yTexto, "", pos+1 + "°     " + cat.get(pos++)));
		
			jlName = new JLabel();
			jlName.setIcon(imgBar);
			jlName.setBounds(10, yBack, imgBar.getIconWidth(), imgBar.getIconHeight());
			jp.add(jlName);
			
			yBack += 24;
			yTexto += 24;
			
			if(pos == 9) {
				xTexto -= 10;
			}
		}
		
		jScroll = new JScrollPane(jp);
		jp.setPreferredSize( new Dimension(600, yTexto));
		jScroll.setBounds(252, 0, 643, 513);
		jp.setBackground(Color.WHITE);
        jp.setBorder(null);
        jScroll.setBorder(null);
		add(jScroll);
	}
	
	protected void paintComponent(Graphics g) {
		Image img;
		
		img = background.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
	}
	
}
