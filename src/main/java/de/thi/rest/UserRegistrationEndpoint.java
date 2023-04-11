package de.thi.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.thi.beans.UserRegistration;
import de.thi.entities.User;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.kafka.common.protocol.types.Field;
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
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;

@Path("/user")
public class UserRegistrationEndpoint {

    @Inject
    UserRegistration userRegistration;

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

            System.out.println(entity1.getContent().toString());
            return Response.status(response1.getStatusLine().getStatusCode()).build();
        } finally {
            response1.close();
        }
    }



}
