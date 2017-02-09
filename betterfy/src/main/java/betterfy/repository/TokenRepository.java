package betterfy.repository;

import betterfy.entity.Token;
import org.springframework.data.repository.CrudRepository;


import javax.transaction.Transactional;

/**
 * Created by nik on 2/8/17.
 */

@Transactional
public interface TokenRepository extends CrudRepository<Token, Long> {

    public Token findByToken(String token);
}
