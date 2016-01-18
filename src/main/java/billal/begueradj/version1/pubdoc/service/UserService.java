package billal.begueradj.version1.pubdoc.service;

import billal.begueradj.version1.pubdoc.domain.User;
import java.util.List;

public interface UserService {

    User getUser(String username);
    
    User addUser(String username, String password);
    
    List<User> getAllUsers();
}
