package employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import object.ConnectionFactory;
import object.Util;

public class EmployeeDAO {
	
	Connection connection;
	
	public EmployeeDAO() {
        connection = new ConnectionFactory().getConnection();
    }

    @SuppressWarnings("deprecation")
	public void register(RegisterEmployee func) {
        String sql = "insert into funcionario" + "(matricula,adm,nome,dataInicio,senha) " + "values(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Util.convertInt(func.getJtMatriculetion()));
            ps.setString(2, func.getAdm());
            ps.setString(3, func.getJtName().getText());
            ps.setDate(4, Util.getDate());
            ps.setString(5, func.getJpPassword().getText());

            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /*
    public void altera(Funcionario func) {
        String sql = "update funcionario set adm=?, nome=?, dataInicio=?, dataFim=?, senha=?, dicaSenha=?  where matricula=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, func.getAdm());
            ps.setString(2, func.getNome());
            ps.setDate(3, func.getDataInicio());
            ps.setDate(4, func.getDataFim());
            //ps.setBlob(5,func.getFoto());
            ps.setString(5, func.getSenha());
            ps.setString(6, func.getDicaSenha());
            ps.setInt(7, func.getMatricula());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Funcionario> getLista() {
        List<Funcionario> funcionarios = new ArrayList<>();
        String sql = "select * from funcionario";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //Instancia a classe Funcionario
                Funcionario func = new Funcionario();
                // atrui os valores recuperando do banco de dados para a classe Funcionario
                func.setMatricula(rs.getInt("matricula"));
                func.setAdm(rs.getString("adm"));
                func.setNome(rs.getString("nome"));
                func.setDataInicio(rs.getDate("dataInicio"));
                func.setDataFim(rs.getDate("dataFim"));
                func.setFoto(rs.getBlob("foto"));
                func.setSenha(rs.getString("senha"));
                func.setDicaSenha(rs.getString("dicaSenha"));
                //adiciona o funcionario no ArrayList
                funcionarios.add(func);
            }
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return funcionarios;
    }

    public void deleta(Funcionario func) {
        String sql = "delete from funcionario where matricula=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, func.getMatricula());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String pesquisa(Funcionario func) {
        String categoria;
        String sql = "select * funcionario where matricula = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, func.getMatricula());
            categoria = "" + func.getMatricula() + " " + func.getAdm() + " " + func.getNome() + " " + func.getDataInicio() + " "
                    + func.getDataFim() + " " + func.getSenha() + " " + func.getDicaSenha();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoria;
    }

   public static void main(String[] args) {
        //Adicionar
        
        Funcionario fun = new Funcionario();
        FuncionarioDao funDao = new FuncionarioDao();
        /*
        fun.setMatricula(123456);
        fun.setAdm("Lala");
        fun.setNome("Maria Regina Araújo Souza");
         Calendar dataC = Calendar.getInstance();
        Date data = new Date(dataC.getTimeInMillis());
        fun.setDataInicio(data);
        //fun.setDataFim(5, func.getDataFim());
        //ps.setBlob(6,func.getFoto());
        fun.setSenha("12345");
        fun.setDicaSenha("Sequencia de 5 numeros");

        
        funDao.adiciona(fun);
        /*
       
        
        //GetLista
        /*
       FuncionarioDao funDao = new FuncionarioDao();
       List<Funcionario> fs = funDao.getLista();
       for(Funcionario f : fs){
           System.out.println(f.getNome()+" "+f.getMatricula());
       }
         */
        
        //Delete
        /*
       List<Funcionario> fs = funDao.getLista();
       for(Funcionario f : fs){
           if(f.getMatricula()==123456)
               funDao.deleta(f);
       }
       
        
        //Altera
        
       List<Funcionario> fs = funDao.getLista();
       for(Funcionario f : fs){
           if(f.getMatricula()==1234567)
               f.setNome("Maria Regina");
               funDao.altera(f);
       }
        
        //Pesquisa
       
       CategoriaDAO cat = new CategoriaDAO();
       List<Categoria> categorias = cat.getLista();
       for(Categoria c : categorias){
           if(c.getCodigo()==123456)
               System.out.println(cat.pesquisa(c));
       }
         
      
    
   }
   */
}
