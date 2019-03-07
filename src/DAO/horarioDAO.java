/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.horario;
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
public class horarioDAO extends ExecuteSQL{
    public horarioDAO(Connection con) {
        super(con);
    }
    
    public String InserirHorario(horario a){
        
        String sql = "insert into horario values (0,?,?)";
    
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
             ps.setString(1, a.getInicio());
             ps.setString(2, a.getFim());
             
              if(ps.executeUpdate() > 0){
              
                  return "Inserido com sucesso";
              
              } else {
              
                  return "Erro ao inserir";
            
              }
              
        } catch (SQLException e){
        
            return e.getMessage();
        
        }
    }
     public List<horario> ListarComboHorario(){
    String sql = "SELECT Nome FROM horario";
    List<horario> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           if(rs!=null){
           while(rs.next()){
           horario c = new horario();
           c.setInicio(rs.getString(1));
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
       public List<horario> ConsultaCodigoHorario(String nome){
    String sql = "SELECT id FROM horario WHERE nome ='"+nome+"'";
    List<horario> lista = new ArrayList<>();
    try {
        PreparedStatement ps = getCon().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        if(rs!=null){
            while (rs.next()) {                
            horario c = new horario();
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
         public String ExcluirHorario(horario c){
   String sql = "DELETE FROM horario WHERE id = ?";
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
   public List<horario> Pesquisar_Nome_Horario(String inicio){
        String sql = "select * from horario where inicio Like '"+inicio+ "%'";
         List <horario> lista = new ArrayList<>();
        
        try{
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs != null){
              while (rs.next()){
                  horario a = new horario();
                  a.setCod(rs.getInt(1));
                  a.setInicio(rs.getString(2));
                  a.setFim(rs.getString(3));
                  
                  
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
        public List<horario> Pesquisar_Cod_Horario(int cod){
   String sql = "SELECT * FROM horario WHERE id ='"+cod+"'";
   List<horario> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                horario a = new horario();
                a.setCod(rs.getInt(1));
                a.setInicio(rs.getString(2));
                a.setFim(rs.getString(2));
               
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
    //Capturar
    public List<horario> CapturarHorario(int cod){
        String sql = "SELECT * FROM horario WHERE id='"+cod+"'";
        List<horario> lista = new ArrayList<>();

        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    horario c = new horario();
                    c.setCod(rs.getInt(1));
                    c.setInicio(rs.getString(2));
                    c.setFim(rs.getString(3));
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
     //testar
    public boolean Testar_Horario(int cod){
        boolean result =false;
        try {
            String sql = "SELECT * FROM horario WHERE id='"+cod+"'";
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
    //Alterar
    public String Alterar_Horario(horario c){
    String sql = "UPDATE horario SET inicio = ?, fim = ? WHERE id = ?";
    
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);
            ps.setString(1,c.getInicio());
            ps.setString(2,c.getFim());
            ps.setInt(3,c.getCod());
            
            if (ps.executeUpdate()>0) {
                return "Atualizado com sucesso";
            }else{
                return "Erro ao atualizar";
                       
            }
        } catch (SQLException ex) {
            return ex.getMessage();
        }      
    
}
    //Listar
    public List<horario> ListarHorario(){
   String sql = "SELECT * FROM horario";
   List<horario> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                horario f = new horario();
                f.setCod(rs.getInt(1));
                f.setInicio(rs.getString(2));
                f.setFim(rs.getString(3));
                
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
}







