/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.penyewaankamera;
import java.time.LocalDate;
/**
 *
 * @author Dovs
 */
public class PeminjamanKamera {
private int idPeminjaman;
    private String namaKamera;
    private String namaPeminjam;
    private LocalDate tanggalPinjam;
    private LocalDate tanggalKembali; // null selama kamera belum dikembalikan
    private String status;
    
//  Contructor
    public PeminjamanKamera(int idPeminjaman, String namaKamera, String namaPeminjam, LocalDate tanggalPinjam) {
        this.idPeminjaman = idPeminjaman;
        this.namaKamera = namaKamera;
        this.namaPeminjam = namaPeminjam;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalKembali = null;
        this.status = "Dipinjam"; 
    }

//    Getter
    public int getIdPeminjaman() {
        return idPeminjaman; 
    }
    public String getNamaKamera() {
        return namaKamera; 
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public LocalDate getTanggalPinjam() {
        return tanggalPinjam;
    }

    public LocalDate getTanggalKembali() {
        return tanggalKembali;
    }

    public String getStatus() {
        return status;
    }
    
// Setter

    public void setTanggalKembali(LocalDate tanggalKembali) {
        this.tanggalKembali = tanggalKembali;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString(){
        return "Peminjaman #" + idPeminjaman +
                " | Kamera: " + namaKamera +
                " | Peminjam: " + namaPeminjam +
                " | Tgl Pinjam: " + tanggalPinjam +
                " | Tgl Kembali: " + (tanggalKembali == null ? "-" : tanggalKembali) +
                " | Status: " + status;
    }
}
