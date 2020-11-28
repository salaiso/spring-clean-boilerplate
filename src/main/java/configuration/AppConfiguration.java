package configuration;

import core.entities.ItemRepository;
import core.model.SessionData;
import usecases.AddItemUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import usecases.GetItemsUseCase;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
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
  public AddItemUseCase addItemUseCase(ItemRepository itemRepository) {
    return new AddItemUseCase(itemRepository);
  }
}
