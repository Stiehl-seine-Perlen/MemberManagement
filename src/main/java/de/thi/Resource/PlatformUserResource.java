package de.thi.Resource;

import de.benevolo.entities.events.Event;
import de.benevolo.entities.user.PlatformUser;
import de.thi.services.PlatformUserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/users")
public class PlatformUserResource {

    @Inject
    PlatformUserService platformUserService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PlatformUser> getAllPlatformUsers(){return platformUserService.getAllPlatformUsers();}

    @GET
    @Path("{platformuserid}")
    @Produces(MediaType.APPLICATION_JSON)

    public PlatformUser getPlatformUserById(@PathParam("platformuserid")Long platformuserId){
        return platformUserService.getPlatformUserById(platformuserId);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public PlatformUser createPlatformUser(PlatformUser platformUser){return platformUserService.persistPlatformUser(platformUser);}


}
