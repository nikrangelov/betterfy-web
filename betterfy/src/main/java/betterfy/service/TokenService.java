package betterfy.service;

import betterfy.entity.Token;
import betterfy.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nik on 2/9/17.
 */

@Component
public class TokenService {

    @Autowired
    TokenRepository tokenRepository;

    public boolean isTokenUsed(String token){
            Token tmp = tokenRepository.findByToken(token);
            if(tmp == null){
                return false;
            }else{
                return true;
            }
    }
}
