package app.controllers.common;

import app.entities.Item;
import app.services.ItemService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FullInformationController {

    private ItemService itemService;
    @Autowired
    public FullInformationController(ItemService is){
        this.itemService = is;
    }
    @RequestMapping(method = RequestMethod.GET, path = "/user/items/{id}")
    public String renderNewUsers(@PathVariable String id, Model model){
        Item item ;
        try {
            item = itemService.getItemById(id);
        } catch (NotFoundException e) {
            item = itemService.defaultItem();
        }
        model.addAttribute("item",item);
        return "/user/fullinformation";
    }
}
