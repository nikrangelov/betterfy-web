package betterfy.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by nik on 2/26/17.
 */

@Path("secured/goal")
public class GoalController {

    @Path("all")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response allGoals(){
        return Response.ok("Msg").build();
    }

    @Path("add")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addGoal(){ return Response.ok("Msg").build(); }

    @Path("delete/{id}")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response deleteGoal(){
        return Response.ok("Msg").build();
    }

    @Path("status/{id}")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response changeGoalStatus(){
        return Response.ok("Msg").build();
    }

    @Path("statistic")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response goaltaskStatistic(){
        return Response.ok("Msg").build();
    }

}
