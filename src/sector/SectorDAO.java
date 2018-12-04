package sector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import object.ConnectionFactory;
import object.Util;

public class SectorDAO {
	private Connection connection;

    public SectorDAO() {
        connection = new ConnectionFactory().getConnection();
    }

    /* salva no banco de dados */
    public void register(RegisterSector set) {
        String sql = "insert into setor" + "(nome,limiteMax) " + "values(?,?)";
 
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, set.getJtName().getText());
            ps.setInt(2, Util.convertInt(set.getJtLimit()));
            ps.executeUpdate();
            ps.close();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    /* retorna um ArrayList com o nome e o limite máximo de cada setor */
    public List<String> getList() {
        List<String> s = new ArrayList<>();
        String sql = "select * from Setor";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
    
                s.add(rs.getString("nome"));
                s.add(rs.getInt("limiteMax") + "");
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }
    
    /* retorna um ArrayList com o nome de cada setor */
    public List<String> getNameList() {
        List<String> s = new ArrayList<>();
        String sql = "select * from Setor";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
    
                s.add(rs.getString("nome"));
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }
    
    public int getLimit(int number) {
    	
    	int limit = 0;
    	String sql = "select limiteMax from Setor where numero = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, number);
            
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	limit = rs.getInt("limiteMax");
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    	return limit;
    }
    
    /* Altera o setor no banco de dados */
    public void update(UpdateSector set) {
        String sql = "update setor set nome=?, limiteMax =? where numero=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql); 
            ps.setString(1, set.getJtName().getText());
            ps.setInt(2, Util.convertInt(set.getJtLimit()));
            ps.setInt(3, set.getCode());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void delete(DeleteSector set) {
        String sql = "delete from setor where numero=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, set.getCode());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /*   
    public String pesquisa(Setor set) {
        String s;
        String sql = "select * setor where matricula = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, set.getNumero());
            s= "" + set.getNumero() + " " + set.getNome();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }
    
    
    public static void main(String[] args) {
        //Adicionar
        
        Setor s = new Setor();
        s.setNumero(2);
        s.setNome("DAINFRA");
        s.setLimiteMax(100);
        
        SetorDao sd = new SetorDao();
        sd.adiciona(s);
    }
    */
}
