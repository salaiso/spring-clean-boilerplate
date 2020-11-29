package entrypoint;

import core.model.SessionData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import usecases.AddItemUseCase;
import usecases.GetItemUseCase;
import usecases.GetItemsUseCase;
import core.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemEntryPoint {

  Logger log = LoggerFactory.getLogger(ItemEntryPoint.class);
  protected GetItemsUseCase getItemsUseCase;
  protected AddItemUseCase addItemUseCase;
  protected GetItemUseCase getItemUseCase;

  @Autowired
  protected SessionData sessionData;

  public ItemEntryPoint(GetItemsUseCase getItemsUseCase, AddItemUseCase addItemUseCase, GetItemUseCase getItemUseCase) {
    this.getItemsUseCase = getItemsUseCase;
    this.addItemUseCase = addItemUseCase;
    this.getItemUseCase = getItemUseCase;
  }

  @GetMapping(path = "/items", produces = "application/json")
  public List<Item> getItems() {
    log.info("GET /items");
    return getItemsUseCase.getItems();
  }

  @GetMapping(path = "/item/{id}", produces = "application/json")
  public Item getItem(@PathVariable String id) {
    log.info("GET /item/{id}");
    return getItemUseCase.getItem(id);
  }

  @PutMapping(path = "/item", consumes = "application/json", produces = "application/json")
  public String putItem(@RequestBody Item item) {
    log.info("PUT /item");
    return addItemUseCase.addItem(item, sessionData);
  }
}
