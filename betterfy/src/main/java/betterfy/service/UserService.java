package betterfy.service;

import betterfy.entity.User;
import betterfy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by nik on 2/8/17.
 */

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public boolean createUser(User user){
        try {

            userRepository.save(user);
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }

    public boolean updateUser(User user){
        return createUser(user);
    }

}
