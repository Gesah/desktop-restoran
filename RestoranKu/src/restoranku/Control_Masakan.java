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
public class Control_Masakan extends Koneksi {
    // Codingan ini termasuk Enkapsulasi
    // digunakan untuk menyimpan nilai dari atribut dibawah ini pada tabel tb_masakan
    private String idmasakan;
    private String namamasakan;
    private int harga;
    private String statusmasakan;
    
    public Control_Masakan() {
        setkonek();
    }
        //  digunakan untuk mengatur nilai dari atribut idmasakan, namamasakan, harga dan statusmasakan
    public void setIdmasakan(String idmasakan) {
        this.idmasakan = idmasakan;
    }

    public void setNamamasakan(String namamasakan) {
        this.namamasakan = namamasakan;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setStatusmasakan(String statusmasakan) {
        this.statusmasakan = statusmasakan;
    }
    
    // digunakan untuk mengambil nilai dari atribut idmasakan, namamasakan, harga dan statusmasakan
    public String getIdmasakan() {
        return idmasakan;
    }

    public String getNamamasakan() {
        return namamasakan;
    }

    public int getHarga() {
        return harga;
    }

    public String getStatusmasakan() {
        return statusmasakan;
    }
    // digunakan untuk menyimpan data baru pada tabel tb_masakan
    public void simpandata() {
        String sql = "INSERT INTO tb_masakan VALUES ('"+getIdmasakan()+"','"+getNamamasakan()+"','"+getHarga()+"','"+getStatusmasakan()+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Control_Masakan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // digunakan untuk menampilkan semua data dari tabel tb_masakan
    public void tampildata (DefaultTableModel dtm){
        String sql = "SELECT * FROM tb_masakan";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[4];
            while(rs.next()) {
                data[0] = rs.getString("id_masakan");
                data[1] = rs.getString("nama_masakan");
                data[2] = rs.getInt("harga");
                data[3] = rs.getString("status_masakan");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Control_Masakan.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    // digunakan untuk mengupdate data yang ada pada tabel tb_masakan
   public void updatedata() {
        String sql = "UPDATE tb_masakan SET nama_masakan = '"+getNamamasakan()+"', harga = '"+getHarga()+"', status_masakan = '"+getStatusmasakan()+"' WHERE id_masakan = '"+getIdmasakan()+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
              Logger.getLogger(Control_Masakan.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   // digunakan untuk mengupdate data yang ada pada tabel tb_masakan
    public void hapusdata() { 
    String sql = "DELETE FROM tb_masakan WHERE id_masakan = '"+getIdmasakan()+"'";
    try {
        st.executeUpdate(sql);
    } catch (SQLException ex) {
        Logger.getLogger(Control_Masakan.class.getName()).log(Level.SEVERE, null, ex);
    } 
  }
      // digunakan untuk mencari data dari tabel tb_masakan dan tb_masakan berdasarkan id_masakan dan nama_masakan
      public ResultSet caridata(DefaultTableModel dtm, String cari) {
        try {
            String sql = "SELECT * FROM tb_masakan WHERE id_masakan LIKE '%"+cari+"%' OR nama_masakan LIKE '%"+cari+"%' OR harga LIKE '%"+cari+"%'";
            rs = st.executeQuery(sql);
            Object [] data = new Object[4];
                while(rs.next()) {
                data[0] = rs.getString("id_masakan");
                data[1] = rs.getString("nama_masakan");
                data[2] = rs.getInt("harga");
                data[3] = rs.getString("status_masakan");
                dtm.addRow(data);
                
             }
        } catch (SQLException ex) {
            Logger.getLogger(Control_Masakan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
      
      }
    
}
