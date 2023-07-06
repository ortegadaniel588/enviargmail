import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EnvioCorreo {
    public static void main(String[] args) {
        // Datos del remitente
        String remitente = "ortegadaniel588@gmail.com";
        String password = "lqnrqhhyzqapdfft";
        
        // Datos del destinatario
        String destinatario = "danielfortnite599@gmail.com";
        String pruebadeenviodecontrasena = "daniel123";
        
        // Configurar las propiedades
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        // Crear una sesión
        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, password);
            }
          });
        
        try {
            // Crear un objeto MimeMessage
            Message message = new MimeMessage(session);
            
            // Establecer el remitente
            message.setFrom(new InternetAddress(remitente));
            
            // Establecer el destinatario
            message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(destinatario));
            
            // Establecer el asunto del correo
            message.setSubject("¡Hola !" + destinatario);
            
            // Establecer el contenido del correo
            message.setText("Hola,\n\nEste esta es tu contrasena: " + pruebadeenviodecontrasena);
            
            // Enviar el correo
            Transport.send(message);
            
            System.out.println("El correo ha sido enviado exitosamente.");
            
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
