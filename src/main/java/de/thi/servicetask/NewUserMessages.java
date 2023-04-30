package de.thi.servicetask;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class NewUserMessages {


    public void sendWelcomeEmail(String userID) {
        System.out.println("Welcome Email sent to .... "+ userID);

    }

    public void sendRecommendationEmail(String userID) {
        System.out.println("Recommendation Email sent to .... "+ userID);

    }
}
