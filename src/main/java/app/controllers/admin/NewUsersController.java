package app.controllers.admin;

import app.entities.User;
import app.services.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
@Controller
public class NewUsersController {

    private UserService userServ;

    @Autowired
    public NewUsersController(UserService userServ) {
        this.userServ = userServ;
    }

    @RequestMapping(method = RequestMethod.GET, path = "admin/newusers")
    public String renderNewUsers(Model model){
        List<User> users = userServ.getNewUsersServ();
        model.addAttribute("allnewusers", users);
        return "admin/newusers";
    }

    @RequestMapping(method = RequestMethod.POST, path = "admin/newusers")
    public String approveNewUsers(@RequestParam String login, Model model) throws NotFoundException {
        User user = userServ.getUserByLogin(login);
        userServ.changeStatus(user);
        //List<User> users = userServ.getNewUsersServ();
       // model.addAttribute("allnewusers", users);
        return "redirect:admin/newusers";
    }
}
