package app.controllers.common;

import app.entities.User;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginPageController {

    private UserService userServ;
    @Autowired
    public LoginPageController(UserService us) {
        this.userServ = us;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String renderLogin(Model model) {
        User user = userServ.getUserByLogin();
        if(){
            model.addAttribute("newAdd","Дождитесь подтверждения администратором!");
        }
        return "login";
    }
}
