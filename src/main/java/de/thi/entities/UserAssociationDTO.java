package de.thi.entities;


public class UserAssociationDTO {
    private User user;
    private Association association;
  /*   private Boolean memberStatus ;
    private Boolean reviewStatus ;
    private String text4Finance ;*/
   
   public UserAssociationDTO(){

   }

   public UserAssociationDTO(User user, Association association/* , String text4Finance, Boolean memberStatus, Boolean reviewStatus*/){
        this.user = user;
        this.association = association;
       /* this.text4Finance = text4Finance;
        this.memberStatus = memberStatus;
        this.reviewStatus = reviewStatus;*/
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
/* 
    public String getText4Finance() {
        return text4Finance;
    }

    public void setText4Finance(String text4Finance) {
        this.text4Finance = text4Finance;
    }

    public boolean getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(boolean memberStatus) {
        this.memberStatus = memberStatus;
    }

    public boolean getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(boolean reviewStatus) {
        this.reviewStatus = reviewStatus;
    }
    */
   
}
