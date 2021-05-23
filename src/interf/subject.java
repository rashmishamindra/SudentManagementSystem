/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interf;

import connection.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Rashmi Muthisnghe
 */
public class subject extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    //String id;
    /**
     * Creates new form subject
     */
    public subject() {
        initComponents();
        conn = DBConnect.connect();
        generateSubjectID();
        clear();
        fillList();
        setdate();
      //  id = "";
       
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
    
    private void fillList(){
        DefaultListModel m = new DefaultListModel();
       
        try{
            String sql = "SELECT * FROM subject";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String subject = rs.getString("subject");
                //ComboBox_sub.addItem(subject);
                m.addElement(subject);
            }
            List_subject.setModel(m);
        }
        catch(Exception e){
          System.out.print("Exception is trows "+ e);
        }
    }
    
    private void clear() {
       TextField_subject.setText("");
    }
    
    public void generateSubjectID(){
        try 
        {
            String sql = "SELECT MAX(right(subNo,2)) as s from subject";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                if(rs.first()== false){
                    TextField_subId.setText("Sub_001");
                }
                else{
                    rs.last();
                    int id = rs.getInt(1)+1;
                    String s = String.valueOf(id);
                    int no = s.length();
                    for(int a=0; a<3-no; a++ ){
                       s = "0"+s;
                      
                    }
                    TextField_subId.setText("Sub_"+s);
                }
            }
            
//            String qry = "SELECT MAX(subNo) as s from subject";
//            pst = conn.prepareStatement(qry);
//            rs = pst.executeQuery();
//            String id;
//            if(rs.next()){
//                String r1 = rs.getString("s");
//                int ln = r1.length();
//                String stxt = r1.substring(0,4);
//                String snum = r1.substring(4,ln);
//                int n = Integer.parseInt(snum);
//                n++;
//                snum = Integer.toString(n);
//                id = stxt+snum;
//                TextField_subId.setText(id);
//            }
//            else{
//                id = "Sub_00001";
//                TextField_subId.setText(id);
//            }
            
//            Statement s=conn.createStatement();
//            ResultSet rs=s.executeQuery("SELECT count(subNo) as ssss FROM subject");
//            while(rs.next()){
//                
//                int count = rs.getInt("ssss");
//                ++count;
//                
//                int id = count;
//                TextField_subId.setText(String.valueOf("Sub_"+id));
//            }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
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
        Button_save = new javax.swing.JButton();
        Button_delete = new javax.swing.JButton();
        Button_update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        List_subject = new javax.swing.JList<>();
        Button_home = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TextField_subId = new javax.swing.JTextField();
        TextField_subject = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbldate2 = new javax.swing.JLabel();
        lbldate11 = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DMIMS");
        setMinimumSize(new java.awt.Dimension(1385, 754));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SUBJECTS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, -1, -1));

        Button_save.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (3).png"))); // NOI18N
        Button_save.setText("Save");
        Button_save.setToolTipText("Add New Subject");
        Button_save.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        Button_save.setBorderPainted(false);
        Button_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_saveActionPerformed(evt);
            }
        });
        getContentPane().add(Button_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 141, 46));

        Button_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete (1).png"))); // NOI18N
        Button_delete.setText("Delete");
        Button_delete.setToolTipText("Delete Subject");
        Button_delete.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        Button_delete.setBorderPainted(false);
        Button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(Button_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 520, 136, 46));

        Button_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (2).png"))); // NOI18N
        Button_update.setText("Edit");
        Button_update.setToolTipText("Edit subject name");
        Button_update.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        Button_update.setBorderPainted(false);
        Button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_updateActionPerformed(evt);
            }
        });
        getContentPane().add(Button_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 520, 144, 46));

        List_subject.setToolTipText("Subjects");
        List_subject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                List_subjectMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(List_subject);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 240, 190, 320));

        Button_home.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home-icon (1).png"))); // NOI18N
        Button_home.setText("Menu");
        Button_home.setToolTipText("Go to Menu");
        Button_home.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        Button_home.setBorderPainted(false);
        Button_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_homeActionPerformed(evt);
            }
        });
        getContentPane().add(Button_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 50, 163, 46));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Key_30px.png"))); // NOI18N
        jButton8.setText("Log Out");
        jButton8.setToolTipText("Log Out");
        jButton8.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 50, 159, 46));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (1).png"))); // NOI18N
        jButton2.setToolTipText("Close This");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 50, 43, 46));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 118, 1276, 10));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Subject Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        TextField_subId.setEditable(false);
        jPanel1.add(TextField_subId, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 270, -1));
        jPanel1.add(TextField_subject, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 270, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Subject");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blue-bg (2).jpg"))); // NOI18N
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 240));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 510, 240));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/book_stack (1).png"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 380, 430));

        lbldate2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate2.setForeground(new java.awt.Color(255, 255, 255));
        lbldate2.setText("Date :");
        getContentPane().add(lbldate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        lbldate11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate11.setForeground(new java.awt.Color(255, 255, 255));
        lbldate11.setText("Time :");
        getContentPane().add(lbldate11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        lbltime.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbltime.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 140, 30));

        lbldate.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 140, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blue-bg (2).jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1380, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Button_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_saveActionPerformed
        try
        {  
            String sql = "Insert into subject(SubNo, subject) values (?,?)";

            pst = conn.prepareStatement(sql);
            pst.setString(1,TextField_subId.getText() );
            pst.setString(2,TextField_subject.getText() );         
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Save Successful");
                fillList();
                generateSubjectID();
                clear();
                
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_Button_saveActionPerformed

    private void List_subjectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_List_subjectMouseClicked
        String tmp = (String)List_subject.getSelectedValue();
        String sql = "Select * from subject where subject=?";
        try
        {  
            pst = conn.prepareStatement(sql);
            pst.setString(1, tmp);
            rs = pst.executeQuery();
            if(rs.next()){
                String add1 = rs.getString("SubNo");
                TextField_subId.setText(add1);
                String add2 = rs.getString("subject");
                TextField_subject.setText(add2);
              
            }
                
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_List_subjectMouseClicked

    private void Button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_updateActionPerformed
        int x1 = JOptionPane.showConfirmDialog(null, "Do you want to update this...");
        if(x1==0)
        {
            try{
            
                String value1 = TextField_subId.getText();
                String value2 = TextField_subject.getText();
           
                String sql = "update subject set subject='"+value2+"' where subNo='"+value1+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
           
                JOptionPane.showMessageDialog(null, "Update Successful");
                fillList();

                generateSubjectID();
                clear();
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_Button_updateActionPerformed

    private void Button_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_deleteActionPerformed
        int x1 = JOptionPane.showConfirmDialog(null, "Do you want to delete this...");
        if(x1==0)
        {
            String sql = "delete from subject where subNo=?";

            try{
                pst = conn.prepareStatement(sql);
                pst.setString(1, TextField_subId.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Delete Successful");
                fillList();
                generateSubjectID();
                clear();
               
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_Button_deleteActionPerformed

    private void Button_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_homeActionPerformed
        main m = new main();
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
            java.util.logging.Logger.getLogger(subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(subject.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new subject().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_delete;
    private javax.swing.JButton Button_home;
    private javax.swing.JButton Button_save;
    private javax.swing.JButton Button_update;
    private javax.swing.JList<String> List_subject;
    private javax.swing.JTextField TextField_subId;
    private javax.swing.JTextField TextField_subject;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbldate11;
    private javax.swing.JLabel lbldate2;
    private javax.swing.JLabel lbltime;
    // End of variables declaration//GEN-END:variables
}
