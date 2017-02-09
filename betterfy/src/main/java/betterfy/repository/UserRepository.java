package betterfy.repository;

import betterfy.entity.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by nik on 2/8/17.
 */


@Transactional
public interface UserRepository extends CrudRepository<User, Long>{

    public User findByEmail(String email);
}

