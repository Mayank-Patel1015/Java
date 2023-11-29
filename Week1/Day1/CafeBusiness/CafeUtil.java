import java.util.ArrayList;

public class CafeUtil {
  public int getStreakGoal() {
    int streak = 10;
    int sum = 0;
    for (int i = 0; i <= streak; i++) {
      sum += i;
    }
    return sum;
  }

  public int getStreakGoal(int numWeeks) {
    int sum = 0;
    for (int i = 0; i <= numWeeks; i++) {
      sum += i;
    }
    return sum;
  }

  double getOrderTotal(double[] prices) {
    int sum = 0;
    for (int i = 0; i < prices.length; i++) {
      sum += prices[i];
    }
    return sum;
  }

  void displayMenu(ArrayList<String> menuItems) {
    for (int i = 0; i < menuItems.size(); i++) {
      System.out.println(i + " " + menuItems.get(i));
    }
  }

  public void addCustomer(ArrayList<String> customers) {
    System.err.println("Please enter your name: ");
    String username = System.console().readLine();
    System.out.println("Hello, " + username);
    System.out.println("There are " + customers.size() + " people in front of you.");
    customers.add(username);
  }

}
