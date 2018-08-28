package app.services;

import app.entities.User;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component

public class UserDataService {
    private User user;
    private UserService userServ;

    @Autowired
    public UserDataService(UserService userService) {
        this.userServ = userService;
    }

    public User getCurrentUser() {
          if (user == null) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String name = authentication.getName();
            try {
                user = userServ.getUserByLogin(name);
            } catch (NotFoundException e) {
                user = new User();
                user.setLogin("anonimus");
            }
        }
        return user;
    }
}
