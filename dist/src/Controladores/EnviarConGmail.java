
package Controladores;
     
import java.util.Properties;
import javax.mail.*;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EnviarConGmail {
    public  void EnviarConGMail(String destinatario, String asunto, String cuerpo) {
        if(!destinatario.equalsIgnoreCase("")){
            String remitente = "venturagroup.noreply";  //Para la dirección nomcuenta@gmail.com
            String clave = "V3ntur4.2019";  //Para la dirección nomcuenta@gmail.com

            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");  //El servidor SMTP de Google
            props.put("mail.smtp.user", remitente);
            props.put("mail.smtp.clave", clave);    //La clave de la cuenta
            props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
            props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
            props.put("mail.smtp.port", "587");//El puerto SMTP seguro de Google

            Session session = Session.getDefaultInstance(props);
            MimeMessage message = new MimeMessage(session);

            try {
                message.setFrom(new InternetAddress(remitente));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));   //Se podrían añadir varios de la misma manera
                message.setSubject(asunto);
                message.setText(cuerpo);
                Transport transport = session.getTransport("smtp");
                transport.connect("smtp.gmail.com", remitente, clave);
                transport.sendMessage(message, message.getAllRecipients());
                transport.close();
            }
            catch (MessagingException me) {
                me.printStackTrace();   //Si se produce un error
            }
        }   
    }
}


