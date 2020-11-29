package usecases;

import core.entities.ItemRepository;
import core.model.Item;

import java.util.List;

public class GetItemUseCase {

  protected ItemRepository repository;

  public GetItemUseCase(ItemRepository itemRepository) {
    this.repository = itemRepository;
  }

  public Item getItem(String id) {
    return repository.getItem(id);
  }
}
