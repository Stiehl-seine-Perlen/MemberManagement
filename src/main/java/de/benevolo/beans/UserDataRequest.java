package de.benevolo.beans;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import de.benevolo.entities.User;
import de.benevolo.entities.UserUpdateRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@Transactional
@ApplicationScoped
public class UserDataRequest implements PanacheRepository<User>{
    
    @Inject 
    UserUpdateRepository userUpdateRepository;

    public User getUserData(Long id) {
        User user = userUpdateRepository.findById(id);
        return user;
    }
    
    public List<User> getAllUser() {
        return find("ORDER BY username").list();
    }
}