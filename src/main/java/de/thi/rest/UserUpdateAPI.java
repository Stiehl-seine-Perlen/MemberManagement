package de.thi.rest;

import de.thi.entities.User;
import de.thi.beans.UserUpdate;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.json.JSONObject;

@Path("/user")
public class UserUpdateAPI {

    @Inject
    UserUpdate userUpdate;

    @POST
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(User user) {
        userUpdate.persist(user);
        //return response with status 200 and the user object as json without the password field
        JSONObject userJson = new JSONObject(user);
        userJson.remove("password");
        //write user into process context
        return Response.status(200).entity(userJson.toString()).build();
    }
}
