package app.repositories;

import app.entities.Item;
import app.entities.User;
import app.entities.mappers.ItemRowMapper;
import app.entities.mappers.UserRowMapper;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ItemRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Item> getAllItems() {
        return jdbcTemplate.query("select * from items", new ItemRowMapper());
    }

    public List<Item> getMyItems(int id) {
        String sql = "select * from items where id_user="+id;
        return jdbcTemplate.query(sql, new ItemRowMapper());
    }

    public void addItem(Item item){
        String sql = "insert into items (name,description,cost,status,id_user) values (?,?,?,false,?)";
        Object[] args = {item.getName(),item.getDescription(),item.getCost(),item.getIdUser()};
        jdbcTemplate.update(sql,args);
    }

    public Item getItemById(String id) throws NotFoundException {
        String sql = "select * from items where id="+id;
        Item item;
        List<Item> li = jdbcTemplate.query(sql,new ItemRowMapper());
        if (!li.isEmpty()){
            item = li.get(0);
        }
        else{
            throw new NotFoundException("item with id=" + id+ " not found");
        }
        return item;
    }

    public Item defaultItem(){
        Item item = new Item();
        item.setId((long) 0);
        item.setName("NoName");
        item.setDescription("NoDescription");
        item.setCost(BigDecimal.valueOf(0));
        item.setStatus(false);
        return item;
    }
}
