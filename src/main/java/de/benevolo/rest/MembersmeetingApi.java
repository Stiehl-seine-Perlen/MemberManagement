package de.benevolo.rest;

import de.benevolo.beans.Membersmeeting;
import de.benevolo.entities.AssignMembersmeeting;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Transactional
@Path("/membersmeeting")
public class MembersmeetingApi {

    @Inject
    Membersmeeting membersmeeting;

    @POST
    @Path("/assign")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMembersmeeting(AssignMembersmeeting meeting) {
        membersmeeting.persist(meeting);
    }
}