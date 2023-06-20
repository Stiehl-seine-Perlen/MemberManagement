package de.benevolo.membermeetingmanagement.services;

import de.benevolo.membermeetingmanagement.entities.Membermeeting;
import de.benevolo.membermeetingmanagement.repositories.MembermeetingRepositorie;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Transactional
@Path("/membersmeeting")
public class MembermeetingService {

    @Inject
    MembermeetingRepositorie membersmeetingRespositorie;

    @POST
    @Path("/assign")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addMembermeeting(Membermeeting meeting) {
        membersmeetingRespositorie.persist(meeting);
    }
}