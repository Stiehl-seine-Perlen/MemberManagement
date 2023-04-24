package de.thi.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.thi.entities.User;

@ApplicationScoped
public class RestArchiver {

    private static final Logger LOG = LoggerFactory.getLogger(RestArchiver.class);

    @Inject
    @RestClient
    UserUpdateRestClient userUpdateRestClient;

    public void archive(User user) {

        userUpdateRestClient.post(user);
        LOG.info("User '{}' successfully updated", user.getUsername());
    }
}