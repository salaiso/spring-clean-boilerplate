package usecases;

import core.model.Item;
import core.entities.ItemRepository;
import core.model.SessionData;

public class AddItemUseCase {

  protected ItemRepository repository;

  public AddItemUseCase(ItemRepository itemRepository) {
    this.repository = itemRepository;
  }

  public String addItem(Item item, SessionData session) {
    return repository.addItem(item);
  }
}
