package betterfy.controller;

import betterfy.entity.Credentials;
import betterfy.entity.Token;
import betterfy.entity.User;
import betterfy.service.UserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.UUID;

/**
 * Created by nik on 1/30/17.
 */

@Path("/authentication")
public class Authentication {

    @Autowired
    UserService userService;

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response authenticateUser(Credentials credentials){

        String email = credentials.getEmail();
        String password = credentials.getPassword();
        String stringToken = null;
        User user =  userService.findByEmail(email);
        if(user == null){
            return Response.ok("No such user").build();
        }
        // perform check on users tokens and delete expired ones
        String hashedPassword = user.getPassword();
        if(BCrypt.checkpw(password, hashedPassword)){
            // issue token
            Token token = new Token();
            token.initToken();
            token.setUser(user);
            stringToken = token.getToken();
            user.addToken(token);
            userService.updateUser(user);

        }else{
            return Response.ok("Wrong password").build();
        }
        //String token = authenticate(email, password);

        //String token = "null";
        return Response.ok(stringToken).build();
    }


    private void removeExpiredCookies(){
        
    }
}
