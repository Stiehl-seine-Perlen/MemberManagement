package de.thi.rest;

import de.thi.entities.Association;
import de.thi.entities.User;
import de.thi.jpa.MembershipRepository;
import de.thi.jpa.UserRegistration;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;


@ApplicationScoped
// Get process context of kogito application
public class CheckMembership {

    @Inject
    MembershipRepository membershipRepository;

    @Inject
    UserRegistration userRegistration;


    @POST // POST Endpunkt
	@Consumes(MediaType.APPLICATION_JSON)
    @Transactional
	public boolean checkStatus(User user, Association association)
	{

        System.out.println("Was im Memberschiprepo?" + membershipRepository.count());


        String username = "El Hehe";  //String nur zum testen

        if(user != null){
            System.out.println("Übergebene User vollständig");
            username = user.getUsername();
        }else{
            User nUser = new User("hermine", "djijij111", "kilian12345");
            user = nUser;
            System.out.println("Übergebene User ist NULL");
        }


        if(association != null){
           // ArrayList <String> memberList = association.getMemberList();
        }else{
            ArrayList <String> nList = new ArrayList<String>(){
            {
                add("torsten");
                add("janina"); 
                add("franco");
                add("brad");
            }
        };
            Association nAssociation = new Association("Fc Bayern", "bayern@bayern.com", "ijidjeji1232", nList);
            association = nAssociation;
        }
        
        ArrayList <String> memberList = association.getMemberList();


        boolean found = false;
        for(String usernameSearch : memberList){
            if(usernameSearch.equals(username)){
                System.out.println("Haha bingo is drinnen!");
                found = true;
            }else{
                found = false;
            }
        }

        
        if(found == true){
            System.out.println(user.getUsername()+ " is already Member in " + association.getName() + "!");
            return found;
        }else{
            System.out.println(user.getUsername() + " is NOT Member " + association.getName() + "!");
            return found;
        
	    }
    }

}