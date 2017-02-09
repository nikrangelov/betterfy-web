package betterfy.controller;

import betterfy.entity.Token;
import betterfy.entity.User;
import betterfy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by nik on 1/29/17.
 */

@Path("/test")
public class Test {

    private static final String USER_ID_HEADER = "USER_ID";

    @Autowired
    UserService userService;

    @GET
    @Produces("application/json")
    public String test() {

        if(userService == null){
            return "Not ok!";
        }
        User user = userService.findByEmail("niki@rangelov.com");
        System.out.println(user.getId());
        List<Token> tokens = user.getTokens();
        System.out.println(tokens.size());
        /*if(tokens == null){
            System.out.println("null");
        }*/
        for(Token t: user.getTokens()){
            System.out.println(t.getToken());
        }

        return "Jersey: Up and Running!";
    }

    @Path("/secured")
    @GET
    @Produces("application/json")
    public String securedTest(@HeaderParam(USER_ID_HEADER) long id){
        User user = userService.findById(id);
        String email = user.getEmail();
        return email;
    }

}
