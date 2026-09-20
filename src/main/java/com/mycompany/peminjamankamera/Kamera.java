/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peminjamankamera;

/**
 *
 * @author Dovs
 */
public class Kamera {
    private String nama;
    private String jenis;

    public Kamera(String nama, String jenis) {
        this.nama = nama;
        this.jenis = jenis;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    // Method untuk menampilkan informasi kamera
    public String getInfo() {
        return nama + " [" + jenis + "]";
    }
}
