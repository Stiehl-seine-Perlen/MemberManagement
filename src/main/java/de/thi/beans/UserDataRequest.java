package de.thi.beans;

import de.thi.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UserDataRequest{
    
    @Inject 
    UserUpdate userUpdate;

    // public user getUserData(Long id) {
        
    //     return user;
    // }

    public User getUserData(User user) {
        return user;
    }
}