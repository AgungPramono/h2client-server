/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.belajar.h2.belajarh2api.controller;

import com.agung.belajar.h2.belajarh2api.dao.SiswaDao;
import com.agung.belajar.h2.belajarh2api.entity.Siswa;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author agung
 */
@RestController
@RequestMapping("/api/siswa")
public class SiswaController {

    @Autowired
    private SiswaDao siswaDao;

    @GetMapping("/list")
    public Iterable<Siswa> getAllPage() {
        return siswaDao.findAll();
    }

    @GetMapping("/list2")
    public Page<Siswa> getBp(@PageableDefault(size = 1000) Pageable page) {
        return siswaDao.findAll(page);
    }

    @GetMapping("/count")
    public Long getJumlahSiswa() {
        return siswaDao.count();
    }

    @PostMapping("/submit")
    public ResponseEntity<String> insertBatchSiswa(@RequestBody @Valid Siswa s) {
//        siswaDao.save(s);
//        while(true){
        List<Siswa> listSiswa = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Siswa siswa = new Siswa();
            siswa.setId(UUID.randomUUID().toString());
            siswa.setNoInduk("noIndukapi" + i);
            siswa.setNama("siswaapi" + i);
            siswa.setAlamat("alamatsiswaapi" + i);
            listSiswa.add(siswa);
        }
        siswaDao.saveAll(listSiswa);
        return new ResponseEntity<>(listSiswa.size()+" student created",HttpStatus.CREATED);
//        }
    }
}
