package entrypoint;

import core.model.SessionData;
import usecases.AddItemUseCase;
import usecases.GetItemsUseCase;
import core.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemEntryPoint {

  protected GetItemsUseCase getItemsUseCase;
  protected AddItemUseCase addItemUseCase;

  @Autowired
  protected SessionData sessionData;

  public ItemEntryPoint(GetItemsUseCase getItemsUseCase, AddItemUseCase addItemUseCase) {
    this.getItemsUseCase = getItemsUseCase;
    this.addItemUseCase = addItemUseCase;
  }

  @GetMapping(path = "/items", produces = "application/json")
  public List<Item> getItems() {
    return getItemsUseCase.getItems();
  }

  @PutMapping(path = "/item", consumes = "application/json", produces = "application/json")
  public String putItem(@RequestBody Item item) {
    return addItemUseCase.addItem(item, sessionData);
  }
}
