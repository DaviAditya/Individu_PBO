/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.peminjamankamera;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dovs
 */
public class Service {
    private List<Kamera> daftarKamera;        
    private List<PeminjamanKamera> daftarPeminjaman;
    private int nomorBerikutnya;

    public Service() {
        this.daftarKamera = new ArrayList<>();
        this.daftarPeminjaman = new ArrayList<>();
        this.nomorBerikutnya = 1;
    }

    // Menerima objek Kamera (bisa KameraDSLR atau KameraMirrorless)
    public void tambahKamera(Kamera kamera) {
        daftarKamera.add(kamera);
    }

    private boolean sedangDipinjam(String namaKamera) {
        for (PeminjamanKamera p : daftarPeminjaman) {
            if (p.getNamaKamera().equalsIgnoreCase(namaKamera) && p.getStatus().equals("Dipinjam")) {
                return true;
            }
        }
        return false;
    }

    public void tampilkanKameraTersedia() {
        System.out.println("\n=== Daftar Kamera Tersedia ===");
        boolean adaYangTersedia = false;
        for (Kamera k : daftarKamera) {
            if (!sedangDipinjam(k.getNama())) {
                System.out.println("- " + k.getInfo());
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
        boolean ditemukan = false;
        for (Kamera k : daftarKamera) {
            if (k.getNama().equalsIgnoreCase(namaKamera)) {
                ditemukan = true;
                break;
            }
        }

        if (!ditemukan) {
            System.out.println("Kamera '" + namaKamera + "' tidak ditemukan di daftar.");
            return null;
        }
        if (sedangDipinjam(namaKamera)) {
            System.out.println("Maaf, kamera '" + namaKamera + "' sedang dipinjam orang lain.");
            return null;
        }

        PeminjamanKamera peminjamanBaru = new PeminjamanKamera(
                nomorBerikutnya++,
                namaKamera,
                namaPeminjam,
                LocalDate.now()
        );

        daftarPeminjaman.add(peminjamanBaru);

        System.out.println("\nPeminjaman berhasil dicatat!");
        System.out.println(peminjamanBaru);

        return peminjamanBaru;
    }

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