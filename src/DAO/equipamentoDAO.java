/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.equipamento;
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
public class equipamentoDAO extends ExecuteSQL {

    public equipamentoDAO(Connection con) {
        super(con);
    }
    
    public String Inserir_equipamento(equipamento a){
        
        String sql = "insert into produto values (0,?,?,?,?,?,?)";
    
        try{
            PreparedStatement ps = getCon().prepareStatement(sql);
            
             ps.setString(1, a.getNome());
             ps.setInt(2,a.getId_tipo());
             ps.setInt(3,a.getId_marca());
             ps.setString(4, a.getQuantidade());
             ps.setString(5, a.getDescricao());
             ps.setString(6, a.getImagem());
            
              
              if(ps.executeUpdate() > 0){
              
                  return "Inserido com sucesso";
              
              } else {
              
                  return "Erro ao inserir";
            
              }
              
        } catch (SQLException e){
        
            return e.getMessage();
        
        }
    }
    
    //Testar
   public boolean Testar_equipamento(int cod){
   boolean result = false;
   
       try{
          String sql = "SELECT * FROM produto WHERE id = '"+cod+"'";
           
          PreparedStatement ps = getCon().prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          if(rs!= null){
          while(rs.next()){
          result = true;
          }
          }
          
       }catch(SQLException ex) {
          ex.getMessage();
       }
       return result;
   }
   //Capturar 
    public List<equipamento> CapturarEquipamento(int cod){
    String sql = "SELECT * FROM produto WHERE id = '"+cod+"'";
    List<equipamento> lista = new ArrayList<>();
        try {
            PreparedStatement pr = getCon().prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            if(rs!=null){
                while(rs.next()){
                    equipamento f = new equipamento();
                    f.setCod(rs.getInt(1));
                    f.setNome(rs.getString(2));
                    f.setId_tipo(rs.getInt(3));
                    f.setId_marca(rs.getInt(4));
                    f.setQuantidade(rs.getString(5));
                    f.setDescricao(rs.getString(6));
                    f.setImagem(rs.getString(7));
                    lista.add(f);

                }
                return lista;
            }else{
                return null;
            }                    
        } catch (SQLException ex) {
            return null;
        }
    
    }   
   //Alterar
     public String Alterar_Equipamento(equipamento f){
   String sql = "UPDATE produto SET nome = ? ,id_tipo = ? ,id_marca = ?, quantidade = ? ,descricao = ? ,imagem = ? WHERE id = ?";
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           
           ps.setString(1,f.getNome());
           ps.setInt(2, f.getId_tipo());
           ps.setInt(3, f.getId_marca());
           ps.setString(4,f.getQuantidade());
           ps.setString(5,f.getDescricao());
           ps.setString(6,f.getImagem());
           ps.setInt(7,f.getCod());
           if (ps.executeUpdate() >0) {
               return "Equipamento Atualizado Com Sucesso";
           }else{
               return "Erro ao Atualizar";
           }
           
       } catch (SQLException ex) {
           return ex.getMessage();
       }
   
   
   }
   //Consultar
   public List<equipamento> ListarEquipamento(){
   String sql = "SELECT * FROM produto";
   List<equipamento> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                equipamento f = new equipamento();
                f.setCod(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setId_tipo(rs.getInt(3));
                f.setId_marca(rs.getInt(4));
                f.setQuantidade(rs.getString(5));
                f.setDescricao(rs.getString(6));
                f.setImagem(rs.getString(7));
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
   //Consultar
   public List<equipamento> Listar_Nome_Equipamento(String nome){
   String sql = "SELECT * FROM produto WHERE nome LIKE '%"+nome+"%'";
   List<equipamento> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                equipamento f = new equipamento();
                f.setCod(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setId_tipo(rs.getInt(3));
                f.setId_marca(rs.getInt(4));
                f.setQuantidade(rs.getString(5));
                f.setDescricao(rs.getString(6));
                f.setImagem(rs.getString(7));
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
   //Consultar
   public List<equipamento> Listar_Codigo_Equipamento(int cod){
   String sql = "SELECT * FROM produto WHERE id ='"+cod+"'";
   List<equipamento> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
               while (rs.next()) {                   
                equipamento f = new equipamento();
                f.setCod(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setId_tipo(rs.getInt(3));
                f.setId_marca(rs.getInt(4));
                f.setQuantidade(rs.getString(5));
                f.setDescricao(rs.getString(6));
                f.setImagem(rs.getString(7));
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
   //ListarExcluir
   public List<equipamento> ListarComboEquipamento(){
   String sql = "SELECT nome FROM produto";
   List<equipamento> lista = new ArrayList<>();
   
       try {
           PreparedStatement pr = getCon().prepareStatement(sql);
           ResultSet rs = pr.executeQuery();
           
           if(rs!= null){
            while(rs.next()){
                equipamento f = new equipamento();
                f.setNome(rs.getString(1));
                lista.add(f);
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
   public List<equipamento> ConsultaCodigoEquipamento(String nome){
   String sql = "SELECT id FROM produto WHERE nome = '"+nome+"'";
   List<equipamento> lista = new ArrayList<>();
   
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!= null){
                while(rs.next()){
                    equipamento f = new equipamento();
                    f.setCod(rs.getInt(1));
                    lista.add(f);
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
   public String ExcluirEquipamento(equipamento f){
   String sql = "DELETE FROM produto WHERE id = ? AND nome = ?";
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
   
   public List<equipamento> PesquisarCodEquipamento(int cod){
   String sql = "SELECT id,nome,id_tipo,tipo_marca,quantidade,descricao,imagem FROM produto WHERE id='"+cod+"'";
   List<equipamento> lista = new ArrayList<>();
       try {
           PreparedStatement ps = getCon().prepareStatement(sql);
           ResultSet rs = ps.executeQuery();
           
           if(rs!=null){
           while(rs.next()){
           equipamento f = new equipamento();
                f.setCod(rs.getInt(1));
                f.setNome(rs.getString(2));
                f.setId_tipo(rs.getInt(3));
                f.setId_marca(rs.getInt(4));
                f.setQuantidade(rs.getString(5));
                f.setDescricao(rs.getString(6));
                f.setImagem(rs.getString(7));
                lista.add(f);         
           
           }
           return lista;
           }else{
           return null;
           }
           
       } catch (SQLException e) {
       return null;
       }
   
   }
  
}