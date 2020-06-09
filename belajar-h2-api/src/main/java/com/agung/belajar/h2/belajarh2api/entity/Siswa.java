/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.agung.belajar.h2.belajarh2api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author agung
 */
@Data
@Entity
public class Siswa {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    private String id;

    @Column(name = "no_induk", nullable = false)
    @JsonProperty("no_induk")
    private String noInduk;

    @Column(name = "nama", nullable = false)
    @NotNull
    private String nama;
    @Column(name = "alamat", nullable = false)
    @NotNull
    private String alamat;
}
