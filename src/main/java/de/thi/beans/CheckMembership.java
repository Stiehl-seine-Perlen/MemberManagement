package de.thi.beans;

import de.thi.entities.Association;
import de.thi.entities.User;
import io.smallrye.mutiny.Uni;

import org.kie.kogito.internal.process.runtime.KogitoProcessContext;

import com.thoughtworks.xstream.mapper.Mapper.Null;

import java.util.List;

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
        String name = user.getUsername();

        String assName = association.getAssName();

       // Uni<Association> searchedMember = membershipRepository.find("member", association.getMemberList()).firstResult();
       boolean searchedMember = false;

        if(searchedMember == false){
            return false;
        }else{
            return true;
        }
    }

}