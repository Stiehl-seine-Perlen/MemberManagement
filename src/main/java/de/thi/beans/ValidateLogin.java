package de.thi.beans;

import de.thi.entities.User;

import javax.inject.Inject;

public class ValidateLogin {

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
}
