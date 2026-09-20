/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import java.util.Scanner;
import com.mycompany.penyewaankamera.Service;

/**
 *
 * @author Dovs
 */
public class Main {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Service service = new Service();
 
        // Data awal
        service.tambahKamera("Canon EOS 90D");
        service.tambahKamera("Sony Alpha A7 III");
        service.tambahKamera("Nikon Z6");
        service.tambahKamera("Canon 600d");
        
        int pilihan;
 
        do {
            System.out.println("\n===== SISTEM PEMINJAMAN KAMERA =====");
            System.out.println("1. Lihat Kamera Tersedia");
            System.out.println("2. Pinjam Kamera");
            System.out.println("3. Kembalikan Kamera");
            System.out.println("4. Lihat Semua Peminjaman");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
 
            // Validasi input
            while (!scanner.hasNextInt()) {
                System.out.print("Input harus berupa angka. Pilih menu (1-5): ");
                scanner.next();
            }
            pilihan = scanner.nextInt();
            scanner.nextLine();
 
            switch (pilihan) {
                case 1:
                    service.tampilkanKameraTersedia();
                    break;
 
                case 2:
                    service.tampilkanKameraTersedia();
                    System.out.print("Nama Peminjam       : ");
                    String namaPeminjam = scanner.nextLine();
                    System.out.print("Nama Kamera dipinjam: ");
                    String namaKamera = scanner.nextLine();
 
                    service.pinjamKamera(namaPeminjam, namaKamera);
                    break;
 
                case 3:
                    service.tampilkanSemuaPeminjaman();
                    System.out.print("Masukkan ID Peminjaman yang dikembalikan: ");
                    int idPeminjaman = scanner.nextInt();
 
                    service.kembalikanKamera(idPeminjaman);
                    break;
 
                case 4:
                    service.tampilkanSemuaPeminjaman();
                    break;
 
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem ini!");
                    break;
 
                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
 
        } while (pilihan != 5);
 
        scanner.close();
    }
}
