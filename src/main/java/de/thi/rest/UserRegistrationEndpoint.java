package de.thi.rest;

import de.thi.beans.UserRegistration;
import de.thi.entities.User;
import org.json.JSONObject;


import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/user")
public class UserRegistrationEndpoint {

    @Inject
    UserRegistration userRegistration;

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) {
        userRegistration.persist(user);
        //return response with status 200 and the user object as json without the password field
        JSONObject userJson = new JSONObject(user);
        userJson.remove("password");
        //write user into process context
        return Response.status(200).entity(userJson.toString()).build();
    }



}
