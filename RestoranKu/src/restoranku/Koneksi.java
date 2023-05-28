/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS-AMD01
 */
public class Koneksi {
    // Connection Koneksi
    Connection konek; // deklarasi variabel untuk menyimpan koneksi ke database.
    Statement st; // deklarasi variabel untuk mengeksekusi perintah SQL.
    public ResultSet rs; // deklarasi variabel untuk menyimpan hasil dari query yang dijalankan.
    
    // method setkonek() digunakan untuk menyimpan koneksi ke database dan mengeksekusi perintah SQL.
    public void setkonek() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // digunakan untuk mengambil kelas driver yang dibutuhkan untuk koneksi ke MySQL.
            konek = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_restoran","root",""); // digunakan untuk membuat koneksi ke database, dengan parameter berupa URL koneksi, username dan password.
            st = konek.createStatement(); // digunakan untuk membuat objek statement yang digunakan untuk mengeksekusi perintah SQL.
            System.out.println("Koneksi sukses"); // digunakan untuk mencetak pesan pada console jika koneksi berhasil
        } catch (ClassNotFoundException ex) { // digunakan untuk menangkap exception jika driver yang dibutuhkan tidak ditemukan.
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) { // digunakan untuk menangkap exception jika terjadi kesalahan pada saat koneksi ke database.
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
