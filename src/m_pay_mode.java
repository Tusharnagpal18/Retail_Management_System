import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class m_pay_mode extends javax.swing.JFrame {
static Connection con;
    static PreparedStatement pst;
    /**
     * Creates new form m_pay_mode
     */
    public m_pay_mode() {
        initComponents();
        Savepanel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Addpanel = new javax.swing.JPanel();
        modify1 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Inquire = new javax.swing.JButton();
        pay_mod_id = new javax.swing.JTextField();
        pay_moddesc = new javax.swing.JTextField();
        Savepanel = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        modify2 = new javax.swing.JButton();
        Quit = new javax.swing.JButton();
        Help = new javax.swing.JButton();
        Fresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PAY MODE MASTER");

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Pay Mode Id");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Description");

        Addpanel.setOpaque(false);

        modify1.setText("Modify");
        modify1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modify1MouseClicked(evt);
            }
        });
        modify1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify1ActionPerformed(evt);
            }
        });
        modify1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                modify1KeyPressed(evt);
            }
        });

        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        add.setText("Add");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        add.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addKeyPressed(evt);
            }
        });

        jButton6.setText("Quit");

        Inquire.setText("Inquire");
        Inquire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InquireActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddpanelLayout = new javax.swing.GroupLayout(Addpanel);
        Addpanel.setLayout(AddpanelLayout);
        AddpanelLayout.setHorizontalGroup(
            AddpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddpanelLayout.createSequentialGroup()
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modify1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Inquire, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        AddpanelLayout.setVerticalGroup(
            AddpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(AddpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modify1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inquire, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pay_mod_id.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pay_mod_id.setEnabled(false);
        pay_mod_id.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pay_mod_idFocusGained(evt);
            }
        });
        pay_mod_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_mod_idActionPerformed(evt);
            }
        });
        pay_mod_id.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pay_mod_idKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pay_mod_idKeyReleased(evt);
            }
        });

        pay_moddesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pay_moddesc.setEnabled(false);
        pay_moddesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pay_moddescActionPerformed(evt);
            }
        });

        Savepanel.setOpaque(false);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        Save.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                SaveKeyPressed(evt);
            }
        });

        modify2.setText("Print");
        modify2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify2ActionPerformed(evt);
            }
        });

        Quit.setText("Quit");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });

        Help.setText("Help");
        Help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HelpActionPerformed(evt);
            }
        });

        Fresh.setText("Fresh");
        Fresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SavepanelLayout = new javax.swing.GroupLayout(Savepanel);
        Savepanel.setLayout(SavepanelLayout);
        SavepanelLayout.setHorizontalGroup(
            SavepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SavepanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(modify2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Quit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Help, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fresh, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        SavepanelLayout.setVerticalGroup(
            SavepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SavepanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(SavepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modify2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Help, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Addpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Savepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pay_moddesc, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pay_mod_id, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pay_mod_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pay_moddesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(Addpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Savepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

              public void close()
     {
         WindowEvent closeWindow=new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
         Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
     }   
   
    
    
    public void my_add(){
        if(pay_mod_id.getText().isEmpty() || pay_moddesc.getText().isEmpty())
        {  JOptionPane.showMessageDialog(this, "Enter the data!");
        }
        else{
        try {
            con=DB.getCon();
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            
              String tushar="insert into m_pay_mod(pay_mod_id,pay_mod_desc) values(?,?)";
           
              System.out.println("printed");
            PreparedStatement pst=con.prepareStatement(tushar);
            pst.setString(1,pay_mod_id.getText());
            pst.setString(2,pay_moddesc.getText());
            System.out.println("printed09");
            pst.executeUpdate();
            System.out.println("printe77d");
            JOptionPane.showMessageDialog(null, "inserted successfully!");
            
        } catch (Exception e) {
            
        }
        
       }
        pay_mod_id.setText("");
        pay_moddesc.setText("");
   }
    
    
    public void my_modify(){
    
         if(pay_mod_id.getText().isEmpty() || pay_moddesc.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Enter the data!");
        }
        else{
        try {
            con=DB.getCon();
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            
              String quer="update m_pay_mod set pay_mod_desc='"+pay_moddesc.getText()+"'"+"where pay_mod_id='"+pay_mod_id.getText()+"'";
            
            PreparedStatement pst=con.prepareStatement(quer);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Updated!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        pay_mod_id.setText("");
        pay_moddesc.setText("");
        }

   }
    public static String pid,pdesc;
    public static int k=0;
    public void refresh(String id,String desc)
    {
        pay_mod_id.setText(id);
        pay_moddesc.setText(desc);
    }
       private void my_delete(){
    if(pay_mod_id.getText().isEmpty() || pay_moddesc.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Enter the data!");
        }
        else{
        
                try {
            con=DB.getCon();
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            
  
            String quer="delete from m_pay_mod where pay_mod_id=?";
            
            PreparedStatement pst=con.prepareStatement(quer);
            pst.setString(1,pay_mod_id.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted successfully!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
                
        }
         pay_mod_id.setText("");
          pay_moddesc.setText("");
          
   }


    
    
    
    
    
    
    int i;

    
    private void modify1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modify1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_modify1MouseClicked

    private void modify1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modify1ActionPerformed

        i=2;
        Addpanel.hide();
        pay_mod_id.setEnabled(true);
        pay_moddesc.setEnabled(true);
        Savepanel.show();
    }//GEN-LAST:event_modify1ActionPerformed

    private void modify1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modify1KeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String gId=pay_mod_id.getText();
            try {
                con=DB.getCon();
                //
                //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
                
                String quer="select item_type_desc from m_item_type where item_type_id='"+gId+"'";

                PreparedStatement pst=con.prepareStatement(quer);
                ResultSet rs=pst.executeQuery();
                if(rs.next())
                {
                    pay_moddesc.setText(rs.getString(1));
                }

                //JOptionPane.showMessageDialog(null, "Data Updated!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }//GEN-LAST:event_modify1KeyPressed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        Addpanel.hide();
        pay_mod_id.setEnabled(true);
        pay_moddesc.setEnabled(true);
        Savepanel.show();
        i=3;
    }//GEN-LAST:event_deleteActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        Addpanel.hide();
        pay_mod_id.setEnabled(true);
        pay_moddesc.setEnabled(true);
        Savepanel.show();
        i=1;
    }//GEN-LAST:event_addActionPerformed

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_addKeyPressed

    private void InquireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InquireActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InquireActionPerformed

    private void pay_mod_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_mod_idActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_pay_mod_idActionPerformed

    private void pay_mod_idKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pay_mod_idKeyPressed
        // TODO add your handling code here:
        if(i==2||i==3){
            if(evt.getKeyCode()==KeyEvent.VK_F1){
                PayTable tt= new PayTable();
                tt.setVisible(true);
            }
            if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                String tId=pay_mod_id.getText();
                try {
                    con=DB.getCon();
                    //
                    //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
                    
                    String quer="select pay_mod_desc from m_pay_mod where pay_mod_id='"+tId+"'";

                    PreparedStatement pst=con.prepareStatement(quer);
                    ResultSet rs=pst.executeQuery();
                    if(rs.next())
                    {
                        pay_moddesc.setText(rs.getString(1));
                    }

                    //JOptionPane.showMessageDialog(null, "Data Updated!");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);

                }
            }
        }
    }//GEN-LAST:event_pay_mod_idKeyPressed

    private void pay_mod_idKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pay_mod_idKeyReleased
        // TODO add your handling code here:
        if(i==1){

            if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                String gcId=pay_mod_id.getText();

                try {
                    con=DB.getCon();
                    //
                    //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
                    
                    String sql="select pay_mod_desc from m_pay_mod where pay_mod_id='"+gcId+"'";

                    PreparedStatement pst=con.prepareStatement(sql);
                    ResultSet rs=pst.executeQuery();
                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(null, "Item already exist!");
                    }

                    //JOptionPane.showMessageDialog(null, "Data Updated!");

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);

                }
            }

        }

        //        if(i==2){
            //            if(evt.getKeyCode()==KeyEvent.VK_ENTER){
                //               String gId=grpid.getText();
                //            try {
                    //            con=DB.getCon();
                    //            //
                    //            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
                    //            
                    //              String tushar="select group_desc from m_group where group_id='"+gId+"'";
                    //
                    //            PreparedStatement pst=con.prepareStatement(tushar);
                    //            ResultSet rs=pst.executeQuery();
                    //            if(rs.next())
                    //            {
                        //                grpdesc.setText(rs.getString(1));
                        //            }
                    //
                    //            //JOptionPane.showMessageDialog(null, "Data Updated!");
                    //
                    //        } catch (Exception e) {
                    //            JOptionPane.showMessageDialog(null, e);
                    //
                    //        }
                //        }
            //        }
    }//GEN-LAST:event_pay_mod_idKeyReleased

    private void pay_moddescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pay_moddescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pay_moddescActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        if(i==1){

            //                try {
                //                    String gcId=typeid.getText();
                //                    con=DB.getCon();
                //                    //
                //                    //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
                //                    
                //                    String quer="select item_type_desc from m_item_type where item_type_id='"+gcId+"'";
                //
                //                    PreparedStatement pst=con.prepareStatement(quer);
                //                    ResultSet rs=pst.executeQuery();
                //                    if(rs.next())
                //                    {
                    //                        JOptionPane.showMessageDialog(null, "Item already exist!");
                    //                    }
                //                }
            //                catch(Exception e)
            //                        {
                //
                //                        }
            System.out.println("fitjee");
                my_add();
        }

        else if(i==2){
            System.out.println("gtrerer");
            my_modify();
        }
        //        else if(i==3){
            //            my_delete();
            //        }

        // my_add();
    }//GEN-LAST:event_SaveActionPerformed

    private void SaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SaveKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_SaveKeyPressed

    private void modify2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modify2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modify2ActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
