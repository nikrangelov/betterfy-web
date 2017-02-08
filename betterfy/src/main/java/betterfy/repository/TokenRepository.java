package betterfy.repository;

import betterfy.entity.Token;
import org.springframework.stereotype.Repository;

/**
 * Created by nik on 2/8/17.
 */

@Repository
public interface TokenRepository<Token, Long> {

    public Token findByToken(String token);

}
