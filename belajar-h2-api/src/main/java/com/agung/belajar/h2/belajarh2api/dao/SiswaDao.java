/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.belajar.h2.belajarh2api.dao;

import com.agung.belajar.h2.belajarh2api.entity.Siswa;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author agung
 */
public interface SiswaDao extends PagingAndSortingRepository<Siswa, String>{
    
}
