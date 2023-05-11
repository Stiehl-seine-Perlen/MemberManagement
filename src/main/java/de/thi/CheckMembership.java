package de.thi;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.benevolo.entities.association.Association;
import de.benevolo.entities.association.Membership;
import de.benevolo.entities.user.PlatformUser;
import de.thi.jpa.MembershipRepository;

@ApplicationScoped
// Get process context of kogito application
public class CheckMembership {

    private static final Logger LOGGER = LoggerFactory.getLogger(CheckMembership.class);

    @Inject // NOT USED YET
    MembershipRepository membershipRepository;

    @Transactional
    public boolean checkStatus(PlatformUser user, Association association) {
        
        boolean result = false;

        try {
             
            LOGGER.info("Getting all Memberships with User -> " + user.getName() + " and Association -> " + association.getAssociationName());

            // Code to select Membership with matching association id und user id
            // When no matches list is empty

            List<Membership> userMembershipList = membershipRepository.list("FROM Membership WHERE associationrole_associationroleid IS " + association.getId() + " AND userid IS " + user.getId());
            LOGGER.info("Generated List: " + userMembershipList);

            if(userMembershipList.isEmpty()){
                result = false; // -> No Member
            }else{
                result = true; // -> Already Member
            }
           
        } catch (Exception e) {
            LOGGER.error("Exception -> Error: Something wrong in fetching Data from Memberships");
        }; 

        return result;
    }
}