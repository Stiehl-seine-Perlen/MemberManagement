package de.benevolo.member_management.membership.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import de.benevolo.entities.association.Membership;


import de.benevolo.member_management.membership.services.CheckMembershipService;

@Path("/")
public class MembershipApplicationResource {

    @Inject
    CheckMembershipService checkMembershipService;

    /*@POST
    @Path("application")
    @Produces(MediaType.APPLICATION_JSON)
    public String name (){
      return "ja hallo hier";
    }
    */

   
}
