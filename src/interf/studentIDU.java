/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interf;

import com.lowagie.text.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Rashmi Muthisnghe
 */
public class studentIDU extends javax.swing.JFrame {

    /**
     * Creates new form studentID
     */
    public studentIDU() {
        initComponents();
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd ");
        Date date = new Date();
        jLabel4.setText(dateFormat.format(date));
        setdate();
        // size of jfram
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void setdate(){
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
    
     public PageFormat getPageFormat(PrinterJob pj)
    {
        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();
        
        double middleHeight = 8.0;
        double headerHeight = 2.0;
        double footerHeight = 2.0;
        double width = convert_CM_TO_PPI(18);
        double height = convert_CM_TO_PPI(headerHeight+middleHeight+footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(0, 10, width, height-convert_CM_TO_PPI(1));
        
        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);
        
        return pf;
    }
    
    protected static double convert_CM_TO_PPI(double cm)
    {
        return toPPI(cm*0.393600787);
    }
    
    protected static double toPPI(double inch)
    {
        return inch*72d;
    }

    
    public class BillPrintable implements Printable {
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex)throws PrinterException
    {
        int result = NO_SUCH_PAGE;
        if (pageIndex==0)
        {
            Graphics2D g2d = (Graphics2D) graphics;
            double width = pageFormat.getImageableWidth();
            g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
          FontMetrics metrics=g2d.getFontMetrics(new java.awt.Font("Arial",java.awt.Font.BOLD,7));
            int idLength = metrics.stringWidth("000");
            int amtLength = metrics.stringWidth("00000");
            int qtyLength = metrics.stringWidth("00000");
            int priceLength = metrics.stringWidth("00000");
            int prodLength = (int)width - idLength -amtLength- qtyLength -  priceLength - 17 ;
        
            int productPosition = 0;
            int discountPosition= prodLength+5;
            int pricePosition = discountPosition +idLength+10;
            int qtyPosition=pricePosition + priceLength + 4;
            int amtPosition=qtyPosition + qtyLength;
            
            try{
            /*Draw Header*/
            int y=30;
            int yShift = 20;
            int headerRectHeight=10;
            int headerRectHeighta=40;
            
            ///////////////// Product names Get ///////////
                
                String date=jLabel4.getText();
                String name=jTextField1.getText();
                
            ///////////////// Product names Get ///////////
                
            
            ///////////////// Product price Get ///////////
//                int pp1a=Integer.valueOf(pp1.getText());
//                int pp2a=Integer.valueOf(pp2.getText());
//                int pp3a=Integer.valueOf(pp3.getText());
//                int pp4a=Integer.valueOf(pp4.getText());
//                int sum=pp1a+pp2a+pp3a+pp4a;
            ///////////////// Product price Get ///////////
                
             g2d.setFont(new java.awt.Font("Monospaced",java.awt.Font.BOLD,9));
            g2d.drawString("----------------------------------------------------",12,y);y+=yShift;
            g2d.drawString("----------------------------------------------------",12,y);y+=yShift;
            g2d.drawString("             Student Registration Form              ",12,y);y+=yShift;
            g2d.drawString("----------------------------------------------------",12,y);y+=headerRectHeight;
            g2d.drawString("----------------------------------------------------",12,y);y+=headerRectHeight;
      
            g2d.drawString("                                                    ",10,y);y+=yShift;
            g2d.drawString("              DHAHAM MAWATHA INSTITUTE              ",10,y);y+=yShift;
            g2d.drawString("----------------------------------------------------",10,y);y+=headerRectHeight;
            g2d.drawString("        Name                      "+name+"          ",10,y);y+=yShift;
            g2d.drawString("        Registered Date           "+date+"          ",10,y);y+=yShift;
            g2d.drawString("----------------------------------------------------",10,y);y+=yShift;
            g2d.drawString("                     Contact Us                     ",10,y);y+=yShift;
            g2d.drawString("                     071-4923391                    ",10,y);y+=yShift;
            g2d.drawString("****************************************************",10,y);y+=yShift;
            g2d.drawString("****************************************************",10,y);y+=yShift;
                   
           
             
           
            
//            g2d.setFont(new Font("Monospaced",Font.BOLD,10));
//            g2d.drawString("Customer Shopping Invoice", 30,y);y+=yShift; 
          

    }
    catch(Exception r){
    r.printStackTrace();
    }
             result = PAGE_EXISTS; 
    } 
        return result;  
    }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Button_home = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbldate2 = new javax.swing.JLabel();
        lbldate11 = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DMIMS");
        setMinimumSize(new java.awt.Dimension(1385, 754));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORM");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 80, -1, 50));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Student Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 68, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 68, 244, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registered Date");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 125, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(314, 128, 244, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/printer (1).png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 203, 153, 52));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blue-bg (1).jpg"))); // NOI18N
        jLabel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 310));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 250, 630, 310));

        Button_home.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home-icon (1).png"))); // NOI18N
        Button_home.setText("Menu");
        Button_home.setToolTipText("Go to menu");
        Button_home.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), java.awt.Color.white));
        Button_home.setBorderPainted(false);
        Button_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_homeActionPerformed(evt);
            }
        });
        getContentPane().add(Button_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 146, 53));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Key_30px.png"))); // NOI18N
        jButton8.setText("Log Out");
        jButton8.setToolTipText("Go to login form");
        jButton8.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), java.awt.Color.white));
        jButton8.setBorderPainted(false);
        jButton8.setMaximumSize(new java.awt.Dimension(87, 45));
        jButton8.setMinimumSize(new java.awt.Dimension(87, 45));
        jButton8.setPreferredSize(new java.awt.Dimension(87, 45));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 50, 146, 53));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (1).png"))); // NOI18N
        jButton2.setToolTipText("Close this");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), java.awt.Color.white));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 50, 53, 53));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 1290, 10));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Untitled.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 500, 390));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("STUDENT REGISTRATION ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, 50));

        lbldate2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate2.setForeground(new java.awt.Color(255, 255, 255));
        lbldate2.setText("Date :");
        getContentPane().add(lbldate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        lbldate11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate11.setForeground(new java.awt.Color(255, 255, 255));
        lbldate11.setText("Time :");
        getContentPane().add(lbldate11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        lbldate.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 140, 30));

        lbltime.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbltime.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 140, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blue-bg (2).jpg"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PrinterJob pj = PrinterJob.getPrinterJob();        
        pj.setPrintable(new BillPrintable(),getPageFormat(pj));
        try {
             pj.print();
             JOptionPane.showMessageDialog(null, "Saved Successful");
          
        }
         catch (PrinterException ex) {
                 ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Button_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_homeActionPerformed
        mainU m = new mainU();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Button_homeActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        login l = new login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(studentIDU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(studentIDU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(studentIDU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(studentIDU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new studentIDU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbldate11;
    private javax.swing.JLabel lbldate2;
    private javax.swing.JLabel lbltime;
    // End of variables declaration//GEN-END:variables
}
