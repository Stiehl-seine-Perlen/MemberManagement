package de.thi.beans;

import de.thi.entities.User;
import org.kie.kogito.internal.process.runtime.KogitoProcessContext;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
// Get process context of kogito application
public class ValidateRegistration {

    @Inject
    UserRegistration userRegistration;


    public boolean validateUserInput(User user) {


        if (validateUsername(user)
                && validatePassword(user)
                && validateEmail(user)) {
            return true;
        } else {
            return false;
        }
    }

    //Get Process Context from Kogito Application and validate username
    //TODO: Refine username validation
    public boolean validateUsername(User user) {


        User searchedUser = userRegistration.find("username", user.getUsername()).firstResult();

        //test if username is already in database
        if(searchedUser != null){
            //log Entry: Username already exists
            System.out.println("Username >>"+ user.getUsername()+"<< already exists");
            return false;
        }
        //Username is not already in database -> Vald new username
        System.out.println("Username >>"+ user.getUsername()+"<< not found -> valid new username");
        return true;
    }

    public boolean validatePassword(User user) {

        String password = user.getPassword();
        return password != null && password.length() >= 8;
    }

    private boolean validateEmail(User user) {

        String email = user.getEmail();
        User searchedUser = userRegistration.find("email", user.getEmail()).firstResult();

        //TODO: Validate email with regex

        //Regex from ChatGPT
        //String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

        if(searchedUser == null && email.contains("@")){
            return true;
        }
        else {
            return false;
        }
    }

    @Transactional
    public void registerUser(User user) {
        userRegistration.persist(user);
        // print out user
        System.out.println("User: " + user.getId() + " registered!");
    }

}