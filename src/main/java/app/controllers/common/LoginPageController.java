package app.controllers.common;

import app.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginPageController {

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String renderLogin(Model model) {
        return "login";
    }
}
