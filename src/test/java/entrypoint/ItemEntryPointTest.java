package entrypoint;

import configuration.TestConfiguration;
import core.model.Item;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfiguration.class})
public class ItemEntryPointTest extends ExternalResource {

  @Autowired
  ItemEntryPoint itemEntryPoint;

  @Test
  public void addingAnItemWorks() {

    int numItems = itemEntryPoint.getItems().size();

    Item input = new Item();
    input.setId(UUID.randomUUID().toString());
    input.setData(UUID.randomUUID().toString());
    itemEntryPoint.putItem(input);

    Assert.assertEquals("an item was inserted ", numItems + 1, itemEntryPoint.getItems().size());
  }

  @Test
  public void readingAnItemWorks() {

    Item input = new Item();
    input.setId(UUID.randomUUID().toString());
    input.setData(UUID.randomUUID().toString());

    itemEntryPoint.putItem(input);
    Item output = itemEntryPoint.getItem(input.getId());

    Assert.assertEquals("id is read back correctly", input.getId(), output.getId());
    Assert.assertEquals("data is read back correctly", input.getData(), output.getData());
  }

}