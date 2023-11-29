import java.util.ArrayList;

public class TestOrders {
  public static void main(String[] args) {

    // Menu items
    Item mocha = new Item("Mocha", 2.99);
    Item latte = new Item("Latte", 12.99);
    Item dripCoffee = new Item("DripCoffee", 4.99);
    Item cappuccino = new Item("Cappuccino", 9.99);
    // Order variables -- order1, order2 etc.
    Order order1 = new Order("Cindhuri", 4, false, mocha);

    // Application Simulations
    // Use this example code to test various orders' updates
    System.out.printf("Name: %s\n", order1.name);
    System.out.printf("Total: %s\n", order1.total);
    System.out.printf("Ready: %s\n", order1.ready);
  }
}