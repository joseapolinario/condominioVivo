package services;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailCondominio {

    SimpleEmail email = new SimpleEmail();

    public EmailCondominio() {

        try {
            email.setHostName("smtp.googlemail.com");
            email.setSslSmtpPort("465");
            email.setAuthenticator(new DefaultAuthenticator("condominiovivo@gmail.com", "condominiovivo@12"));
            email.setSSLOnConnect(true);
            email.setFrom("joseapolinario7@gmail.com", "jose");

            email.setSubject("Teste message");
            email.setMsg("Espero que esteja lendo isso...");
            
            email.addTo("joseapolinario7@gmail.com", "Jose");
            
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(EmailCondominio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}