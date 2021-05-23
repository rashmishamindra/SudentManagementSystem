/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interf;

import connection.DBConnect;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Rashmi Muthisnghe
 */
public class branchU extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    /**
     * Creates new form branch
     */
    public branchU() {
        initComponents();
        conn = DBConnect.connect();
        generateBID();
        clear();
        updateTable();
        setdate1();
        
        // size of jfram
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
    private void updateTable(){
        String sql = "select bId AS ID, place AS Place, CONCAT(no,' ',street1,' ',street2,' ',city) AS Address, tp AS Telephone_No from branch";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Table_branch.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    private void clear() {
       try{
       TextField_place.setText("");
       TextField_phone.setText("");
       TextField_no.setText("");
       TextField_s1.setText("");
       TextField_s2.setText("");
       TextField_city.setText("");
       
       }
       catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    
     public void generateBID(){
        try 
        {
            String sql = "SELECT MAX(right(bId,2)) as s from branch";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                if(rs.first()== false){
                    TextField_bid.setText("B_001");
                }
                else{
                    rs.last();
                    int id = rs.getInt(1)+1;
                    String s = String.valueOf(id);
                    int no = s.length();
                    for(int a=0; a<3-no; a++ ){
                       s = "0"+s;
                      
                    }
                    TextField_bid.setText("B_"+s);
                }
            }
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
        jButton1 = new javax.swing.JButton();
        Button_update = new javax.swing.JButton();
        Button_delete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_branch = new javax.swing.JTable();
        TextField_search = new javax.swing.JTextField();
        Button_search = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        Button_home = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TextField_no = new javax.swing.JTextField();
        TextField_s1 = new javax.swing.JTextField();
        TextField_s2 = new javax.swing.JTextField();
        TextField_city = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextField_place = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        TextField_phone = new javax.swing.JTextField();
        TextField_bid = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        lbldate2 = new javax.swing.JLabel();
        lbldate11 = new javax.swing.JLabel();
        lbltime = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DMIMS");
        setMinimumSize(new java.awt.Dimension(1385, 754));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BRANCHES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (3).png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 609, 154, 53));

        Button_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (2).png"))); // NOI18N
        Button_update.setText("Update");
        Button_update.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        Button_update.setBorderPainted(false);
        Button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_updateActionPerformed(evt);
            }
        });
        getContentPane().add(Button_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 610, 154, 54));

        Button_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete (1).png"))); // NOI18N
        Button_delete.setText("Delete");
        Button_delete.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        Button_delete.setBorderPainted(false);
        Button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(Button_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 610, 154, 50));

        Table_branch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Table_branch.setToolTipText("Branch Details");
        Table_branch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_branchMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_branch);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(841, 240, 467, 310));
        getContentPane().add(TextField_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(841, 187, 300, -1));

        Button_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (4).png"))); // NOI18N
        Button_search.setText("Search");
        Button_search.setToolTipText("Search Branch Details");
        Button_search.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        Button_search.setBorderPainted(false);
        Button_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_searchActionPerformed(evt);
            }
        });
        getContentPane().add(Button_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(1154, 169, 154, 53));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 141, 1233, 10));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (1).png"))); // NOI18N
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1270, 60, 43, 53));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Key_30px.png"))); // NOI18N
        jButton8.setText("Log Out");
        jButton8.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1100, 60, 154, 53));

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
        getContentPane().add(Button_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 60, 154, 53));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 3, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Street2");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(298, 23, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Street1");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 23, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("No");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 23, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("City");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 23, -1, -1));
        jPanel1.add(TextField_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 21, 71, -1));
        jPanel1.add(TextField_s1, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 21, 103, -1));
        jPanel1.add(TextField_s2, new org.netbeans.lib.awtextra.AbsoluteConstraints(355, 21, 90, -1));
        jPanel1.add(TextField_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 21, 92, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blue-bg (1).jpg"))); // NOI18N
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 60));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 620, 60));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Phone");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Address");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));
        jPanel2.add(TextField_place, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 184, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Branch ID");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Place");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        TextField_phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextField_phoneKeyTyped(evt);
            }
        });
        jPanel2.add(TextField_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 184, -1));

        TextField_bid.setEditable(false);
        jPanel2.add(TextField_bid, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 184, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blue-bg (2).jpg"))); // NOI18N
        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 5, true));
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 370));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(75, 190, 710, 370));

        lbldate2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate2.setForeground(new java.awt.Color(255, 255, 255));
        lbldate2.setText("Date :");
        getContentPane().add(lbldate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, -1, -1));

        lbldate11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate11.setForeground(new java.awt.Color(255, 255, 255));
        lbldate11.setText("Time :");
        getContentPane().add(lbldate11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, -1, -1));

        lbltime.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbltime.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 140, 30));

        lbldate.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 140, 30));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blue-bg (2).jpg"))); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    try
        {  
          String sql = "Insert into branch(bid, place, no, street1, street2, city, tp) values (?,?,?,?,?,?,?)";
          
          pst = conn.prepareStatement(sql);
          pst.setString(1,TextField_bid.getText() );
          pst.setString(2,TextField_place.getText() );
          pst.setString(3,TextField_no.getText() );
          pst.setString(4,TextField_s1.getText() );
          pst.setString(5,TextField_s2.getText() );
          pst.setString(6,TextField_city.getText() );
          pst.setString(7,TextField_phone.getText() );
            
          pst.execute();
          
          JOptionPane.showMessageDialog(null, "Add Successful");
                updateTable();
                generateBID();
                
                clear();
                
                
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Table_branchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_branchMouseClicked
        try{
           int row = Table_branch.getSelectedRow();
           String table_click = (Table_branch.getModel().getValueAt(row, 0).toString());
           String sql = "select * from branch where bId='"+table_click+"'";
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
           
           if(rs.next()){
               String add1 = rs.getString("bId");
               TextField_bid.setText(add1);
               String add2 = rs.getString("place");
               TextField_place.setText(add2);
               String add3 = rs.getString("no");
               TextField_no.setText(add3);
               String add4 = rs.getString("street1");
               TextField_s1.setText(add4);
               String add5 = rs.getString("street2");
               TextField_s2.setText(add5);
               String add6 = rs.getString("city");
               TextField_city.setText(add6);
               String add7 = rs.getString("tp");
               TextField_phone.setText(add7);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_Table_branchMouseClicked

    private void Button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_updateActionPerformed
        int x1 = JOptionPane.showConfirmDialog(null, "Do you want to update this...");
       if(x1==0)
        {
        try{
            
           String value1 = TextField_bid.getText();
           String value2 = TextField_place.getText();
           String value3 = TextField_no.getText();
           String value4 = TextField_s1.getText();
           String value5 = TextField_s2.getText();
           String value6 = TextField_city.getText();
           String value7 = TextField_phone.getText();
           
           String sql = "update branch set place='"+value2+"', no='"+value3+"', street1='"+value4+"', street2='"+value5+"', city='"+value6+"', tp='"+value7+"' where bId='"+value1+"'";
           pst = conn.prepareStatement(sql);
           pst.execute();
           
           JOptionPane.showMessageDialog(null, "Update Successful");
               updateTable();

               generateBID();
               
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
            String sql = "delete from branch where bId=?";

            try{
               pst = conn.prepareStatement(sql);
               pst.setString(1, TextField_bid.getText());
               pst.execute();
               JOptionPane.showMessageDialog(null, "Delete Successful");
               updateTable();

               generateBID();
               
                clear();
               
               
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_Button_deleteActionPerformed

    private void Button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_searchActionPerformed
        String s = TextField_search.getText();
        String sql = "SELECT * FROM branch WHERE bId LIKE '%"+s+"%'OR place LIKE '%"+s+"%' ";
        
        try{
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        Table_branch.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
          System.out.print("Exception is trows "+ e);
      }
    }//GEN-LAST:event_Button_searchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        login l = new login();
        l.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void Button_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_homeActionPerformed
        mainU m = new mainU();
        m.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Button_homeActionPerformed

    private void TextField_phoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_phoneKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))&& (caracter != '\b')) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "Cannot Input Characters!");
        }
        if (TextField_phone.getText().length() == 10 ){ // limit textfield to 10 characters
            evt.consume(); 
        } 
    }//GEN-LAST:event_TextField_phoneKeyTyped

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
            java.util.logging.Logger.getLogger(branchU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(branchU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(branchU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(branchU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new branchU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_delete;
    private javax.swing.JButton Button_home;
    private javax.swing.JButton Button_search;
    private javax.swing.JButton Button_update;
    private javax.swing.JTable Table_branch;
    private javax.swing.JTextField TextField_bid;
    private javax.swing.JTextField TextField_city;
    private javax.swing.JTextField TextField_no;
    private javax.swing.JTextField TextField_phone;
    private javax.swing.JTextField TextField_place;
    private javax.swing.JTextField TextField_s1;
    private javax.swing.JTextField TextField_s2;
    private javax.swing.JTextField TextField_search;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbldate11;
    private javax.swing.JLabel lbldate2;
    private javax.swing.JLabel lbltime;
    // End of variables declaration//GEN-END:variables
}
