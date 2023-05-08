package de.benevolo.beans;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import de.benevolo.entities.User;
import de.benevolo.entities.UserUpdateRepository;
import de.benevolo.rest.UserUpdateRestClient;

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