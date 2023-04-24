package de.thi.beans;

import de.thi.entities.User;
import de.thi.entities.UserUpdate;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Transactional
@ApplicationScoped
public class UserDataRequest implements PanacheRepository<User>{
    
    @Inject 
    UserUpdate userUpdate;

    public User getUserData(Long id) {
        return findById(id);
    }
    
    public List<User> getAllUser() {
        return find("ORDER BY username").list();
    }
}