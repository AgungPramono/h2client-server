/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.belajar.java.entity.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author agung
 */
public class KoneksiHelper {

    static final String url = "";
    static final String username = "";
    static final String password = "";

    static Connection connection;

    public static Connection connect() {
        try {
            Class.forName("mysql.jdbc.DriverManager");
            connection= DriverManager.getConnection(url, username, password);
            if(connection != null){
                return connection;
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KoneksiHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public void disconnect(Connection connection){
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(KoneksiHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
