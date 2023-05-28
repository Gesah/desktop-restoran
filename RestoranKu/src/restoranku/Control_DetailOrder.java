/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranku;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS-AMD01
 */
public class Control_DetailOrder extends Koneksi {
     private String iddetail;
     private String idorder;
     private String idmasakan;
     private String keterangan;
     private String statusdetail;
     
     public Control_DetailOrder() {
        setkonek(); // digunakan untuk menyimpan koneksi ke database dan mengeksekusi perintah SQL.
    }

    public void setIddetail(String iddetail) {
        this.iddetail = iddetail;
    }

    public void setIdorder(String idorder) {
        this.idorder = idorder;
    }

    public void setIdmasakan(String idmasakan) {
        this.idmasakan = idmasakan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setStatusdetail(String statusdetail) {
        this.statusdetail = statusdetail;
    }

    public String getIddetail() {
        return iddetail;
    }

    public String getIdorder() {
        return idorder;
    }

    public String getIdmasakan() {
        return idmasakan;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getStatusdetail() {
        return statusdetail;
    }
    // DefaultTableModel dtm digunakan untuk menyimpan data yang ditampilkan dalam tabel pada aplikasi.
     public void tampildata (DefaultTableModel dtm){ // digunakan untuk menampilkan semua data dari tabel tb_detail_order dan tb_masakan
        String sql = "SELECT * FROM tb_detail_order, tb_masakan WHERE tb_masakan.id_masakan=tb_detail_order.id_masakan";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[6];
            while(rs.next()) {
                data[0] = rs.getString("id_detail_order");
                data[1] = rs.getString("id_order");
                data[2] = rs.getString("id_masakan");
                data[3] = rs.getString("nama_masakan");
                data[4] = rs.getString("keterangan");
                data[5] = rs.getString("status_detail_order");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Control_DetailOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     // digunakan untuk mencari data dari tabel tb_detail_order dan tb_masakan berdasarkan id_order
      public void cari(DefaultTableModel dtm, String cari){ 
    String sql = "SELECT * FROM tb_order, tb_detail_order, tb_masakan WHERE tb_masakan.id_masakan=tb_detail_order.id_masakan AND tb_detail_order.id_order =  '"+cari+"'";
        try {
            rs=st.executeQuery(sql);
            Object[] data = new Object[6];
            while(rs.next()){
                data[0] = rs.getString("id_detail_order");
                data[1] = rs.getString("id_order");
                data[2] = rs.getString("id_masakan");
                data[3] = rs.getString("nama_masakan");
                data[4] = rs.getString("keterangan");
                data[5] = rs.getString("status_detail_order");
            dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Control_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

// Overall, kode ini digunakan untuk mengolah data dari tabel "tb_detail_order" dan "tb_masakan" di database MySQL melalui aplikasi Java, dengan menggunakan class Control_DetailOrder dan subclass dari class Koneksi yang sudah dibuat sebelumnya.