package de.benevolo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.benevolo.entities.User;
import de.benevolo.entities.UserUpdateRepository;

import java.util.List;

@Path("/user/")
public class UserUpdateResource {

	@Inject
	UserUpdateRepository userUpdateRepository;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> all() {
		return userUpdateRepository.listAll();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User byId(@PathParam("id") Long id) {
		return userUpdateRepository.findById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public void post(User user) {
		userUpdateRepository.persist(user);
	}
}

