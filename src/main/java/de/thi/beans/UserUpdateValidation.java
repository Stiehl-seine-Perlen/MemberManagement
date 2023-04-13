package de.thi.beans;

import de.thi.entities.User;
//import de.thi.beans.ValidateRegistration;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import org.kie.kogito.internal.process.runtime.KogitoProcessContext;

public class UserUpdateValidation{
    
    @Inject 
    UserUpdate userUpdate;

    public boolean validateUserUpdate(User user, KogitoProcessContext context) {
        if (validateUsername(user) && 
            validatePassword(user) && 
            validateEmail(user)) {
                return true;
        }
        else {
            return false;
        }   
    }

    @Transactional
    public void updateUser(User user) {
        userUpdate.persist(user);
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