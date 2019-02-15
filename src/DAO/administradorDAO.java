/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.administrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Raiane
 */
public class administradorDAO extends ExecuteSQL {
    public administradorDAO(Connection con) {
        super(con);
    }
    public boolean Logar(String usuario, String senha){
         boolean finalResult = false;
         try{
         String consulta = "select usuario, senha from administrador where usuario = '"+usuario+ "' and senha = '" + senha +"'";
             PreparedStatement ps = getCon().prepareStatement(consulta);
             ResultSet rs = ps.executeQuery();
         
         if(rs != null){
             while (rs.next()){
                 administrador a = new administrador();
                 a.setUsuario(rs.getString(1));
                 a.setSenha (rs.getString(2));
                 finalResult = true;
             }
         }
         
        } catch (SQLException ex){
            ex.getMessage();
            
        }
         return finalResult;
    }
}
