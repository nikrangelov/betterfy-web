package betterfy.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by nik on 1/29/17.
 */

@Path("/test")
public class Test {

    @GET
    @Produces("application/json")
    public String test() {
        return "Jersey: Up and Running!";
    }

}
