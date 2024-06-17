import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.util.Calendar;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */

public class InvoicGen extends javax.swing.JFrame {
    static Connection con;
    static PreparedStatement pst;
    /**
     * Creates new form InvoicGen
     */
    
    int rowBar;
    int qtyM;
    float amtMain;
    
    public InvoicGen() {
        initComponents();
//        invtab.setAutoResizeMode(invtab.AUTO_RESIZE_OFF);
        dat();
//        run();
//        times();
/******************TIME*********************/

     paym.setSelectedItem(null);
     paym.addItem("");
     typepaymod_ins();
     cstnm.setText("");
     cstadd.setText("");
     custcomb.setSelectedItem(null);
     custcomb.addItem("");
     invtab.setShowGrid(true);
     paytab.setShowGrid(true);
//     invtab.setShowHorizontalLines(true);
//     invtab.setShowVerticalLines(true);

//     paytab.setVisible(false);
    }
//  
    int i;
    String b=null,m=null,ii=null,sp1=null,gp=null,cs=null,id=null,hs=null;
    double x,y,z;
    float mr;       
    
//    java.util.Date date = new java.util.Date();
    public void dat(){

    Date d=new Date();
    SimpleDateFormat sdf=new SimpleDateFormat("dd/mm/yyyy");
    
    String dd=sdf.format(d);
    billdt.setDate(d);
} 
    
          public void close()
     {
         WindowEvent closeWindow=new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
         Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
     }
public void fresh()
{
    pamt.setText("");
    paym.setSelectedItem(null);
    cstend.setText("");
    bnk1.setText("");
    ccn.setText("");
    cqno.setText("");
//    cqdt.setName("");
      cqdt.setDate(null);
}

public boolean chBar()
  {
        int barTab;
        boolean val=false;
        int invbr=Integer.parseInt(invbar.getText());
        System.out.println("bar is "+invbr);
        System.out.println(invtab.getRowCount()+" rows");
        for(int i=0;i<invtab.getRowCount();i++)
        {
            System.out.println("inside checkbar loop");
            barTab=Integer.parseInt(invtab.getValueAt(i,1).toString());
            if(barTab==invbr)
            {
                val=true;
                rowBar=i;
                qtyM=Integer.parseInt(invtab.getValueAt(i, 3).toString());
                amtMain=Float.parseFloat(invtab.getValueAt(i, 10).toString());
                System.out.println("barcode matched");
                break;
            }      
       }
        System.out.println("not maatched");
        System.out.println("val is "+val);
        return val;
    }


public void getcustidformail()
{
    String cs1=custcomb.getSelectedItem().toString();          
}

class myThread extends Thread {

        String str = "";

        @Override
        public void run(){
             
            while(true) {
                Calendar c = Calendar.getInstance();
                str = String.format("%02d : %02d : %02d", c.get(c.HOUR), c.get(c.MINUTE), c.get(c.SECOND));
                tim.setText(str);
                try{
                    sleep(1000);
                }
                catch(Exception e)
                {
                    System.out.println("exception is "+e);
                }
            }
        }
    }

    
        int getValue;
    public void add()
    {
        insertserno();
    }
    
