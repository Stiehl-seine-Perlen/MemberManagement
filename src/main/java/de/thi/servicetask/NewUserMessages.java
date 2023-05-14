package de.thi.servicetask;

import io.quarkus.mailer.reactive.ReactiveMailer;
import io.smallrye.mutiny.Uni;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class NewUserMessages {
    
    private static final Logger LOG = LoggerFactory.getLogger(NewUserMessages.class);


    public void sendWelcomeEmail(String username) {
        LOG.info("Welcome Email sent to .... " + username);
        sendEmail(username);
    }

    public void sendRecommendationEmail(String username) {
        LOG.info("Recommendation Email sent to .... " + username);
        sendEmail(username);                                                  //TODO: Change to recommendation email

    }

    //TODO: Make maler async (reactive Mailer)
    @Inject
    Mailer mailer;


    public void sendEmail(String username) {

        Mail mail = new Mail();
        mail.addTo("info@example.org"); //TODO: Change to user email
        mail.setFrom("no-reply@benevolo.de");
        mail.setSubject("Welcome to Benevolo!");
        mail.setText("Hello to User: "+ username); //TODO: Change to html template
        //mail.setHtml()

        mailer.send(mail);
    }


}
