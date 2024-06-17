package retail1;

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
//import com.mysql.jdbc.Conection;
//import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
//import java.mysql.j

/**
 *
 * @author Admin
 */
public class Server {
    private static Connection con;

     ServerSocket server = null;
    Socket client = null;
    ObjectOutputStream out =null;
    String str = null;
    /**
     * @return the con
     */
    
    public Server()
    {
        try {
            server = new ServerSocket(3456);
            System.out.println("Starting the Server");
            
            Loginnew ll=new Loginnew();
            ll.setVisible(true);
//               Loader ld=new Loader();
//               ld.setVisible(true);

//              m_group mg=new m_group();
//              mg.setVisible(true);
//            check();
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Connection getCon() {

       try {
           Class.forName("com.mysql.jdbc.Driver");
           con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Retailmgt?zeroDateTimeBehavior=convertToNull","root","");
            
        } catch (Exception e) {
        }
       return con;
    }

    /**
     * @param aCon the con to set
     */

    public static void setCon(Connection aCon) {
        con = aCon;
    }
    
    public static void main(String[] args) {
       new Server();
    }
}
