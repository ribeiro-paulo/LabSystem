package term;

import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import object.ConnectionFactory;
import object.Util;

public class TermDAO {
	
	private Connection connection;

    public TermDAO() {
        connection = new ConnectionFactory().getConnection();
    }
    
    /* Salva no banco */
    public void register(RegisterTerm tr) {
        String sql = "Call sp_AdicionaTermo (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setString(1, String.valueOf(tr.getSituetion()));
            ps.setString(2, tr.getJtDescrip().getText());
            ps.setDate(3, Util.getDate());
            ps.setInt(4, Util.returnKey("numero", "setor", tr.getJcSector().getSelectedItem().toString())); //chave estrageira de setor
            ps.setInt(5, Util.matriculation);
            
            ps.setInt(6, Util.returnKey("codigo", "objeto", tr.getJcComponent().getSelectedItem().toString()));
            ps.setInt(7, tr.getTermKey());
            ps.setDate(8, Util.getDate());
            ps.setInt(9, Util.returnKey("numero", "setor", tr.getJcSector().getSelectedItem().toString())); //chave estrageira de setor

            
            ps.executeUpdate();
            ps.close();
      
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       
    }
    
    public List<String> getList() {
        List<String> trs = new ArrayList<>();
        String sql = "select obj.nome, s.nome from termoresponsabilidade as tr, objetotermo  as ot, responsabilidade as r, objeto as obj , setor as s where tr.numero = ot.termoNum and ot.objCod = obj.codigo and ot.objCod = r.objCod and tr.setNum = r.setNum";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				trs.add(Util.convertUp("COMPONENTE: " + rs.getString("obj.nome") + "     SETOR: " + rs.getString("s.nome")));
			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
        return trs;
    }
    
    public List<String> getTerm(ConsultTerm c , int key) {
        List<String> trs = new ArrayList<>();
        String sql = "select obj.nome, s.nome, tr.situacao, tr.descricao, tr.funcCriaMat, tr.dataCriacao from termoresponsabilidade as tr, objetotermo  as ot, responsabilidade as r, objeto as obj , setor as s where tr.numero = " + key + " and tr.numero = ot.termoNum and ot.objCod = obj.codigo and ot.objCod = r.objCod and tr.setNum = r.setNum";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				setMenssage(497, 176, rs.getString("obj.nome"), c);
				setMenssage(497, 209, rs.getString("s.nome"), c);
				
				if(rs.getString("tr.situacao").equals("A")) 
					setMenssage(497, 241, "ATIVO", c);
				else
					setMenssage(497, 241, "DESATIVADO", c);
				
				setMenssage(497, 274, rs.getString("tr.descricao"), c);
				
				setMenssage(497, 307, Util.getValue("nome", "funcionario", "matricula", rs.getString("tr.funcCriaMat")), c);

				setMenssage(706, 124, Util.convertDate(rs.getString("tr.dataCriacao")), c);

			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
        return trs;
    }
    
    public List<String> getUpdate(UpdateTerm u , int key) {
        List<String> trs = new ArrayList<>();
        String sql = "select obj.nome, s.nome, s.numero, tr.situacao, tr.descricao, tr.funcCriaMat, tr.dataCriacao from termoresponsabilidade as tr, objetotermo  as ot, responsabilidade as r, objeto as obj , setor as s where tr.numero = " + key + " and tr.numero = ot.termoNum and ot.objCod = obj.codigo and ot.objCod = r.objCod and tr.setNum = r.setNum";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				u.setsNumber(rs.getInt("s.numero"));
				u.setfCreated(rs.getInt("tr.funcCriaMat"));
				
				
				setMenssage(493, 164, rs.getString("obj.nome"), u);
				
				setMenssage(724, 164, rs.getString("s.nome"), u);
				
				if(rs.getString("tr.situacao").equals("A")) {
				  	
					u.setSitBall(Util.ball(572, 213, u));
					u.setSituetion("A");
				}
				else {
					
					u.setSitBall(Util.ball(680, 213, u));
					u.setSituetion("D");
				}
				
				u.setEnBall(Util.ball(680, 248, u));	
				/*
				
				setMenssage(497, 274, rs.getString("tr.descricao"), u);
				
				setMenssage(497, 307, Util.getValue("nome", "funcionario", "matricula", rs.getString("tr.funcCriaMat")), u);

				setMenssage(706, 124, Util.convertDate(rs.getString("tr.dataCriacao")), u);
				*/
			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
        return trs;
    }
    
    public void getDelete(DeleteTerm d , int key) {
       
        String sql = "select obj.nome, s.nome from termoresponsabilidade as tr, objetotermo  as ot, responsabilidade as r, objeto as obj , setor as s where tr.numero = " + key + " and tr.numero = ot.termoNum and ot.objCod = obj.codigo and ot.objCod = r.objCod and tr.setNum = r.setNum";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				setMenssage(535, 187, rs.getString("obj.nome"), d);
				
				setMenssage(535, 222, rs.getString("s.nome"), d);
				
			}
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
       
    }
    
    public void update(UpdateTerm u) {
        String sql = "call sp_AlteraTermo( ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
           
            ps.setInt(1, u.gettNumber());
            ps.setInt(2, u.getsNumber());
            ps.setInt(3, u.getfCreated());
            ps.setString(4, u.getSituetion());
            ps.setInt(5, u.getfAss());
            ps.setDate(6, u.getDtFim());
            ps.setDate(7, u.getDtAss());
            
            ps.executeUpdate();
            ps.close();
      
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
       
    }
    
    public static JLabel setMenssage(int x, int y, String text, JPanel jp) {
		    	
		JLabel jlabel = new JLabel(Util.convertUp(text));
		jlabel.setFont(new Font("Arial", Font.BOLD, 15));
		jlabel.setForeground(Color.WHITE);
		jlabel.setBounds(x, y, 500, 40);
		jp.add(jlabel);
		
		return jlabel;
	}
}