//        close();
//        setDefaultCloseOperation(dashboard.DISPOSE_ON_CLOSE);
        Savepanel.hide();
        Addpanel.setVisible(true);
    }//GEN-LAST:event_QuitActionPerformed

    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpActionPerformed
        // TODO add your handling code here:
        newTable tb=new newTable();
        tb.setVisible(true);
    }//GEN-LAST:event_HelpActionPerformed

    private void FreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FreshActionPerformed
        // TODO add your handling code here:
        pay_mod_id.setText("");
        pay_moddesc.setText("");
    }//GEN-LAST:event_FreshActionPerformed

    private void pay_mod_idFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pay_mod_idFocusGained
        // TODO add your handling code here:
        if(k==1)
        {
            refresh(pid, pdesc);
            k=0;
        }
    }//GEN-LAST:event_pay_mod_idFocusGained

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
            java.util.logging.Logger.getLogger(m_pay_mode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(m_pay_mode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(m_pay_mode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(m_pay_mode.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new m_pay_mode().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Addpanel;
    private javax.swing.JButton Fresh;
    private javax.swing.JButton Help;
    private javax.swing.JButton Inquire;
    private javax.swing.JButton Quit;
    private javax.swing.JButton Save;
    private javax.swing.JPanel Savepanel;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton modify1;
    private javax.swing.JButton modify2;
    public javax.swing.JTextField pay_mod_id;
    public static javax.swing.JTextField pay_moddesc;
    // End of variables declaration//GEN-END:variables
}
