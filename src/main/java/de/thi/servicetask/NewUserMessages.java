package de.thi.servicetask;

import io.quarkus.mailer.reactive.ReactiveMailer;
import io.smallrye.mutiny.Uni;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class NewUserMessages {


    public void sendWelcomeEmail(String username) {
        System.out.println("Welcome Email sent to .... " + username);
        sendEmail(username);
    }

    public void sendRecommendationEmail(String username) {
        System.out.println("Recommendation Email sent to .... " + username);
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
