package de.thi.servicetask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.benevolo.MailService;
import de.benevolo.email.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class NewUserMessages {
    
    private static final Logger LOG = LoggerFactory.getLogger(NewUserMessages.class);

    private MailService mailService = MailService.getInstance();



    public void sendWelcomeEmail(String usernameAndEmail) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode json = objectMapper.readTree(usernameAndEmail);
        String username = json.get("username").asText();
        String email = json.get("email").asText();

        LOG.info("Welcome Email sent to .... " + username + " with email: " + email);
        sendEmail(username, email);
    }

    public void sendRecommendationEmail(String usernameAndEmail) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode json = objectMapper.readTree(usernameAndEmail);
        String username = json.get("username").asText();
        String email = json.get("email").asText();

        LOG.info("Recommendation Email sent to  >>" + username + "<< with email: >>" + email + "<<");
        sendEmail(username, email);   //TODO: Change to recommendation email
    }

    public void sendEmail(String username, String email_adress_new_user) {

        String welcomeMail = """
                <!DOCTYPE html>
                <html>
                <head>
                  <meta charset="UTF-8">
                  <title>Willkommens-E-Mail</title>
                </head>
                <body>
                  <div style="max-width: 600px; margin: 0 auto; padding: 20px;">
                    <h1>Willkommen bei Benevolo!</h1>
                    <p>Hallo <b> $username</b>!</p>
                    <p>Herzlich willkommen bei Benevolo! Wir freuen uns, dass du dich für unseren Service entschieden hast, um Vereine zu managen.</p>
                    <p>Als Mitglied unserer Plattform hast du Zugriff auf eine Vielzahl von Funktionen, die dir dabei helfen, den Verein effizient zu organisieren, Kommunikationen zu verwalten und Mitglieder einzubinden.</p>
                    <p>Unser Team steht dir jederzeit zur Verfügung, um dir bei Fragen oder Problemen behilflich zu sein. Zögere nicht, uns zu kontaktieren.</p>
                    <p>Wir wünschen dir viel Erfolg und Spaß bei der Nutzung von Benevolo!</p>
                    <p>Freundliche Grüße,</p>
                    <p>Das Benevolo-Team</p>
                  </div>
                </body>
                </html>
                """.replace("$username", username);
        Email email = new Email(
                email_adress_new_user,
                username, "Willkommens-E-Mail",
                welcomeMail,
                "jav4296@thi.de ",
                "Benevolo"
        );
        try {

            LOG.info("### Sending email to " + email_adress_new_user + "... ###");
            mailService.sendMessage(email);
            LOG.info("### Email sent to " + email_adress_new_user + " ! ###");
        } catch (Exception e) {
            LOG.info("### Error while sending email to " + email_adress_new_user + " ###");
            e.printStackTrace();
        }



    }


}
