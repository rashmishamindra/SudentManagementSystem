/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interf;

//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
//import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import connection.DBConnect;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Rashmi Muthisnghe
 */
public class classShedualU extends javax.swing.JFrame {

    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    ResultSet rs1 = null;
    PreparedStatement pst1 = null;
    ResultSet rs2 = null;
    PreparedStatement pst2 = null;
    ResultSet rs3 = null;
    PreparedStatement pst3 = null;
    
    /**
     * Creates new form classShedual
     */
    public classShedualU() {
        initComponents();
        conn = DBConnect.connect();
        generateClassID();
        fillcombo();
        updateTable();
        fillcombo_place();
        jLabel11.setVisible(false);
        jLabel12.setVisible(false);
        jLabel13.setVisible(false);
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
    
    private void clear() {
        try{
           ComboBox_sub.setSelectedItem("-SELECT-");
           ComboBox_teacher.setSelectedItem("-SELECT-");
           ComboBox_place.setSelectedItem("-SELECT-");
           ComboBox_grade.setSelectedItem("-SELECT-");
           ComboBox_day.setSelectedItem("-SELECT-");
           String time = "00:00:00";
           DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
           Date date = sdf.parse(time);
           TimeChooser_start.setTime(date);
           TimeChooser_end.setTime(date);
           TextField_price.setText("");
        }
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    private void updateTable(){
        String sql = "select classNo AS Class_ID, subject AS Subject_ID, Teacher AS Teacher_ID, place AS Branch_ID, grade AS Grade, day AS Day, stime AS Start_Time, etime AS End_Time, price AS Monthly_Fee from class";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            Table_class.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void generateClassID(){
        try 
        {
            String sql = "SELECT MAX(right(classNo,2)) as s from class";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                if(rs.first()== false){
                    TextField_cid.setText("C_00001");
                }
                else{
                    rs.last();
                    int id = rs.getInt(1)+1;
                    String s = String.valueOf(id);
                    int no = s.length();
                    for(int a=0; a<5-no; a++ ){
                       s = "0"+s;
                      
                    }
                    TextField_cid.setText("C_"+s);
                }
            }
        } 
        catch (Exception e) 
        {
            System.out.println(e);
        }
    }
    
    private void fillcombo(){
        String sql = "SELECT * FROM subject";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String subject = rs.getString("subject");
                ComboBox_sub.addItem(subject);
            }
        }
        catch(Exception e){
          System.out.print("Exception is trows "+ e);
        }
    }
    
