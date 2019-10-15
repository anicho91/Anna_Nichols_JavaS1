import java.util.List;

public interface ItemDao {
    Item add(Item item);
    List<Item> findAll();
    Item findById(int id);
}