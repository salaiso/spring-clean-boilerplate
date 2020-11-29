package configuration;

import core.entities.ItemRepository;
import core.model.SessionData;
import org.springframework.context.annotation.*;
import usecases.AddItemUseCase;
import usecases.GetItemUseCase;
import usecases.GetItemsUseCase;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class AppConfiguration {

  @Bean
  @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
  public SessionData cleanSession() {
    return new SessionData();
  }

  @Bean
  public ItemRepository getItemRepository() {
    return new ItemRepository();
  }

  @Bean
  public GetItemsUseCase getItemsUseCase(ItemRepository itemRepository) {
    return new GetItemsUseCase(itemRepository);
  }

  @Bean
  public GetItemUseCase getItemUseCase(ItemRepository itemRepository) {
    return new GetItemUseCase(itemRepository);
  }

  @Bean
  public AddItemUseCase addItemUseCase(ItemRepository itemRepository) {
    return new AddItemUseCase(itemRepository);
  }
}
