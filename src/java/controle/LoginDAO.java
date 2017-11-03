/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Pessoa;
import model.ConnectionFactory;

/**
 *
 * @author cesardias
 */
public class LoginDAO  {

    /**
     * @return the sql
     */
    public String getSql() {
        return sql;
    }

    /**
     * @param sql the sql to set
     */
    public void setSql(String sql) {
        this.sql = sql;
    }
 private String sql;
    
        public Boolean verificaLogin (Pessoa pessoa){    
            
            boolean result = false;
            
            
            setSql("SELECT LOGIN, SENHA "  
                + "FROM PESSOA WHERE LOGIN = ? and SENHA = ? ");

            try (Connection conn = ConnectionFactory.connect();
                PreparedStatement pstmt  = conn.prepareStatement(getSql())){

                        pstmt.setString(1,pessoa.getLogin());
                        pstmt.setString(2,pessoa.getSenha());
                        
                        ResultSet rs  = pstmt.executeQuery();
                        
                       result = rs.next();
                        
             } catch (SQLException e) {
                    System.out.println(e.getMessage());
             }
             
            
             return result;                 
       }                    
  }

    
       
