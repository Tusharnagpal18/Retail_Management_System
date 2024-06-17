
import java.sql.Connection;
import java.sql.DriverManager;
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class DB {
 
    private static Connection con;

    /**
     * @return the con
     */
    public static Connection getCon() {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////            con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Retailmgt","sa","sql123");
//        con=DriverManager.getConnection("jdbc:sqlserver://localhost:49949;databaseName=Retailmgt","sa","bds123");
//        } catch (Exception e) {
//        }
//        return con;

//FOR MYSQL
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
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
    
}
