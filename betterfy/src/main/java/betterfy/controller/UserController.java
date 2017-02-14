package betterfy.controller;

import betterfy.request.Credentials;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by nik on 2/13/17.
 */

@Path("secured/user")
public class UserController {

    @Path("changePassword")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response changePassword(){
        return Response.ok("Msg").build();
    }


    @Path("deleteUser")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response deleteUser(){
        return Response.ok("Msg").build();
    }

}
