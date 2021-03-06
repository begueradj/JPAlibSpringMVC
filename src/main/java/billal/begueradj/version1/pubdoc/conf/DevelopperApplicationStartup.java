package billal.begueradj.version1.pubdoc.conf;

import billal.begueradj.version1.pubdoc.domain.User;
import billal.begueradj.version1.pubdoc.service.UserService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
@Profile("developper")
public class DevelopperApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = 
            LoggerFactory.getLogger(DevelopperApplicationStartup.class);
    
    @Resource
    public UserService userService;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        User user = userService.addUser("admin","admin");
        if(user == null) {
            logger.warn("admin already present");
        } else {
            logger.info("add an default admin user");            
        }
        
        // checking if transaction works at startup
        assert userService.getAllUsers().size() >= 1;
    }    
}
