package usecases;

import core.entities.ItemRepository;
import core.model.Item;
import java.util.List;

public class GetItemsUseCase {

  protected ItemRepository repository;

  public GetItemsUseCase(ItemRepository itemRepository) {
    this.repository = itemRepository;
  }

  public List<Item> getItems() {
    return repository.getItems();
  }
}
