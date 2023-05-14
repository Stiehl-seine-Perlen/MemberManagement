package de.thi.Resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import de.benevolo.entities.user.PlatformUser;
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
    @Named("welcomeNewUserProcess")
    Process<? extends Model>  welcomeNewUserProcess;

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
            LOG.info("Extracted username: " + username);

            // Create User Object from EventData
            PlatformUser platformUser = new PlatformUser(username);

            // Create Model for Process
            Model model = welcomeNewUserProcess.createModel();
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("username", username);
		    model.fromMap(parameters);

		    // Start Process
		    ProcessInstance<?> processInstance = welcomeNewUserProcess.createInstance(model);
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

            LOG.info("Extracted username: " + username);

            PlatformUser platformUser = new PlatformUser(username);

            // Create Model for Process
            Model model = welcomeNewUserProcess.createModel();
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("username", username);
            model.fromMap(parameters);

            // Start Process
            ProcessInstance<?> processInstance = welcomeNewUserProcess.createInstance(model);
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
