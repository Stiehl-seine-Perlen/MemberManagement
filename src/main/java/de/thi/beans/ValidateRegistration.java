package de.thi.beans;

import de.thi.entities.User;
import io.quarkus.logging.Log;
import org.kie.kogito.internal.process.runtime.KogitoProcessContext;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
// Get process context of kogito application
public class ValidateRegistration {

    @Inject
    UserRegistration userRegistration;

    public void validateUserInput(KogitoProcessContext processContext) {
        if (validateUsername(processContext)
                && validatePassword(processContext)
                && validateEmail(processContext)) {
            processContext.setVariable("validUser", true);
        }
        else {
            processContext.setVariable("validUser", false);
        }
    }

    //Get Process Context from Kogito Application and validate username
    //TODO: Refine username validation
    public boolean validateUsername(KogitoProcessContext processContext) {
        User user = (User) processContext.getVariable("user"); //TODO: cast necessary?
        //search for user in database

        User searchedUser = userRegistration.find("username", user.getUsername()).firstResult();

        //test if username is already in database
        if(searchedUser != null){
            //log Entry: Username already exists
            Log.info("Username >>"+ user.getUsername()+"<< already exists");
            return false;
        }
        //Username is not already in database -> Vald new username
        Log.info("Username >>"+ user.getUsername()+"<< not found -> valid new username");
        return true;
    }
    public boolean validatePassword(KogitoProcessContext processContext){

        User user = (User) processContext.getVariable("User");
        String password = user.getPassword();
        if(password != null && password.length() >= 8){
            return true;
        }
        else {
            return false;
        }
    }
    private boolean validateEmail(KogitoProcessContext processContext) {

        User user = (User) processContext.getVariable("User");
        String email = user.getEmail();
        User searchedUser = userRegistration.find("email", user.getEmail()).firstResult();

        //Validate email with regex

        //Regex from ChatGPT
        String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

        if(searchedUser == null && email.matches(regex)){
            return true;
        }
        else {
            return false;
        }
    }
}
