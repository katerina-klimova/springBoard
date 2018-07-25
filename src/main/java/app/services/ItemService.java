package app.services;

import app.entities.Item;
import app.repositories.ItemRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<Item> getAllItemsServ(){
        return itemRepository.getAllItems();
    }

    public List<Item> getMyItems(int id) {
        return itemRepository.getMyItems(id);
    }

    public void addItem(Item item){
        this.itemRepository.addItem(item);
    }

    public Item getItemById(String id) throws NotFoundException {
        return itemRepository.getItemById(id);
    }
    public Item defaultItem(){
        return itemRepository.defaultItem();
    }
}
