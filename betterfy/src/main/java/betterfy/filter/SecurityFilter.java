package betterfy.filter;

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

    public static final String USER_ID_HEADER = "USER_ID";
    private static final String SECURED_URL_PREFIX = "secured";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse) res;
        String authToken = null;

        String requestedUrl = request.getRequestURI().toString();
        authToken = request.getHeader(USER_ID_HEADER);
        //System.out.println(authToken);

        if(requestedUrl.contains(SECURED_URL_PREFIX)){

            if(!isTokenValid(authToken)){
                Response.ResponseBuilder builder = null;
                String msg = "User cannot access the resource!";
                builder = Response.status(Response.Status.UNAUTHORIZED).entity(msg);
                throw new WebApplicationException(builder.build());
            }



        }

        //response.setHeader(USER_ID_HEADER, "12");
        chain.doFilter(req, res);
    }


    private boolean isTokenValid(String token) {

        return true;
    }

    @Override
    public void destroy() {

    }

}
