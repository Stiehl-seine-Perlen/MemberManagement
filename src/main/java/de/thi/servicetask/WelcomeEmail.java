package de.thi.servicetask;

import javax.enterprise.context.ApplicationScoped;

public class WelcomeEmail {

    @ApplicationScoped
    public void sendWelcomeEmail() { //TODO: add Username
        System.out.println("Welcome Email sent to ....");
    }
}
