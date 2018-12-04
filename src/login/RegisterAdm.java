package login;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import object.ConnectionFactory;
import object.Util;

public class RegisterAdm extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon backgorund;
	private JTextField jtName;
	private JTextField jtMatriculetion;
	private JPasswordField jpPassword;
	private	JPasswordField jpConfirm;
	private JButton jbNext;
	private RegisterAdm func;
	
	public RegisterAdm() {
		
		func = this;
		
		backgorund = new ImageIcon("res\\iniciar\\ModeloAdicionarADM.png");
		
		jbNext = Util.setButton(jbNext, 690, 450, 70, 70, this);
		jtName = Util.setField(298, 202, 408, this);
		jtMatriculetion = Util.setField(331, 265, 373, this);
		jpPassword = Util.setPassword(303, 328, 403, this);
		jpConfirm = Util.setPassword(403, 391, 300, this);
		
	}
	
	
	/* Salva no banco */
	@SuppressWarnings("deprecation")
	public void register() {
		
		Connection connection = new ConnectionFactory().getConnection();
        String sql = "insert into funcionario" + "(matricula,adm,nome,dataInicio,senha) " + "values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Util.convertInt(jtMatriculetion));
            ps.setString(2, "A");
            ps.setString(3, jtName.getText());
            ps.setDate(4, Util.getDate());
            ps.setString(5, jpPassword.getText());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public RegisterAdm getFunc() {
		return func;
	}


	public void setFunc(RegisterAdm func) {
		this.func = func;
	}


	public JButton getJbNext() {
		return jbNext;
	}


	public void setJbNext(JButton jbNext) {
		this.jbNext = jbNext;
	}


	public JTextField getJtName() {
		return jtName;
	}



	public void setJtName(JTextField jtName) {
		this.jtName = jtName;
	}



	public JTextField getJtMatriculetion() {
		return jtMatriculetion;
	}



	public void setJtMatriculetion(JTextField jtMatriculetion) {
		this.jtMatriculetion = jtMatriculetion;
	}



	public JPasswordField getJpPassword() {
		return jpPassword;
	}



	public void setJpPassword(JPasswordField jpPassword) {
		this.jpPassword = jpPassword;
	}



	public JPasswordField getJpConfirm() {
		return jpConfirm;
	}



	public void setJpConfirm(JPasswordField jpConfirm) {
		this.jpConfirm = jpConfirm;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	protected void paintComponent(Graphics g) {

		Image img;

		img = backgorund.getImage();
		g.drawImage(img, 0, 0, img.getWidth(this), img.getHeight(this), this);
	}
}
