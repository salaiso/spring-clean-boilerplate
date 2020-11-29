package core.entities;

import core.model.Item;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Transactional
public class ItemRepository {

  @PersistenceContext
  private EntityManager em;

  public List<Item> getItems() {
    return em.createQuery("select i from Item i", Item.class).getResultList();
  }

  public Item getItem(String id) {
    return em.find(Item.class, id);
  }
  
  public String addItem(Item item) {
    String id = UUID.randomUUID().toString();
    item.setId(id);
    em.persist(item);
    return id;
  }
}
