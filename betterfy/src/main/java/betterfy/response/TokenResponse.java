package betterfy.response;


/**
 * Created by nik on 2/12/17.
 */
public class TokenResponse {

    private String token;

    public TokenResponse(){

    }

    public TokenResponse(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
