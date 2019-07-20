package com.FirstMavenProject.FirstRest;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("actorresource")
public class ActorResource {

	ActorDB actorDB = new ActorDB();

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public ArrayList<Actor> getActors() {

		System.out.println("getActors called");
		return actorDB.getActors();
	}

	@GET
	@Path("getActor/{id}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Actor getActor(@PathParam("id") int id) {

		System.out.println("inside getActor method");
		return actorDB.getActor(id);
	}

	@PUT
	@Path("addActor")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

	public void addActor(Actor a) {

		actorDB.addActor(a);

	}

	@POST
	@Path("updateActor")
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public void updateActor(Actor a) {

		actorDB.updateActor(a);
	}

}
