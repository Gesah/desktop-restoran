/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranku;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS-AMD01
 */
public class Control_Order extends Koneksi {
     // digunakan untuk menyimpan nilai dari atribut dibawah ini pada tabel tb_order
     private String idorder;
     private String idmasakan;
     private String nomeja;
     private String tanggal;
     private String keterangan;
     private String statusorder;
     
     public Control_Order() {
        setkonek();
    }
     // digunakan untuk mengatur data order
    public void setIdorder(String idorder) {
        this.idorder = idorder;
    }

    public void setIdmasakan(String idmasakan) {
        this.idmasakan = idmasakan;
    }

    public void setNomeja(String nomeja) {
        this.nomeja = nomeja;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public void setStatusorder(String statusorder) {
        this.statusorder = statusorder;
    }
    // digunakan untuk mengambil data order
    public String getIdorder() {
        return idorder;
    }

    public String getIdmasakan() {
        return idmasakan;
    }

    public String getNomeja() {
        return nomeja;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getStatusorder() {
        return statusorder;
    }
    //  digunakan untuk menyimpan data order baru ke dalam database
    public void simpandataorder() {
       String sql = "INSERT INTO `tb_order` VALUES ('"+getIdorder()+"','"+getNomeja()+"','"+getTanggal()+"','"+getKeterangan()+"','"+getStatusorder()+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Control_Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void simpandatadetailorder() {
       String sql = "INSERT INTO tb_detail_order VALUES (null,'"+getIdorder()+"','"+getIdmasakan()+"','"+getKeterangan()+"','"+getStatusorder()+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Control_Order.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // digunakan untuk menampilkan semua data order dari database ke dalam tabel yang ditentukan dalam parameter dtm
     public void tampildata (DefaultTableModel dtm){
        String sql = "SELECT * FROM `tb_order`";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[5];
            while(rs.next()) {
                data[0] = rs.getString("id_order");
                data[1] = rs.getString("no_meja");
                data[2] = rs.getDate("tanggal");
                data[3] = rs.getString("keterangan");
                data[4] = rs.getString("status_order");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Control_Order.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     // digunakan untuk memperbarui data order yang sudah ada di database
     public void updatedata () {
         String sql = "UPDATE `tb_order` SET no_meja = '"+getNomeja()+"', tanggal = '"+getTanggal()+"', keterangan = '"+getKeterangan()+"', status_order = '"+getStatusorder()+"' WHERE id_order = '"+getIdorder()+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Control_Order.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     // digunakan untuk menghapus data order dari database
      public void hapusdata() {
        String sql = "DELETE FROM `tb_order` WHERE id_order = '"+getIdorder()+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Control_Order.class.getName()).log(Level.SEVERE, null, ex);
        } 
      }
      // Pada method cekId() digunakan untuk mengecek apakah id_order yang dimasukkan sudah ada di dalam tabel "tb_order" atau belum. Method ini akan mengeksekusi query SQL 
      // untuk mencari data yang sesuai dengan id_order yang diambil dari getter getIdorder() yang diterima sebagai parameter.
      public ResultSet cekId() throws SQLException{
          String sql = "SELECT * FROM `tb_order` where id_order='"+getIdorder()+"'";
          rs = st.executeQuery(sql);
          return rs;
      }
}
