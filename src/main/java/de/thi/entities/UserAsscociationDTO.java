package de.thi.entities;


public class UserAsscociationDTO {
    private User user;
    private Association association;
   
   public UserAsscociationDTO(){

   }

   public UserAsscociationDTO(User user, Association association){
        this.user = user;
        this.association = association;
   }
   
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Association getAssociation() {
        return association;
    }
    public void setAssociation(Association association) {
        this.association = association;
    }
    
   
}
