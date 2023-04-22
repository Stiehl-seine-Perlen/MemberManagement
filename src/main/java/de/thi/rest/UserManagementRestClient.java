package de.thi.rest;

import de.thi.entities.User;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@ApplicationScoped
@RegisterRestClient(configKey = "user")
public interface UserManagementRestClient {


    @POST
    void post(String username, String password);


}
