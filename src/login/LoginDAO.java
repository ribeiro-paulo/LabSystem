package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import object.ConnectionFactory;
import object.Util;

public class LoginDAO {
	
	Connection connection;
	
	public LoginDAO() {
        connection = new ConnectionFactory().getConnection();
    }
	
	@SuppressWarnings("deprecation")
	public int searchPerson(Login login) {

		/*
		 *  0 - erro
		 *  1 - funcionário
		 *  2 - admin
		 */
		int is = 0;
		
		String sql = "select adm from funcionario where matricula = ? and senha = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, Util.convertInt(login.getJtMatriculetion()));
			ps.setString(2, login.getJpPassword().getText());
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				Util.matriculation = Util.convertInt(login.getJtMatriculetion());
				
				if(rs.getString("adm").equals("f")) 
					is = 1;
				else
					is = 2;
				
			}
			ps.close();
		} catch (SQLException e) {
			
		}
		return is;

	}
}
