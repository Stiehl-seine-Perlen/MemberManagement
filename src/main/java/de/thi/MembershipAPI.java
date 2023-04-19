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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;


@Path("/request")
public class MembershipAPI  {

    @Inject
    MembershipRepository membershipRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Association> all()
	{
		return membershipRepository.listAll();
	}

    /*
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Complaint byId(@PathParam("id") Long id)
	{
		return complaintRepository.findById(id);
	}*/

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public void post(Association association)
	{
		membershipRepository.persist(association);
	}


}