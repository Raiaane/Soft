/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raiane
 */
public class professorDAO extends ExecuteSQL{
    public professorDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_Professor(professor a){
        
        String sql = "insert into professor values (0,?,?,?,?,?)";
    
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
             ps.setString(1, a.getNome());
             ps.setString(2, a.getEmail());
             ps.setString(3, a.getCpf());
             ps.setString(4, a.getTelefone());
             ps.setString(5, a.getEndereco());
              if(ps.executeUpdate() > 0){
              
                  return "Inserido com sucesso";
              
              } else {
              
                  return "Erro ao inserir";
            
              }
              
        } catch (SQLException e){
        
            return e.getMessage();
        
        }
    }

    
    //Listar professor
    
    public List<professor> ListarProfessor(){
        String sql = "select id, nome, email, cpf, telefone, endereco from professor";
        List <professor> lista = new ArrayList<>();
        
        try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
              while (rs.next()){
                 professor a = new professor();
                  a.setCod(rs.getInt(1));
                  a.setNome(rs.getString(2));
                  a.setEmail(rs.getString(3));
                  a.setCpf(rs.getString(4));
                  a.setTelefone(rs.getString(5));
                  a.setEndereco(rs.getString (6));
                  
                  lista.add(a);
                  
              }
              return lista;
          }else{
              return null;
          }
          
 
        }catch (SQLException e){
            return null;
        
        }
    }
    
    //pesquisar professor 
    
    public List<professor> Pesquisar_Nome_Professor(String nome){
        String sql = "select id, nome, email, cpf, telefone, endereco from professor where nome Like '"+nome+ "%'";
         List <professor> lista = new ArrayList<>();
        
        try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
              while (rs.next()){
                  professor a = new professor();
                  a.setCod(rs.getInt(1));
                  a.setNome(rs.getString(2));
                  a.setEmail(rs.getString(3));
                  a.setCpf(rs.getString(4));
                  a.setTelefone(rs.getString(5));
                  a.setEndereco(rs.getString (6));
                  
                  lista.add(a);
                  
              }
              return lista;
          }else{
              return null;
          }
          
 
        }catch (SQLException e){
            return null;
        
        }
    
    }
    
    //testar professor
    
    public boolean Testar_Professor (int cod){
       boolean Resultado = false;
       try{
           String sql = "select * from  professor where id = "+cod+"";
            PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery();
             if(rs != null){
                 while(rs.next()){
                     Resultado = true;
                     
                 }
             }
       } catch (SQLException ex){
           ex.getMessage();   
       }
       return Resultado;
    }
    
    
    //Capturar professor
    public List<professor> CapturarCliente(int cod){
    String sql = "SELECT * FROM professor WHERE id = '"+cod+"'";
    List<professor> lista = new ArrayList<>();
        try {
            PreparedStatement pr = getCon().prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    professor c = new professor();
                    PreparedStatement ps = getCon().prepareStatement(sql);
                    c.setCod(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    c.setEmail(rs.getString(3));
                    c.setCpf(rs.getString(4));
                    c.setTelefone(rs.getString(5));
                    c.setEndereco(rs.getString(6));
                    lista.add(c);

                }
                return lista;
            }else{
                return null;
            }                    
        } catch (SQLException e) {
            return null;
        }
    }
       //Alterar
     public String Alterar_Professor(professor c){
   String sql = "UPDATE professor SET Nome = ?, email=?, cpf=?, telefone=?, endereco=?  WHERE id = ?";
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           
                    ps.setString(1,c.getNome());
                    ps.setString(2,c.getEmail());
                    ps.setString(3,c.getCpf());
                    ps.setString(4,c.getTelefone());
                    ps.setString(5,c.getEndereco());
                    ps.setString(6,c.getTelefone());
                    ps.setInt(11,c.getCod());
           
           if (ps.executeUpdate() > 0) {
               return "Professor Atualizado Com Sucesso";
           }else{
               return "Erro ao Atualizar";
           }
           
       } catch (SQLException e) {
           return e.getMessage();
       }
     }
   //ListarCombo professor 
   public List<professor> ListarComboProfessor(){
   String sql = "select nome from professor order by nome";
   List<professor> lista = new ArrayList<>();
   
       try {
           PreparedStatement pr = getCon().prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           
           if(rs!= null){
            while(rs.next()){
                professor c = new professor();
                c.setNome(rs.getString(1));
                lista.add(c);
            }        
            return lista;
           }else{
            return null;
           }           
       } catch (SQLException ex) {
       return null;
       }
   
   }
   
   //Consultar
   public List<professor> Pesquisar_Cod_Professor(int cod){
   String sql = "SELECT * FROM professor WHERE id ='"+cod+"'";
   List<professor> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                professor a = new professor();
                a.setCod(rs.getInt(1));
                a.setNome(rs.getString(2));
                a.setEmail(rs.getString(3));
                a.setCpf(rs.getString(4));
                a.setTelefone(rs.getString(5));
                a.setEmail(rs.getString (6));
                a.setEndereco(rs.getString (7));
                lista.add(a);
                
               }   
               return lista;
           }else{
           return null;
           }
       }catch (SQLException e) {
       return null;
       }
   }
   //consultar
   public List<professor> ConsultaCodigoProfessor(String nome){
   String sql = "SELECT idcliente FROM professor WHERE nome = '"+nome+"'";
   List<professor> lista = new ArrayList<>();
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!= null){
                while(rs.next()){
                    professor c = new professor();
                    c.setCod(rs.getInt(1));
                    lista.add(c);
                }
                return lista;            
           }else{
                return null;
           }
       } catch (SQLException ex) {
           return null;
       }
   
   }
   //Excluir
   public String ExcluirCliente(professor f){
   String sql = "DELETE FROM professor WHERE id = ? AND Nome = ?";
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.setInt(1, f.getCod());
           ps.setString(2,f.getNome());
           if(ps.executeUpdate()>0){
                return "Excluido com sucesso!";
           }else{
                return "Erro ao excluir!";
           }
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   }

}
