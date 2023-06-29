package de.benevolo.member_management.membership.services;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.benevolo.entities.association.Association;
import de.benevolo.entities.association.AssociationRole;
import de.benevolo.entities.association.Membership;
import de.benevolo.entities.user.PlatformUser;

import de.benevolo.member_management.membership.connectors.AssociationRestClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

//import de.benevolo.association.repositories.AssociationRepository;
@ApplicationScoped
public class MembershipService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MembershipService.class);

    @Inject
    @RestClient
    AssociationRestClient associationRestClient;

    @Transactional
    public Boolean persistMembership(Association association, PlatformUser user) {

        // Mocking a little bit, because DB has no entrys
        AssociationRole role = new AssociationRole("Mitglied", "Vordefiniertes Mitglied", false, false, false);
        
        Membership membership = new Membership(null, user.getId(), role);
        membership.setMembershipId(null);
        membership.getAssociationRole().setAssociationRoleId(null);

        try {
            associationRestClient.addMembership(membership);
            LOGGER.info("PERSISTET -->  " + membership.toString());
            return true;
        } catch (Exception e) {
            LOGGER.error("EXCEPTION -->  " + e);
            return false;
        }

    }

    public Boolean checkStatus(PlatformUser user, Association association) {

        Boolean result = false;

        try {
            //get all "members / memberships" of association 
            List<Membership> membershipsList = associationRestClient.getMembershipsByAssociationId(association.getId());

            LOGGER.info("Username: " + user.getName());
            LOGGER.info("Assoname: " + association.getAssociationName());
            LOGGER.info("UserId: " + user.getId());
            LOGGER.info("Generated List: " + membershipsList);

            //Check if user is already member of association
            if (membershipsList.isEmpty() == true) {
                LOGGER.info("Generated List EMPTY?: " + membershipsList.isEmpty());
            } else {
                for (Membership membership : membershipsList) {
                    LOGGER.info("MeberId: " + membership.getUserId());
                    if (membership.getUserId() == user.getId()) {
                        result = true;
                    }
                }
            }

        } catch (Exception e) {
            LOGGER.error("Exception -> Error: Something wrong in fetching Data from Memberships");
        }
        return result;
    }

}