    private void fillcombo_teacher(){
        String sub = jLabel11.getText();
        String sql = "SELECT CONCAT(fname,' ',lname) AS Name FROM teacher WHERE subject = '"+sub+"'";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String teacher = rs.getString("Name");
                ComboBox_teacher.addItem(teacher);
            }
        }
        catch(Exception e){
          System.out.print("Exception is trows "+ e);
        }
    }
    
    private void fillcombo_place(){
        String sql = "SELECT * FROM branch";
        try{
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            
            while(rs.next()){
                String place = rs.getString("place");
                ComboBox_place.addItem(place);
            }
        }
        catch(Exception e){
          System.out.print("Exception is trows "+ e);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        TextField_cid = new javax.swing.JTextField();
        ComboBox_sub = new javax.swing.JComboBox<>();
        ComboBox_teacher = new javax.swing.JComboBox<>();
        ComboBox_place = new javax.swing.JComboBox<>();
        ComboBox_day = new javax.swing.JComboBox<>();
        TextField_price = new javax.swing.JTextField();
        TimeChooser_start = new lu.tudor.santec.jtimechooser.JTimeChooser();
        TimeChooser_end = new lu.tudor.santec.jtimechooser.JTimeChooser();
        jButton1 = new javax.swing.JButton();
        Button_update = new javax.swing.JButton();
        Button_delete = new javax.swing.JButton();
        TextField_search = new javax.swing.JTextField();
        Button_search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_class = new javax.swing.JTable();
        ComboBox_grade = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        Button_home = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        lbltime = new javax.swing.JLabel();
        lbldate = new javax.swing.JLabel();
        lbldate2 = new javax.swing.JLabel();
        lbldate11 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DMIMS");
        setMinimumSize(new java.awt.Dimension(1385, 754));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CLASS SCHEDULER");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Class ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 137, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Teacher");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 233, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Subject");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 187, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Place");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 277, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Start Time");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(944, 190, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("End Time");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(944, 237, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Day");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(944, 137, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Monthly fee");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(944, 279, -1, -1));

        TextField_cid.setEditable(false);
        TextField_cid.setPreferredSize(new java.awt.Dimension(82, 20));
        TextField_cid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_cidActionPerformed(evt);
            }
        });
        getContentPane().add(TextField_cid, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 137, 233, 30));

        ComboBox_sub.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-" }));
        ComboBox_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_subActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBox_sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 187, 233, -1));

        ComboBox_teacher.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-" }));
        ComboBox_teacher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBox_teacherMouseClicked(evt);
            }
        });
        ComboBox_teacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_teacherActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBox_teacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 233, 233, -1));

        ComboBox_place.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-" }));
        ComboBox_place.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBox_placeMouseClicked(evt);
            }
        });
        ComboBox_place.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_placeActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBox_place, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 277, 233, -1));

        ComboBox_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        getContentPane().add(ComboBox_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(1068, 137, 235, -1));

        TextField_price.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TextField_priceKeyTyped(evt);
            }
        });
        getContentPane().add(TextField_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(1068, 279, 235, -1));
        getContentPane().add(TimeChooser_start, new org.netbeans.lib.awtextra.AbsoluteConstraints(1068, 187, 235, -1));
        getContentPane().add(TimeChooser_end, new org.netbeans.lib.awtextra.AbsoluteConstraints(1068, 234, 235, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (3).png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.setToolTipText("Save Class Details");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, 142, 47));

        Button_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (2).png"))); // NOI18N
        Button_update.setText("Update");
        Button_update.setToolTipText("Update Class Details");
        Button_update.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        Button_update.setBorderPainted(false);
        Button_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_updateActionPerformed(evt);
            }
        });
        getContentPane().add(Button_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 470, 142, 50));

        Button_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/delete (1).png"))); // NOI18N
        Button_delete.setText("Delete");
        Button_delete.setToolTipText("Delete Class Details");
        Button_delete.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        Button_delete.setBorderPainted(false);
        Button_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(Button_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 470, 142, 50));

        TextField_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextField_searchActionPerformed(evt);
            }
        });
        getContentPane().add(TextField_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 490, 355, -1));

        Button_search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (4).png"))); // NOI18N
        Button_search.setText("Search");
        Button_search.setToolTipText("Search Class Details");
        Button_search.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        Button_search.setBorderPainted(false);
        Button_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_searchActionPerformed(evt);
            }
        });
        getContentPane().add(Button_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 142, 51));

        Table_class.setModel(new javax.swing.table.DefaultTableModel(
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
        Table_class.setToolTipText("Class Details");
        Table_class.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_classMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table_class);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 537, 1245, 180));

        ComboBox_grade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-SELECT-", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" }));
        ComboBox_grade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox_gradeActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBox_grade, new org.netbeans.lib.awtextra.AbsoluteConstraints(607, 321, 233, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Grade");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 325, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 109, 1294, 10));

        Button_home.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Button_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home-icon (1).png"))); // NOI18N
        Button_home.setText("Menu");
        Button_home.setToolTipText("Go To Menu");
        Button_home.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        Button_home.setBorderPainted(false);
        Button_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Button_homeActionPerformed(evt);
            }
        });
        getContentPane().add(Button_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 30, 139, 50));

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
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 30, 147, 50));

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
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 30, 50, 50));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, 1270, 10));

        jLabel11.setText("jLabel11");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 190, -1, -1));

        jLabel12.setText("jLabel12");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 236, -1, -1));

        jLabel13.setText("jLabel13");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/classshedual (1).png"))); // NOI18N
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 330, 300));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loading-hi (1).png"))); // NOI18N
        jButton4.setText("Table Load");
        jButton4.setToolTipText("Table Load");
        jButton4.setAutoscrolls(true);
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.black, java.awt.Color.white));
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 470, 146, 50));

        lbltime.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbltime.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbltime, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 140, 30));

        lbldate.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(lbldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 140, 30));

        lbldate2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate2.setForeground(new java.awt.Color(255, 255, 255));
        lbldate2.setText("Date :");
        getContentPane().add(lbldate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        lbldate11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbldate11.setForeground(new java.awt.Color(255, 255, 255));
        lbldate11.setText("Time :");
        getContentPane().add(lbldate11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/blue-bg (2).jpg"))); // NOI18N
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1420, 830));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBox_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_subActionPerformed
        String sub = ComboBox_sub.getSelectedItem().toString();
        String sql = "SELECT `subNo` FROM `subject` WHERE subject='"+sub+"' ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString("subNo");
                jLabel11.setText(id);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(teacher.class.getName()).log(Level.SEVERE, null, ex);
        }

        fillcombo_teacher();
        
        ComboBox_teacher.removeAllItems();
        fillcombo_teacher();
    }//GEN-LAST:event_ComboBox_subActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {  
          String sql = "Insert into class(classNo, subject, Teacher, place, grade, day, stime, etime, price ) values (?,?,?,?,?,?,?,?,?)";
          
          pst = conn.prepareStatement(sql);
          pst.setString(1,TextField_cid.getText() );
          pst.setString(2,jLabel11.getText() );
          pst.setString(3,jLabel12.getText());
          pst.setString(4,jLabel13.getText());
          pst.setString(5,ComboBox_grade.getSelectedItem().toString() );
          pst.setString(6,ComboBox_day.getSelectedItem().toString() );
          pst.setString(7,TimeChooser_start.getFormatedTime() );
          pst.setString(8,TimeChooser_end.getFormatedTime() );
          pst.setString(9,TextField_price.getText() );         
          pst.execute();
          
          JOptionPane.showMessageDialog(null, "Save Successful");
                updateTable();
                generateClassID();
                
                clear();
                
                
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void Table_classMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_classMouseClicked
         try{
           int row = Table_class.getSelectedRow();
           String table_click = (Table_class.getModel().getValueAt(row, 0).toString());
           String sql = "select * from class where classNo='"+table_click+"'";
           pst = conn.prepareStatement(sql);
           rs = pst.executeQuery();
           
           if(rs.next()){
               String add1 = rs.getString("classNo");
               TextField_cid.setText(add1);
               try{
                String add2 = rs.getString("subject");
                jLabel11.setText(add2);
                String sql1 = "SELECT `subject` FROM `subject` WHERE `subNo`='"+add2+"'";
                pst1 = conn.prepareStatement(sql1);
                rs1 = pst1.executeQuery();
                while(rs1.next()){
                    String sub = rs1.getString("subject");
                    ComboBox_sub.setSelectedItem(sub);
                }
                }catch(Exception e){
                    System.out.println(e);
                }
               
                try{
                String add3 = (Table_class.getModel().getValueAt(row, 2).toString());
                jLabel12.setText(add3);
                String sql2 = "SELECT `fname` FROM `teacher` WHERE `tno`='"+add3+"'";
                pst2 = conn.prepareStatement(sql2);
                rs2 = pst2.executeQuery();
                while(rs2.next()){
                    String teacher = rs2.getString("fname");
                    ComboBox_teacher.setSelectedItem(teacher);
                }
                }catch(Exception e){
                    System.out.println(e);
                }
               
                try{
                String add4 = (Table_class.getModel().getValueAt(row, 3).toString());
                jLabel13.setText(add4);
                String sql3 = "SELECT `place` FROM `branch` WHERE `bId`='"+add4+"'";
                pst3 = conn.prepareStatement(sql3);
                rs3 = pst3.executeQuery();
                while(rs3.next()){
                    String place = rs3.getString("place");
                    ComboBox_place.setSelectedItem(place);
                }
                }catch(Exception e){
                    System.out.println(e);
                }
                              
//               String add4 = (Table_class.getModel().getValueAt(row, 3).toString());
//               ComboBox_place.setSelectedItem(add4);
               String add5 = (Table_class.getModel().getValueAt(row, 4).toString());
               ComboBox_grade.setSelectedItem(add5);
               String add6 = (Table_class.getModel().getValueAt(row, 5).toString());
               ComboBox_day.setSelectedItem(add6);  
               String add7 = (Table_class.getModel().getValueAt(row, 6).toString());
               DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
               Date date = sdf.parse(add7);
               TimeChooser_start.setTime(date);
               String add8 = (Table_class.getModel().getValueAt(row, 7).toString());
               Date date1 = sdf.parse(add8);
               TimeChooser_end.setTime(date1);
               String add9 = (Table_class.getModel().getValueAt(row, 8).toString());
               TextField_price.setText(add9);
              
           }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_Table_classMouseClicked

    private void Button_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_updateActionPerformed
         int x1 = JOptionPane.showConfirmDialog(null, "Do you want to update this...");
       if(x1==0)
        {
        try{
            
           String value1 = TextField_cid.getText();
           String value2 = jLabel11.getText();
           String value3 = jLabel12.getText();
           String value4 = jLabel13.getText();
           String value5 = ComboBox_grade.getSelectedItem().toString();
           String value6 = ComboBox_day.getSelectedItem().toString();
           String value7 = TimeChooser_start.getFormatedTime();
           String value8 = TimeChooser_end.getFormatedTime();
           String value9 = TextField_price.getText();
           
           String sql = "update class set subject='"+value2+"', Teacher='"+value3+"', place='"+value4+"', grade='"+value5+"', day='"+value6+"', stime='"+value7+"', etime='"+value8+"', price='"+value9+"' where classNo='"+value1+"'";
           pst = conn.prepareStatement(sql);
           pst.execute();
           
           JOptionPane.showMessageDialog(null, "Update Successful");
               updateTable();

               generateClassID();
               
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
            String sql = "delete from class where classNo=?";

            try{
               pst = conn.prepareStatement(sql);
               pst.setString(1, TextField_cid.getText());
               pst.execute();
               JOptionPane.showMessageDialog(null, "Delete Successful");
               updateTable();

               generateClassID();
               
                clear();
               
               
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_Button_deleteActionPerformed

    private void Button_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Button_searchActionPerformed
        String s = TextField_search.getText();
        String sql = "SELECT * FROM class WHERE classNo LIKE '%"+s+"%'OR subject LIKE '%"+s+"%' OR Teacher LIKE '%"+s+"%' OR grade LIKE '%"+s+"%' OR place LIKE '%"+s+"%'  ";
        
        try{
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        Table_class.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
          System.out.print("Exception is trows "+ e);
      }
        
    }//GEN-LAST:event_Button_searchActionPerformed

    private void TextField_cidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_cidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_cidActionPerformed

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

    private void TextField_priceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextField_priceKeyTyped
        
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9') )&& (caracter != '.')&& (caracter != '\b')) 
        {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(rootPane, "Cannot Input letters!");
        }
    }//GEN-LAST:event_TextField_priceKeyTyped

    private void TextField_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextField_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextField_searchActionPerformed

    private void ComboBox_teacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_teacherActionPerformed
        
    }//GEN-LAST:event_ComboBox_teacherActionPerformed

    private void ComboBox_teacherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBox_teacherMouseClicked
        String teacher = ComboBox_teacher.getSelectedItem().toString();
        String sql = "SELECT `tNo` FROM `teacher` WHERE CONCAT(fname,' ',lname)='"+teacher+"' ";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString("tNo");
                jLabel12.setText(id);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ComboBox_teacherMouseClicked

    private void ComboBox_placeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBox_placeMouseClicked
        
    }//GEN-LAST:event_ComboBox_placeMouseClicked

    private void ComboBox_placeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_placeActionPerformed
        String place = ComboBox_place.getSelectedItem().toString();
        String sql = "SELECT bId FROM `branch` WHERE `place`='"+place+"'";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while(rs.next()){
                String id = rs.getString("bId");
                jLabel13.setText(id);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ComboBox_placeActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        updateTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ComboBox_gradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox_gradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox_gradeActionPerformed

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
            java.util.logging.Logger.getLogger(classShedualU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(classShedualU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(classShedualU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(classShedualU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new classShedualU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Button_delete;
    private javax.swing.JButton Button_home;
    private javax.swing.JButton Button_search;
    private javax.swing.JButton Button_update;
    private javax.swing.JComboBox<String> ComboBox_day;
    private javax.swing.JComboBox<String> ComboBox_grade;
    private javax.swing.JComboBox<String> ComboBox_place;
    private javax.swing.JComboBox<String> ComboBox_sub;
    private javax.swing.JComboBox<String> ComboBox_teacher;
    private javax.swing.JTable Table_class;
    private javax.swing.JTextField TextField_cid;
    private javax.swing.JTextField TextField_price;
    private javax.swing.JTextField TextField_search;
    private lu.tudor.santec.jtimechooser.JTimeChooser TimeChooser_end;
    private lu.tudor.santec.jtimechooser.JTimeChooser TimeChooser_start;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbldate;
    private javax.swing.JLabel lbldate11;
    private javax.swing.JLabel lbldate2;
    private javax.swing.JLabel lbltime;
    // End of variables declaration//GEN-END:variables
}
