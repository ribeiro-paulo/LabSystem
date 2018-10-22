package component;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Update extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ImageIcon background;
	private ImageIcon backgroundText;
	public JTextField jtName;
	public JButton jbSearch;
	private JLabel jlObject;
	
	public Update() {
		
		background = new ImageIcon("res\\backGround\\ModeloAtualizar.png");
		backgroundText = new ImageIcon("res\\backGround\\Consulta\\FundoDoTexto.png");
		jtName = new JTextField();
		jbSearch = new JButton();
		
		setLayout(null);

		Util.setText(jtName, 425, 221, 285, 30);
		Util.setButton(jbSearch, null, 640, 280, 75, 30);
		
		
		
		Util.newMenu();
		add(Util.jbRegister);
		add(Util.jbConsult);
		add(Util.jbUpdate);
		add(Util.jbDelete);
		add(jbSearch);
		add(jtName);
	}
	
	/* Pesquisa o nome que o usuário digitou */
	public void searchName(JTextField name) {
		
		jtName.setVisible(false);
		jbSearch.setVisible(false);
		
		Connection conn;
		int yTexto = 165, xTexto = 390;
		int fundo = - 150;
		
    
		try {
            Class.forName(Util.driver);
            conn = DriverManager.getConnection(Util.url, Util.user, Util.password);
            
            String sqlPesq = "select nome, descricao, situacao, qtde from objeto where nome=?";
            PreparedStatement pstPesq = conn.prepareStatement(sqlPesq);
            
            pstPesq.setString(1,name.getText());
            ResultSet rs = pstPesq.executeQuery();
            
            if (rs.next()){  

            	jlObject = new JLabel(rs.getString("NOME"));
            	jlObject.setFont(Util.font);
            	jlObject.setForeground(Color.WHITE);
            	jlObject.setBounds( 525 - rs.getString("NOME").length() / 3 * rs.getString("NOME").length(), yTexto, 400, 70);
            	add(jlObject);
            	
            	add(Util.setLabel(xTexto, yTexto += 30, "Descrição", rs.getString("DESCRICAO")));
            	
            	add(Util.setLabel(xTexto, yTexto += 30, "Situação", rs.getString("SITUACAO")));
            	
            	add(Util.setLabel(xTexto, yTexto += 30, "Quantidade", rs.getString("QTDE")));
            	
            	jlObject = new JLabel();
            	jlObject.setIcon(backgroundText);
            	
            	jlObject.setBounds(300, fundo += 100, backgroundText.getIconWidth(), background.getIconHeight());
            	add(jlObject);
            	
            } else{
                System.out.println("Código não existe");
            }
            rs.close();
            pstPesq.close();
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
