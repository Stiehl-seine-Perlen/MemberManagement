package de.thi.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.benevolo.entities.user.PlatformUser;
import de.thi.services.PlatformUserService;
import org.json.JSONObject;
import org.kie.kogito.Model;
import org.kie.kogito.process.Process;
import org.kie.kogito.process.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.HashMap;
import java.util.Map;

@Path("/startRegistrationProcess")
public class StartRegistrationProcessResource {

    private static final Logger LOG = LoggerFactory.getLogger(StartRegistrationProcessResource.class);

    @Inject
    @Named("NewUserMessageProcess")
    Process<? extends Model>  NewUserMessageProcess;

    @Inject
    PlatformUserService platformUserService;

    @POST
    @Path("/Admin")
    @Consumes("application/json")
    @Produces("application/json")
    public void startRegistrationProcessAdmin(String event) {
        LOG.info("Registration Process *Admin* started");
        LOG.info(event);

        try {

            // Parse Event
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode eventNode = objectMapper.readTree(event);
            String userString = eventNode.get("representation").asText();

            LOG.info("Userdata from Event: " + userString);

            // Extract username from EventData
            JsonNode userNode = objectMapper.readTree(userString);
            String username = userNode.get("username").asText();
            String email = userNode.get("email").asText();
            LOG.info("Extracted username: " + username);
            LOG.info("Extracted email: " + email);

            // Create User Object from EventData
            // Is this legal?
            PlatformUser platformUser = new PlatformUser(username, email);
            platformUserService.persistPlatformUser(platformUser);

            // Create Model for Process
            Model model = NewUserMessageProcess.createModel();
            Map<String, Object> parameters = new HashMap<>();
            //Username and Email as JSON String
            String usernameAndEmail = "{\"username\": \"" + username + "\", \"email\": \"" + email + "\"}";

            // Give Model the Username and Email as Json String, because Kogito can't handle 2 Arguments...
            parameters.put("usernameAndEmail", usernameAndEmail);
		    model.fromMap(parameters);

		    // Start Process
		    ProcessInstance<?> processInstance = NewUserMessageProcess.createInstance(model);
		    processInstance.start();


        }
        catch (JsonProcessingException e) {
            LOG.info("Error while parsing event!!!");
            LOG.info("apporting...");
            LOG.info("Error: " + e.getMessage());
        }



    }


    @POST
    @Path("/User")
    @Consumes("application/json")
    @Produces("application/json")
    public void startRegistrationProcessUser(String event){

        LOG.info("Registration Process *User* started");
        LOG.info(event);
        try {


            // Parse Event
            JSONObject obj = new JSONObject(event);
            String username = obj.getJSONObject("details").getString("username");
            String email = obj.getJSONObject("details").getString("email");

            LOG.info("Extracted username: " + username);
            LOG.info("Extracted email: " + email);

             // Create User Object from EventData
            // Is this legal?
            PlatformUser platformUser = new PlatformUser(username, email);
            platformUserService.persistPlatformUser(platformUser);

            // Create Model for Process
            Model model = NewUserMessageProcess.createModel();
            Map<String, Object> parameters = new HashMap<>();
            //Username and Email as Json String
            String usernameAndEmail = "{\"username\": \"" + username + "\", \"email\": \"" + email + "\"}";

            // Give Model the Username and Email as Json String, because Kogito can't handle 2 Arguments...
            parameters.put("usernameAndEmail", usernameAndEmail);
            model.fromMap(parameters);

            // Start Process
            ProcessInstance<?> processInstance = NewUserMessageProcess.createInstance(model);
            processInstance.start();



        }
        catch (Exception e){
            LOG.info("Error while parsing event!!!");
            LOG.info("apporting...");
            LOG.info("Error: " + e.getMessage());
            e.printStackTrace();
        }

    }



}
