/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
import java.io.*;
import java.sql.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;

/**
 *
 * @author Admin
 */
public class Server {
    private static Connection con;

       static ServerSocket server = null;
    Socket client = null;
    ObjectOutputStream out =null;
    String str = null;
    /**
     * @return the con
     */
    
    public Server()
    {
        try {
            server = new ServerSocket(1236);
            
            System.out.println("Starting the Server");
            
            login ll=new login();
            
            ll.setVisible(true);
//            dashboard d=new dashboard();
//            d.setVisible(true);
//            ll.lgn_check();
//               Loader ld=new Loader();
//               ld.setVisible(true);

//              m_group mg=new m_group();
//              mg.setVisible(true);
//            check();
//server.close();
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
//    public  void soc()
//    {
//        try{
//        server = new ServerSocket(3456);
//        }
//        catch(Exception e)
//        {
//            
//        }
//    }
    
    public static Connection getCon() {

       try {
//           server = new ServerSocket(9999);
           Class.forName("com.mysql.jdbc.Driver");
           con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Retailmgt?zeroDateTimeBehavior=convertToNull","root","");
            server.close();
        } catch (Exception e)
        {
            
        }
       return con;
    }

    /**
     * @param aCon the con to set
     */
//    public void check()
//    {
////        login l=new login();
////         l.lgn_check();
//        m_group mg=new m_group();
//        mg.my_add();
//        mg.my_modify();
//        mg.my_delete();
//        
//    }
    public static void setCon(Connection aCon) {
        con = aCon;
    }
    
    public static void main(String[] args) {
       new Server();
    }
}
