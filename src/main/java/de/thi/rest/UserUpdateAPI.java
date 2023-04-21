package de.thi.rest;

import de.thi.entities.User;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

@ApplicationScoped
@RegisterRestClient(configKey = "user")
public interface UserUpdateAPI {

    @GET
    List<User> all();

    @GET
    @Path("{id}")
    User byId(@PathParam("id") Long id);

    @POST
    void post(User user);
}
