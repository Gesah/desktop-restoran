/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restoranku;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import restoranku.Control_Transaksi;

/**
 *
 * @author ASUS-AMD01
 */
public class Transaksi extends javax.swing.JDialog {
    DefaultTableModel dt;
    Control_Transaksi ct;
    String idtrans, idorder, tanggal;
    double total,bayar,kem;
    
      //Currency Rupiah
    DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
    
    /**
     * Creates new form Transaksi
     */
    public Transaksi(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ct = new Control_Transaksi();
        txtidorder.setEnabled(false);
        tgl();
        reset();
        tampildata();
        txtsearch.requestFocus();
    
    //Currency Rupiah
    formatRp.setCurrencySymbol("Rp. ");
    formatRp.setMonetaryDecimalSeparator(',');
    formatRp.setGroupingSeparator('.');
    kursIndonesia.setDecimalFormatSymbols(formatRp);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdetailorder = new javax.swing.JTable();
        txtsearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtidorder = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbltotalbayar = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtjumlahbayar = new javax.swing.JTextField();
        lbltanggal = new javax.swing.JLabel();
        lblkembalian = new javax.swing.JLabel();
        kembalian = new javax.swing.JLabel();
        btnhitung = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        btnbayar = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Menu Transaksi");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        tbdetailorder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID Detail", "ID Order", "Nama Masakan", "Jumlah"
            }
        ));
        tbdetailorder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbdetailorderMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbdetailorder);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 620, -1));

        txtsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtsearchKeyReleased(evt);
            }
        });
        jPanel1.add(txtsearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 130, -1));

        jLabel2.setText("| Cari ID Order Anda ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 30));

        jLabel3.setText("Search");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, 30));
        jPanel1.add(txtidorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 200, 160, 30));

        jLabel4.setText("ID Order");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Total Bayar");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 300, -1, -1));

        lbltotalbayar.setText("-");
        jPanel1.add(lbltotalbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 350, -1, -1));

        jLabel8.setText("Rp");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 350, -1, -1));

        txtjumlahbayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtjumlahbayarKeyReleased(evt);
            }
        });
        jPanel1.add(txtjumlahbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 440, 160, 30));

        lbltanggal.setText("-");
        jPanel1.add(lbltanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 20, -1, -1));

        lblkembalian.setText("-");
        jPanel1.add(lblkembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 490, 120, -1));

        kembalian.setText("Kembalian");
        jPanel1.add(kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 490, -1, -1));

        btnhitung.setText("Hitung");
        btnhitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhitungActionPerformed(evt);
            }
        });
        jPanel1.add(btnhitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 560, 100, 40));

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanel1.add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 620, 100, 40));

        btnbayar.setText("Bayar");
        btnbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbayarActionPerformed(evt);
            }
        });
        jPanel1.add(btnbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 560, 100, 40));

        jLabel12.setText("Jumlah Bayar");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 410, -1, -1));

        jLabel13.setText("Tanggal :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, -1, -1));

        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 80, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 710));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbayarActionPerformed
        // TODO add your handling code here:
        simpandata();
    }//GEN-LAST:event_btnbayarActionPerformed

    private void btnhitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhitungActionPerformed
        // TODO add your handling code here:
         if (!txtjumlahbayar.getText().equalsIgnoreCase("")) {
            bayar = Double.parseDouble(txtjumlahbayar.getText());
            Double total = Double.parseDouble(lbltotalbayar.getText());
            kem = bayar-total;
            
            if (kem < 0) {
                kembalian.setVisible(false);
                lblkembalian.setText("Jumlah uang kurang");
                lblkembalian.setForeground(new java.awt.Color(255, 51, 51));
                btnbayar.setEnabled(false);
            }else{
                kembalian.setVisible(true);
                lblkembalian.setText(String.valueOf(+kem));
                lblkembalian.setText(kursIndonesia.format(kem));
                lblkembalian.setForeground(new java.awt.Color(0,0,0));
                btnbayar.setEnabled(true);

            }
        }
    }//GEN-LAST:event_btnhitungActionPerformed

    private void tbdetailorderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbdetailorderMouseClicked
        // TODO add your handling code here:
        txtjumlahbayar.setEnabled(true);
        txtjumlahbayar.requestFocus();
        txtidorder.setText(tbdetailorder.getValueAt(tbdetailorder.getSelectedRow(),1) .toString());
           total();
    }//GEN-LAST:event_tbdetailorderMouseClicked

    private void txtsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtsearchKeyReleased
        // TODO add your handling code here:
        tampildata();
    }//GEN-LAST:event_txtsearchKeyReleased

    private void txtjumlahbayarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtjumlahbayarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjumlahbayarKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        reset();
        tampildata();
    }//GEN-LAST:event_btnresetActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Transaksi dialog = new Transaksi(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnbayar;
    private javax.swing.JButton btnhitung;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kembalian;
    private javax.swing.JLabel lblkembalian;
    private javax.swing.JLabel lbltanggal;
    private javax.swing.JLabel lbltotalbayar;
    private javax.swing.JTable tbdetailorder;
    private javax.swing.JTextField txtidorder;
    private javax.swing.JTextField txtjumlahbayar;
    private javax.swing.JTextField txtsearch;
    // End of variables declaration//GEN-END:variables

 private void tgl() {
        lbltanggal.setText(new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date()));
    }

 private void cari(){
     dt=(DefaultTableModel)tbdetailorder.getModel();
     dt.setRowCount(0);
     ct.cari(dt, txtsearch.getText().toString());
     tbdetailorder.setModel(dt);
 }
 
 private void tampildata () {
    DefaultTableModel dtm = (DefaultTableModel) tbdetailorder.getModel();
    dtm.setRowCount(0);
    ct.tampildata(dtm);
    tbdetailorder.setModel(dtm);
}

 private void total() {
        try { 
            ResultSet rs = ct.total(tbdetailorder.getValueAt(tbdetailorder.getSelectedRow(), 1).toString());
            if (rs.next()) {
            
            lbltotalbayar.setText(rs.getObject("total").toString());
                
            }  
        } catch (SQLException ex) {
            Logger.getLogger(Transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 
 private void simpandata() {
     idorder = txtidorder.getText();
     tanggal = lbltanggal.getText();
     total = Double.parseDouble(lbltotalbayar.getText());
     ct.setIdOrder(idorder);
     ct.setTanggal(tanggal);
     ct.setTotal(total);
     ct.simpandata();
     JOptionPane.showMessageDialog(rootPane,"Pembayaran Berhasil!","Informasi",JOptionPane.INFORMATION_MESSAGE);
     btnbayar.setEnabled(false);
   }
 
 private void reset() {
     txtsearch.setText(null);
     txtidorder.setText(null);
     lbltotalbayar.setText(null);
     txtjumlahbayar.setText(null);
     txtjumlahbayar.setEnabled(false);
     lblkembalian.setText(null);
     btnbayar.setEnabled(false);
     txtsearch.requestFocus();
 }
}
