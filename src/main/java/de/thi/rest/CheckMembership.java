package de.thi.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import de.thi.entities.UserAssociationDTO;
import de.thi.jpa.ApplicationRepository;


@ApplicationScoped
// Get process context of kogito application
public class CheckMembership {

    @Inject
    ApplicationRepository membershipRepository;

    @POST // POST Endpunkt 
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    @Transactional
	public UserAssociationDTO checkStatus(UserAssociationDTO  userAsscociationDTO)
	{

        //Überprüfung ob user bereits in der mitgliederliste ist
        boolean found = false;
        for(String usernameSearch : userAsscociationDTO.getAssociation().getMemberList()){
            if(usernameSearch.equals(userAsscociationDTO.getUser().getUsername())){
                System.out.println("User: " + userAsscociationDTO.getUser().getUsername() +" ist vorhanden!");
                found = true;
            }else{
                found = false;
            }
        }

        //Rückgabe des Ergebnisses der Überprüfung
        if(found == true){
            System.out.println(userAsscociationDTO.getUser().getUsername()+ " is already Member in " + userAsscociationDTO.getAssociation().getName() + "!");
            // userAsscociationDTO.setMemberStatus(true);         
            return userAsscociationDTO;
        }else{
            System.out.println(userAsscociationDTO.getUser().getUsername() + " is NOT Member of " + userAsscociationDTO.getAssociation().getName() + "!");
            // userAsscociationDTO.setMemberStatus(false);
            return userAsscociationDTO;
        
	    }
    }

}