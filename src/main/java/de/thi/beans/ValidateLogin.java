package de.thi.beans;

import de.thi.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ValidateLogin {
    private static final Logger LOG = LoggerFactory.getLogger(ValidateLogin.class);

    @Inject
    UserRegistration userRegistration;
    public boolean validate(String username, String password) {

        User user = userRegistration.find("username", username).firstResult();

        //test if username is already in database and if password is correct
        if(user != null){
            if(user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

    public void login(){

        LOG.info("Login successful!");

    }
}
