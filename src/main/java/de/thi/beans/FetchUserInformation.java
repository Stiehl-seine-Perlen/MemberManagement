package de.thi.beans;

import de.thi.entities.User;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

//Converts bean into a quarkus bean
@ApplicationScoped
//ERROR THAT HAS TO BE CHECKED!
public class UserRegistration implements PanacheRepository<User> {
    // auto implemented
   }
public class FetchUserInformation {

    @Inject
    UserRegistration userRegistration;

    public String getUsername(long userId) {
        User user = userRegistration.findById(userId);
        if (user != null) {
            return user.getUsername();
        }
        return null;
    }

    public String getEmail(long userId) {
        User user = userRegistration.findById(userId);
        if (user != null) {
            return user.getEmail();
        }
        return null;
    }

    public String getPassword(long userId) {
        User user = userRegistration.findById(userId);
        if (user != null) {
            return user.getPassword();
        }
        return null;
    }

    public long getID(long userId) {
        User user = userRegistration.findById(userId);
        if (user != null) {
            return user.getId();
        }
        return 0;
    }
}
