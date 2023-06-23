package de.benevolo.member_management.membership.connectors;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import de.benevolo.entities.association.Association;
import de.benevolo.entities.association.Membership;

@ApplicationScoped
@RegisterRestClient(configKey = "association")
public interface AssociationRestClient {

    
    @GET
    @Path("{id}/")
    Association byId(@PathParam("id") Long id);
    
    @GET
    @Path("{id}/members/")
    List<Membership> membersByAssociationId(@PathParam("id") Long id);

    @POST
    @Path("addMembership/")
    Association addMembership(Membership membership);

}