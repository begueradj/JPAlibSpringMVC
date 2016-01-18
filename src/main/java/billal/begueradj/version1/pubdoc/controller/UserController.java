package billal.begueradj.version1.pubdoc.controller;

import billal.begueradj.version1.pubdoc.service.UserService;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView viewUsers() {
        return new ModelAndView("viewUsers","users",userService.getAllUsers());
    }
}
