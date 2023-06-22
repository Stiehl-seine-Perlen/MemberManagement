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

@ApplicationScoped
// Get process context of kogito application
public class OLDCheckMembershipService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OLDCheckMembershipService.class);

    @Inject
    MembershipRepository membershipRepository;

    @Transactional
    public Boolean checkStatus(PlatformUser user, Association association) {
        
        Boolean result = false;

        try {
             
            LOGGER.info("Getting all Memberships with User -> " + user.getName() + " and Association -> " + association.getAssociationName());

            // Code to select Membership with matching association id und user id
            // No matches -> empty list

            List<Membership> userMembershipList = membershipRepository.list("FROM Membership WHERE associationrole_associationroleid IS " + association.getId() + " AND userid IS " + user.getId());
            LOGGER.info("Generated List: " + userMembershipList);

            if(userMembershipList.isEmpty() != true){
                LOGGER.info("Generated List EMPTY?: " + userMembershipList.isEmpty());
                result = true; // -> Already Member
            }
           
        } catch (Exception e) {
            LOGGER.error("Exception -> Error: Something wrong in fetching Data from Memberships");
        }; 

        LOGGER.info("user: " + user.getName());
        return result;
    }
}