package de.thi.entities;

import javax.persistence.Entity;

import de.benevolo.entities.association.Association;
import de.benevolo.entities.user.PlatformUser;

public class UserAssociationDTO {
    private PlatformUser user;
    private Association association;
   
   public UserAssociationDTO(){

   }

   public UserAssociationDTO(PlatformUser user, Association association){
        this.user = user;
        this.association = association;
   }
   
    public PlatformUser getUser() {
        return user;
    }
    public void setUser(PlatformUser user) {
        this.user = user;
    }
    public Association getAssociation() {
        return association;
    }
    public void setAssociation(Association association) {
        this.association = association;
    }
    
   
}
