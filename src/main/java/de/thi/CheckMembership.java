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

        //Tests
        if (user != null && association != null) {
            LOGGER.info("User passed: "+ user.getName() + "\tAssociation passed: " + association.getAssociationName());
        } else {
            LOGGER.info("LEER: -------------------------------------- ");
        }
       

        try {

            // userMembershipList.add(membershipRepository.find("userId", user.getId()));
           // LinkedList<Membership> userMembershipList = new LinkedList<Membership>();

            Membership predictedMembership = new Membership(user.getId(), null, association);


            List<Membership> userMembershipList = membershipRepository.list("userid", user.getId());

            userMembershipList.addAll(membershipRepository.list("userid", user.getId()));

            LOGGER.info("Doing Something!");
            LOGGER.info("List: " + userMembershipList);
        } catch (Exception e) {
      
            LOGGER.error("Exception -> Error : fuck u", e);
        }
        
        return true;
    }

}