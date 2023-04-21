package de.thi.beans;

import de.thi.entities.User;
//import de.thi.beans.ValidateRegistration;
import de.thi.entities.UserUpdate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserUpdateValidation{
    
    @Inject 
    UserUpdate userUpdate;

    public boolean validateUserUpdate(User user) {
        if (validateUsername(user.getUsername()) && 
            validatePassword(user.getPassword()) && 
            validateEmail(user.getEmail())) {
                return true;
        }
        else {
            return false;
        }   
    }

    // these functions will fanish, when the class "ValidteRegistration" can be imported
    public boolean validateUsername(String username) {
        return true;
    }
    public boolean validatePassword(String password) {
        return true;
    }
    public boolean validateEmail(String email) {
        return true;
    }
}