/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Marca;
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
public class MarcaDAO extends ExecuteSQL {
    public MarcaDAO(Connection con) {
        super(con);
    }
     //inserir
    public String InserirCategoria(Marca c){
    
    String sql = "insert into marca VALUES(0,?)";

    try {
       
        PreparedStatement ps = getCon().prepareStatement(sql);
             ps.setString(1, c.getNome());
            
        if(ps.executeUpdate()>0){
        return "Marca cadastrada com sucesso";
        }else{
        return "Erro ao cadastrar";
        }
        
    } catch (SQLException e) {
        return e.getMessage();
    }
    } 
    //Alterar
    public String Alterar_Marca(Marca c){
    String sql = "UPDATE marca SET nome=? WHERE idcategoria=?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,c.getNome());
            ps.setInt(2,c.getCod());
            
            if (ps.executeUpdate()>0) {
                return "Marca atualizada com sucesso";
            }else{
                return "Erro ao atualizar";
                       
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }       
}
    //testar
    public boolean Testar_Marca(int cod){
        boolean result =false;
        try {
            String sql = "SELECT * FROM marca WHERE id='"+cod+"'";
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
    public List<Marca> CapturarMarca(int cod){
        String sql = "SELECT * FROM marca WHERE id='"+cod+"'";
        List<Marca> lista = new ArrayList<>();

        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    Marca c = new Marca();
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
   public List<Marca> ListarCategoria(){
   String sql = "SELECT * FROM marca";
   List<Marca> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Marca f = new Marca();
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
   public List<Marca> ListarComboMarca(){
    String sql = "SELECT Nome FROM marca";
    List<Marca> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           if(rs!=null){
           while(rs.next()){
           Marca c = new Marca();
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
   public List<Marca> ConsultaCodigoMarca(String nome){
    String sql = "SELECT id FROM marca WHERE nome ='"+nome+"'";
    List<Marca> lista = new ArrayList<>();
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs!=null){
            while (rs.next()) {                
            Marca c = new Marca();
            c.setCod(rs.getInt(1));
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
   public String ExcluirMarca(Marca c){
   String sql = "DELETE FROM marca WHERE id = ?";
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
   public List<Marca> Pesquisar_Nome_Marca(String nome){
        String sql = "select id, nome from marca where nome Like '"+nome+ "%'";
         List <Marca> lista = new ArrayList<>();
        
        try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
              while (rs.next()){
                  Marca a = new Marca();
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
    public List<Marca> Pesquisar_Cod_Marca(int cod){
   String sql = "SELECT * FROM categoria WHERE idcategoria ='"+cod+"'";
   List<Marca> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                Marca a = new Marca();
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
