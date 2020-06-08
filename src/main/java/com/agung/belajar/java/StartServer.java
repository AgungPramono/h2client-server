1/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.belajar.java;

import ch.qos.logback.classic.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import org.h2.tools.Server;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agung
 */
public class StartServer {

    private static final Logger log = (Logger) LoggerFactory.getLogger(StartServer.class);
    private static Server server = null;

    public static void main(String[] args) throws SQLException {
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("start/stop server");
            System.out.println("1.start server");
            System.out.println("2.stop server");
            System.out.println("Masukkan pilihan :");
            Integer pilih = scanner.nextInt();
            switch (pilih) {
                case 1:
                    startServer();
                    break;
                case 2:
                    stopServer();
                    break;
            }
        }while(true);
    }

    private static void startServer() {
        try {
            server = Server.createTcpServer(
                    "-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
            server.start();
            log.debug(server.getURL());
            log.debug("server started");
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(StartServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void stopServer() {
        if (server != null) {
            server.stop();
            log.debug("server stopped");
        }
    }
}
