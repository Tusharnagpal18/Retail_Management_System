///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package my_package;
//
//import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.security.Security;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class Mail {
//    
    public static  void send_mail(String mailid,String msg,String otp)
 {
     String userid="shamit",pass="pass123";
     String otpmsg="YOUR OTP IS"+otp;
     try{
         if(mailid!=null){
                String[] EMAILADDR = {mailid}; 
                Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                Properties props = new Properties();
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.auth", "true");
                props.put("mail.debug", "true");
                props.put("mail.smtp.port", "465");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.socketFactory.fallback", "false");
                Session ses = Session.getDefaultInstance(props,new javax.mail.Authenticator() 
                {
                    protected PasswordAuthentication getPasswordAuthentication() 
                    {
                        //Please Provide The Sender Address
                      return new PasswordAuthentication("shivendra9810256984@gmail.com", "tqxhvqtfqngjxplg");
                    }
                });
                ses.setDebug(true);
               
                Message msgg = (Message) new MimeMessage(ses); // Multipurpose Internet Mail Extension 
                InternetAddress addressFrom = new InternetAddress("shivendra9810256984@gmail.com");
                msgg.setFrom(addressFrom);
                InternetAddress[] ADDRESS_TO = new InternetAddress[EMAILADDR.length];
                System.out.println("size of emailaddr is "+EMAILADDR.length);
                for (int i = 0; i < EMAILADDR.length; i++) 
                {
                    
                        ADDRESS_TO[i] = new InternetAddress(EMAILADDR[i]);
                                        
                }
                msgg.setRecipients(Message.RecipientType.BCC, ADDRESS_TO);
               // Setting the Subject and Content Type
               
                msgg.setSubject("THANK YOU FOR SHOPPING WITH US!!");
                msgg.setContent(msg+"\n"+otpmsg,"text/html");
//                msgg.setContent("your OTP is"+otp,"text/html");
//                msgg.setContent("Hello "+userid+", this mail is sent with the help of java code \n request for password recovery & ur password is - "+pass, "text/html");
                Transport.send((javax.mail.Message) msgg);
                System.out.println("successfully sent");
            
              }
            else
            {
                System.out.println("in the else");

            }
     }
     catch(Exception e)
     {
         System.out.println("exception is "+e);   
     }
 }
}

