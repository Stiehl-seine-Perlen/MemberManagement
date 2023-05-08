package de.benevolo.rest;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import de.benevolo.entities.User;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@ApplicationScoped
@RegisterRestClient(configKey = "user")
public interface UserUpdateRestClient {

    @GET
    List<User> all();

    @GET
    @Path("{id}")
    User byId(@PathParam("id") Long id);

    @POST
    void post(User user);
}
