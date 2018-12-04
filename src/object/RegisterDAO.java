package object;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO{

	public RegisterDAO(Register register) {

		Connection conn;
		
		try {
			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);
			String sql = "insert into objeto ( nome, descricao, situacao, qtde, catCod) values(?,?,?,?,?)";
	
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, register.getJtName().getText());
			pst.setString(2, register.getJtDescription().getText());
			pst.setString(3, "Em uso");
			pst.setString(4, register.getJtAmount().getText());
			pst.setInt(5, Util.CategoryCode(register.getJcCategory().getSelectedItem().toString()));

			pst.executeUpdate();
			pst.close();
			conn.close();
			
			/* Responsabilidade */
			Class.forName(Util.driver);
			conn = DriverManager.getConnection(Util.url, Util.user, Util.password);
			
			String sql2 = "insert into responsabilidade (objCod,setNum, dataInicio) values(?,?,?)";
			PreparedStatement pst2 = conn.prepareStatement(sql2);
			
			pst2.setInt(1, Util.returnKey("codigo", "objeto", register.getJtName().getText().toString()));
			pst2.setInt(2, Util.sectorNumber(register.jcSector.getSelectedItem().toString()));
			pst2.setString(3, "2002.06.17");
			
			pst2.executeUpdate();
			
			pst2.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}

	}
}
