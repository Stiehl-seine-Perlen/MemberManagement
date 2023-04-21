package de.thi.beans;

import de.thi.entities.Association;
import de.thi.entities.User;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
// Get process context of kogito application
public class CheckMembership {

    @Inject
    MembershipRepository membershipRepository;

    @Inject
    UserRegistration userRegistration;

    public boolean checkStatus(User user, Association association){

       
        // Deliver name to Kogito / BPMN

        //-->Commented lines are real DB use
        //  String userName = user.getUsername();
        //String assName = association.getName();
      
        //Testcase production
        String assName = "Wolfsburg";
        //String userName = "Tortsten";
        String userName = "Brunhilde";
        System.out.println("----> IN CHECKMEMBERSHIP");
       
       
        /* */
        
        ArrayList<String> memberListFake = new ArrayList<String>();

        memberListFake.add("Volvo");
        memberListFake.add("MrFake");
        memberListFake.add("Ford");
        memberListFake.add("Mazda");
        System.out.println(memberListFake);


        //Produce Fake User und Association for DEMO

        User userFake = new User("MrFake", "fake123", "fake@trump.com");
        Association assoFake = new Association("VfL Wolfsburg", "vfl@wolfsburg.com", "123VW", memberListFake);
        
        memberListFake.add("Donald Trump");
        memberListFake.add("Torsten");
        assoFake.setMemberList(memberListFake);

        registerUserAndAsso(userFake, assoFake);


        System.out.println("Testausgabe 2");


        // Check if user exist in memberlist
        List<String> searchedMember = assoFake.getMemberList();

        System.out.println("Testausgabe 3: " + searchedMember + " #List Empty ->" + searchedMember.isEmpty());
        
       // User searchedMember = userRegistration.find("username", user.getUsername()).firstResult();
       

        System.out.println("Testausgabe 4");
        if(searchedMember.contains(userName)){
            System.out.println(userName + " is already Member in " + assName + "!");
            return true;
        }else{
            System.out.println(userName + " is NOT Member " + assName + "!");
            return false;
        }
        
       
        
        
       
    }
    
    //Demo Fake DB entry
    @Transactional
        public void registerUserAndAsso(User userFake, Association assoFake) {
        userRegistration.persist(userFake);
        membershipRepository.persist(assoFake);
        // print out user
        System.out.println("User: " + userFake.getId() + " registered!");
        System.out.println("Association: " + assoFake.getAssociationId() + " registered!");
        System.out.println("Testausgabe 1");
    }        

}