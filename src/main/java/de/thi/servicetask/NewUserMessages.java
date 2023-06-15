package de.thi.servicetask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.mailer.reactive.ReactiveMailer;
import io.smallrye.mutiny.Uni;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import static org.eclipse.microprofile.jwt.Claims.email;

@ApplicationScoped
public class NewUserMessages {
    
    private static final Logger LOG = LoggerFactory.getLogger(NewUserMessages.class);


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

        LOG.info("Recommendation Email sent to .... " + username + " with email: " + email);
        sendEmail(username, email);                                                  //TODO: Change to recommendation email

    }

    //TODO: Make maler async (reactive Mailer)
    @Inject
    Mailer mailer;


    public void sendEmail(String username, String email) {

        //TODO: Change to SMTP Client of Benevolo!

        Mail mail = new Mail();
        mail.addTo("info@example.org");
        mail.setFrom("no-reply@benevolo.de");
        mail.setSubject("Welcome to Benevolo!");
        mail.setText("Hello to User: "+ username);
        //mail.setHtml()
        mailer.send(mail);
    }


}
