package app.controllers.common;

import app.entities.Item;
import app.services.ItemService;
import app.services.UserDataService;
import app.utils.ValidationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddItemController {

    private ItemService itemService;
    private UserDataService userDataService;
    public AddItemController(ItemService _itemService,UserDataService _userDataService){
        this.itemService = _itemService;
        this.userDataService = _userDataService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user/additem")
    public String renderAddItem(@ModelAttribute Item item, Model model) {
        boolean isCorrect=true;
        if(!ValidationUtils.validateCost(item.getCost())){
            model.addAttribute("errorCost","The cost muct be above zero!");
            isCorrect=false;
        }
        if("".equals(item.getName())){
            model.addAttribute("errorName","Name cannot be empty!");
            isCorrect=false;
        }
        if(isCorrect){
            Long idUser = userDataService.getCurrentUser().getId();
            item.setIdUser(idUser);
            itemService.addItem(item);
            return "redirect:/user/items";
        }
        return "/user/additem";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/additem")
    public String renderItem() {
        return "/user/additem";
    }



    @ModelAttribute("itemForm")
    public Item getItem() {
        return new Item();
    }
}
