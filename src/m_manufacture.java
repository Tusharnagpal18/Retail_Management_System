
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
import net.proteanit.sql.DbUtils;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class m_manufacture extends javax.swing.JFrame {
static Connection con;
    static PreparedStatement pst;
    /**
     * Creates new form m_manufacture
     */
    public m_manufacture() {
        initComponents();
        Savepanel.hide();
    }
    
    
    public void close()
     {
         WindowEvent closeWindow=new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
         Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
     }   
    
    private void my_add(){
        if(mnfid.getText().isEmpty() || mnfname.getText().isEmpty())
        {  JOptionPane.showMessageDialog(this, "Enter the data!");
        }
        else{
        try {
            
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            con=DB.getCon();
              String tushar="insert into m_manuf(mnf_id,mnf_name,mnf_address,mnf_city,mnf_district,mnf_state,mnf_country,mnf_zip) values(?,?,?,?,?,?,?,?)";
            
             pst=con.prepareStatement(tushar);
            pst.setString(1,mnfid.getText());
            pst.setString(2,mnfname.getText());
            pst.setString(3,mnfaddr.getText());
            pst.setString(4,mnfcity.getText());
            pst.setString(5,mnfdist.getText());
            pst.setString(6,mnfstate.getText());
            pst.setString(7,mnfcon.getText());
            pst.setString(8,mnfzip.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "inserted successfully!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,"ex is "+e);
        }
        mnfid.setText("");
        mnfname.setText("");
        mnfaddr.setText("");
        mnfcity.setText("");
        mnfdist.setText("");
        mnfstate.setText("");
        mnfcon.setText("");
        mnfzip.setText("");
       }
   }
   
   private void my_modify(){
        
       if(mnfid.getText().isEmpty() || mnfname.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Enter the data!");
        }
        else{
        try {
            
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            con=DB.getCon();
              String tushar="update m_manuf set mnf_name='"+mnfname.getText()+"',mnf_address='"+mnfaddr.getText()+"',mnf_city='"+mnfcity.getText()+"',mnf_district='"+mnfdist.getText()+"',mnf_state='"+mnfstate.getText()+"',mnf_country='"+mnfcon.getText()+"',mnf_zip='"+mnfzip.getText()+"'"+"where mnf_id="+mnfid.getText();
            
             pst=con.prepareStatement(tushar);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Updated!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        mnfid.setText("");
        mnfname.setText("");
        mnfaddr.setText("");
        mnfcity.setText("");
        mnfdist.setText("");
        mnfstate.setText("");
        mnfcon.setText("");
        mnfzip.setText("");
        }
   }
   
   private void my_delete(){
   if(mnfid.getText().isEmpty() )
        {
            JOptionPane.showMessageDialog(this, "Enter the data!");
        }
        else{
        
                try {
            
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            con=DB.getCon();
  
            String tushar="delete from m_manuf where mnf_id=?";
            
             pst=con.prepareStatement(tushar);
            pst.setString(1,mnfid.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted successfully!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
                mnfid.setText("");
        mnfname.setText("");
        mnfaddr.setText("");
        mnfcity.setText("");
        mnfdist.setText("");
        mnfstate.setText("");
        mnfcon.setText("");
        mnfzip.setText("");
                
        }
   
   }
   
   public void enb()
   {
        mnfid.enable(true);
        mnfname.enable(true);
        mnfaddr.enable(true);
        mnfcity.enable(true);
        mnfdist.enable(true);
        mnfstate.enable(true);
        mnfcon.enable(true);
        mnfzip.enable(true);
   }
 
   int j;
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
        mnfid = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        mnfname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        mnfaddr = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        mnfcity = new javax.swing.JTextField();
        mnfdist = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mnfstate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mnfcon = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        mnfzip = new javax.swing.JTextField();
        Addpanel = new javax.swing.JPanel();
        modify = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Inquire = new javax.swing.JButton();
        Savepanel = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        modify2 = new javax.swing.JButton();
        Help = new javax.swing.JButton();
        Fresh = new javax.swing.JButton();
        Quit = new javax.swing.JButton();
        savdel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MANUFACTURER  MASTER");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Manufacturer Id");

        mnfid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnfid.setEnabled(false);
        mnfid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnfidActionPerformed(evt);
            }
        });
        mnfid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mnfidKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mnfidKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Address");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Name");

        mnfname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnfname.setEnabled(false);
        mnfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnfnameActionPerformed(evt);
            }
        });
        mnfname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mnfnameKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mnfnameKeyReleased(evt);
            }
        });

        mnfaddr.setColumns(20);
        mnfaddr.setRows(5);
        mnfaddr.setEnabled(false);
        jScrollPane1.setViewportView(mnfaddr);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("City");

        mnfcity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnfcity.setEnabled(false);
        mnfcity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnfcityActionPerformed(evt);
            }
        });
        mnfcity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mnfcityKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mnfcityKeyReleased(evt);
            }
        });

        mnfdist.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnfdist.setEnabled(false);
        mnfdist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnfdistActionPerformed(evt);
            }
        });
        mnfdist.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mnfdistKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mnfdistKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("District");

        mnfstate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnfstate.setEnabled(false);
        mnfstate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnfstateActionPerformed(evt);
            }
        });
        mnfstate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mnfstateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mnfstateKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("State");

        mnfcon.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnfcon.setEnabled(false);
        mnfcon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnfconActionPerformed(evt);
            }
        });
        mnfcon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mnfconKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mnfconKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Country");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Zip");

        mnfzip.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnfzip.setEnabled(false);
        mnfzip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnfzipActionPerformed(evt);
            }
        });
        mnfzip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                mnfzipKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mnfzipKeyReleased(evt);
            }
        });

        Addpanel.setOpaque(false);

        modify.setText("Modify");
        modify.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                modifyMouseClicked(evt);
            }
        });
        modify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyActionPerformed(evt);
            }
        });
        modify.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                modifyKeyPressed(evt);
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
                .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(modify, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Inquire, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Savepanel.setOpaque(false);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        modify2.setText("Print");
        modify2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify2ActionPerformed(evt);
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

        Quit.setText("Quit");
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });

        savdel.setText("Delete");
        savdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savdelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SavepanelLayout = new javax.swing.GroupLayout(Savepanel);
        Savepanel.setLayout(SavepanelLayout);
        SavepanelLayout.setHorizontalGroup(
            SavepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SavepanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(savdel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    .addComponent(Help, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(savdel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(mnfid, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(mnfname, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(mnfzip, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(mnfstate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addComponent(mnfcity, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mnfdist, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mnfcon, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(Savepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(Addpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mnfid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(mnfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mnfcity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(mnfdist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(mnfstate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(mnfcon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(mnfzip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(Addpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Savepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnfidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnfidActionPerformed

        // TODO add your handling code here:

    }//GEN-LAST:event_mnfidActionPerformed

    private void mnfidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfidKeyPressed
        // TODO add your handling code here:
        if(j==2||j==3){
        if(evt.getKeyCode()==KeyEvent.VK_F1){
        manufTable mt=new manufTable();
            mt.setVisible(true);
        }
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
               String gId=mnfid.getText();
            try {
            
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            con=DB.getCon();
              String tushar="select mnf_name,mnf_address,mnf_city,mnf_district,mnf_state,mnf_country,mnf_zip from m_manuf where mnf_id="+gId;
            
             pst=con.prepareStatement(tushar);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
            mnfname.setText(rs.getString(1));
            mnfaddr.setText(rs.getString(2));
            mnfcity.setText(rs.getString(3));
            mnfdist.setText(rs.getString(4));
            mnfstate.setText(rs.getString(5));
            mnfcon.setText(rs.getString(6));
            mnfzip.setText(rs.getString(7));
            }
            
            //JOptionPane.showMessageDialog(null, "Data Updated!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        }
        }

    }//GEN-LAST:event_mnfidKeyPressed

    private void mnfidKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfidKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_mnfidKeyReleased

    private void mnfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfnameActionPerformed

    private void mnfnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfnameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfnameKeyPressed

    private void mnfnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfnameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfnameKeyReleased

    private void mnfcityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnfcityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfcityActionPerformed

    private void mnfcityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfcityKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfcityKeyPressed

    private void mnfcityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfcityKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfcityKeyReleased

    private void mnfdistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnfdistActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfdistActionPerformed

    private void mnfdistKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfdistKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfdistKeyPressed

    private void mnfdistKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfdistKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfdistKeyReleased

    private void mnfstateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnfstateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfstateActionPerformed

    private void mnfstateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfstateKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfstateKeyPressed

    private void mnfstateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfstateKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfstateKeyReleased

    private void mnfconActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnfconActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfconActionPerformed

    private void mnfconKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfconKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfconKeyPressed

    private void mnfconKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfconKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfconKeyReleased

    private void mnfzipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnfzipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfzipActionPerformed

    private void mnfzipKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfzipKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfzipKeyPressed

    private void mnfzipKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mnfzipKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_mnfzipKeyReleased

    private void modifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_modifyMouseClicked

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed

        Addpanel.hide();
        
        Savepanel.show();
        savdel.hide();
        enb();
        mnfid.requestFocusInWindow();
        j=2;

    }//GEN-LAST:event_modifyActionPerformed

    private void modifyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modifyKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String gId=mnfid.getText();
            try {
                
                //
                //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
                con=DB.getCon();
                String quer="select mnf_name,mnf_address,mnf_city,mnf_district,mnf_state,mnf_country,mnf_zip from m_manuf where mnf_id='"+gId;

                 pst=con.prepareStatement(quer);
                ResultSet rs=pst.executeQuery();
                if(rs.next())
                {
                    mnfname.setText(rs.getString(1));
                    mnfaddr.setText(rs.getString(2));
                    mnfcity.setText(rs.getString(3));
                    mnfdist.setText(rs.getString(4));
                    mnfstate.setText(rs.getString(5));
                    mnfcon.setText(rs.getString(6));
                    mnfzip.setText(rs.getString(7));
                }

                //JOptionPane.showMessageDialog(null, "Data Updated!");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }
    }//GEN-LAST:event_modifyKeyPressed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        Addpanel.hide();
        mnfid.setEnabled(true);

        Savepanel.show();
        Save.hide();
        mnfid.requestFocusInWindow();
        j=3;
//        enb();
    }//GEN-LAST:event_deleteActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        Addpanel.hide();
        
        Savepanel.show();
        savdel.hide();
        enb();
        mnfid.requestFocusInWindow();
                
        j=1;

    }//GEN-LAST:event_addActionPerformed

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_addKeyPressed

    private void InquireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InquireActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_InquireActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:

        if(j==1){

            my_add();
        }
        else if(j==2){

            my_modify();
        }
        //     else if(i==3){
            //     my_delete();
            //     }

        // my_add();
        //my_modify();

    }//GEN-LAST:event_SaveActionPerformed

    private void modify2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modify2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modify2ActionPerformed

    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpActionPerformed
        // TODO add your handling code here:
        newTable tb=new newTable();
        tb.setVisible(true);

    }//GEN-LAST:event_HelpActionPerformed

    private void FreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FreshActionPerformed
        // TODO add your handling code here:
        mnfid.setText("");
        mnfname.setText("");
        mnfaddr.setText("");
        mnfcity.setText("");
        mnfdist.setText("");
        mnfstate.setText("");
        mnfcon.setText("");
        mnfzip.setText("");
    }//GEN-LAST:event_FreshActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
        Savepanel.hide();
        Addpanel.setVisible(true);

    }//GEN-LAST:event_QuitActionPerformed

    private void savdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savdelActionPerformed
        // TODO add your handling code here:

        my_delete();
    }//GEN-LAST:event_savdelActionPerformed

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
            java.util.logging.Logger.getLogger(m_manufacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(m_manufacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(m_manufacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(m_manufacture.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new m_manufacture().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea mnfaddr;
    public static javax.swing.JTextField mnfcity;
    public static javax.swing.JTextField mnfcon;
    public static javax.swing.JTextField mnfdist;
    public javax.swing.JTextField mnfid;
    public static javax.swing.JTextField mnfname;
    public static javax.swing.JTextField mnfstate;
    public static javax.swing.JTextField mnfzip;
    private javax.swing.JButton modify;
    private javax.swing.JButton modify2;
    private javax.swing.JButton savdel;
    // End of variables declaration//GEN-END:variables
}
