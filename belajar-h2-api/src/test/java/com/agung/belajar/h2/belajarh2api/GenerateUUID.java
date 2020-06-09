/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.belajar.h2.belajarh2api;

import java.util.UUID;
import org.junit.jupiter.api.Test;

/**
 *
 * @author agung
 */
public class GenerateUUID {

    @Test
    public void testUUID(){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }
    
}
