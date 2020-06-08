/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.belajar.java;

import com.agung.belajar.java.entity.Siswa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agung
 */
public class DemoClient {

    private static final ch.qos.logback.classic.Logger log = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(StartServer.class);

    public static void main(String[] args) {
        try {
            Class.forName("org.h2.Driver");
            String url = "jdbc:h2:~/database/test";
            String username = "sa";
            String password = "";
            Connection con = DriverManager.getConnection("jdbc:h2:tcp://192.168.43.25:9090/~/database/test", "sa", "");
            if (con != null) {
                log.debug("koneksi berhasil");
            }

            String createTable = ""
                    + "create table siswa("
                    + "no_induk VARCHAR(50) NOT NULL, "
                    + "nama VARCHAR(50) NOT NULL, "
                    + "alamat VARCHAR(20) NOT NULL"
                    + ")";

            PreparedStatement ps = con.prepareStatement(createTable);
            ps.executeUpdate();
            batchInsert(con);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DemoClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DemoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void batchInsert(Connection connection) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String sql = "insert into siswa(no_induk,nama,alamat) values (?,?,?)";
                    while (true) {
                        for (int i = 0; i < 10; i++) {
                            PreparedStatement ps = connection.prepareStatement(sql);
//                            ps.setInt(1, i+1);
                            ps.setString(1, "00"+i);
                            ps.setString(2, "nama"+i);
                            ps.setString(3, "alamat"+i);
                            ps.executeUpdate();
                            
                            log.debug("insert data");
                        }
                    }
                    
                } catch (SQLException ex) {
                    Logger.getLogger(DemoClient.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
        }
        );
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DemoClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
