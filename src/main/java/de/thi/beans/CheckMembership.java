package de.thi.beans;

import de.thi.entities.Association;
import de.thi.entities.User;

// This import is needed for "MemberList" - Java.util.List is not compatible
import io.quarkus.hibernate.orm.PersistenceUnit.List;

import io.smallrye.mutiny.Uni;
import it.unimi.dsi.fastutil.objects.ObjectLists.EmptyList;

import org.kie.kogito.internal.process.runtime.KogitoProcessContext;

import com.thoughtworks.xstream.mapper.Mapper.Null;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
// Get process context of kogito application
public class CheckMembership {

    @Inject
    MembershipRepository membershipRepository;

    public boolean checkStatus(User user, Association association){

        // Deliver name to Kogito / BPMN
        String userName = user.getUsername();

        String assName = association.getName();

        // Check if user exist in memberlist
        List searchedMember = membershipRepository.find("userName", association.getMemberList()).firstResult();

        if(searchedMember.value() != null){
            System.out.println("User is already Member!");
            return true;
        }else{
            System.out.println("User is NOT Member!");
            return false;
        }
    }

}