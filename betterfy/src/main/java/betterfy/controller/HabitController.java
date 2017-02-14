package betterfy.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by nik on 2/13/17.
 */

@Path("secured/habit")
public class HabitController {

    @Path("all")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response getAllHabits(){
        return Response.ok("Msg").build();
    }

    @Path("{id}")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response getHabitById(@PathParam("id") long id){
        return Response.ok("Msg").build();
    }



    @Path("addHabit")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addHabit(){
        return Response.ok("Msg").build();
    }

    @Path("deleteHabit/{id}")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response deleteHabit(@PathParam("id") long id){
        return Response.ok("Msg").build();
    }


    @Path("addDate/{id}")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addDate(){
        return Response.ok("Msg").build();
    }

    @Path("removeDate/{id}")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response removeDate(){
        return Response.ok("Msg").build();
    }

}
