package betterfy.controller;

import betterfy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by nik on 1/29/17.
 */

@Path("/test")
public class Test {

    @Autowired
    UserService userService;

    @GET
    @Produces("application/json")
    public String test() {

        if(userService == null){
            return "Not ok!";
        }
        return "Jersey: Up and Running!";
    }

}
