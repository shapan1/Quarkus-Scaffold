package org.sdashore;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.util.HashMap;
import java.util.Map;

@Path("/developer")
public class DeveloperResource {

    Map<Long, Developer> devs = new HashMap<>();

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeveloper(Developer developer) {
        developer.persist();
        devs.put(developer.getId(), developer);
        return Response
                .created(
                        UriBuilder
                                .fromResource(DeveloperResource.class)
                                .path(Long.toString(developer.getId())).build())
                .entity(developer).build();

    }

    @GET
    @Path("get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDeveloper(@PathParam("id") Long id){
        return Response
                .created(
                        UriBuilder
                                .fromResource(DeveloperResource.class)
                                .path(Long.toString(id)).build())
                .entity(devs.get(id)).build();
    }
}
