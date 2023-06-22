package de.benevolo.member_management.membership.services;

import java.util.List;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import de.benevolo.entities.association.Association;
import de.benevolo.entities.user.PlatformUser;
import de.benevolo.entities.association.Membership;
import de.benevolo.member_management.membership.connectors.AssociationRestClient;

@ApplicationScoped
public class AssociationRestRequestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AssociationRestRequestService.class);

    @Inject
    @RestClient
    AssociationRestClient associationRestClient;

     
    public Association loadAssociationById(Long associationId) {
        
        LOGGER.info("ASSOCIATION: " + associationId);

        Association association = associationRestClient.byId(associationId);

        if(association == null){
            LOGGER.info("ASSOCIATION is NULL");
        }else{
             LOGGER.info("Association Name: " + association.getAssociationName() + "Association ID: " + associationId);
        }
        
        return association;
    }

    //get all memberships of association
    public List<Membership> loadMembershipByAssociationId(Long associationId) {
        
        LOGGER.info("in loadmembershipbyass: " + associationId);

        List<Membership> members = associationRestClient.membersByAssociationId(associationId);
        for (Membership member : members) {
            LOGGER.info("MeberId: " + member.getUserId());
        }
        return members;
    }   
    
}
