package core.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

  @Id
  private String id;

  private String data;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
  public String getData() {
    return data;
  }
  public void setData(String data) {
    this.data = data;
  }
}
