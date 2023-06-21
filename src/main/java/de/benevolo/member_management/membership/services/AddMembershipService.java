package de.benevolo.member_management.membership.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotAcceptableException;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import de.benevolo.entities.association.Association;
import de.benevolo.entities.association.Membership;
import de.benevolo.entities.user.PlatformUser;


//import de.benevolo.association.repositories.AssociationRepository;

public class AddMembershipService {

    /* 
    @Inject

    public Membership persistMembership(Association association, PlatformUser user){

        Membership membership = new Membership();

        return membership;
    }
    */
}
