package betterfy.filter;

import betterfy.entity.Token;
import betterfy.entity.User;
import betterfy.library.HeaderMapRequestWrapper;
import betterfy.service.TokenService;
import betterfy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.io.IOException;


/**
 * Created by nik on 1/29/17.
 */

@Component
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements Filter {

    @Autowired
    UserService userService;

    @Autowired
    TokenService tokenService;

    public static final String USER_TOKEN_HEADER = "USER_TOKEN";
    private static final String SECURED_URL_PREFIX = "secured";
    private static final String USER_ID_HEADER = "USER_ID";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) res;
        HeaderMapRequestWrapper requestWrapper = new HeaderMapRequestWrapper(request);
        String authToken = null;

        String requestedUrl = request.getRequestURI().toString();
        authToken = request.getHeader(USER_TOKEN_HEADER);
        // DoSystem.out.println(authToken);

        if(requestedUrl.contains(SECURED_URL_PREFIX)){

            if(!isTokenValid(authToken)){
                Response.ResponseBuilder builder = null;
                String msg = "User cannot access the resource!";
                builder = Response.status(Response.Status.UNAUTHORIZED).entity(msg);
                throw new WebApplicationException(builder.build());
            }

            long userID = getUserIdByToken(authToken);
            requestWrapper.addHeader(USER_ID_HEADER, Long.toString(userID));
            //response.setHeader(USER_ID_HEADER, Long.toString(userID));

            System.out.println(userID);

        }

        chain.doFilter(requestWrapper, res);
    }


    private boolean isTokenValid(String tokenString) {
        Token token = tokenService.findByToken(tokenString);
        if(token==null){
            return false;
        }
        return true;
    }

    public long getUserIdByToken(String tokenString){
        Token token = tokenService.findByToken(tokenString);
        long id = token.getUser().getId();
        return id;
    }

    @Override
    public void destroy() {

    }

}
