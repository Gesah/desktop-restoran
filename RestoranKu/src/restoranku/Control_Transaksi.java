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
public class Control_Transaksi extends Koneksi {
    // Termasuk enkapsulasi
    private String idTransaksi;
    private String idOrder;
    private String tanggal;
    private double total;
    public Control_Transaksi() {
        setkonek();
    }
    // method set ini digunakan untuk mengatur/mengeset nilai dari variabel 
    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }
    // method get ini digunakan untuk mengambil nilai dari variabel.
    public String getIdOrder() {
        return idOrder;
    }

    public String getTanggal() {
        return tanggal;
    }

    public double getTotal() {
        return total;
    }
    // method ini digunakan untuk menyimpan data transaksi baru ke dalam database dengan menggunakan SQL Insert statement.
     public void simpandata(){
        String sql = "INSERT INTO tb_transaksi VALUES (null,'" + getIdOrder() + "','" + getTanggal() + "','" + getTotal() + "')";
         try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Control_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //  method ini digunakan untuk mencari data transaksi dari database dengan menggunakan SQL Select statement 
     // dan menampilkan hasil pencarian ke dalam table model yang diberikan sebagai input.
    public void cari(DefaultTableModel dtm, String cari){
    String sql = "SELECT * FROM tb_masakan,tb_detail_order WHERE tb_masakan.id_masakan=tb_detail_order.id_masakan AND tb_detail_order.id_order =  '"+cari+"'";
        try {
            rs=st.executeQuery(sql);
            Object[] data = new Object[4];
            while(rs.next()){
            data[0]=rs.getString("id_detail_order");
            data[1]=rs.getString("id_order");
            data[2]=rs.getString("nama_masakan");
            data[3]=rs.getString("keterangan");
            dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Control_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // method ini digunakan untuk menampilkan semua data 
    // transaksi dari database ke dalam table model yang diberikan sebagai input.
       public void tampildata(DefaultTableModel dtm){
    String sql = "SELECT * FROM tb_masakan,tb_detail_order WHERE tb_masakan.id_masakan=tb_detail_order.id_masakan";
        try {
            rs=st.executeQuery(sql);
            Object[] data = new Object[4];
            while(rs.next()){
            data[0]=rs.getString("id_detail_order");
            data[1]=rs.getString("id_order");
            data[2]=rs.getString("nama_masakan");
            data[3]=rs.getString("keterangan");
            dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Control_Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       // method ini digunakan untuk menghitung total harga dari transaksi tertentu 
       // dengan menggunakan SQL Select statement dan kembalian dari query yang dijalankan.
        public ResultSet total(String total) throws SQLException {
        String sql = "SELECT SUM(tb_masakan.harga*tb_detail_order.keterangan) AS total FROM tb_masakan,tb_detail_order WHERE tb_masakan.id_masakan ="
                + " tb_detail_order.id_masakan AND tb_detail_order.id_order = '" + total + "' GROUP BY tb_detail_order.id_order";
        return  st.executeQuery(sql);
    }
     
}
