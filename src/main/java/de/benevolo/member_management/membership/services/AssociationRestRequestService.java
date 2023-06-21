package de.benevolo.member_management.membership.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import de.benevolo.entities.association.Association;
import de.benevolo.entities.association.Membership;
import de.benevolo.member_management.membership.connectors.AssociationRestClient;

@ApplicationScoped
public class AssociationRestRequestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssociationRestRequestService.class);

    @RestClient
    AssociationRestClient associationRestClient;

    // THIS
    public List<Association> getAllEntries() {

        List<Association> associations = associationRestClient.getAllEntries();
        LOGGER.info("All Associations: \n" + associations);
        
        return associations;
    }

    /* 
    public Association loadAssociationById(Long associationId) {
        Association association = associationRestClient.byId(associationId);

        LOGGER.info("Association Name: " + association.getAssociationName() + "Association ID: " + associationId);
        
        return association;
    }

    public List<Membership> loadMembershipByAssociationId(Long associationId) {

        List<Membership> members = associationRestClient.membersByAssociationId(associationId);
        for (Membership member : members) {
           
            LOGGER.info("Member ID: " + member.getUserId());
        }
        return members;
    }
    */
}
