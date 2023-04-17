package de.thi.beans;

import de.thi.entities.User;
//import de.thi.beans.ValidateRegistration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UserUpdateValidation{
    
    @Inject 
    UserUpdate userUpdate;

    public boolean validateUserUpdate(User user) {
        if (validateUsername(user) && 
            validatePassword(user) && 
            validateEmail(user)) {
                return true;
        }
        else {
            return false;
        }   
    }

    public boolean validateUserUpdate() {
        return false;
    }

    @Transactional
    public void doUserUpdate(User user) {
        userUpdate.persist(user);
    }

    @Transactional
    public void doUserUpdate() {
        System.out.println("Error: can't persist User with no User Object!");
    }

    // these functions will fanish, when the class "ValidteRegistration" can be imported
    public boolean validateUsername(User user) {
        return true;
    }
    public boolean validatePassword(User user) {
        return true;
    }
    public boolean validateEmail(User user) {
        return true;
    }
}