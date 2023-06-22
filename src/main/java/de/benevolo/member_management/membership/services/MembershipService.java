package de.benevolo.member_management.membership.services;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.NotAcceptableException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.benevolo.entities.association.Association;
import de.benevolo.entities.association.AssociationRole;
import de.benevolo.entities.association.Membership;
import de.benevolo.entities.user.PlatformUser;
import de.benevolo.member_management.membership.repositories.MembershipRepository;

//import de.benevolo.association.repositories.AssociationRepository;
@ApplicationScoped
public class MembershipService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MembershipService.class);

    @Inject
    MembershipRepository membershipRepository;

    @Transactional
    public Boolean persistMembership(Association association, PlatformUser user){

        Membership membership = new Membership(null, user.getId(), new AssociationRole());
        membership.setMembershipId(null);
        membership.getAssociationRole().setAssociationRoleId(null);
        
       
        try {
            membershipRepository.persist(membership);
            LOGGER.info("PERSISTET!" + membership.toString());
           return true;
        } catch (Exception e) {
           // logger.error("Could Not Persist Membership", e);
           LOGGER.info("EXCEPTION" + e);
            return false;
        }

        //JSON Builder

            
/* 
            JsonObjectBuilder roleBuilder = Json.createObjectBuilder();
            roleBuilder.add("roleName", association.getAssociationRoles().getRoleName());
            roleBuilder.add("roleDescription", association.getAssociationRoles().getRoleDescription());
            roleBuilder.add("canTransaction", association.getAssociationRoles().getCanTransaction());
            roleBuilder.add("canAccount", association.getAssociationRoles().getCanAccount());
            roleBuilder.add("canEvent", association.getAssociationRoles().getCanEvent());
            
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("userId", user.getId());
            jsonObjectBuilder.add("associationRole", roleBuilder);
           
            
            JsonObject jsonObject = jsonObjectBuilder.build();
            String json = jsonObject.toString();
            
            System.out.println(json);

*/
        
    }

}