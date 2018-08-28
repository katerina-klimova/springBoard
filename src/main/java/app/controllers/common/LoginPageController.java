package app.controllers.common;

import app.entities.User;
import app.services.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginPageController {

    private UserService userServ;
    @Autowired
    public LoginPageController(UserService us) {
        this.userServ = us;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String renderLogin() {

        return "login";
    }
}
