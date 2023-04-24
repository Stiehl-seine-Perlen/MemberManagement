package de.thi.rest;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kie.kogito.Model;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;

import de.thi.entities.UserAssociationDTO;

// New Endpoint - Test if the other endpoint isn't working because of 2 Object Parameters in 
// endpoint -> CheckMembership.java -> method -> checkstatus(User user, Associatio)

@Path("user/join/associationTest")
public class membershipTest {
    @Inject
    @Named("MembershipRequest")
    Process<? extends Model> MembershipRequestProcess;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void joinAssociation(UserAssociationDTO userAsscociationDTO){
        

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("User", userAsscociationDTO.getUser());
        parameters.put("Association", userAsscociationDTO.getAssociation());
        

        Model model = MembershipRequestProcess.createModel();
        model.fromMap(parameters);

        ProcessInstance<?> processInstance = MembershipRequestProcess.createInstance(model);

        processInstance.start();  

    }
}
