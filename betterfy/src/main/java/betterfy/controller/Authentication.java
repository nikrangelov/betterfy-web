package betterfy.controller;

import betterfy.entity.Credentials;

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

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response authenticateUser(Credentials credentials){

        String email = credentials.getEmail();
        String password = credentials.getPassword();
        String token = authenticate(email, password);

        //String token = "null";
        return Response.ok(token).build();
    }

    private String authenticate(String email, String password){
        // authenticate
        String token = null;
        return token;
    }

    private String issueToken(String email){
        final String token = UUID.randomUUID().toString().replaceAll("-", "");
        // connect it to the user
        return token;
    }
}
