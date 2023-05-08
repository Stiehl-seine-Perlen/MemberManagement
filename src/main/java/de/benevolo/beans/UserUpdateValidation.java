package de.benevolo.beans;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import de.benevolo.entities.User;
import de.benevolo.entities.UserUpdateRepository;

@ApplicationScoped
public class UserUpdateValidation{
    
    @Inject 
    UserUpdateRepository userUpdateRepository;

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

    // these functions will vanish, when the class "ValidteRegistration" can be imported
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