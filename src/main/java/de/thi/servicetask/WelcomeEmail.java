package de.thi.servicetask;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WelcomeEmail {

    public void sendWelcomeEmail(String userID) { //TODO: add Username
        System.out.println("Welcome Email sent to ....");

    }
}
