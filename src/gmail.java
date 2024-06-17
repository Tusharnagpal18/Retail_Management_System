
import java.io.File;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class gmail {
//    String message="******THANKING YOU******";
//        String subject="HI MY FIRST MAIL";
//        String to="softgenbds@gmail.com";
//        String from ="shivendra9810256984.com";
//        sendEmail(message,subject,to,from);
    
    //Responsible for send msg....

    public static void sendEmail(String message, String subject, String to, String from) {
                        
//        InvoicGen invg=new InvoicGen();
//        invg.getcustidformail();
        //Variable for gmail
        
        String host="smtp.gmail.com";
        
        //Get the System Properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES"+properties);
        
        //Setting important information to Properties object
        //HOST SET
        
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465"); //GMAIL PORT PUT IT IN A STRING
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.socketFactory.fallback", "false");
        
        //Step 1:To get the Session object...
        Session session=Session.getInstance(properties, new Authenticator()//Authenticator having annonymous class
 {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("shivendra9810256984@gmail.com", "tqxhvqtfqngjxplg"); //To change body of generated methods, choose Tools | Templates.
            }
   
});        
        session.setDebug(true);
        //Step 2:Compose the message[text,Multimedia]
        MimeMessage m=new MimeMessage(session);
        
        try{
        //from email
        m.setFrom(new InternetAddress(from));
        
        //adding Recepient to message
        m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        
        //adding Subject to msg
        m.setSubject(subject);
        
        //adding text to msg
        m.setText(message);
        m.setContent(message,"text/html");
        
        
        
        //Send 
        //Step 3:Send msg using Transport class
            Transport.send(m);
            
            System.out.println("Sent Successsfulllyyy.......");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
       
    }

    
//    This is for Attachment
//    public static void sendAttach(String message, String subject, String to, String from) {
//        
//        String host="smtp.gmail.com";
//        
//        //Get the System Properties
//        Properties properties = System.getProperties();
//        System.out.println("PROPERTIES"+properties);
//        
//        //Setting important information to Properties object
//        //HOST SET
//        
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", "465"); //GMAIL PORT PUT IT IN A STRING
//        properties.put("mail.smtp.ssl.enable", "true");
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.socketFactory.port", "465");
//                properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//                properties.put("mail.smtp.socketFactory.fallback", "false");
//        
//        //Step 1:To get the Session object...
//        Session session=Session.getInstance(properties, new Authenticator()//Authenticator having annonymous class
// {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("shivendra9810256984@gmail.com", "Physicschemibio"); //To change body of generated methods, choose Tools | Templates.
//            }
//   
//});        
//        session.setDebug(true);
//        //Step 2:Compose the message[text,Multimedia]
//        MimeMessage m=new MimeMessage(session);
//        
//        try{
//        //from email
//        m.setFrom(new InternetAddress(from));
//        
//        //adding Recepient to message
//        m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//        
//        //adding Subject to msg
//        m.setSubject(subject);
//        
//       //Attachment
//       //path
//       String path="D:\\SHIVENDRA KUMAR SINGH RESUME.pdf";
//       
//            MimeMultipart mimeMultipart=new MimeMultipart();
//            //text  //file
//            MimeBodyPart textmime = new MimeBodyPart();
//            MimeBodyPart fileMime = new MimeBodyPart();
//        
//            try {
//                textmime.setText(message);
//                File file=new File(path);
//                MimeBodyPart attachmentPart = new MimeBodyPart();
//                attachmentPart.attachFile(file);
//                
//                mimeMultipart.addBodyPart(textmime);
//                mimeMultipart.addBodyPart(fileMime);
//                 
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            m.setContent(mimeMultipart);
//        //Send 
//        //Step 3:Send msg using Transport class
//            Transport.send(m);
//            
//            System.out.println("Sent Successsfulllyyy.......");
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        }
//       
//        
    }
    
//}
