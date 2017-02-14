package betterfy.controller;

import betterfy.request.Credentials;
import betterfy.entity.User;
import betterfy.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by nik on 2/9/17.
 */

@Path("/register")
public class Registration {

    @Autowired
    UserService userService;

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response registration(Credentials credentials){
        String email = credentials.getEmail();
        String password = credentials.getPassword();
        //System.out.println(email + " " + password); // for debug purposes!
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        User user = new User(email, hashedPassword);

        User tmp = userService.findByEmail(email);
        if(tmp == null){
            if(userService.createUser(user)){
                return Response.ok("Ok! User created").build();
            }
        }
        return Response.ok("Error! User not created").build();
    }
}
