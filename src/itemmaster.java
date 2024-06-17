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
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
public class itemmaster extends javax.swing.JFrame {
 static Connection con;
    static PreparedStatement pst;
    /**
     * Creates new form itemmaster
     */
    public itemmaster() {
        initComponents();
        
        grplbl.setText("");
        grpcom.setSelectedItem(null);
        grpcom.addItem("");
        
        typlbl.setText("");
        typecom.setSelectedItem(null);
        typecom.addItem("");
        
        mnflbl.setText("");
        mnfcom.setSelectedItem(null);
        mnfcom.addItem("");
        
        salunlbl.setText("");
        salunid.setSelectedItem(null);
        salunid.addItem("");
        
//        mnflbl.setText("");
        txtypcom.setSelectedItem(null);
        txtypcom.addItem("");
        salunid.enable(false);
    }
    
    public static String item_id1;
    public static int chkk=0;
    public void refresh()
    {
        itemid.setText(""+item_id1);
    }
 
          
////     
           
  
    int getValue;
    public void grpcombo_ins()
       {
    try{
        
            con=DB.getCon();
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            
            String tushar="select group_id from m_group";
             pst=con.prepareStatement(tushar);
            java.sql.ResultSet rs=pst.executeQuery();
            while(rs.next())
      {
//          String sr=
          grpcom.addItem(rs.getString("group_id"));
//     
           
      }
          }
    catch (Exception e) {
    
        }
}
    
    public void close()
     {
         WindowEvent closeWindow=new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
         Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
     }
   
     public void typecombo_ins() 
             {
                try{
        
            con=DB.getCon();
            
            
            String tushar="select item_type_id from m_item_type";
             pst=con.prepareStatement(tushar);
            java.sql.ResultSet rs=pst.executeQuery();

            while(rs.next())
      {
//          String sr=
          typecom.addItem(rs.getString("item_type_id"));
//     
           
      }
          }
    catch (Exception e) {
    
        } 
             }
     
     
     public void saluni_ins()
             {
                try{
        
            con=DB.getCon();
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            
            String quer="select unit_id from m_unit";
             pst=con.prepareStatement(quer);
            java.sql.ResultSet rs=pst.executeQuery();

            while(rs.next())
      {
//          String sr=
          salunid.addItem(rs.getString("unit_id"));
//     
           
      }
          }
    catch (Exception e) {
    
        } 
             }
     
    
 
     public void mnfcombo_ins()
       {
    try{
        
            con=DB.getCon();
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            
            String quer="select mnf_id from m_manuf";
             pst=con.prepareStatement(quer);
            java.sql.ResultSet rs=pst.executeQuery();

            while(rs.next())
      {
//          String sr=
          mnfcom.addItem(rs.getString("mnf_id"));
//     
           
      }
          }
    catch (Exception e) {
    
        }
}
     
     
        public void txtypcombo_ins()
       {
    try{
        
            con=DB.getCon();
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            
            String quer="select tax_tpe from m_Taxtype";
             pst=con.prepareStatement(quer);
            java.sql.ResultSet rs=pst.executeQuery();

            while(rs.next())
      {
//          String sr=
          txtypcom.addItem(rs.getString("tax_tpe"));
//     
           
      }
          }
    catch (Exception e) {
    
        }
}
 
 //================================autoid======================================================//
   
