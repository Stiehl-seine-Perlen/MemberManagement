package de.thi.rest;

import java.util.ArrayList;

import javax.enterprise.context.ApplicationScoped;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;

import de.thi.entities.Association;
import de.thi.entities.User;
import de.thi.jpa.MembershipRepository;
import de.thi.jpa.UserRegistration;

@ApplicationScoped
// Get process context of kogito application
public class CheckMembership {

    @Inject
    MembershipRepository membershipRepository;

    @Inject
    UserRegistration userRegistration;

    @POST // POST Endpunkt 
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean checkStatus(User user, Association association)
	{



        String username = "Mr.Fake";  //String nur zum testen 

        if(user != null){ //Testen ob ein User Objekt übergeben wurde
            System.out.println("Übergebene User vollständig -> " + user.toString());
            username = user.getUsername();
        }else{  //User ist NULL -> Zu testzwecken wird der Parameter initialisiert
            User nUser = new User("Carlo Ancelotti", "djijij111", "kilian12345");
            user = nUser;
            System.out.println("Übergebene User ist NULL");
        }


        //Das selbe wie Oben zum testen -> jetzt aber für Association
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
        

        //Überprüfung ob user bereits in der mitgliederliste ist
        boolean found = false;
        for(String usernameSearch : association.getMemberList()){
            if(usernameSearch.equals(username)){
                System.out.println("User: " + username +" ist vorhanden!");
                found = true;
            }else{
                found = false;
            }
        }

        //Rückgabe des Ergebnisses der Überprüfung
        if(found == true){
            System.out.println(user.getUsername()+ " is already Member in " + association.getName() + "!");
            return found;
        }else{
            System.out.println(user.getUsername() + " is NOT Member of " + association.getName() + "!");
            return found;
        
	    }
    }

}