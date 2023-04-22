package de.thi.rest;

import de.thi.beans.UserRegistration;
import de.thi.entities.User;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;


@Path("/user")
public class UserRegistrationEndpoint {

    @Inject
    UserRegistration userRegistration;

    @Inject
    UserManagementRestClient userManagementRestClient;


    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) throws IOException {

        // Call Kogito Process with POST Request

        // Apache HTTP Client: Prepare Request
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String enpoint = "http://localhost:8080/regprocess";
        HttpPost httpPost = new HttpPost(enpoint);

        //Create JSON Object from User Object
        String json = new JSONObject()
                .put("user", new JSONObject()
                        .put("username", user.getUsername())
                        .put("password", user.getPassword())
                        .put("email", user.getEmail()))
                .toString();

        //Set Headers
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        //Create http Entity from String
        httpPost.setEntity(new StringEntity(json));

        //actually execute the request
        CloseableHttpResponse response1 = httpclient.execute(httpPost);

        try {
            System.out.println(response1.getStatusLine()); //Check HTTP Code for Response
            HttpEntity entity1 = response1.getEntity(); //TODO: Do something useful with the response

            //print response body to console
            String responseBody = EntityUtils.toString(entity1);
            System.out.println(responseBody);

            // Create JSON for Response
            // send only neccecary information to frontend
            JSONObject obj = new JSONObject(responseBody);
            String id = obj.getJSONObject("user").getInt("id") + "";
            String username = obj.getJSONObject("user").getString("username");
            String email = obj.getJSONObject("user").getString("email");

            String responseJson = new JSONObject()
                    .put("user", new JSONObject()
                            .put("id", id)
                            .put("username", username)
                            .put("email", email))
                    .toString();

            // get 'valid' attribute of response
            String valid = obj.get("valid")+"";
            boolean validBool = Boolean.parseBoolean(valid);
            if (validBool){
                System.out.println("Registration valid");
                 return Response.ok(responseJson).build();
            }
            else {
                System.out.println("Registration not valid");
                return Response.status(422).build();
            }

        } finally {
            response1.close();
        }
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public void loginUser(String username, String password){
        userManagementRestClient.post(username, password);
    }

}