   public void autoid(String PassQuery)
    {
        try{
        
            con=DB.getCon();
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            
//            String sql="select item_id  from m_item";
            java.sql.Statement pst=con.createStatement();
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
        
            con=DB.getCon();
            
//               String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            
//            String sql="select item_id  from m_item";
             String inv="1000"+getValue;
             itemid.setText(inv);
//             Statement st=con.createStatement() ;
//              pst=con.prepareStatement(insertdata);
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
    
    
//    public static String id="";
//    public static String name="";
//    public void refresh(String id,String name)
//    {
//        grpid.setText(id);
//        grpdesc.setText(name);
//        System.out.println(id);
//        System.out.println(name);
//    }
 

//=====================================Active====================================================//
    
    
                
//    
    
   public void enb()
   {
        itemid.enable(true);
        itemdesc.enable(true);
        typecom.enable(true);
        typlbl.enable(true);
        grpcom.enable(true);
        grplbl.enable(true);
        mnfcom.enable(true);
        mnflbl.enable(true);
        salunid.enable(true);
        salunlbl.enable(true);

        txtypcom.enable(true);
        hsn.enable(true);
        
        stk.enable(true);
        minordlvl.enable(true);
        reordlvl.enable(true);
        barcode.enable(true);
        cp.enable(true);
        mrp.enable(true);
        sp.enable(true);
        Actchk.enable(true);
        
        
   }  
    
   public void empty()
   {
       itemid.setText("");
        itemdesc.setText("");
        typecom.setSelectedItem(null);
        typecom.addItem("");
        typlbl.setText("");
        grpcom.setSelectedItem(null);
        grpcom.addItem("");
        grplbl.setText("");
        mnflbl.setText("");
        mnfcom.setSelectedItem(null);
        mnfcom.addItem("");
        salunlbl.setText("");
        salunid.setSelectedItem(null);
        salunid.addItem("");
        salunlbl.setText("");
        margp.setText("");
        opbal.setText("");
        expdt.setText("");
        txtypcom.setSelectedItem(null);
        txtypcom.addItem("");
        hsn.setText("");
        stk.setText("");
        minordlvl.setText("");
         reordlvl.setText("");
        barcode.setText("");
        cp.setText("");
        mrp.setText("");
        sp.setText("");
        
   }
//-------------------------------------operations-------------------------------------------------//
     
     public void my_add(){
        enb();
                 
        String s1=null;
           if(Actchk.isSelected())
            {
                s1="Y";
            }
            else
            {
                s1="N";
            }
        try{
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    
          
          con=DB.getCon();
//        Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:49949;databaseName=Retailmgt","sa","bds123");
            String quer="insert into m_item(item_id,item_desc,item_type_id,item_type_name,group_id,group_desc,manuf_id,manuf_name,"
               + "sale_unit_id,sale_unit_desc,gst_per,hsn_code,Stock,min_lvl,reorder_lvl,cess,bar_code,cost_price,mrp,sale_price,active_yn) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            String quer="insert into m_item(item_id,item_desc,item_type_id,item_type_name,group_id,group_desc,manuf_id,manuf_name) values (?,?,?,?,?,?,?,?)";
//            String quer="insert into i_master(item_id,active_yn) values (?,?)";
             pst=con.prepareStatement(quer);
         
               pst.setString(1,itemid.getText());
           
            pst.setString(2,itemdesc.getText());
           
            String val=typecom.getSelectedItem().toString();
            pst.setString(3,val);
           
            pst.setString(4,typlbl.getText());
           
            String val1=grpcom.getSelectedItem().toString();
            pst.setString(5,val1);
           
            pst.setString(6,grplbl.getText());
           
            String val4=mnfcom.getSelectedItem().toString();
            pst.setString(7,val4);
           
            pst.setString(8,mnflbl.getText());
//           
            String val5=salunid.getSelectedItem().toString();
            pst.setString(9,val5);
           
            pst.setString(10,salunlbl.getText());
           
            String val6=txtypcom.getSelectedItem().toString();
            pst.setString(11,val6);
           
            pst.setString(12,hsn.getText());
           
            pst.setString(13,stk.getText());
           
            pst.setString(14,minordlvl.getText());
           
            pst.setString(15,reordlvl.getText());
                      
            pst.setString(16,cs.getText());
            
            pst.setString(17,barcode.getText());
//           
            pst.setString(18,cp.getText());
           
            pst.setString(19,mrp.getText());
           
            pst.setString(20,sp.getText());
//            
            pst.setString(21,s1);
            System.out.println("aaa");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"inserted");
            System.out.println("aaaaaa");
            
           
    }
        catch(Exception e)
        {
           
        }
        empty();
    }

   
   private void my_modify(){
        String s1=null;
           if(Actchk.isSelected())
            {
                s1="Y";
            }
            else
            {
                s1="N";
            }
       if(itemid.getText().isEmpty() || itemdesc.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Enter the data!");
        }
        else{
        try {
            
            con=DB.getCon();
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            
              String quer="update m_item set item_desc='"+itemdesc.getText()+"',item_type_id='"+typecom.getSelectedItem().toString()+"',item_type_name='"+typlbl.getText()+"',group_id='"+grpcom.getSelectedItem()+"',group_desc='"+grplbl.getText()+"',manuf_id='"+mnfcom.getSelectedItem().toString()+"',manuf_name='"+mnflbl.getText()+"',sale_unit_id='"+salunid.getSelectedItem().toString()+"',sale_unit_desc='"+salunlbl.getText()+"',gst_per='"+txtypcom.getSelectedItem().toString()+"',hsn_code='"+hsn.getText()+"',Stock='"+stk.getText()+"',min_lvl='"+minordlvl.getText()+"',reorder_lvl='"+reordlvl.getText()+"',cess='"+cs.getText()+"',bar_code='"+barcode.getText()+"',cost_price='"+cp.getText()+"',mrp='"+mrp.getText()+"',sale_price='"+sp.getText()+"',active_yn='"+s1+"'"+"where item_id='"+itemid.getText()+"' OR bar_code='"+itemid.getText()+"'";
            
             pst=con.prepareStatement(quer);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Updated!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        empty();
        }
   }
//   
//   private void my_delete(){
//   if(itemid.getText().isEmpty() || itemdesc.getText().isEmpty())
//        {
//            JOptionPane.showMessageDialog(this, "Enter the data!");
//        }
//        else{
//        
//                try {
//            con=DB.getCon();
//            //
//            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
//            
//  
//            String tushar="delete from m_item where item_id=?";
//            
//             pst=con.prepareStatement(tushar);
//            pst.setString(1,itemid.getText());
//            pst.executeUpdate();
//            JOptionPane.showMessageDialog(null, "Deleted successfully!");
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//            
//        }
//               empty(); 
//        }
//   
//   }
   
   
   
    
    int i;
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        grpcom = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        typecom = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        stk = new javax.swing.JTextField();
        mnfcom = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        salunid = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtypcom = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        hsn = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        Actchk = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        barcode = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cp = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        mrp = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        sp = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        grplbl = new javax.swing.JLabel();
        salunlbl = new javax.swing.JLabel();
        typlbl = new javax.swing.JLabel();
        mnflbl = new javax.swing.JLabel();
        itemdesc = new javax.swing.JTextField();
        Savepanel1 = new javax.swing.JPanel();
        Save1 = new javax.swing.JButton();
        modify6 = new javax.swing.JButton();
        Help = new javax.swing.JButton();
        Fresh = new javax.swing.JButton();
        Quit = new javax.swing.JButton();
        savdel = new javax.swing.JButton();
        Addpanel = new javax.swing.JPanel();
        modify = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Inquire = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        minordlvl = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        reordlvl = new javax.swing.JTextField();
        itemid = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cs = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        netr = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        opbal = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        margp = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        expdt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Item Master");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Item Id");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Group");

        grpcom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        grpcom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                grpcomFocusGained(evt);
            }
        });
        grpcom.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                grpcomPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });
        grpcom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grpcomActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Desc");

        typecom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        typecom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                typecomFocusGained(evt);
            }
        });
        typecom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typecomActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Type");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Manufac.");

        stk.setBackground(new java.awt.Color(255, 204, 153));
        stk.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        mnfcom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnfcom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                mnfcomFocusGained(evt);
            }
        });
        mnfcom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnfcomActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Sale Unit");

        salunid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salunid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                salunidFocusGained(evt);
            }
        });
        salunid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salunidActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("GST%");

        txtypcom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtypcom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtypcomFocusGained(evt);
            }
        });
        txtypcom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtypcomActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("HSN");

        hsn.setBackground(new java.awt.Color(255, 204, 153));
        hsn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Stock");

        Actchk.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        Actchk.setSelected(true);
        Actchk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActchkActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("ACTIVE");

        barcode.setBackground(new java.awt.Color(255, 204, 153));
        barcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        barcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                barcodeActionPerformed(evt);
            }
        });
        barcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                barcodeKeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("BARCODE");

        cp.setBackground(new java.awt.Color(255, 204, 153));
        cp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cpKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("COST PRICE");

        mrp.setBackground(new java.awt.Color(255, 204, 153));
        mrp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mrp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mrpActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("MRP");

        sp.setBackground(new java.awt.Color(255, 204, 153));
        sp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("SALE PRICE");

        grplbl.setBackground(new java.awt.Color(255, 204, 153));
        grplbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        grplbl.setOpaque(true);

        salunlbl.setBackground(new java.awt.Color(255, 204, 153));
        salunlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        salunlbl.setOpaque(true);

        typlbl.setBackground(new java.awt.Color(255, 204, 153));
        typlbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        typlbl.setOpaque(true);

        mnflbl.setBackground(new java.awt.Color(255, 204, 153));
        mnflbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        mnflbl.setOpaque(true);

        itemdesc.setBackground(new java.awt.Color(255, 204, 153));
        itemdesc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        Savepanel1.setOpaque(false);

        Save1.setText("Save");
        Save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Save1ActionPerformed(evt);
            }
        });

        modify6.setText("Print");
        modify6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify6ActionPerformed(evt);
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

        javax.swing.GroupLayout Savepanel1Layout = new javax.swing.GroupLayout(Savepanel1);
        Savepanel1.setLayout(Savepanel1Layout);
        Savepanel1Layout.setHorizontalGroup(
            Savepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Savepanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Save1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(savdel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(modify6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Quit, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Help, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Fresh, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Savepanel1Layout.setVerticalGroup(
            Savepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Savepanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(Savepanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Save1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modify6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Help, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(savdel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

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
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

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

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Reorder Level");

        minordlvl.setBackground(new java.awt.Color(255, 204, 153));
        minordlvl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Minimum Order level");

        reordlvl.setBackground(new java.awt.Color(255, 204, 153));
        reordlvl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        itemid.setEditable(false);
        itemid.setBackground(new java.awt.Color(255, 204, 153));
        itemid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        itemid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                itemidFocusGained(evt);
            }
        });
        itemid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemidActionPerformed(evt);
            }
        });
        itemid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemidKeyPressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Cess %");

        cs.setBackground(new java.awt.Color(255, 204, 153));
        cs.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("EXPIRY DATE");

        netr.setBackground(new java.awt.Color(255, 204, 153));
        netr.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        netr.setOpaque(true);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("NET RATE");

        opbal.setBackground(new java.awt.Color(255, 204, 153));
        opbal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        opbal.setOpaque(true);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("OP BALANCE");

        margp.setBackground(new java.awt.Color(255, 204, 153));
        margp.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        margp.setOpaque(true);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("MARGIN");

        expdt.setBackground(new java.awt.Color(255, 204, 153));
        expdt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(itemid, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(itemdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(typecom, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(typlbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(minordlvl, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(reordlvl, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(expdt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(273, 273, 273)
                                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(netr, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(Actchk))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(167, 167, 167)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cp, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel14))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel13)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel15)
                                        .addGap(82, 82, 82)
                                        .addComponent(jLabel16)
                                        .addGap(39, 39, 39))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mrp, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(160, 160, 160)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(jLabel22)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(320, 320, 320)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtypcom, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(margp, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addComponent(stk, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(grpcom, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(salunid, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cs, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(grplbl, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(41, 41, 41)
                                        .addComponent(jLabel7)
                                        .addGap(30, 30, 30)
                                        .addComponent(mnfcom, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(mnflbl, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(salunlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(jLabel17)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(hsn, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(opbal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(Addpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Savepanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel3)
                        .addComponent(itemdesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(typecom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(itemid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(typlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(grpcom))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(mnfcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(mnflbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(grplbl, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(salunid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(salunlbl, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hsn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(opbal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtypcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(stk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(14, 14, 14))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(margp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(reordlvl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(expdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel25)
                        .addComponent(minordlvl)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Actchk))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel16)))
                                .addGap(10, 10, 10)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(netr, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(159, 159, 159))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(barcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Addpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Savepanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtypcomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtypcomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtypcomActionPerformed

    private void ActchkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActchkActionPerformed
         // TODO add your handling code here:
         
    }//GEN-LAST:event_ActchkActionPerformed

    private void mrpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mrpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mrpActionPerformed

    private void spActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spActionPerformed

    private void salunidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salunidActionPerformed
        // TODO add your handling code here:
                   try {                                        
            String s3=salunid.getSelectedItem().toString();          
            con=DB.getCon();
           
           
             
            String quer="Select unit_desc from m_unit where unit_id='"+s3+"'";
             pst=con.prepareStatement(quer);
            java.sql.ResultSet rs=pst.executeQuery();
            
           if(rs.next())
            {
//                String value=(String)grpcom.getSelectedItem();
                salunlbl.setText(rs.getString(1));
                //1 is taken becoz as we specify only 1 text field to find anotherone  
            }  
              // TODO add your handling code here:
        }
     catch (Exception e) {
        }

    }//GEN-LAST:event_salunidActionPerformed

    private void typecomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typecomActionPerformed
        // TODO add your handling code here:
                try {                                        
            String s2=typecom.getSelectedItem().toString();          
            con=DB.getCon();
           
           
             
            String quer="Select item_type_desc from m_item_type where item_type_id='"+s2+"'";
             pst=con.prepareStatement(quer);
            java.sql.ResultSet rs=pst.executeQuery();
            
           if(rs.next())
            {
//                String value=(String)grpcom.getSelectedItem();
                typlbl.setText(rs.getString(1));
                //1 is taken becoz as we specify only 1 text field to find anotherone  
            }  
              // TODO add your handling code here:
        }
     catch (Exception e) {
        }

 
    }//GEN-LAST:event_typecomActionPerformed

    private void barcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_barcodeActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_barcodeActionPerformed

    private void grpcomPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_grpcomPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
//        String tmp=(String)grpcom.getSelectedItem();
//        
//        try {
//            con=DB.getCon();
//            //
//            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
//            
//              String tushar="select * from m_group where group_id=?";
//            
//             pst=con.prepareStatement(tushar);
//            pst.setString(1, tmp);
//            java.sql.ResultSet rs=pst.executeQuery();
//            if(rs.next())
//            {
//                grplbl.setText(rs.getString(1));
//            }
//            
//            //JOptionPane.showMessageDialog(null, "Data Updated!");
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//            
//        }
    }//GEN-LAST:event_grpcomPopupMenuWillBecomeInvisible

    private void grpcomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grpcomActionPerformed
        // TODO add your handling code here:
         try {                                        
            String s1=grpcom.getSelectedItem().toString();          
            con=DB.getCon();
           
           
             
            String tushar="Select group_desc from m_group where group_id='"+s1+"'";
             pst=con.prepareStatement(tushar);
            java.sql.ResultSet rs=pst.executeQuery();
            
           if(rs.next())
            {
//                String value=(String)grpcom.getSelectedItem();
                grplbl.setText(rs.getString(1));
                //1 is taken becoz as we specify only 1 text field to find anotherone  
            }  
              // TODO add your handling code here:
        }
     catch (Exception e) {
        }

    }//GEN-LAST:event_grpcomActionPerformed

    private void Save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Save1ActionPerformed
        // TODO add your handling code here:
        if(i==1){
           itemid.setEditable(false);    
           int a=Integer.parseInt(mrp.getText());
           int b=Integer.parseInt(sp.getText());
           if(b>a)
           {
               JOptionPane.showMessageDialog(this, "Sale Price Cannot greater Than Mrp!!");
           }
           else
           {
               my_add();
               empty();
               insertserno();
               itemdesc.requestFocus();
               
           }
           
            
            


        }
        else if(i==2){

            my_modify();

        }
        //     else if(i==3){
            //     my_delete();
            //     }

        // my_add();
        //my_modify();

    }//GEN-LAST:event_Save1ActionPerformed

    private void modify6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modify6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modify6ActionPerformed

    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpActionPerformed
        // TODO add your handling code here:
        newTable tb=new newTable();
        tb.setVisible(true);

    }//GEN-LAST:event_HelpActionPerformed

    private void FreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FreshActionPerformed
        // TODO add your handling code here:
          empty();
    }//GEN-LAST:event_FreshActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:

              
              Savepanel1.hide();
                Addpanel.show();
                itemid.setText("");

    }//GEN-LAST:event_QuitActionPerformed

    private void savdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savdelActionPerformed
        // TODO add your handling code here:

//        my_delete();
    }//GEN-LAST:event_savdelActionPerformed

    private void modifyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_modifyMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_modifyMouseClicked

    private void modifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyActionPerformed

        Addpanel.hide();
        itemid.setEnabled(true);
        itemid.setEditable(true);
        itemdesc.setEnabled(true);
        Savepanel1.show();
        savdel.hide();
        i=2;
       
        itemid.requestFocusInWindow();
        grpcombo_ins();
        mnfcombo_ins();
        txtypcombo_ins();
        saluni_ins();
        typecombo_ins();
    }//GEN-LAST:event_modifyActionPerformed

    private void modifyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modifyKeyPressed
        // TODO add your handling code here:
//        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
//            String imId=itemid.getText();
//            try {
//                con=DB.getCon();
//                //
//                //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
//                
//                String tushar="select * from m_item where item_id='"+imId+" or bar_code="+imId+"'";
//
//                 pst=con.prepareStatement(tushar);
//                ResultSet rs=pst.executeQuery();
//                    String s1;
//                    String s2="Y";
//                if(rs.next())
//                {
////                    grpdesc.setText(rs.getString(1));
////                    mnfname.setText(rs.getString(1));
////                    mnfaddr.setText(rs.getString(2));
////                    mnfcity.setText(rs.getString(3));
////                    mnfdist.setText(rs.getString(4));
////                    mnfstate.setText(rs.getString(5));
////                    mnfcon.setText(rs.getString(6));
////                    mnfzip.setText(rs.getString(7));
//                    
//            itemdesc.setText(rs.getString(1));
//            
//            typecom.setSelectedItem(rs.getString(2));
//            typlbl.setText(rs.getString(3));
//            grpcom.setSelectedItem(rs.getString(4));
//            grplbl.setText(rs.getString(5));
//       
//            mnfcom.setSelectedItem(rs.getString(9));
//            mnflbl.setText(rs.getString(10));
//            salunid.setSelectedItem(rs.getString(11));
//            salunlbl.setText(rs.getString(12));
//       
//            txtypcom.setSelectedItem(rs.getString(14));
//            hsn.setText(rs.getString(15));
//            stk.setText(rs.getString(13));
//            minordlvl.setText(rs.getString(14));
//            reordlvl.setText(rs.getString(15));
//            cs.setText(rs.getString(16));
//            barcode.setText(rs.getString(17));
//            cp.setText(rs.getString(18));
//            mrp.setText(rs.getString(19));
//            sp.setText(rs.getString(20));
//            
//
//            s1=rs.getString(21);
//        
//        if(s2.equals(s1))
//        {
//            Actchk.setSelected(true);
//        }
//        else
//        {
//            Actchk.setSelected(false);
//        }
//                }
//
//                //JOptionPane.showMessageDialog(null, "Data Updated!");
//
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(null, e);
//
//            }
//        }
    }//GEN-LAST:event_modifyKeyPressed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        Addpanel.hide();
        enb();
        Savepanel1.show();
        Save1.hide();
        

    }//GEN-LAST:event_deleteActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
            insertserno();
        Addpanel.hide();
        enb();
        Savepanel1.show();
        savdel.hide();
        i=1;
        itemdesc.requestFocus();
        grpcombo_ins();
        typecombo_ins();
        mnfcombo_ins();
        saluni_ins();
        txtypcombo_ins();
        
        

    }//GEN-LAST:event_addActionPerformed

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_addKeyPressed

    private void InquireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InquireActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_InquireActionPerformed

    private void mnfcomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnfcomActionPerformed
        // TODO add your handling code here:
                try {                                        
            String s3=mnfcom.getSelectedItem().toString();          
            con=DB.getCon();
           
           
             
            String tushar="Select mnf_name from m_manuf where mnf_id='"+s3+"'";
             pst=con.prepareStatement(tushar);
            java.sql.ResultSet rs=pst.executeQuery();
            
           if(rs.next())
            {
//                String value=(String)grpcom.getSelectedItem();
                mnflbl.setText(rs.getString(1));
                //1 is taken becoz as we specify only 1 text field to find anotherone  
            }  
              // TODO add your handling code here:
        }
     catch (Exception e) {
        }

 
    }//GEN-LAST:event_mnfcomActionPerformed

    private void itemidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemidActionPerformed
        // TODO add your handling code here:
       
       
        
       
    }//GEN-LAST:event_itemidActionPerformed

    private void barcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_barcodeKeyPressed
        // TODO add your handling code here:
        char c= evt.getKeyChar();
        if(Character.isLetter(c))
        {
            barcode.setEditable(false);
            JOptionPane.showMessageDialog(this, "Please Enter Number Only!!");
            
        }
        else
        
       {   barcode.requestFocusInWindow();
           System.err.println("dfdffd");
            barcode.setEditable(true);
//            barcode.requestFocus(true);
        
        }
        
    }//GEN-LAST:event_barcodeKeyPressed

    private void cpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cpKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cpKeyPressed

    private void itemidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemidKeyPressed
        // TODO add your handling code here:
        String a;
        String s="Y";
                if(i==2||i==3){
        if(evt.getKeyCode()==KeyEvent.VK_F1){
        itemTable imt=new itemTable();
            imt.setVisible(true);
        }
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
               String imId=itemid.getText();
            try {
               
            con=DB.getCon();
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
            
              String tushar="select item_id,item_desc,item_type_id,item_type_name,group_id,group_desc,manuf_id,manuf_name,sale_unit_id,sale_unit_desc,op_bal,stock,gst_per,margin_per,hsn_code,min_lvl,reorder_lvl,exp_dt,cess,bar_code,cost_price,mrp,sale_price,net_rt,active_yn from m_item where item_id="+imId+" OR bar_code="+imId ;
            
             pst=con.prepareStatement(tushar);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
                a=rs.getString(1);
            
            itemdesc.setText(rs.getString(2));
            typecom.setSelectedItem(rs.getString(3));
            typlbl.setText(rs.getString(4));
            grpcom.setSelectedItem(rs.getString(5));
            grplbl.setText(rs.getString(6));
            mnfcom.setSelectedItem(rs.getString(7));
            mnflbl.setText(rs.getString(8));
            salunid.setSelectedItem(rs.getString(9));
            salunlbl.setText(rs.getString(10));
            opbal.setText(rs.getString(11));
            stk.setText(rs.getString(12));
            txtypcom.setSelectedItem(rs.getString(13));
            margp.setText(rs.getString(14));
            hsn.setText(rs.getString(15));
            minordlvl.setText(rs.getString(16));
            reordlvl.setText(rs.getString(17));
            expdt.setText(rs.getString(18)); 
            cs.setText(rs.getString(19));
            barcode.setText(rs.getString(20));
            cp.setText(rs.getString(21));
            mrp.setText(rs.getString(22));
            sp.setText(rs.getString(23));
             netr.setText(rs.getString(24));
            String act=(rs.getString(25));
            if(s.equals(act))
            {
               Actchk.setSelected(true);
            }
            else
            {
                Actchk.setSelected(false);
            }
           itemid.setText(a);
            }
            
            
            //JOptionPane.showMessageDialog(null, "Data Updated!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
                System.out.println(""+e);
        }
        }
        }

    }//GEN-LAST:event_itemidKeyPressed

    private void grpcomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_grpcomFocusGained
        // TODO add your handling code here:
        grpcom.removeAllItems();
        grplbl.setText("");
        grpcom.setSelectedItem(null);
        grpcom.addItem("");
        grpcombo_ins();
        
    }//GEN-LAST:event_grpcomFocusGained

    private void typecomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_typecomFocusGained
        // TODO add your handling code here:
        typecom.removeAllItems();
        typlbl.setText("");
        typecom.setSelectedItem(null);
        typecom.addItem("");

        typecombo_ins();
    }//GEN-LAST:event_typecomFocusGained

    private void mnfcomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_mnfcomFocusGained
        // TODO add your handling code here:
        mnfcom.removeAllItems();
        mnflbl.setText("");
        mnfcom.setSelectedItem(null);
        mnfcom.addItem("");

        mnfcombo_ins();
    }//GEN-LAST:event_mnfcomFocusGained

    private void salunidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_salunidFocusGained
        // TODO add your handling code here:
        salunid.removeAllItems();
        salunlbl.setText("");
        salunid.setSelectedItem(null);
        salunid.addItem("");

        saluni_ins();
    }//GEN-LAST:event_salunidFocusGained

    private void txtypcomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtypcomFocusGained
        // TODO add your handling code here:
        txtypcom.removeAllItems();
        

        txtypcom.setSelectedItem(null);
        txtypcom.addItem("");

        txtypcombo_ins();
    }//GEN-LAST:event_txtypcomFocusGained

    private void itemidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemidFocusGained
        // TODO add your handling code here:
        if(chkk==1)
        {
        refresh();
        }
        else
        {
            chkk=0;
        }
    }//GEN-LAST:event_itemidFocusGained

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        close();
        setDefaultCloseOperation(dashboard.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(itemmaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(itemmaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(itemmaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(itemmaster.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new itemmaster().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox Actchk;
    private javax.swing.JPanel Addpanel;
    private javax.swing.JButton Fresh;
    private javax.swing.JButton Help;
    private javax.swing.JButton Inquire;
    private javax.swing.JButton Quit;
    private javax.swing.JButton Save1;
    private javax.swing.JPanel Savepanel1;
    private javax.swing.JButton add;
    private javax.swing.JTextField barcode;
    private javax.swing.JTextField cp;
    private javax.swing.JTextField cs;
    private javax.swing.JButton delete;
    private javax.swing.JTextField expdt;
    private javax.swing.JComboBox<String> grpcom;
    private javax.swing.JLabel grplbl;
    private javax.swing.JTextField hsn;
    private javax.swing.JTextField itemdesc;
    public javax.swing.JTextField itemid;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel margp;
    private javax.swing.JTextField minordlvl;
    private javax.swing.JComboBox<String> mnfcom;
    private javax.swing.JLabel mnflbl;
    private javax.swing.JButton modify;
    private javax.swing.JButton modify6;
    private javax.swing.JTextField mrp;
    private javax.swing.JLabel netr;
    private javax.swing.JLabel opbal;
    private javax.swing.JTextField reordlvl;
    private javax.swing.JComboBox<String> salunid;
    private javax.swing.JLabel salunlbl;
    private javax.swing.JButton savdel;
    private javax.swing.JTextField sp;
    private javax.swing.JTextField stk;
    private javax.swing.JComboBox<String> txtypcom;
    private javax.swing.JComboBox<String> typecom;
    private javax.swing.JLabel typlbl;
    // End of variables declaration//GEN-END:variables
}
