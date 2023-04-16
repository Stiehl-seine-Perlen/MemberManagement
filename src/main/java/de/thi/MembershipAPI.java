package de.thi;

import de.thi.beans.MembershipRepository;
import de.thi.entities.Association;
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


@Path("/membership")
public class MembershipAPI  {

    @Inject
    MembershipRepository membershipRepository;


    @POST
    @Path("/accept")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(User user) throws IOException {

        // Call Kogito Process with POST Request

        // Apache HTTP Client: Prepare Request
        CloseableHttpClient httpclient = HttpClients.createDefault();
        String enpoint = "http://localhost:8080/joinAssProcess";
        HttpPost httpPost = new HttpPost(enpoint);

        //Create JSON Object from User Object
        String json = new JSONObject()
                .put("user", new JSONObject()
                        .put("username", user.getUsername()))
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
            String assName = obj.getJSONObject("association").getString("assName");

            String responseJson = new JSONObject()
                    .put("association", new JSONObject()
                            .put("association", assName))
                    .toString();

            // get 'valid' attribute of response
            String checkStatus = obj.get("checkStatus")+"";
            boolean validBool = Boolean.parseBoolean(checkStatus);
            if (validBool){
                System.out.println("Test1");
                 return Response.ok(responseJson).build();
            }
            else {
                System.out.println("Test2");
                return Response.status(422).build();
            }

        } finally {
            response1.close();
        }
    }


}