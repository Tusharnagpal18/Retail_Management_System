
import static java.lang.reflect.Array.set;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.lang.String;
import java.util.Date;
import java.util.StringJoiner;
import javax.swing.JOptionPane;
import java.util.StringTokenizer;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

 
public class autoid extends javax.swing.JFrame {
      
    /**
     * Creates new form autoid
     */
    public autoid() {
        initComponents();
//        autoid();
insertserno();

//  autoid("select count(id)+1 from AutoId");
    
    }
    
    
   


     
//    private void autonId()
//     {
//         try {
//             
//             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            //
//            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
//            java.sql.Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:49949;databaseName=Retailmgt","sa","bds123");
//              String tushar="SELECT id FROM AutoID ORDER BY id DESC LIMIT 1";
//            
//            PreparedStatement pst=con.prepareStatement(tushar);
//            ResultSet rs=pst.executeQuery();
////         String sql="SELECT id FROM AutoID ORDER BY id DESC LIMIT 1";        
////         PreparedStatement  pst=conn.prepareStatement(sql);
////         ResultSet rs=pst.executeQuery();
//       if(rs.next())
//       {
//            String rnno=rs.getString("id");
//            int co=rnno.length();
//           String txt= rnno.substring(0, 2);
//           String num=rnno.substring(2, co);
//           int n=Integer.parseInt(num);
//           n++;
//           String snum=Integer.toString(n);
//           String ftxt=txt+snum;
//           txtautoid.setText(ftxt);
//
//       }
//       else
//       {
//           txtautoid.setText("MI1000");
//       }
//
//
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(rootPane, e);
//    }
//
//}
    int getValue;
    public void add()
    {
        insertserno();
    }
    
    public void autoid(String PassQuery)
    {
        try{
        
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            java.sql.Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:49949;databaseName=Retailmgt","sa","bds123");
//            String sql="select item_id  from m_item";
            Statement pst=con.createStatement();
            java.sql.ResultSet rs=pst.executeQuery(PassQuery);
            
          if(rs.next())
          {
              getValue=Integer.parseInt(rs.getString(1));
          }
        }
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    
        }
 
    }
    
    
    public void insertserno()
    {   autoid("select count(item_id)+1 from m_item");
    
//        String insertdata="insert into AutoId(id) values (?)";
        
        try{
        
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
//               String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            java.sql.Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:49949;databaseName=Retailmgt","sa","bds123");
//            String sql="select item_id  from m_item";
             String inv="1000"+getValue;
             txtautoid.setText(inv);
//             Statement st=con.createStatement() ;
//             PreparedStatement pst=con.prepareStatement(insertdata);
//             pst.setString(1, inv);
//             pst.setString(2,autonm.getText());
//             pst.execute();
             System.out.println("abc");
//            java.sql.ResultSet rs=pst.executeQuery(PassQuery);
             
            
          
        }
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    
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
        txtautoid = new javax.swing.JTextField();
        autonm = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Id");

        txtautoid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtautoidActionPerformed(evt);
            }
        });

        autonm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autonmActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtautoid, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(autonm, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtautoid, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(autonm, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(35, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(27, 27, 27))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtautoidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtautoidActionPerformed

        // TODO add your handling code here:
//          autoid("select count(id)+1 from AutoId");
    
    }//GEN-LAST:event_txtautoidActionPerformed

    private void autonmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autonmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_autonmActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String s1=txtautoid.getText();
        String s2=autonm.getText();
        
                try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            java.sql.Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:49949;databaseName=Retailmgt","sa","bds123");
              String tushar="insert into m_item values(?,?)";
            
            PreparedStatement pst=con.prepareStatement(tushar);
            pst.setString(1,s1);
            pst.setString(2,s2);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "inserted successfully!");
            
        } catch (Exception e) {
            
        }
//        id.setText("");
//        grpdesc.setText("");
       
    
        
        // TODO add your handling code here:
//        insertserno();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(autoid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(autoid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(autoid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(autoid.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new autoid().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField autonm;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtautoid;
    // End of variables declaration//GEN-END:variables
}
