/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.penyewaankamera;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dovs
 */
public class Service {
    private List<String> daftarKamera;        
    private List<PeminjamanKamera> daftarPeminjaman;
    private int nomorBerikutnya;
 
    public Service() {
        this.daftarKamera = new ArrayList<>();
        this.daftarPeminjaman = new ArrayList<>();
        this.nomorBerikutnya = 1;
    }
 
    // Menambahkan kamera baru
    public void tambahKamera(String namaKamera) {
        daftarKamera.add(namaKamera);
    }
 
    // Mengecek kamera sedang dipinjam
    private boolean sedangDipinjam(String namaKamera) {
        for (PeminjamanKamera p : daftarPeminjaman) {
            if (p.getNamaKamera().equalsIgnoreCase(namaKamera) && p.getStatus().equals("Dipinjam")) {
                return true;
            }
        }
        return false;
    }
 
    // Menampilkan semua kamera yang tersedia
    public void tampilkanKameraTersedia() {
        System.out.println("\n=== Daftar Kamera Tersedia ===");
        boolean adaYangTersedia = false;
        for (String namaKamera : daftarKamera) {
            if (!sedangDipinjam(namaKamera)) {
                System.out.println("- " + namaKamera);
                adaYangTersedia = true;
            }
        }
        if (!adaYangTersedia) {
            System.out.println("Maaf, semua kamera sedang dipinjam.");
        }
    }
 
    private PeminjamanKamera cariPeminjamanById(int idPeminjaman) {
        for (PeminjamanKamera p : daftarPeminjaman) {
            if (p.getIdPeminjaman() == idPeminjaman) {
                return p;
            }
        }
        return null;
    }
 

    public PeminjamanKamera pinjamKamera(String namaPeminjam, String namaKamera) {
        if (!daftarKamera.contains(namaKamera)) {
            System.out.println("Kamera '" + namaKamera + "' tidak ditemukan di daftar.");
            return null;
        }
        if (sedangDipinjam(namaKamera)) {
            System.out.println("Maaf, kamera '" + namaKamera + "' sedang dipinjam orang lain.");
            return null;
        }
 
        PeminjamanKamera PeminjamanKameraBaru = new PeminjamanKamera(
                nomorBerikutnya++,
                namaKamera,
                namaPeminjam,
                LocalDate.now()
        );
 
        daftarPeminjaman.add(PeminjamanKameraBaru);
 
        System.out.println("\nPeminjaman berhasil dicatat!");
        System.out.println(PeminjamanKameraBaru);
 
        return PeminjamanKameraBaru;
    }
 
    // Mengembalikan kamera berdasarkan id peminjaman
    public void kembalikanKamera(int idPeminjaman) {
        PeminjamanKamera peminjaman = cariPeminjamanById(idPeminjaman);
 
        if (peminjaman == null) {
            System.out.println("Data peminjaman dengan ID " + idPeminjaman + " tidak ditemukan.");
            return;
        }
        if (peminjaman.getStatus().equals("Selesai")) {
            System.out.println("Peminjaman ini sudah pernah dikembalikan sebelumnya.");
            return;
        }
 
        peminjaman.setTanggalKembali(LocalDate.now());
        peminjaman.setStatus("Selesai");
 
        System.out.println("\nPengembalian berhasil dicatat!");
        System.out.println(peminjaman);
    }
 
    // Menampilkan riwayat peminjaman
    public void tampilkanSemuaPeminjaman() {
        System.out.println("\n=== Riwayat Semua Peminjaman ===");
        if (daftarPeminjaman.isEmpty()) {
            System.out.println("Belum ada data peminjaman.");
            return;
        }
        for (PeminjamanKamera p : daftarPeminjaman) {
            System.out.println(p);
        }
    }
}
