
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class otpgen {
    
    public static String generateOtp()
    {
        int randomNo=(int) (Math.random()*9000)+1000;
        String otp=String.valueOf(randomNo);
        return otp;
    }
    
    
}
