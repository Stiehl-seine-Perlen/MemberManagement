package de.thi.beans;

import de.thi.entities.User;
import de.thi.entities.UserUpdate;
import de.thi.rest.UserUpdateAPI;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.inject.Inject;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WriteUserData {

    @Inject
    UserUpdate userUpdate;

    @Inject
    @RestClient
    UserUpdateAPI userUpdateAPI;

    @PostConstruct
    public void initialiseDB() {
    User kermit = new User("kermit", "kermit@demo.de", "12345678");
    userUpdate.persist(kermit);
    User fozzie = new User("fozzie", "fozzie@demo.de", "87654321");
    userUpdate.persist(fozzie);
    }

    public void archive(User user) {
        userUpdateAPI.post(user);
    }

}