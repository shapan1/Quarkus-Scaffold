package org.sdashore;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/hello")
public class GreetingResource {

    @GET
    @Path("get")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello(
        @Context UriInfo uriInfo,
        @QueryParam("order") Order order,
        @NotBlank @HeaderParam("authorization") String authorization
    ) {
        return String.format("URI: %s - Order %s - Authorization: %s", uriInfo.getAbsolutePath(), order, authorization);
    }

    @POST
    @Path("post")
    @Consumes(MediaType.TEXT_PLAIN)
    public void create() {
        System.out.println("Post method - Create");
    }

    @PUT
    @Path("put")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String update() {
        return "PUT method - update";
    }

    @DELETE
    @Path("delete")
    public void delete() {
        System.out.println("Deleted");
    }
}