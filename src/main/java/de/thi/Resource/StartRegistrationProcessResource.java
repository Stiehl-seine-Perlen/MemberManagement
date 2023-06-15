package de.thi.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.benevolo.entities.user.PlatformUser;
import org.kie.kogito.Model;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;

import javax.inject.Inject;
import javax.inject.Named;
import javax.json.Json;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.Map;

@Path("/startRegistrationProcess")
public class StartRegistrationProcessResource {

    @Inject
    @Named("welcomeNewUserProcess")
    Process<? extends Model>  welcomeNewUserProcess;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public void startRegistrationProcess(String event) {
        System.out.println("Registration Process started");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode1 = objectMapper.readTree(event);
            String user = jsonNode1.get("representation").asText();

            System.out.println("Userdata form Event: " + user);

            JsonNode jsonNode2 = objectMapper.readTree(user);
            String username = jsonNode2.get("username").asText();
            String email = "test@test.test"; //TODO: we need to extract the email too
            System.out.println("Extracted username: " + username);

            PlatformUser platformUser = new PlatformUser(username, email);

            Model model = welcomeNewUserProcess.createModel();
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("username", username);
		    model.fromMap(parameters);

		    // when
		    ProcessInstance<?> processInstance = welcomeNewUserProcess.createInstance(model);
		    processInstance.start();




        }
        catch (JsonProcessingException e) {
            System.out.println("Error while parsing event!!!");
            System.out.println("apporting...");
            System.out.println("Error: " + e.getMessage());
        }



    }



}
