package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Consult extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ImageIcon background;
	protected JLabel jlObject;
	protected JPanel jp;
	protected ImageIcon backgroundText;
	protected JScrollPane jsScroll;
	protected ImageIcon componentConsult;
	
	public Consult() {

		background = new ImageIcon("res\\backGround\\ModeloConsultar.png");
		backgroundText = new ImageIcon("res\\backGround\\Consulta\\FundoDoTexto.png");
		componentConsult = new ImageIcon("res\\backGround\\Consulta\\consultarComponente.png");
		
		setLayout(null);
		
		jp = new JPanel();
		
		Util.newMenu();
		add(Util.jbRegister); 
		add(Util.jbConsult); 
		add(Util.jbUpdate);
		add(Util.jbDelete);
		
		listObject();
		
	}
	
	/* Lista todos os componente do banco de dados */
	public void listObject() {
		
		Connection conn;
		int yTexto = 84, xTexto = 100;
		int fundo = - 230;
		
		// Consultar componente;
		jp.setLayout(null);
		jlObject = new JLabel();
		jlObject.setIcon(componentConsult);
		jlObject.setBounds(34, 36, componentConsult.getIconWidth(), componentConsult.getIconHeight());
		jp.add(jlObject);
		
		try {
			
            Class.forName(Util.driver);
            conn = DriverManager.getConnection(Util.url, Util.user, Util.password);
            Statement st = conn.createStatement();
            String sql = "SELECT NOME, DESCRICAO, SITUACAO, QTDE FROM OBJETO";
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
            	
            	
            	jlObject = new JLabel(rs.getString("NOME"));
            	jlObject.setFont(Util.font);
            	jlObject.setForeground(Color.WHITE);
            	jlObject.setBounds( 310 - rs.getString("NOME").length() / 3 * rs.getString("NOME").length(), yTexto, 400, 70);
            	jp.add(jlObject);
            	
            	jp.add(Util.setLabel(xTexto, yTexto += 30, "Descrição", rs.getString("DESCRICAO")));
            	
            	jp.add(Util.setLabel(xTexto, yTexto += 30, "Situação", rs.getString("SITUACAO")));
            	
            	jp.add(Util.setLabel(xTexto, yTexto += 30, "Quantidade", rs.getString("QTDE")));
            	
            	jlObject = new JLabel();
            	jlObject.setIcon(backgroundText);
            	
            	jlObject.setBounds(75, fundo += 100, backgroundText.getIconWidth(), background.getIconHeight());
            	jp.add(jlObject);
            	
            	yTexto+= 78; 
            	
            	fundo += 69;
            }
            
            jsScroll = new JScrollPane(jp);
            jp.setPreferredSize( new Dimension(600, yTexto + 25));
            jp.setBackground(Color.WHITE);
            jp.setBorder(null);
            jsScroll.setBounds(252, 0, 643, 573);
            add(jsScroll);
            
            st.close();
            conn.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	protected void paintComponent(Graphics g) {
		Image img;
		
		img = background.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), null);

	}

}
