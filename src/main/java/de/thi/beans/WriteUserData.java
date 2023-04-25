package de.thi.beans;

import de.thi.entities.User;
import de.thi.entities.UserUpdateRepository;
import de.thi.rest.UserUpdateRestClient;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WriteUserData {

    @Inject
    UserUpdateRepository userUpdateRepository;

    @Inject
    @RestClient
    UserUpdateRestClient userUpdateRestClient;

    @Transactional
    @PostConstruct
    public void initialiseDB() {
    User kermit = new User("kermit", "kermit@demo.de", "12345678");
    userUpdateRepository.persist(kermit);
    User fozzie = new User("fozzie", "fozzie@demo.de", "87654321");
    userUpdateRepository.persist(fozzie);
    }
}