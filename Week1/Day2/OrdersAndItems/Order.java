import java.util.ArrayList;

public class Order {
  String name;
  Double total;
  Boolean ready;
  ArrayList<Item> items;

  public Order() {
    this.name = null;
    this.total = 0.0;
    this.ready = false;
    this.items = new ArrayList<>();
  }

  public Order(String name, Double total, Boolean Ready, ArrayList<Item> items) {
    this.name = name;
    this.total = total;
    this.ready = ready;
    this.items = items;
  }
}
