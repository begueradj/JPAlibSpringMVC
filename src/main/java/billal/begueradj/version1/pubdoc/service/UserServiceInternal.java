package billal.begueradj.version1.pubdoc.service;

import billal.begueradj.version1.pubdoc.domain.User;
import billal.begueradj.version1.pubdoc.repository.UserRepository;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional
public class UserServiceInternal implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    @Transactional
    public User addUser(String username, String password) {
        User user = userRepository.findByUsername(username);        
        if (user != null) {
            return null;
        }
        user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return user;
    }

    @Override
    @Transactional(readOnly=true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
