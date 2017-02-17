package betterfy.controller;

import betterfy.entity.Habit;
import betterfy.entity.User;
import betterfy.request.HabitDetails;
import betterfy.response.AllHabitsResponse;
import betterfy.service.HabitService;
import betterfy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * Created by nik on 2/13/17.
 */

@Path("secured/habit")
public class HabitController {

    private static final String USER_ID_HEADER = "USER_ID";

    @Autowired
    UserService userService;

    @Autowired
    HabitService habitService;

    @Path("all")
    @GET
    @Produces("application/json")
    @Consumes("application/json")
    public Response getAllHabits(@HeaderParam(USER_ID_HEADER) long id){
        User user = userService.findById(id);
        AllHabitsResponse allHabitsResponse = new AllHabitsResponse();
        for(Habit habit: user.getHabits()){
            allHabitsResponse.addHabit(habit);
            System.out.println(habit.getName());
        }
        return Response.ok(allHabitsResponse).build();
    }

    @Path("{id}")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response getHabitById(@PathParam("id") long id){
        return Response.ok("Msg").build();
    }



    @Path("add")
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response addHabit(HabitDetails habitDetails, @HeaderParam(USER_ID_HEADER) long id){
        Habit habit = new Habit();
        habit.setName(habitDetails.getName());
        habit.setQuestion(habitDetails.getQuestion());
        habit.setTimes(habitDetails.getTimes());
        habit.setDays(habitDetails.getDays());
        User user = userService.findById(id);
        habit.setUser(user);
        user.getHabits().add(habit);
        System.out.println("Hello " + user.getHabits().size());
        userService.updateUser(user);
        //habitService.createHabit(habit);
        return Response.ok().build();
    }

    @Path("deleteHabit/{id}")
    @DELETE
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
