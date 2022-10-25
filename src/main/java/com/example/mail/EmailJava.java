package com.example.mail;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailJava {
    Email email;

    public EmailJava(){
        email = new SimpleEmail();
        config();
    }

    private void config(){
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setDebug(true);
        email.setAuthentication("medicinesreminderapp@gmail.com","zaq1@WSX");
        email.setSSLOnConnect(true);
    }
    public void sendEmail(String password, String toEmail){
        try{

            email.setFrom("fitapp@gmail.com");
            email.setSubject("Password reminder");
            email.setMsg("This is your password:  "+password);
            email.addTo(toEmail);
            email.addReplyTo("fitapp@gmail.com");
            email.send();
        }catch(EmailException ex){
        }
    }

}
