package de.benevolo.member_management.membership.servicetask;

import de.benevolo.entities.association.Association;

import javax.enterprise.context.ApplicationScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class informText {

    private static final Logger LOGGER = LoggerFactory.getLogger(informText.class);

    public static String generateText(Boolean memberStatus) {
        
        LOGGER.info("generateText -> Success?: " + memberStatus);
        
        if(memberStatus == true){
            return "You Are Already a Member!";
        }else{
            return "Congratulations - Your are now a Member!";
        }
        
    }
    
}
