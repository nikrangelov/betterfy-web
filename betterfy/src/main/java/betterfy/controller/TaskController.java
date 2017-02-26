package betterfy.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by nik on 2/26/17.
 */


@Path("secured/task")
public class TaskController {

    @Path("all/{id}")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response allTasks(){
        return Response.ok("Msg").build();
    }

    @Path("add/{id}")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addTask(){ return Response.ok("Msg").build(); }

    @Path("delete/{id}")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Response deleteTask(){
        return Response.ok("Msg").build();
    }

    @Path("status/{id}")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response changeTaskStatus(){
        return Response.ok("Msg").build();
    }
}
