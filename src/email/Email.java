/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.swing.JOptionPane;
/**
 *
 * @author hyder_000
 */
public class Email {
    private String To;
    private String From;
    private String Subject;
    private String message;
    private String Password;
    private int number;
    
    
    
    public Email(String To,String From,String Subject,String Password,String message,int number){
    this.To=To;
    this.From=From;
    this.Subject=Subject;
    this.Password=Password;
    this.message=message;
    this.number=number;
    
    }
    
    public void Send(){
    
    Properties p=new Properties();
    p.put("mail.smtp.auth", "true");
    p.put("mail.smtp.starttls.enable", "true");
    p.put("mail.smtp.host", "smtp.gmail.com");
    p.put("mail.smtp.port",587);
    
    Session s=Session.getInstance(p, new javax.mail.Authenticator() {
       protected PasswordAuthentication getPasswordAuthentication(){
       
           return new PasswordAuthentication(From, Password);
       }
    });
    
    MimeMessage email=new MimeMessage(s);
    
    try{
    
        email.setFrom(new InternetAddress(From));
        email.addRecipients(Message.RecipientType.TO, To);
        email.setSubject(Subject);
        email.setText(message);
        
        for(int i=1; i<number; i++){
       
            Transport.send(email);
            
        }
        JOptionPane.showMessageDialog(null,"Sent Successfully");
        
    }
    catch(Exception e){
    
        JOptionPane.showMessageDialog(null, "Google has blocked this due to security");
      
        System.out.println(e);
      
      
      
      }    
    }
}
