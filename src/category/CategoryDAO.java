package category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.ConnectionFactory;

public class CategoryDAO {
	
	Connection connection;
	
	public CategoryDAO() {
		connection = new ConnectionFactory().getConnection();
	}
	
	/*
	 * Adicona a nova categoria no banco 
	 */
	public void adicionar(RegisterCategory cat) throws SQLException {
		String sql = "insert into categoria" + "(nome) " + "values(?)";

		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setString(1, cat.getJtName().getText());

		ps.executeUpdate();
		ps.close();

	}
    
	/*
	 * retorna um array list do nome de todas as categorias
	 */
    public List<String> getList() {
        List<String> categorias = new ArrayList<>();
        String sql = "select nome from categoria";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	
                //adiciona a categoria no ArrayList
                categorias.add(rs.getString("nome"));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categorias;
    }
    
    /* Atualiza o nome da categoria */
    public void Update(UpdateCategory cat) {
        String sql = "update categoria set nome=? where codigo=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setString(1, cat.getJtName().getText());
            ps.setInt(2, cat.getCode());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(DeleteCategory cat) {
        String sql = "delete from categoria where codigo=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cat.getCode());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /*

    public String pesquisa(Categoria cat) {
        String categoria;
        String sql = "select * categoria where codigo = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, cat.getCodigo());
            categoria= "" + cat.getCodigo() + " " + cat.getNome();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoria;
    }
   */
}
