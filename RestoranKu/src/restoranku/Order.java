/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranku;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import restoranku.Control_Masakan;
import restoranku.Control_Order;

/**
 *
 * @author ASUS-AMD01
 */
public class Order extends javax.swing.JDialog {
    Control_Masakan cm;
    Control_Order co;
    String iddetailorder,idorder,nomeja,tanggal,keterangan,status,idmasakan;
    DefaultTableModel dt;
    /**
     * Creates new form Order
     */
    public Order(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cm = new Control_Masakan();
        co = new Control_Order();
        txtidorder.setEnabled(false);
        lblnomeja.setVisible(false);
        txtnomeja.setVisible(false);
        bg.add(dtp);
        bg.add(dlv);
        tgl();
        tampildata();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbmasakan = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblnomeja = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblharga = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        dlv = new javax.swing.JRadioButton();
        dtp = new javax.swing.JRadioButton();
        txtnomeja = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblidmasakan = new javax.swing.JLabel();
        lblnamamasakan = new javax.swing.JLabel();
        txtjumlahpesan = new javax.swing.JTextField();
        lbljumlahpesan = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblinformasi = new javax.swing.JLabel();
        txtidorder = new javax.swing.JTextField();
        btnpesan = new javax.swing.JButton();
        lbltanggal = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Menu Order");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        tbmasakan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Masakan", "Nama Masakan", "Harga", "Status Masakan"
            }
        ));
        tbmasakan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbmasakanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbmasakan);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 610, -1));

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 90, 140, -1));

        jLabel2.setText("Search");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 90, -1, 30));

        jLabel3.setText("| Pilih Masakan");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, 30));

        jLabel4.setText("ID Order");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, -1, 30));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblnomeja.setText("No Meja");
        jPanel2.add(lblnomeja, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 30));

        jLabel6.setText("| Keterangan");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel7.setText(":");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 10, -1));

        lblharga.setText("-");
        jPanel2.add(lblharga, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 120, -1));

        jLabel9.setText("ID Masakan");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel10.setText("Harga");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        dlv.setText("Delivery");
        dlv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dlvMouseClicked(evt);
            }
        });
        dlv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlvActionPerformed(evt);
            }
        });
        jPanel2.add(dlv, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        dtp.setText("Ditempat");
        dtp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dtpMouseClicked(evt);
            }
        });
        dtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dtpActionPerformed(evt);
            }
        });
        jPanel2.add(dtp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, -1));

        txtnomeja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnomejaActionPerformed(evt);
            }
        });
        jPanel2.add(txtnomeja, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 130, 30));

        jLabel12.setText(":");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 10, -1));

        jLabel13.setText(":");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 10, -1));

        lblidmasakan.setText("-");
        jPanel2.add(lblidmasakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 120, -1));

        lblnamamasakan.setText("-");
        jPanel2.add(lblnamamasakan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 120, -1));
        jPanel2.add(txtjumlahpesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 130, 30));

        lbljumlahpesan.setText("Jumlah Pesan");
        jPanel2.add(lbljumlahpesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 30));

        jLabel11.setText("Nama Masakan ");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));
        jPanel2.add(lblinformasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 220, 80));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 320, 380));

        txtidorder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidorderKeyReleased(evt);
            }
        });
        jPanel1.add(txtidorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 170, 30));

        btnpesan.setText("Pesan Sekarang");
        btnpesan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesanActionPerformed(evt);
            }
        });
        jPanel1.add(btnpesan, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, 270, 40));

        lbltanggal.setText("-");
        jPanel1.add(lbltanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 30, -1, -1));

        jLabel14.setText(":");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, -1, -1));

        jLabel15.setText("Tanggal");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 30, -1, -1));

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 90, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 640));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dlvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlvActionPerformed

    private void dtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dtpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dtpActionPerformed

    private void txtnomejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnomejaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomejaActionPerformed

    private void btnpesanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesanActionPerformed
        // TODO add your handling code here:
        pesan();
    }//GEN-LAST:event_btnpesanActionPerformed

    private void tbmasakanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbmasakanMouseClicked
        // TODO add your handling code here:
        settabel();
        txtidorder.setText("ORD-"+new SimpleDateFormat("mmss").format(new java.util.Date()));
    }//GEN-LAST:event_tbmasakanMouseClicked

    private void txtidorderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidorderKeyReleased
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_txtidorderKeyReleased

    private void dtpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dtpMouseClicked
        // TODO add your handling code here:
        lblnomeja.setVisible(true);
        txtnomeja.setVisible(true);
    }//GEN-LAST:event_dtpMouseClicked

    private void dlvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dlvMouseClicked
        // TODO add your handling code here:
        lblnomeja.setVisible(false);
        txtnomeja.setVisible(false);
    }//GEN-LAST:event_dlvMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        tampildata();
    }//GEN-LAST:event_txtsearchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Order dialog = new Order(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg;
    private javax.swing.JButton btnpesan;
    private javax.swing.JRadioButton dlv;
    private javax.swing.JRadioButton dtp;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblharga;
    private javax.swing.JLabel lblidmasakan;
    private javax.swing.JLabel lblinformasi;
    private javax.swing.JLabel lbljumlahpesan;
    private javax.swing.JLabel lblnamamasakan;
    private javax.swing.JLabel lblnomeja;
    private javax.swing.JLabel lbltanggal;
    private javax.swing.JTable tbmasakan;
    private javax.swing.JTextField txtidorder;
    private javax.swing.JTextField txtjumlahpesan;
    private javax.swing.JTextField txtnomeja;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables

