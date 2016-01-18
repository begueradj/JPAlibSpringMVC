package billal.begueradj.version1.pubdoc.controller;

import billal.begueradj.version1.pubdoc.domain.UserSession;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class CheckUserInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(CheckUserInterceptor.class);
    
    @Resource
    private UserSession userSession;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws IOException {

        if (request.getPathInfo().equals("/login")) {
            return true;
        }

        String username = userSession.getUsername();

        if (username != null) {
            return true;
        } else {
            
            response.sendRedirect("/pubdoc/app/login");
            return false;
        }
    }

    public void setUserSession(UserSession userSession) {
        this.userSession = userSession;
    }
}

