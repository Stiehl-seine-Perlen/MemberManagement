package de.benevolo.member_management.membermeeting.services;

import de.benevolo.entities.events.Membermeeting;
import de.benevolo.member_management.membermeeting.repositories.MembermeetingRepositorie;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import java.util.List;

@Transactional
@Path("/membermeeting")
public class MembermeetingService {

    @Inject
    MembermeetingRepositorie membermeetingRespositorie;

    @POST
    @Path("/assign")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMembermeeting(Membermeeting meeting) {
        membermeetingRespositorie.persist(meeting);
    }

    @GET
    @Path("/{membermeetingId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Membermeeting getMembermeetingById(@PathParam("membermeetingId") Long membermeetingId){
        return membermeetingRespositorie.findById(membermeetingId);
    }
    
    @GET
    @Path("/listAllMembermeeting")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Membermeeting> getAllMembermeeting(){
        return membermeetingRespositorie.listAll();
    }

    @DELETE
    @Path("delete/{membermeetingId}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteAssociation(@PathParam("membermeetingId") Long membermeetingId) {
        return membermeetingRespositorie.deleteById(membermeetingId);
    }

    @PUT
    @Path("update/{membermeetingId}")
    public Membermeeting updateEvent(@PathParam("membermeetingId") Long id, Membermeeting membermeeting) {
        Membermeeting entity = membermeetingRespositorie.findById(id);
        if(entity == null) {
            throw new NotFoundException();
        }

        entity.setLocation(membermeeting.getLocation());
        entity.setOwnedByAssociationId(membermeeting.getOwnedByAssociationId());
        entity.setDate(membermeeting.getDate());
        entity.setIsClosed(membermeeting.getIsClosed());
        entity.setAgenda(membermeeting.getAgenda());

        return entity;
    }
}