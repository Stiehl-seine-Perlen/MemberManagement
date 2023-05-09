package de.thi.rest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;



// IMPORT ENTITIES REPO
import de.thi.entities.UserAssociationDTO;
import de.thi.jpa.MembershipRepository;

//@Path("/aha")
@ApplicationScoped
// Get process context of kogito application
public class CheckMembership {

    @Inject //NOT USED YET
    MembershipRepository membershipRepository;

    //@Path("/aha")

    public boolean checkStatus(UserAssociationDTO uaDTO) {

         if(uaDTO != null){
            System.out.println("User ist voll: " + uaDTO.toString() + "----> " + uaDTO.getUser().getId() + " " + uaDTO.getUser().getName() + " " + uaDTO.getUser().getAdmin());
            System.out.println("Asso ist voll: " +uaDTO.toString() + "----- >" + " " + uaDTO.getAssociation().getId() + " " + uaDTO.getAssociation().getBusinessMail());
        }else{
            System.out.println("LEER: ------ ");
        }


        return true;
    }

}