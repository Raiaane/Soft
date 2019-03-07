/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Tipo;
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
public class TipoDAO extends ExecuteSQL{
     public TipoDAO(Connection con) {
        super(con);
    }
     //inserir
    public String InserirTipo(Tipo c){
    
    String sql = "insert into tipo VALUES(0,?)";

    try {
       
        PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setString(1, c.getNome());
            
        if(ps.executeUpdate()>0){
        return "Tipo cadastrado com sucesso";
        }else{
        return "Erro ao cadastrar";
        }
        
    } catch (SQLException e) {
        return e.getMessage();
    }
    } 
    //Alterar
    public String Alterar_Tipo(Tipo c){
    String sql = "UPDATE tipo SET nome=? WHERE id=?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,c.getNome());
            ps.setInt(2,c.getCod());
            
            if (ps.executeUpdate()>0) {
                return "Atualizado com sucesso";
            }else{
                return "Erro ao atualizar";
                       
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }       
}
    //testar
    public boolean Testar_Tipo(int cod){
        boolean result =false;
        try {
            String sql = "SELECT * FROM tipo WHERE id='"+cod+"'";
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
               while(rs.next()){
                    result = true;
               }
            }else{
            
            }            
        } catch (SQLException ex) {
            ex.getMessage();
        }
    
        return result;
    }
    //Capturar
    public List<Tipo> CapturarTipo(int cod){
        String sql = "SELECT * FROM tipo WHERE id='"+cod+"'";
        List<Tipo> lista = new ArrayList<>();

        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                   Tipo c = new Tipo ();
                    c.setCod(rs.getInt(1));
                    c.setNome(rs.getString(2));
                    lista.add(c);
                }
                return lista;
            }else{
                return null;
            }    
        }catch(SQLException ex){
            return null;
        }   
    
    }
    //Listar
   public List<Tipo> ListarTipo(){
   String sql = "SELECT * FROM tipo";
   List<Tipo> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Tipo  f = new Tipo();
                f.setCod(rs.getInt(1));
                f.setNome(rs.getString(2));
                lista.add(f);
               }   
               return lista;
           }else{
           return null;
           }
       }catch (SQLException ex) {
       return null;
       }
   }
    //Excluir
   public List<Tipo> ListarComboTipo(){
    String sql = "SELECT Nome FROM tipo";
    List<Tipo> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           if(rs!=null){
           while(rs.next()){
           Tipo  c = new Tipo();
           c.setNome(rs.getString(1));
           lista.add(c);
           }
           
           }else{
           return null;
           }       
           return lista;
       } catch (SQLException ex) {
         return null;
       }
   
   }
   //Excluir
   public List<Tipo> ConsultaCodigoTipo(String nome){
    String sql = "SELECT * FROM tipo WHERE nome ='"+nome+"'";
    List<Tipo> lista = new ArrayList<>();
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs!=null){
            while (rs.next()) {                
            Tipo c = new Tipo();
            c.setCod(rs.getInt(1));
            c.setNome(rs.getString(2));
            lista.add(c);            
            }
        }else{
        return null;
        }        
        return lista;
       } catch (SQLException ex) {
       return null;
       }
    
   }
   //Excluir
   public String ExcluirTipo(Tipo c){
   String sql = "DELETE FROM tipo WHERE id = ?";
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ps.setInt(1,c.getCod());
           if(ps.executeUpdate()>0){
           return "Excluido com sucesso";
           }else{
           return "Erro ao excluir";
           }           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   }
   public List<Tipo> Pesquisar_Nome_Tipo(String nome){
        String sql = "select id, nome from tipo where nome Like '"+nome+ "%'";
         List <Tipo> lista = new ArrayList<>();
        
        try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
              while (rs.next()){
                  Tipo a = new Tipo();
                  a.setCod(rs.getInt(1));
                  a.setNome(rs.getString(2));
                  
                  
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
    public List<Tipo> Pesquisar_Cod_Tipo(int cod){
   String sql = "SELECT * FROM tipo WHERE id ='"+cod+"'";
   List<Tipo> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Tipo a = new Tipo();
                a.setCod(rs.getInt(1));
                a.setNome(rs.getString(2));
               
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
    
    
}