private void tgl() {
        lbltanggal.setText(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
    }
 
private void tampildata() {
     DefaultTableModel dtm = (DefaultTableModel) tbmasakan.getModel();
     dtm.setRowCount(0);
     cm.tampildata(dtm);
     tbmasakan.setModel(dtm);
 }
 
 private void settabel() {
     String status;
     status = (tbmasakan.getValueAt(tbmasakan.getSelectedRow(),3).toString());
     lblidmasakan.setText(tbmasakan.getValueAt(tbmasakan.getSelectedRow(), 0).toString());
     lblnamamasakan.setText(tbmasakan.getValueAt(tbmasakan.getSelectedRow(),1).toString());
     lblharga.setText(tbmasakan.getValueAt(tbmasakan.getSelectedRow(),2).toString());
     btnpesan.setVisible(true);
     jLabel12.setVisible(true);
     jLabel13.setVisible(true);
     jLabel14.setVisible(true);
     jLabel6.setVisible(true);
     jLabel7.setVisible(true);
     jLabel9.setVisible(true);
     jLabel10.setVisible(true);
     jLabel11.setVisible(true);
     lblinformasi.setVisible(false);
     lblidmasakan.setVisible(true);
     lblnamamasakan.setVisible(true);
     lblharga.setVisible(true);
     dtp.setVisible(true);
     dlv.setVisible(true);
     lbljumlahpesan.setVisible(true);
     txtjumlahpesan.setVisible(true);
     
     if(status.equals("Kosong")){
         jLabel6.setVisible(false);
         jLabel7.setVisible(false);
         jLabel9.setVisible(false);
         jLabel10.setVisible(false);
         jLabel11.setVisible(false);
         jLabel12.setVisible(false);
         jLabel13.setVisible(false);
         jLabel14.setVisible(false);
         lblidmasakan.setVisible(false);
         lblnamamasakan.setVisible(false);
         lblinformasi.setText("STATUS MAKANAN KOSONG");
         lblinformasi.setVisible(true);
         lblharga.setVisible(false);
         btnpesan.setVisible(false);
         dtp.setVisible(false);
         dlv.setVisible(false);
         lbljumlahpesan.setVisible(false);
         txtjumlahpesan.setVisible(false);
         lblnomeja.setVisible(false);
         txtnomeja.setVisible(false);
     }
 }
 private void pesan() {
     idorder = txtidorder.getText();
     keterangan = txtjumlahpesan.getText();
     if (lblnomeja.isVisible() && txtnomeja.isVisible()){
        nomeja = txtnomeja.getText();
     } else {
         txtnomeja.setText("0");
     }
     tanggal = lbltanggal.getText();
     idmasakan = lblidmasakan.getText();
     if (dtp.isSelected()){
         status = "Ditempat";
     } else {
         status = "Delivery";
     }
     
     if (txtidorder.getText().isEmpty() || 
         lblidmasakan.getText().isEmpty() ||
         lblnamamasakan.getText().isEmpty() || 
         lblharga.getText().isEmpty() || 
         txtjumlahpesan.getText().isEmpty() || 
         txtnomeja.getText().isEmpty())  {
         JOptionPane.showMessageDialog(rootPane,"Masih ada data yang kosong, wajib diisi","Informasi",JOptionPane.WARNING_MESSAGE);
        } else {
         try {
             co.setIdorder(idorder);
             ResultSet rs = co.cekId();
             if (rs.next()) {
             }else{
                 co.setIdorder(idorder);
                 co.setNomeja(nomeja);
                 co.setTanggal(tanggal);
                 co.setKeterangan(keterangan);
                 co.setStatusorder(status);
                 co.simpandataorder();         
             }
         } catch (SQLException ex) {
             Logger.getLogger(Order.class.getName()).log(Level.SEVERE, null, ex);
         }
         co.setIdorder(idorder);
         co.setIdmasakan(idmasakan);
         co.setKeterangan(keterangan);
         co.setStatusorder(status);
         co.simpandatadetailorder();
       
             JOptionPane.showMessageDialog(rootPane,"Pesanan berhasil diinput","Sukses",JOptionPane.INFORMATION_MESSAGE);
         }
 }
 
 private void cari(){
     dt=(DefaultTableModel)tbmasakan.getModel();
     dt.setRowCount(0);
     cm.caridata(dt, txtsearch.getText().toString());
     tbmasakan.setModel(dt);
 }

}