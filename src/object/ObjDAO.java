package object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ObjDAO {
	
	Connection connection;
	
	public ObjDAO() {
		connection = new ConnectionFactory().getConnection();
	}
	
	public List<String> getList() {
        List<String> obj = new ArrayList<>();
        String sql = "select nome from objeto";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
                //adiciona a categoria no ArrayList
                obj.add(rs.getString("nome"));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return obj;
    }
}
