package de.thi.beans;

import de.thi.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

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