    public void autoid(String PassQuery)
    {
        try{
        
            con=Server.getCon();
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
    {   autoid("select count(inv_no)+1 from t_inv_hdr");
    
//        String insertdata="insert into AutoId(id) values (?)";
        
        try{
            String a="21220000";
        
            con=Server.getCon();
            
//               String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
           
//            String sql="select item_id  from m_item";
             String inv=a+getValue;
              invno.setText(inv);
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
    

    
  public void empty()
  {
//       itemid.setText("");
//        itemdesc.setText("");
        custcomb.setSelectedItem(null);
        custcomb.addItem("");
        cstnm.setText("");
        cstadd.setText("");
        slsmnid.setSelectedItem(null);
        slsmnid.addItem("");
        slsnm.setText("");
        DefaultTableModel dtm=(DefaultTableModel)invtab.getModel();
        int t=dtm.getRowCount();
        for(int l=0; l<t; l++)
        {
            dtm.removeRow(0);
        }
        gramt.setText("");
        totdisc.setText("00.00");
        totdiscamt.setText("00.00");
        netamt.setText("");
        noi.setText("0");
        amtp.setText("");
        itmdesc.setText("");
        totqty.setText("0");
        DefaultTableModel dtpay=(DefaultTableModel)paytab.getModel();
        int tt=dtpay.getRowCount();
        for(int aa=0;aa<tt;aa++)
        {
            dtpay.removeRow(0);
        }
        
  }

public void my_addhdr(){
//    enb();
String s1;
        try{
            
           if(checkyn.isSelected())
            {
                s1="Yes";
            }
            else
            {
                s1="No";
            }
          con=Server.getCon();
//        Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:49949;databaseName=Retailmgt","sa","bds123");
            String quer="insert into t_inv_hdr(inv_no,inv_dt,cust_id,cust_nm,inv_tim,inv_sals,inv_salsnm,inv_cust_addr,"
               + "gross_amt,inv_disc,inv_disc_amt,inv_net_amt,amt_pay,no_item,tot_qty,item_desc,payment_mode) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


             pst=con.prepareStatement(quer);
         
               pst.setString(1,invno.getText());
           
//            pst.setString(2,((JTextField)billdt.getDateEditor().getUiComponent()).getText());
//              SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
              SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd");
    
          String ddd=sdf.format(billdt.getDate());
            pst.setString(2,ddd);
            String val=custcomb.getSelectedItem().toString();
            pst.setString(3,val);
           
            pst.setString(4,cstnm.getText());
            
            pst.setString(5,tim.getText());
           
            String val1=slsmnid.getSelectedItem().toString();
            pst.setString(6,val1);
            System.out.println(" before slsnm");
            pst.setString(7,slsnm.getText());
            System.out.println("after slsnm");
            
            pst.setString(8,cstadd.getText());
            
            pst.setString(9,gramt.getText());
            
            pst.setString(10,totdisc.getText());
            
            pst.setString(11,totdiscamt.getText());
            
            pst.setString(12,netamt.getText());
            
            pst.setString(13,amtp.getText());
            System.out.println(""+amtp.getText());
            
            pst.setString(14,noi.getText());
            
            pst.setString(15,totqty.getText());
            
            pst.setString(16,itmdesc.getText());
           
            pst.setString(17,s1);
            System.out.println("aaa");
            pst.executeUpdate();
//            JOptionPane.showMessageDialog(null,"inserted");
            System.out.println("aaaaaa");
            
           
    }
        catch(Exception e)
        {
           JOptionPane.showMessageDialog(null,"ex in hdr"+ e);
        }
//        empty();
    }


public void my_adddet()
        {   
            System.out.println("in det11");
    String invn,sno,barcod,itemnm,qt,mr,pri,dis,disam,gs,ces,am,itmid,inhs;
    DefaultTableModel dtm= (DefaultTableModel) invtab.getModel();
    try {
        
        System.out.println("in det22");
               
          con=Server.getCon();
//        Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:49949;databaseName=Retailmgt","sa","bds123");
            
        for(int l=0;l<dtm.getRowCount();l++){
         
            sno=dtm.getValueAt(l, 0).toString();
            barcod=dtm.getValueAt(l, 1).toString();
            itemnm=dtm.getValueAt(l, 2).toString();
            qt=dtm.getValueAt(l, 3).toString();
            mr=dtm.getValueAt(l, 4).toString();
            pri=dtm.getValueAt(l, 5).toString();
            dis=dtm.getValueAt(l, 6).toString();
            disam=dtm.getValueAt(l, 7).toString();
            gs=dtm.getValueAt(l, 8).toString();
            ces=dtm.getValueAt(l, 9).toString();
            am=dtm.getValueAt(l, 10).toString();
            itmid=dtm.getValueAt(l, 11).toString();
            inhs=dtm.getValueAt(l, 12).toString();
            System.out.println(""+sno+" "+barcod);
        String quer="insert into t_inv_det(inv_no,S_No,barcode,item_name,qty,mrp,price,disc,"
               + "disc_amt,gst,cess,amt,itemid,inv_hsn) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            String quer="insert into m_item(item_id,item_desc,item_type_id,item_type_name,group_id,group_desc,manuf_id,manuf_name) values (?,?,?,?,?,?,?,?)";
//            String quer="insert into i_master(item_id,active_yn) values (?,?)";
             pst=con.prepareStatement(quer);
              pst.setString(1,invno.getText());
              pst.setString(2,sno);
              pst.setString(3,barcod);
              pst.setString(4,itemnm);
              pst.setString(5,qt);
              pst.setString(6,mr);
              pst.setString(7,pri);
              pst.setString(8,dis);
              pst.setString(9,disam);
              pst.setString(10,gs);
              pst.setString(11,ces);
              pst.setString(12,am);
              pst.setString(13,itmid);
              pst.setString(14,inhs);
              System.out.println("in det33");
              pst.executeUpdate();
//              JOptionPane.showMessageDialog(rootPane,"inserted successfully");
    }
//        con.close();
    } catch (Exception e) 
    {
        JOptionPane.showMessageDialog(null,"ex in det"+e);
    }
}     
        
    String paymo;
public void my_addpaym()
{
//     String invn,sno,barcod,itemnm,qt,mr,pri,dis,disam,gs,ces,am,itmid;
    String payam,paycs,payrf,cno,bn,chqn,chqd;
    DefaultTableModel dtm= (DefaultTableModel) paytab.getModel();
    try {
        
               
          con=Server.getCon();
//        Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:49949;databaseName=Retailmgt","sa","bds123");
            
        for(int l=0;l<dtm.getRowCount();l++){
           
//            invn=dtm.getValueAt(l, 0).toString();
            paymo=dtm.getValueAt(l, 1).toString();
            payam=dtm.getValueAt(l, 2).toString();
            paycs=dtm.getValueAt(l, 3).toString();
            payrf=dtm.getValueAt(l, 4).toString();
            cno=dtm.getValueAt(l, 5).toString();
            bn=dtm.getValueAt(l, 6).toString();
            chqn=dtm.getValueAt(l, 7).toString();
            chqd=dtm.getValueAt(l, 8).toString();
            System.out.println("tt " +payam);
            System.out.println("dd "+paymo);
            System.out.println("in pay11");
        String quer="insert into t_inv_paymode (pay_mod,pay_amt,pay_cash,pay_ref,ccno,bnk,cqno,cqdt,inv_no) values(?,?,?,?,?,?,?,?,?)";
//            String quer="insert into m_item(item_id,item_desc,item_type_id,item_type_name,group_id,group_desc,manuf_id,manuf_name) values (?,?,?,?,?,?,?,?)";
//            String quer="insert into i_master(item_id,active_yn) values (?,?)";
             pst=con.prepareStatement(quer);
              pst.setString(1,paymo);
              pst.setString(2,payam);
              pst.setString(3,paycs);
              pst.setString(4,payrf);
              pst.setString(5,cno);
              pst.setString(6,bn);
              pst.setString(7,chqn);
              pst.setString(8,chqd);
              pst.setString(9,invno.getText());
              System.out.println("in pay22");
              pst.executeUpdate();
              System.out.println("in pay223");
        }
        con.close();
    } catch (Exception e) 
    {
        JOptionPane.showMessageDialog(null, "ex in paymode"+e);
    }
    
}


public void disccal()
{
    float sum=0,sum1=0,sum2=0;
 int g=invtab.getRowCount();
    System.out.println("rows are"+g);
 for(int i=0;i<invtab.getRowCount();i++)
  {          
//      float a=Float.parseFloat(tbl1.getValueAt(i,10).toString());
      float b=Float.parseFloat(invtab.getValueAt(i,5).toString());
      float cc=Float.parseFloat(invtab.getValueAt(i,3).toString());
      float ds=Float.parseFloat(invtab.getValueAt(i,7).toString());
      sum1+=ds;
      float mul=b*cc;
     
      sum+=mul;
   }
 DecimalFormat df=new DecimalFormat("0.00");
   
   double discper=((sum1/sum)*100);

System.out.println(""+discper);
   String disc=df.format(discper);
   gramt.setText(""+sum);
   totdiscamt.setText(""+sum1);
//   disc_per.setText(""+discper);
   totdisc.setText(""+disc);
}


/*-----------------------------------FOR LOCAL AND IGST---------------------------------------------*/
//public void locchck()
//{
//    if(local.isSelected())
//    {
//        custmaster cusm=new custmaster();
//        String gsi=cusm.gstin.getText();
//        char gsar[]=new char [gsi.length()];
//        for(int gg=0;gg<gsi.length();gg++)
//        {
//            gsar[gg]=gsi.charAt(gg);
//        }
//        if(gsar[0]=='0' && gsar[1]=='9')
//        {
//            System.out.println("local");
//            
//        }
//        else{
//            JOptionPane.showMessageDialog(this,"!!!Cannot Make this bill coz Customer Gstin is not Local");
//        }
//    }
//}


//public void igschck()
//{
//    if(igst.isSelected())
//    {
//        custmaster cusm=new custmaster();
//        String gsi=cusm.gstin.getText();
//        char gsar[]=new char [gsi.length()];
//        for(int gg=0;gg<gsi.length();gg++)
//        {
//            gsar[gg]=gsi.charAt(gg);
//        }
//        if(gsar[0]!='0' && gsar[1]!='9')
//        {
//            System.out.println("igst");
//            
//        }
//        else{
//            JOptionPane.showMessageDialog(this,"!!!Cannot Make this bill coz Customer Gstin is not IGST");
//        }
//    }
//}

/********************************************NOW CALCULATION*********************************/
//  public void taxcalc()
//{ String gsva;
//
//    DefaultTableModel dtm=(DefaultTableModel) invtab.getModel();
//    int rows=dtm.getRowCount();
//
//
//    try {
//        for(int l=0;l<rows;l++){
////        gs[i]=Float.parseFloat(dtm.getValueAt(l, 8).toString());   ////////////GST%
////         g[i]=gs[i]/2;
////        int gsin=Integer.parseInt(gs);
////        gsva=dtm.getValueAt(l, 9).toString();  /////////////gst Value
//        }
//         
////         String strgs=Float.toString(g);
//        
//        
////        con=DB.getCon();
////        Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:49949;databaseName=Retailmgt","sa","bds123");
////        String qry="Insert into t_inv_det (cgst,sgst) values(?,?)";
////         pst=con.prepareStatement(qry);
////        pst.setString(1, strgs);
////        pst.setString(2, strgs);
//        
//    } catch (Exception e) {
//    }
//}
//

/*------------------------------------------------------------------------------------------*/
//public void my_locadddet()
//        {   
//            locchck();
//  
//
//            System.out.println("in det11");
//    String invn,sno,barcod,itemnm,qt,mr,pri,dis,disam,gs,ces,am,itmid,inhs;
//    DefaultTableModel dtm= (DefaultTableModel) invtab.getModel();
//    int rows=dtm.getRowCount();
//    float g[]= new float[rows];
////  float gs[]=new float[rows];
//    try {
//        
//        System.out.println("in det22");
//               
//          con=DB.getCon();
//        Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:49949;databaseName=Retailmgt","sa","bds123");
//            
//        for(int l=0;l<dtm.getRowCount();l++){
//         
//            sno=dtm.getValueAt(l, 0).toString();
//            barcod=dtm.getValueAt(l, 1).toString();
//            itemnm=dtm.getValueAt(l, 2).toString();
//            qt=dtm.getValueAt(l, 3).toString();
//            mr=dtm.getValueAt(l, 4).toString();
//            pri=dtm.getValueAt(l, 5).toString();
//            dis=dtm.getValueAt(l, 6).toString();
//            disam=dtm.getValueAt(l, 7).toString();
//            gs=dtm.getValueAt(l, 8).toString();
//            ces=dtm.getValueAt(l, 9).toString();
//            am=dtm.getValueAt(l, 10).toString();
//            itmid=dtm.getValueAt(l, 11).toString();
//            inhs=dtm.getValueAt(l, 12).toString();
//            
//            System.out.println(""+sno+" "+barcod);
//        String quer="insert into t_inv_det(inv_no,S_No,barcode,item_name,qty,mrp,price,disc,"
//               + "disc_amt,gst,cess,amt,itemid,inv_hsn) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
////            String quer="insert into m_item(item_id,item_desc,item_type_id,item_type_name,group_id,group_desc,manuf_id,manuf_name) values (?,?,?,?,?,?,?,?)";
////            String quer="insert into i_master(item_id,active_yn) values (?,?)";
//             pst=con.prepareStatement(quer);
//              pst.setString(1,invno.getText());
//              pst.setString(2,sno);
//              pst.setString(3,barcod);
//              pst.setString(4,itemnm);
//              pst.setString(5,qt);
//              pst.setString(6,mr);
//              pst.setString(7,pri);
//              pst.setString(8,dis);
//              pst.setString(9,disam);
//              pst.setString(10,gs);
//              pst.setString(11,ces);
//              pst.setString(12,am);
//              pst.setString(13,itmid);
//              pst.setString(14,inhs);
//              System.out.println("in det33");
//              pst.executeUpdate();
////              JOptionPane.showMessageDialog(rootPane,"inserted successfully");
//    }
////        con.close();
//    } catch (Exception e) 
//    {
//        JOptionPane.showMessageDialog(null,e);
//    }
//}    

/*-----------------------------------------------------------------------------------*/
    public void typepaymod_ins() 
             {
                try{
        
            con=Server.getCon();
            
           
            String quer="select pay_mod_id from m_pay_mod";
             pst=con.prepareStatement(quer);
            java.sql.ResultSet rs=pst.executeQuery();

            while(rs.next())
      {
//          String sr=
          paym.addItem(rs.getString("pay_mod_id"));
//     
           
      }
          }
    catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } 
             }
     
/*****************************TIME***********************************/
    
     
    
    
//    Timer t ;
//    SimpleDateFormat st;
//public void times(){
//
//    
//    
//    
//    
//    
//    t=new Timer(0, new ActionListener(){
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//           
//            
//            Date dt=new Date();
//            st=new SimpleDateFormat("hh:mm a");
//            
//            String tt=st.format(dt);
//            tim.setText(tt);
//        }
//    });
//    
//    t.start();
//    
//}


public void typecombo_ins() 
             {
                try{
        
            con=Server.getCon();
            
           
            String tushar="select cust_id from m_cust";
             pst=con.prepareStatement(tushar);
            java.sql.ResultSet rs=pst.executeQuery();

            while(rs.next())
      {
//          String sr=
          custcomb.addItem(rs.getString("cust_id"));
//     
           
      }
          }
    catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
             }
     

/*******************Editable True***********************/
public void editenabTru()
{
    invbar.setEditable(true);
    qty.setEditable(true);
    invmrp.setEditable(true);
    sp.setEditable(true);
    updisc.setEditable(true);
    totdisc.setEditable(true);
    totdiscamt.setEditable(true);
    pamt.setEditable(true);
    cstend.setEditable(true);
    ccn.setEditable(true);
    bnk1.setEditable(true);
    cqno.setEditable(true);
    
    cstnm.setEnabled(true);
    slsnm.setEnabled(true);
    cstadd.setEnabled(true);
    cqdt.setEnabled(true);
}


//public void disc_
public void qtysum()
    {
   

        int sum=0;
        float sum1=0,sum2=0;
        int ss=invtab.getRowCount();
        
        for(int x=0;x<ss;x++)
        {
            int a=Integer.parseInt(invtab.getValueAt(x,3).toString());
            
           float b=Float.parseFloat(invtab.getValueAt(x,10).toString());
           float ab=Float.parseFloat(invtab.getValueAt(x,5).toString());
           float mul=a*ab;
           sum1+=mul;
//         
            sum+=a;
            
            sum2+=b;           
        }
//        float cal=
        totqty.setText(Integer.toString(sum));
        gramt.setText(Float.toString(sum1));
        amtp.setText(""+sum2);
        netamt.setText(""+sum2);
//        table1.setV        
        noi.setText(""+ss);
    }



float upramt, smam,refam,nicamt;
public void matc()
{
      nicamt=Float.parseFloat(pamt.getText());
//    float namt=Float.parseFloat(pamt.getText());
     refam=Float.parseFloat(cstend.getText());
     upramt=Float.parseFloat(amtp.getText());
     smam=0;
          int row2=paytab.getRowCount();
          for(int y=0;y<row2;y++)
          {
              float aah=Float.parseFloat(paytab.getValueAt(y,2).toString());
              smam+=aah;
          }
    
}    


        
        
        
public void add_row(Object[] row1)
{
    DefaultTableModel df=(DefaultTableModel)invtab.getModel();
    df.addRow(row1);
   
   
}

public void add_row1(Object[] row1)
{
    DefaultTableModel df=(DefaultTableModel)paytab.getModel();
    df.addRow(row1);
   
   
}

 
public void to_sum_pt1()
       {
          float aamo=Float.parseFloat(amtp.getText());
          float sm=0;
          int row2=paytab.getRowCount();
          for(int y=0;y<row2;y++)
          {
              float ah=Float.parseFloat(paytab.getValueAt(y,2).toString());
              sm+=ah;
          }
          float pyamt=aamo-sm;
           System.out.println("in func"+pyamt);
          pamt.setText(""+pyamt);
      }


public void to_shoown()
{   
    String s=invbar.getText();
    System.out.println(s);
     try {
               
            con=Server.getCon();
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
           
              String tushar="select bar_code,item_desc,mrp,sale_price,gst_per,item_id ,hsn_code from m_item where bar_code='" +s+"' OR item_id='"+s+"'";
            
             pst=con.prepareStatement(tushar);
            ResultSet rs=pst.executeQuery();
            if(rs.next())
            {
               
                b=rs.getString(1);
            
            ii=(rs.getString(2));
                System.out.println("item"+ii);
            m=(rs.getString(3));
            sp1=(rs.getString(4));
            gp=(rs.getString(5));
//            cs=(rs.getString(6));
            id=(rs.getString(6));
            hs=(rs.getString(7));
            }
            System.out.println(m);
            
            
            //JOptionPane.showMessageDialog(null, "Data Updated!");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
}


public void invdisc()
{
    x=Double.parseDouble(updisc.getText());
    System.out.println(x);
  
   
}


public void to_qtysp()
{
    to_shoown();
    invdisc();
    System.out.println("in qty");
//    to_shoown();
    String j1="1";
//    String c11="2";
     int s=invtab.getRowCount()+1;
          System.out.println(s);
//          
          double a=Double.parseDouble(qty.getText());
//      double  b1=Double.parseDouble(sp.getText());
double spp=Double.parseDouble(sp1);
      double c=a*spp;
      z=(x/100)*c;
      double mr=(c-z);
//       for(int i1=0;i1<invtab.getRowCount();i1++)
//  {  
////      float a=Float.parseFloat(tbl1.getValueAt(i,10).toString());
//      float b=Float.parseFloat(invtab.getValueAt(i1,10).toString());
//      mr+=b;
//  }
      cs="0";
      int invbar2=Integer.parseInt(invbar.getText());
       int sqbar=Integer.parseInt(b);
       int sqid=Integer.parseInt(id);
//      String c11=Double.toString(c);
//      invtab.setValueAt(c, 1,11);
        boolean chkk=chBar();
        System.out.println("value of bool is "+chkk);
        System.out.println("value of bool is "+!chkk);
      
      if( invbar2==sqbar || invbar2==sqid && !chkk)
      {
//          chBar();
          System.out.println("in the if of enter");
           add_row (new Object[]{
               s,
               b,
               ii,
      qty.getText(),
      m,
      sp1,
      updisc.getText(),
      z,
      gp,
      cs,
      mr,
      id,
      hs
      });
      }
      
      else if(chkk)
      {int qtl;
              float amtl;
          int row=invtab.getRowCount();
          if(row>=1)
          {
              qtl=Integer.parseInt(qty.getText())+qtyM;
              amtl=qtl*amtMain;
              invtab.setValueAt(qtl, rowBar, 3);
              invtab.setValueAt(amtl, rowBar, 10);
          }
      }
      
      else
      {
          JOptionPane.showMessageDialog(this,"Invalid Item Id or Barcode");
      }
           noi.setText(""+s);
           
//       add_row (new Object[]{
//               s,
////               b,
////               i,
//      qty.getText()
//});
}

public void cust_ins()
             {
                try{
        
            con=Server.getCon();
            //
            //            String url="jdbc:sqlserver://localhost:56822;databaseName=projectrms","sa","sql123"" ;
           
            String quer="select cust_id from m_cust";
             pst=con.prepareStatement(quer);
            java.sql.ResultSet rs=pst.executeQuery();

            while(rs.next())
      {
//          String sr=
          custcomb.addItem(rs.getString("cust_id"));
//          pst.setString(2,cstnm.getText());
//          pst.setString(3,cstadd.getText());
//     
           
      }
          }
    catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } 
             }

public void sals_ins()
{
    try {
        con=Server.getCon();
        
       
            String quer="select sals_id from m_salesman";
             pst=con.prepareStatement(quer);
            java.sql.ResultSet rs=pst.executeQuery();

            while(rs.next())
      {
//          String sr=
          custcomb.addItem(rs.getString("sals_id"));
//          pst.setString(2,cstnm.getText());
//          pst.setString(3,cstadd.getText());
//     
           
      }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
}
  
/*****************************For F1**************************************/
 
   static int p;                                 //after taking item from F1 table and after REMOVING it on the click it again comes.//
   public static String bar1="";
   public static String i_desc1="";
   public static String mrp1="";
   public static String sp22="";
   
   
public void refresh(String bar2,String mrp2,String sp2,String i_desc2)
    { String qty1="1";
      String disc2="00.00";
        System.out.println("ayaya");
        invbar.setText(bar2);
        qty.setText(qty1);
        invmrp.setText(mrp2);
        sp.setText(sp2);
        updisc.setText(disc2);
        itmdesc.setText(i_desc2);
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
        invno = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        custcomb = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        custbtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tim = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        slsmnid = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        invbar = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        invmrp = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        sp = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        updisc = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invtab = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        totdisc = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        totdiscamt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        amtp = new javax.swing.JLabel();
        netamt = new javax.swing.JLabel();
        gramt = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        itmdesc = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        noi = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        totqty = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        paym = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        pamt = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        cstend = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        ccn = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        cqno = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        bnk1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        paytab = new javax.swing.JTable();
        Addpanel = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        Savepanel = new javax.swing.JPanel();
        Save = new javax.swing.JButton();
        print = new javax.swing.JButton();
        Help = new javax.swing.JButton();
        Fresh = new javax.swing.JButton();
        Quit = new javax.swing.JButton();
        canvas1 = new java.awt.Canvas();
        cstnm = new javax.swing.JLabel();
        slsnm = new javax.swing.JLabel();
        cstadd = new javax.swing.JLabel();
        checkyn = new javax.swing.JCheckBox();
        cmaillbl = new javax.swing.JLabel();
        cmail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Invoice Generation");

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setText("Invoice No.");

        invno.setEditable(false);
        invno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                invnoFocusGained(evt);
            }
        });
        invno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invnoActionPerformed(evt);
            }
        });

        jLabel2.setText("Date");

        jLabel3.setText("Customer");

        custcomb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                custcombFocusGained(evt);
            }
        });
        custcomb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                custcombMouseClicked(evt);
            }
        });
        custcomb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custcombActionPerformed(evt);
            }
        });
        custcomb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                custcombKeyPressed(evt);
            }
        });

        jLabel4.setText("Cust. Name");

        custbtn.setText("Cust");
        custbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custbtnActionPerformed(evt);
            }
        });

        jLabel5.setText("Billed Time");

        tim.setText("0");
        tim.setEnabled(false);
        tim.setOpaque(true);

        jLabel7.setText("Salesman");

        slsmnid.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        slsmnid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                slsmnidFocusGained(evt);
            }
        });

        jLabel8.setText("Cust. Address");

        jPanel2.setForeground(new java.awt.Color(204, 153, 255));
        jPanel2.setOpaque(false);

        jLabel9.setText("ITEMID/BARCODE");

        invbar.setEditable(false);
        invbar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                invbarFocusGained(evt);
            }
        });
        invbar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invbarActionPerformed(evt);
            }
        });
        invbar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                invbarKeyPressed(evt);
            }
        });

        jLabel10.setText("QTY");

        qty.setEditable(false);
        qty.setText("0");
        qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyActionPerformed(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qtyKeyPressed(evt);
            }
        });

        jLabel11.setText("MRP");

        invmrp.setEditable(false);
        invmrp.setText("0");

        jLabel12.setText("SALE PRICE");

        sp.setEditable(false);
        sp.setText("0");

        jLabel13.setText("DISCOUNT %");

        updisc.setEditable(false);
        updisc.setText("0.00");
        updisc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                updiscKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invbar, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel10)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel11)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(invmrp, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel13))
                    .addComponent(updisc, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(invmrp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(invbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        invtab.setBorder(javax.swing.BorderFactory.createLineBorder(null));
        invtab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNo.", "Barcode", "Item Name", "Qty", "MRP", "Price", "Disc.", "Disc.Amt.", "GST", "CESS", "AMOUNT", "Item Id", "hsn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invtab.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        invtab.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                invtabMouseDragged(evt);
            }
        });
        invtab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invtabMouseClicked(evt);
            }
        });
        invtab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                invtabKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(invtab);
        if (invtab.getColumnModel().getColumnCount() > 0) {
            invtab.getColumnModel().getColumn(0).setPreferredWidth(50);
            invtab.getColumnModel().getColumn(1).setPreferredWidth(180);
            invtab.getColumnModel().getColumn(2).setPreferredWidth(240);
            invtab.getColumnModel().getColumn(3).setPreferredWidth(80);
            invtab.getColumnModel().getColumn(4).setPreferredWidth(120);
            invtab.getColumnModel().getColumn(5).setPreferredWidth(120);
            invtab.getColumnModel().getColumn(6).setPreferredWidth(70);
            invtab.getColumnModel().getColumn(7).setPreferredWidth(90);
            invtab.getColumnModel().getColumn(8).setPreferredWidth(70);
            invtab.getColumnModel().getColumn(9).setPreferredWidth(80);
            invtab.getColumnModel().getColumn(10).setPreferredWidth(110);
            invtab.getColumnModel().getColumn(11).setPreferredWidth(90);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 958, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );

        jLabel14.setText("Gross Amt");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Disc. %");

        totdisc.setEditable(false);
        totdisc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totdisc.setText("0.00");
        totdisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totdiscActionPerformed(evt);
            }
        });
        totdisc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                totdiscKeyPressed(evt);
            }
        });

        jLabel16.setText("Disc. Amt");

        totdiscamt.setEditable(false);
        totdiscamt.setText("0.00");
        totdiscamt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totdiscamtActionPerformed(evt);
            }
        });
        totdiscamt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                totdiscamtKeyPressed(evt);
            }
        });

        jLabel18.setText("Net Amt");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setText("Amt to Pay");

        amtp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        amtp.setOpaque(true);

        netamt.setOpaque(true);

        gramt.setOpaque(true);

        jLabel24.setText("Item desc.");

        itmdesc.setOpaque(true);

        jLabel26.setText("No. of Items");

        noi.setText("0");
        noi.setOpaque(true);

        jLabel28.setText("Tot. Qty");

        totqty.setBackground(new java.awt.Color(255, 255, 255));
        totqty.setText("0");
        totqty.setOpaque(true);

        jPanel4.setOpaque(false);

        jLabel30.setText("PAY MODES");

        paym.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymActionPerformed(evt);
            }
        });

        jLabel31.setText("AMOUNT");

        pamt.setEditable(false);
        pamt.setText("0.00");
        pamt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pamtKeyPressed(evt);
            }
        });

        jLabel32.setText("CASH TEND");

        cstend.setEditable(false);
        cstend.setText("00.00");
        cstend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cstendActionPerformed(evt);
            }
        });
        cstend.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cstendKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cstendKeyReleased(evt);
            }
        });

        jLabel33.setText("CC No.");

        ccn.setEditable(false);

        jLabel34.setText("CHQ. NO");

        cqno.setEditable(false);

        jLabel35.setText("CHQ. DATE");

        bnk1.setEditable(false);

        jLabel36.setText("BANK");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paym, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel30)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(pamt, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel31)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cstend, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel32)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ccn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel33)))
                .addGap(17, 17, 17)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bnk1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel36)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cqno, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel34)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bnk1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ccn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cstend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(paym, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cqno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        paytab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNo.", "Pay Mode", "Pay Amt", "Cash", "Refund", "CC No", "Bank", "Cheque No.", "Cheque dt"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        paytab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paytabMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(paytab);
        if (paytab.getColumnModel().getColumnCount() > 0) {
            paytab.getColumnModel().getColumn(0).setPreferredWidth(50);
            paytab.getColumnModel().getColumn(1).setPreferredWidth(180);
            paytab.getColumnModel().getColumn(2).setPreferredWidth(240);
            paytab.getColumnModel().getColumn(3).setPreferredWidth(80);
            paytab.getColumnModel().getColumn(4).setPreferredWidth(120);
            paytab.getColumnModel().getColumn(5).setPreferredWidth(110);
            paytab.getColumnModel().getColumn(6).setPreferredWidth(120);
            paytab.getColumnModel().getColumn(7).setPreferredWidth(70);
            paytab.getColumnModel().getColumn(8).setPreferredWidth(90);
        }

        Addpanel.setOpaque(false);

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

        javax.swing.GroupLayout AddpanelLayout = new javax.swing.GroupLayout(Addpanel);
        Addpanel.setLayout(AddpanelLayout);
        AddpanelLayout.setHorizontalGroup(
            AddpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddpanelLayout.createSequentialGroup()
                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        AddpanelLayout.setVerticalGroup(
            AddpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddpanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(AddpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        Savepanel.setOpaque(false);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
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

        javax.swing.GroupLayout SavepanelLayout = new javax.swing.GroupLayout(Savepanel);
        Savepanel.setLayout(SavepanelLayout);
        SavepanelLayout.setHorizontalGroup(
            SavepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SavepanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Save, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(print, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Help, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Fresh, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Quit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        cstnm.setOpaque(true);

        slsnm.setOpaque(true);

        cstadd.setOpaque(true);

        checkyn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkyn.setText("AMOUNT PAID");
        checkyn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkynActionPerformed(evt);
            }
        });

        cmaillbl.setText("Cust. Email");

        cmail.setOpaque(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(invno, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(166, 166, 166)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(custcomb, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(32, 32, 32)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cstnm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(custbtn)
                                                .addGap(8, 8, 8))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(slsmnid, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(slsnm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cstadd, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmaillbl)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmail, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(4, 4, 4)
                                        .addComponent(gramt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(totdisc, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(totdiscamt, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(jLabel18)
                                        .addGap(4, 4, 4)
                                        .addComponent(netamt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(amtp, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(itmdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(26, 26, 26)
                                                .addComponent(jLabel26)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(noi, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel28)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(totqty, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(Addpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(checkyn, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(116, 116, 116))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Savepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(invno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(custcomb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(custbtn)
                            .addComponent(cstnm, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tim, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(slsmnid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel8)
                                .addComponent(slsnm, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cstadd, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmaillbl)
                            .addComponent(cmail, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(checkyn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(totdisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(totdiscamt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(amtp, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(netamt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gramt, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel28)
                                .addComponent(totqty, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel24)
                                .addComponent(itmdesc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26)
                                .addComponent(noi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(canvas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)))
                .addComponent(Addpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Savepanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 970, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_addMouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        Addpanel.hide();
        editenabTru();
        Savepanel.show();
//        savdel.hide();
        i=1;
        invbar.requestFocusInWindow();
//        cust_ins();
        
    }//GEN-LAST:event_addActionPerformed

    private void addKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_addKeyPressed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
                    insertserno();
                    new myThread().start();

                    otpgen otg=new otpgen();
        String neotp=otg.generateOtp();
        
        String am=amtp.getText();
        String message="<h3>THANK YOU FOR SHOPPING WITH US FOR RS.</h3><h4>"+am+"</h4><p>Your OTP is:</p><h1><b><p style=color:Red;>"+neotp+"</p> </h1>";
        String subject="HI YOUR OTP IS";
        
        
        String from ="shivendra9810256984@gmail.com";
        if(i==1){

            my_adddet();
            my_addhdr();
            
                my_addpaym();
            
            
            
            empty();
//            insertserno();
//            gmail g=new gmail();
//              Mail m=new Mail();
            String to=cmail.getText();
//            m.send_mail(to,message,neotp);

            //for MAIL
            gmail gml=new gmail();
            gml.sendEmail(message,subject,to,from);

           JOptionPane.showMessageDialog(null,"MAIL SENT SUCCESSFULLY!!!!");
           invno.setText("");
          
        }
//        else if(i==2){
//
//            
//            my_modify();
//
//        }
        //     else if(i==3){
            //     my_delete();
            //     }

        // my_add();
        //my_modify();

    }//GEN-LAST:event_SaveActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
//        // TODO add your handling code here:
insertserno();
new myThread().start();

otpgen otg=new otpgen();
        String neotp=otg.generateOtp();
        String am=amtp.getText();
        String message="<h3>THANK YOU FOR SHOPPING WITH US FOR RS.</h3><h4>"+am+"</h4><p>Your OTP is:</p><h1><b><p style=color:Red;>"+neotp+"</p> </h1>";
        String subject="HI YOUR OTP IS";
        
        
        String from ="shivendra9810256984@gmail.com";
        
         if(i==1){   
         my_adddet();
            my_addhdr();
            
            my_addpaym();
            
            String to=cmail.getText();            
                        gmail gml=new gmail();
            gml.sendEmail(message,subject,to,from);

           JOptionPane.showMessageDialog(null,"MAIL SENT SUCCESSFULLY!!!!");

//            Loader ldr=new Loader();
//            ldr.setVisible(true);
//            String a;
//            ldr.progress.setValue(i);
            String newin=invno.getText();
            String newdes=itmdesc.getText();
                   
//            ldr.setVisible(false);
        try {
            String sql=null;
            con=Server.getCon();
           
//            JasperDesign jdesign=JRXmlLoader.load("E:\\Retailmgtsys\\RETAIL1\\src\\report1.jrxml");
                          JasperDesign jdesign=JRXmlLoader.load("D:\\Report\\report1.jrxml");
             sql="select * from t_inv_hdr h,t_inv_det d,t_inv_paymode p where h.inv_no=d.inv_no and h.inv_no=p.inv_no and h.inv_no='"+newin+"'";
            
            JRDesignQuery updateQuery=new JRDesignQuery();
            updateQuery.setText(sql);
            jdesign.setQuery(updateQuery);
            JasperReport jreport=JasperCompileManager.compileReport(jdesign);
            JasperPrint jprint=JasperFillManager.fillReport(jreport,null,con);
          
            JasperViewer.viewReport(jprint,false);
            
            
            
//            JasperViewer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//               JasperViewer.s;
//                 JasperViewer.    viewReport(jprint,false);


            empty();
            invno.setText("");
            cmail.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "in catch"+e);
        }
         }
    }//GEN-LAST:event_printActionPerformed

    private void HelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HelpActionPerformed
        // TODO add your handling code here:
        newTable tb=new newTable();
        tb.setVisible(true);

    }//GEN-LAST:event_HelpActionPerformed

    private void FreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FreshActionPerformed
        // TODO add your handling code here:
//        grpid.setText("");
//        grpdesc.setText("");

    }//GEN-LAST:event_FreshActionPerformed

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
        // TODO add your handling code here:
        
        setDefaultCloseOperation(dashboard.DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_QuitActionPerformed

    private void invnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invnoActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_invnoActionPerformed

    private void invbarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invbarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_invbarActionPerformed

    private void totdiscamtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totdiscamtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totdiscamtActionPerformed

    private void custbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custbtnActionPerformed
        // TODO add your handling code here:
        custmaster cs=new custmaster();
        cs.setVisible(true);
        
    }//GEN-LAST:event_custbtnActionPerformed

    private void qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
//            invtab.setShowHorizontalLines(true);
//            invtab.setShowVerticalLines(true);
//            invtab.setShowGrid(true);
      {DefaultTableModel model=(DefaultTableModel)invtab.getModel();
        int selectedRowIndex=invtab.getSelectedRow();
//          to_shoown();
         to_qtysp();
          System.out.println("qty sum");
         qtysum();
         
         DecimalFormat pr=new DecimalFormat("##,###.###");
         float ngrs=Float.parseFloat(gramt.getText());
        float tod=Float.parseFloat(totdisc.getText());
        float pe=(tod/100)*ngrs;
        
         float qt= Float.parseFloat(pr.format(pe));
        
        float round=Math.round(qt);
        
        
        System.out.println(pe);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)  
        {
            totdiscamt.setText(""+round);
        }
        
        float am=ngrs-round;
        {
//            netamt.setText(""+am);
//            amtp.setText(""+am);
//            pamt.setText(""+am);
        }
        
      qty.setText("");
      sp.setText("");
//      totqty.setText("");
      
      invbar.requestFocusInWindow();
      invbar.setText("");
      invmrp.setText("00.00");
      sp.setText("00.00");
//      invtab.editingStopped(e);
      
      
//      invtab.sete
              
      }

    }//GEN-LAST:event_qtyKeyPressed

    private void updiscKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_updiscKeyPressed
        // TODO add your handling code here:
          if(evt.getKeyCode()==KeyEvent.VK_ENTER)
      {DefaultTableModel model=(DefaultTableModel)invtab.getModel();
        int selectedRowIndex=invtab.getSelectedRow();
//          to_shoown();
         to_qtysp();
          System.out.println("qty sum");
         qtysum();
         
         DecimalFormat pr=new DecimalFormat("##,###.###");
         float ngrs=Float.parseFloat(gramt.getText());
        float tod=Float.parseFloat(totdisc.getText());
        float pe=(tod/100)*ngrs;
        
         float qt= Float.parseFloat(pr.format(pe));
        
        float round=Math.round(qt);
        
        
        System.out.println(pe);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)  
        {
            totdiscamt.setText(""+round);
        }
        
//        float am=ngrs-round;
//        {
//            netamt.setText(""+am);
//            amtp.setText(""+am);
////            pamt.setText(""+am);
//        }
        
      qty.setText("");
      sp.setText("");
//      totqty.setText("");
      
      invbar.requestFocusInWindow();
      invbar.setText("");
      invmrp.setText("00.00");
      sp.setText("00.00");
      updisc.setText("00.00");
//      invtab.editingStopped(e);
      
      
//      invtab.sete
          disccal();
      }

    }//GEN-LAST:event_updiscKeyPressed

    private void invtabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invtabMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2)
        {
//            evt.consume();
        
        DefaultTableModel model=(DefaultTableModel)invtab.getModel();
        int selectedRowIndex=invtab.getSelectedRow();
        invbar.setText(model.getValueAt(selectedRowIndex, 1).toString());
        qty.setText(model.getValueAt(selectedRowIndex, 3).toString());
        invmrp.setText(model.getValueAt(selectedRowIndex, 4).toString());
        sp.setText(model.getValueAt(selectedRowIndex, 5).toString());
        updisc.setText(model.getValueAt(selectedRowIndex, 6).toString());
        
        model.removeRow(selectedRowIndex);
//        totqty.setText("");
        qtysum();
        int r;
//            h=tbl1.getSelectedRow();
            int cr=invtab.getRowCount();
            for(int i=selectedRowIndex;i<cr;i++)
            {
                 r=(int)invtab.getValueAt(i, 0);
                 System.out.println("inside "+r);
                r--;  
                System.out.println(""+r);
                invtab.setValueAt(r, i, 0);
            }  
                         
         disccal();
        
    }//GEN-LAST:event_invtabMouseClicked

    
    
//        model.removeRow(selectedRowIndex);
    }                                    
    
    private void invtabKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invtabKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode()==KeyEvent.VK_DELETE){
            
            DefaultTableModel model=(DefaultTableModel)invtab.getModel();
            int sri=invtab.getSelectedRow();
            model.removeRow(sri);
            qtysum();        
            int r;
//            h=tbl1.getSelectedRow();
            int cr=invtab.getRowCount();
            for(int i=sri;i<cr;i++)
            {
                 r=(int)invtab.getValueAt(i, 0);
                r--;  
                invtab.setValueAt(r, i, 0);
            }
            disccal();
        }
      
    }//GEN-LAST:event_invtabKeyPressed

    public void todisc()
    {
        float ngrs=Float.parseFloat(gramt.getText());
        float tod=Float.parseFloat(totdisc.getText());
        float per=(tod/100)*ngrs;
        float gamt=ngrs-per;
        
    }
    
    private void totdiscKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totdiscKeyPressed
        DecimalFormat pr=new DecimalFormat("##,###.###");
        float ngrs=Float.parseFloat(gramt.getText());
        float tod=Float.parseFloat(totdisc.getText());
        float pe=(tod/100)*ngrs;
         float qt= Float.parseFloat(pr.format(pe));
        
        float round=Math.round(qt);
        float amotp=ngrs-round;
        
        System.out.println(pe);
        System.out.println(round);
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)  
        {
            totdiscamt.setText(""+round);
            amtp.setText(""+amotp);
        }
        
//        float am=ngrs-round;
//        {
//            netamt.setText(""+am);
//            amtp.setText(""+am);
//            pamt.setText(""+am);
//        }
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_totdiscKeyPressed

    private void invtabMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invtabMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_invtabMouseDragged

    private void qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyActionPerformed

    private void invbarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_invbarKeyPressed
        // TODO add your handling code here:
        
                if(evt.getKeyCode()==KeyEvent.VK_F3)  
                {if(checkyn.isSelected())
                   {paym.setSelectedIndex(1);
                    String pam=amtp.getText();
                    pamt.setText(pam);
                    cstend.setText("0.00");
                   }
                  else
                   {
                       cstend.setText("0.00");
                     pamt.setText("0.00");
                     cstend.requestFocus();
                   }
                
                }
                
                if(evt.getKeyCode()==KeyEvent.VK_F1)  
                {   
                    
                    InvTable invt=new InvTable();
                    invt.setVisible(true);
                }
    }//GEN-LAST:event_invbarKeyPressed

    private void totdiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totdiscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totdiscActionPerformed

    private void cstendKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cstendKeyPressed
        
        float amo=Float.parseFloat(pamt.getText());
        float damo=Float.parseFloat(amtp.getText());
        float cste=Float.parseFloat(cstend.getText());
        float dif=0;
        float re;
        matc();
        if(cste<amo)
        {
         re=(cste-amo)*(-1);    
        }
        else
        {
           re=cste-amo;
        }
        
        String ccc=ccn.getText();
        String gg="cheq";
        String gc="cash";
        String gh="cc/dc";
        String gemp="";
        String p=paym.getSelectedItem().toString();
        String cc="";
        String bn=bnk1.getText();
        String cq=cqno.getText();
        System.out.println(p);
//        Date d=new Date();
         if(damo>amo)
         {
             dif=damo-amo;
         }
              
         System.out.println("hhhhh76");
      
    int s=paytab.getRowCount()+1;
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {     System.out.println("hhhhh");
//           
            if(smam==upramt)
    {
        JOptionPane.showMessageDialog(null, "Amount Matched!!!");
    }
            
    else
            {
            if(p.equals(gg))
        {SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
    
          String dd=sdf.format(cqdt.getDate());
                     
              add_row1 (new Object[]{
               s,
               p,
               amo,
               cstend.getText(),
               cstend.getText(),
               cc,
               bn,
               cq,
               dd
               
                 });
              
               System.out.println("kkkk");
               }
                 

            
               else if(p.equals(gh))
               {
            
              add_row1 (new Object[]{
               s,
               p,
               amo,
               cstend.getText(),
               cstend.getText(),
               ccc,
//               cc,
//               cc,
//               cc
               });
               System.out.println("okokokok");
               }
               else if(p.equals(gc))
               {
                   if(refam<nicamt)
                   {
                       JOptionPane.showMessageDialog(this, "Cash Tend Cannot Be < PAY AMOUNT!! ");
                   }
                   else{
               add_row1 (new Object[]{
               s,
               p,
               amo,
               cstend.getText(),
               re,
               cc,
               cc,
               cc,
               cc
                 
               });
                   }}
               else if(p.equals(gemp))
                    {
               add_row1 (new Object[]{
               s,
               gemp,
               "0",
               cstend.getText(),
               cstend.getText(),
               cc,
               cc,
               cc,
               cc
                      });
                    }
            else
                {
               add_row1 (new Object[]{
               s,
               p,
               amo,
               cstend.getText(),
               cstend.getText(),
               cc,
               cc,
               cc,
               cc
                      });
                    }
            System.out.println("hjhjhjh");

            cstend.setText("00.00");
        }
            if(damo>amo)
         {
              to_sum_pt1();
//            pamt.setText(""+dif);
         }
            else
            {
                fresh();
            }
        }
        
    }//GEN-LAST:event_cstendKeyPressed

    private void pamtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pamtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pamtKeyPressed

    private void cstendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cstendActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cstendActionPerformed

    private void custcombKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_custcombKeyPressed

                if(evt.getKeyCode()==KeyEvent.VK_F1)  
                {
                    newTable mt=new newTable();
                    mt.setVisible(true);
                    
                    
                }




        // TODO add your handling code here:
    }//GEN-LAST:event_custcombKeyPressed

    private void custcombActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custcombActionPerformed
        // TODO add your handling code here:
        try {                                        
            String cs1=custcomb.getSelectedItem().toString();          
            con=Server.getCon();
           
           
            
            String tushar="Select cust_nm,addr,email from m_cust where cust_id='"+cs1+"'";
             pst=con.prepareStatement(tushar);
            java.sql.ResultSet rs=pst.executeQuery();
            
           if(rs.next())
            {
//                String value=(String)grpcom.getSelectedItem();
                cstnm.setText(rs.getString(1));
                cstadd.setText(rs.getString(2));
                cmail.setText(rs.getString(3));
                //1 is taken becoz as we specify only 1 text field to find anotherone  
            }  
              // TODO add your handling code here:
        }
     catch (Exception e) {
        }
    }//GEN-LAST:event_custcombActionPerformed

    private void custcombMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_custcombMouseClicked
        // TODO add your handling code here:
                
       
    }//GEN-LAST:event_custcombMouseClicked

    private void custcombFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_custcombFocusGained
        // TODO add your handling code here:
        custcomb.removeAllItems();
        cstnm.setText("");
        cstadd.setText("");
        custcomb.setSelectedItem(null);
        custcomb.addItem("");

        cust_ins(); 
    }//GEN-LAST:event_custcombFocusGained

    private void slsmnidFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_slsmnidFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_slsmnidFocusGained

    private void invbarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_invbarFocusGained
        // TODO add your handling code here:
        if(p==1)
       {
//public void refresh(String bar2,String mrp2,String sp2,String i_desc2)
           System.out.println("in if focus"); 
        refresh(bar1,mrp1,sp22,i_desc1);       
       }
       p=0;
    }//GEN-LAST:event_invbarFocusGained

    private void checkynActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkynActionPerformed
        invbar.requestFocusInWindow();  
        
    }//GEN-LAST:event_checkynActionPerformed

    private void paymActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymActionPerformed

    private void cstendKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cstendKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cstendKeyReleased

    private void paytabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paytabMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2)
        {
//            evt.consume();
        
        DefaultTableModel model=(DefaultTableModel)paytab.getModel();
        int selectedRowIndex=paytab.getSelectedRow();
//        invbar.setText(model.getValueAt(selectedRowIndex, 1).toString());
         paym.setSelectedItem(model.getValueAt(selectedRowIndex, 1).toString());
        pamt.setText(model.getValueAt(selectedRowIndex, 2).toString());
        cstend.setText(model.getValueAt(selectedRowIndex, 3).toString());
        ccn.setText(model.getValueAt(selectedRowIndex, 5).toString());
        bnk1.setText(model.getValueAt(selectedRowIndex, 6).toString());
        cqno.setText(model.getValueAt(selectedRowIndex, 7).toString());
//        bnk1.setText(model.getValueAt(selectedRowIndex, 8).toString());
//        
//          SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//           String dd=sdf.format(cqdt.setDate((Date)model.getValueAt(selectedRowIndex, 8)));
          String chqdt=model.getValueAt(selectedRowIndex,8).toString();
        try{
         Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(chqdt);  
 
         cqdt.setDate(date1);
        }
        catch(Exception e)
        {
        }

           model.removeRow(selectedRowIndex);
//        totqty.setText("");
        
        int r;
//            h=tbl1.getSelectedRow();
            int cr=paytab.getRowCount();
            for(int i=selectedRowIndex;i<cr;i++)
            {
                 r=(int)paytab.getValueAt(i, 0);
                r--;  
                paytab.setValueAt(r, i, 0);
            }  
                         
           
//          String dd=sdf.format(cqdt.setDate((String) model.getValueAt(selectedRowIndex, 8)));
        
       
//        totqty.setText("");
                
        
    }                                   

    }//GEN-LAST:event_paytabMouseClicked

    private void totdiscamtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totdiscamtKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_totdiscamtKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
      close();
        setDefaultCloseOperation(dashboard.DISPOSE_ON_CLOSE); 
    }//GEN-LAST:event_jButton6ActionPerformed

    private void invnoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_invnoFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_invnoFocusGained

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
            java.util.logging.Logger.getLogger(InvoicGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InvoicGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InvoicGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InvoicGen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InvoicGen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Addpanel;
    private javax.swing.JButton Fresh;
    private javax.swing.JButton Help;
    private javax.swing.JButton Quit;
    private javax.swing.JButton Save;
    private javax.swing.JPanel Savepanel;
    private javax.swing.JButton add;
    private javax.swing.JLabel amtp;
    private javax.swing.JTextField bnk1;
    private java.awt.Canvas canvas1;
    private javax.swing.JTextField ccn;
    private javax.swing.JCheckBox checkyn;
    private javax.swing.JLabel cmail;
    private javax.swing.JLabel cmaillbl;
    private javax.swing.JTextField cqno;
    private javax.swing.JLabel cstadd;
    private javax.swing.JTextField cstend;
    private javax.swing.JLabel cstnm;
    private javax.swing.JButton custbtn;
    private javax.swing.JComboBox<String> custcomb;
    private javax.swing.JLabel gramt;
    public javax.swing.JTextField invbar;
    private javax.swing.JTextField invmrp;
    public javax.swing.JTextField invno;
    private javax.swing.JTable invtab;
    private javax.swing.JLabel itmdesc;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel netamt;
    private javax.swing.JLabel noi;
    private javax.swing.JTextField pamt;
    private javax.swing.JComboBox<String> paym;
    private javax.swing.JTable paytab;
    private javax.swing.JButton print;
    private javax.swing.JTextField qty;
    private javax.swing.JComboBox<String> slsmnid;
    private javax.swing.JLabel slsnm;
    private javax.swing.JTextField sp;
    private javax.swing.JLabel tim;
    private javax.swing.JTextField totdisc;
    private javax.swing.JTextField totdiscamt;
    private javax.swing.JLabel totqty;
    private javax.swing.JTextField updisc;
    // End of variables declaration//GEN-END:variables
}
