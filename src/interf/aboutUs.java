/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interf;

import java.util.Date;
import javax.swing.JFrame;

/**
 *
 * @author Rashmi Muthisnghe
 */
public class aboutUs extends javax.swing.JFrame {

    /**
     * Creates new form aboutUs
     */
    public aboutUs() {
        initComponents();
        setdate1();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void setdate1(){
        new Thread(new Runnable() {

            public void run() {
              //  throw new UnsupportedOperationException("Not supported yet.");
                
                while(true){
                    
                   Date d=new Date();
                   String date=d.toString();
                   String arr[]=date.split(" ");
                   String dd=arr[5]+"/"+arr[1]+"/"+arr[2];
                   lbldate.setText(dd);
                   
                   lbltime.setText(arr[3]);
                    
                }
            }
        }).start();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Button_home1 = new javax.swing.JButton();
        lbldate2 = new javax.swing.JLabel();
        lbldate11 = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ABOUT US");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Logo (1).png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 410, 310));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Contact Us");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Email:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("marvelsitsolution@gmail.com");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("0775325159");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blue-bg (1).jpg"))); // NOI18N
        jLabel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 430, 620, 230));

        Button_home1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_home1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home-icon (1).png"))); // NOI18N
        Button_home1.setText("Menu");
        Button_home1.setToolTipText("Go to Menu");
        Button_home1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        Button_home1.setBorderPainted(false);
        Button_home1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_home1ActionPerformed(evt);
            }
        });
        getContentPane().add(Button_home1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 50, 140, 50));

        lbldate2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate2.setForeground(new java.awt.Color(255, 255, 255));
        lbldate2.setText("Date :");
        getContentPane().add(lbldate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, -1, -1));

        lbldate11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate11.setForeground(new java.awt.Color(255, 255, 255));
        lbldate11.setText("Time :");
        getContentPane().add(lbldate11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        lbltime.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbltime.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 140, 30));

        lbldate.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 140, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blue-bg (2).jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1390, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_home1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_home1ActionPerformed
        main m = new main();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Button_home1ActionPerformed

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
            java.util.logging.Logger.getLogger(aboutUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aboutUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aboutUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aboutUs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new aboutUs().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_home1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbldate11;
    private javax.swing.JLabel lbldate2;
    private javax.swing.JLabel lbltime;
    // End of variables declaration//GEN-END:variables
}