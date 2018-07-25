package app.controllers.common;

import app.entities.Item;
import app.entities.User;
import app.services.ItemService;
import app.services.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ItemController {

    private ItemService itemService;
    private UserDataService userDataService;

    @Autowired
    public ItemController(ItemService itemService,UserDataService userDataService) {
        this.itemService = itemService;
        this.userDataService = userDataService;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/items")
    public String renderUsers(Model model, HttpSession hs){
        Long id = userDataService.getCurrentUser().getId();
        List<Item> items = itemService.getMyItems(Math.toIntExact(id));
        Item item = new Item();
        if (items.isEmpty()){
            model.addAttribute("noitems", "You have'nt got any item.");
        }else{
            model.addAttribute("allitems", items);
        }
        return "user/items";
    }


}
