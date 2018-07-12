package app.controllers.common;

import app.entities.User;
import app.services.UserService;
import app.utils.ValidationUtils;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static app.utils.ValidationUtils.ERROR_PASSWORD_MESSAGE;

@Controller
public class RegistrationController {


    private UserService userServ;
    private PasswordEncoder passowrdEncoder;

    @Autowired
    public RegistrationController(UserService us, PasswordEncoder passowrdEncoder) {
        this.userServ = us;
        this.passowrdEncoder = passowrdEncoder;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/registration")
    public String renderReg(Model model) {
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/registration")
    public String renderLoginReg(@ModelAttribute User user, Model model) {
        String login = user.getLogin();
        String pass = user.getPassword();
        String name = user.getFIO();
        boolean isCorrect = true;
        if (!ValidationUtils.validatePassword(pass)) {
            model.addAttribute("errorPass", ERROR_PASSWORD_MESSAGE);
            isCorrect = false;
        }
        if (!ValidationUtils.validateName(name)) {
            model.addAttribute("errorName", "Поле не должно быть пустым!");
            isCorrect = false;
        }
        try {
            userServ.getUserByLogin(login);
            model.addAttribute("errorLog", "Такой логин уже существует! Придумайте другой");
            isCorrect = false;}
        catch (NotFoundException e){
            System.out.println(e);
        }

        if (isCorrect) {
            user.setPassword(passowrdEncoder.encode(pass));
            userServ.addUser(user);
            model.addAttribute("successAdd", "Вы успешно зарегистрированы. Теперь можете войти в систему.");
            return "/login";
        } else return "/registration";
    }


    @ModelAttribute("userForm")
    public User getUser() {
        return new User();
    }
}
