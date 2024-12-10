/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author sahan
 */
public class database {
    public static Connection connect (){
    Connection conn=null;
  
    
   
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_project", "root1", "1234");
            } catch (SQLException ex) {
                Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }

        return conn;
}



}