package billal.begueradj.version1.pubdoc.service;

import billal.begueradj.version1.pubdoc.domain.User;
import billal.begueradj.version1.pubdoc.repository.UserRepository;
import javax.annotation.Resource;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
@ActiveProfiles("test")
@Transactional
@TransactionConfiguration
public class UserServiceIntegrationTest {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserService userService;

    @Before
    public void setUp() {
        User user = new User();
        user.setUsername("dummy");
        userRepository.save(user);
    }

    @Test
    public void testGetUser() {
        assertNotNull(userService.getUser("dummy"));
        assertEquals(null,userService.getUser("ghost"));
    }
    
    @Test
    public void testAddUser() {
        assertNotNull(userService.addUser("dummy2","dummy2"));
        assertEquals(null,userService.addUser("dummy2","dummy2"));
        assertEquals(null,userService.addUser("dummy2","blabla"));  
    }
    
    @Test
    public void testGetAllUsers() {
        userService.addUser("dummy2","dummy2");
        assertEquals(2,userService.getAllUsers().size());
    }
}
