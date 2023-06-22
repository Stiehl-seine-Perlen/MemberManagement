package de.benevolo.member_management.membership.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.benevolo.entities.association.Association;
import de.benevolo.entities.association.Membership;
import de.benevolo.entities.user.PlatformUser;
import de.benevolo.member_management.membership.repositories.MembershipRepository;

import de.benevolo.member_management.membership.connectors.AssociationRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
// Get process context of kogito application
public class CheckMembershipService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckMembershipService.class);

    @Inject
    MembershipRepository membershipRepository;

    @Inject
    @RestClient
    AssociationRestClient associationRestClient;

  
    public Boolean checkStatus(PlatformUser user, List<Membership> members) {
        
        Boolean result = false;

        try {
             
           // LOGGER.info("Getting all Memberships with User -> " + user.getName() + " and Association -> " + association.getAssociationName());

            // Code to select Membership with matching association id und user id
            // No matches -> empty list

           // List<Membership> userMembershipList = membershipRepository.list("FROM Membership WHERE associationrole_associationroleid IS " + association.getId() + " AND userid IS " + user.getId());
            LOGGER.info("Generated List: " + members);

            if(members.isEmpty() == true){
                LOGGER.info("Generated List EMPTY?: " + members.isEmpty());
               
            }else{
                for (Membership member : members) {
                    LOGGER.info("MeberId: " + member.getUserId());
                    if(member.getUserId() == user.getId()){
                        result = true;
                    }
                }
            }
           
        } catch (Exception e) {
            LOGGER.error("Exception -> Error: Something wrong in fetching Data from Memberships");
        }; 

        LOGGER.info("user: " + user.getName());
        return result;
    }


    public Boolean checkStatus(PlatformUser user, Association association) {
        
        Boolean result = false;

        try {
             
           // LOGGER.info("Getting all Memberships with User -> " + user.getName() + " and Association -> " + association.getAssociationName());

            // Code to select Membership with matching association id und user id
            // No matches -> empty list

           // List<Membership> userMembershipList = membershipRepository.list("FROM Membership WHERE associationrole_associationroleid IS " + association.getId() + " AND userid IS " + user.getId());
           List<Membership> members = associationRestClient.membersByAssociationId(association.getId()); 

           LOGGER.info("Username: " + user.getName());
           LOGGER.info("UserId: " + user.getId());
           
           LOGGER.info("Generated List: " + members);

            if(members.isEmpty() == true){
                LOGGER.info("Generated List EMPTY?: " + members.isEmpty());
               
            }else{
                for (Membership member : members) {
                    LOGGER.info("MeberId: " + member.getUserId());
                    if(member.getUserId() == user.getId()){
                        result = true;
                    }
                }
            }
           
        } catch (Exception e) {
            LOGGER.error("Exception -> Error: Something wrong in fetching Data from Memberships");
        }; 

        
        LOGGER.info("user: " + user.getName());
        return result;
    }

}