/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author cesardias
 */

public class ConnectionTest {

     /**
     * Connect to a sample database
     */
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:mysql://localhost/PULSE?" +
                                   "user=ADMIN&password=ADMIN";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to MySQL has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}

