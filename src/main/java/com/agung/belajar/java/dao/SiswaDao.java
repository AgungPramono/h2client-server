/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.belajar.java.dao;

import com.agung.belajar.java.entity.helper.KoneksiHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author agung
 */
public class SiswaDao {

    private String sqlCariSemua = "select * from siswa";
    
    
    public void cariSemua() throws SQLException{
        Connection connection = KoneksiHelper.connect();
        PreparedStatement ps = connection.prepareStatement(sqlCariSemua);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {            
            
        }
    }
    
    
}
