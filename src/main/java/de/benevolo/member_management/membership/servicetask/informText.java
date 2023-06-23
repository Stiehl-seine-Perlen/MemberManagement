package de.benevolo.member_management.membership.servicetask;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class informText {

    public static String generateText(Boolean memberStatus) {

        if (memberStatus == true) {
            return "You Are Already a Member!";
        } else {
            return "Congratulations - Your are now a Member!";
        }

    }

}
