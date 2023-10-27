/*
1.Primer paso descargar libreria JavaMail https://javaee.github.io/javamail/
2. la clase java tiene todo
3. luego:
Ve a la página de Seguridad de tu cuenta de Google: https://myaccount.google.com/security.
En la sección "Inicio de sesión en Google", haz clic en "Contraseña de aplicación".
Es posible que se te solicite que vuelvas a iniciar sesión. Proporciona tus credenciales de cuenta de Google.
En la página "Contraseña de aplicación", selecciona "Correo electrónico" en el primer menú desplegable.
Luego, selecciona "Otra aplicación" en el segundo menú desplegable.
En el campo de texto, puedes escribir un nombre descriptivo para identificar la aplicación (por ejemplo, "JavaMail").
Haz clic en el botón "Generar".
Se te proporcionará una contraseña de aplicación. Copia esta contraseña generada.
Después de obtener la contraseña de aplicación, vuelve al código Java y reemplaza la línea String senderPassword = "tu_contraseña"; con la contraseña de aplicación generada.


*/













import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
    public static void main(String[] args) {
        // Información de autenticación del correo emisor
        String senderEmail = "ortegadaniel588@gmail.com";
        String senderPassword = "lqnrqhhyzqapdfft";
        String contrasena = "daniel";
        
        // Información del correo receptor
        String receiverEmail = "danielfortnite599@gmail.com";
        
        // Configuración de las propiedades del servidor de correo
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
        // Creación de una sesión de correo
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });
        
        try {
            // Creación del mensaje de correo
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiverEmail));
            message.setSubject("Hola estas intentando acceder a tu cuenta \n Esta es tu contrasena: " + contrasena);
            message.setText("Correo enviado con satisfaccion");
            
            // Envío del mensaje de correo
            Transport.send(message);
            
            System.out.println("El correo electrónico ha sido enviado exitosamente.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
