/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.belajar.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agung
 */
public class ViewData {

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

            batchQuery(con);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InsertClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InsertClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void batchQuery(Connection connection) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String sql = "select * from siswa";

                    String sqlCount = "select count(*) as jumlah from siswa";

                    while (true) {
                        for (int i = 0; i < 10; i++) {
//                            PreparedStatement ps = connection.prepareStatement(sql);
//                            ResultSet rs = ps.executeQuery();
//
//                            while (rs.next()) {
//                                log.debug("no induk: {}", rs.getString("no_induk"));
//                                log.debug("nama: {}", rs.getString("nama"));
//                                log.debug("alamat : {}", rs.getString("alamat"));
//                            }
                            PreparedStatement ps2PreparedStatement = connection.prepareStatement(sqlCount);
                            ResultSet rs2 = ps2PreparedStatement.executeQuery();
                            while (rs2.next()) {
                                log.debug("jumlah data sekarang :{}", rs2.getInt("jumlah"));
                            }
                        }

                    }

                } catch (SQLException ex) {
                    Logger.getLogger(InsertClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        );
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(InsertClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
